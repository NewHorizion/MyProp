package com.vstar.interceptors;

import java.util.Collections;
import java.util.Set;

import org.apache.struts2.StrutsStatics;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.opensymphony.xwork2.util.TextParseUtil;

/**
 * <p>
 * The HibernateInterceptor is responsible for starting a transaction before
 * the action executes and if the action executes successfully, committing the
 * transaction, otherwise the transaction is rolled back. In addition this
 * transaction interceptor also manages the hibernate session.
 * </p>
 * <p>
 * By default, a null action result (an exception thrown from the action) or a
 * result of ERROR is considered a failure and is rolled back, everything else
 * is committed. For implementations that require other behavior, the
 * <code>wasSuccessful(String)</code> method should be overridden to implement
 * the appropriate logic for determining which results are committed and which
 * results are rolled back.
 * </p>
 */
@SuppressWarnings("serial")
public class HibernateInterceptor implements StrutsStatics, Interceptor
{
  /**
   * The additional result types that would cause the transaction to be rolled
   * back. This parameter allows per action configuration for which results
   * cause rollback.
   */
  @SuppressWarnings("unchecked")
  protected Set rollbackResults = Collections.EMPTY_SET;

  /**
   * Name of the spring bean that will return the hibernate session factory.
   */
  protected String sessionFactoryBeanName = "sessionFactory"; 
  /**
   * Name of the spring bean that will return the Spring transaction manager.
   */
  protected String transactionManagerBeanName = "transactionManager";
  
  /**
   * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
   */
  public void init()
  {
  }

  /**
   * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
   */
  public void destroy()
  {
  }

  /**
   * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
   */
  public String intercept(final ActionInvocation invocation) throws Exception
  {
    final PlatformTransactionManager transManager = (PlatformTransactionManager) InterceptorBeanFactory.createBean(
      transactionManagerBeanName, PlatformTransactionManager.class);
    final SessionFactory sessionFactory = (SessionFactory) InterceptorBeanFactory.createBean(
      sessionFactoryBeanName, SessionFactory.class);
    
    SessionHolder lastSession = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
    while (lastSession != null)
    {
      System.out.println(">>>>>>>>>>>>>>>>>>Rolling back transaction");
      if (lastSession.getTransaction().isActive())
      {
        lastSession.getTransaction().rollback();
      } else {
        break;
      }
      lastSession = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
    }

    final TransactionStatus transStatus = transManager
      .getTransaction(new DefaultTransactionDefinition(
        TransactionDefinition.PROPAGATION_REQUIRES_NEW));

    final Session currentSession = sessionFactory.getCurrentSession();

    // add a listener that will end the transaction after the action has
    // executed
    invocation.addPreResultListener(new PreResultListener()
      {
        public void beforeResult(ActionInvocation invocation, String result)
        {
          if (!transStatus.isCompleted())
          {
            handleTransactionEnd(invocation, transManager, transStatus, result);
          }
        }
      });
    String result = null;
    try
    {
      // execute the action
      result = invocation.invoke();
    }
    finally
    {
      if (!transStatus.isCompleted())
      {
        handleTransactionEnd(invocation,transManager, transStatus, result);
      }
    }
    return result;
  }

  /**
   * Determines if the transaction should be rolled back or committed and rolls
   * back or commits the transaction.
   * 
   * @param invocation
   * @param ctx
   * @param result
   */
  protected void handleTransactionEnd(ActionInvocation invocation, PlatformTransactionManager transManager, TransactionStatus transStatus, String result)
  {
    // a null result indicates an exception occurred
    if (result != null && wasSuccessful(result, invocation.getAction()))
    {
      // write all the data to the database and close session
      transManager.commit(transStatus);
    }
    else
    {
      transManager.rollback(transStatus);
    }
  }

  /**
   * Determines whether the transaction was considered successful or not.
   * 
   * @param result the results of the action, should not be null.
   * @param action the action Object
   * @return true if the action result should commit the transaction, otherwise
   *         false.
   */
  protected boolean wasSuccessful(String result, Object action)
  {
    // if an unhandled exception occurs result will be null
    if (!Action.ERROR.equals(result) && !rollbackResults.contains(result))
    {
      return true;
    }
    return false;
  }

  /**
   * @param rollbackResults
   */
  public void setRollbackResults(String rollbackResults)
  {
    this.rollbackResults = TextParseUtil.commaDelimitedStringToSet(rollbackResults);
  }

  public String getSessionFactoryBeanName()
  {
    return sessionFactoryBeanName;
  }

  public void setSessionFactoryBeanName(String sessionFactoryBeanName)
  {
    this.sessionFactoryBeanName = sessionFactoryBeanName;
  }

  public String getTransactionManagerBeanName()
  {
    return transactionManagerBeanName;
  }

  public void setTransactionManagerBeanName(String transactionManagerBeanName)
  {
    this.transactionManagerBeanName = transactionManagerBeanName;
  }
}

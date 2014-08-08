package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropTransactionDao;

/**
 * PropTransactionDaoProcess
 * 
 */
public class PropTransactionDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropTransactionDao
   * @throws HibernateException
   */
  public PropTransactionDao addUpdatePropTransactionDao(PropTransactionDao propTransactionDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropTransactionDao)session.merge(propTransactionDao);
  }

  /**
   * 
   * @param PropTransactionDaoid
   * @throws HibernateException
   */
  public void deletePropTransactionDao(int propTransactionId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropTransactionDao propTransactionDao = (PropTransactionDao) session.load(PropTransactionDao.class, new Integer(
        propTransactionId));
    session.delete(propTransactionDao);
  }

  /**
   * @return
   */
  public List<PropTransactionDao> getAllPropTransactionDaos() throws HibernateException
  {
    List<PropTransactionDao> propTransactionDaos = new ArrayList<PropTransactionDao>();
    Session session = sessionFactory.getCurrentSession();
    propTransactionDaos = session.createQuery("from PropTransactionDao").list();
    return propTransactionDaos;
  }

  /**
   * @param PropTransactionDaoid
   * @return
   */
  public PropTransactionDao getPropTransactionDaoById(int propTransactionId) throws HibernateException
  {
    PropTransactionDao propTransactionDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropTransactionDao where propTransactionId = :propTransactionId";
    Query query = session.createQuery(queryString);
    query.setInteger("propTransactionId", propTransactionId);
    propTransactionDao = (PropTransactionDao) query.uniqueResult();
    return propTransactionDao;
  }
}

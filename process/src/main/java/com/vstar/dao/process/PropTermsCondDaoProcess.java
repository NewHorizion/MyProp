package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropTermsCondDao;

/**
 * PropTermsCondDaoProcess
 * 
 */
public class PropTermsCondDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropTermsCondDao
   * @throws HibernateException
   */
  public PropTermsCondDao addUpdatePropTermsCondDao(PropTermsCondDao propTermsCondDao)
      throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropTermsCondDao)session.merge(propTermsCondDao);
  }

  /**
   * 
   * @param PropTermsCondDaoid
   * @throws HibernateException
   */
  public void deletePropTermsCondDao(int propTermCondId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropTermsCondDao propTermsCondDao = (PropTermsCondDao) session.load(PropTermsCondDao.class,
        new Integer(propTermCondId));
    session.delete(propTermsCondDao);
  }

  /**
   * @return
   */
  public List<PropTermsCondDao> getAllPropTermsCondDaos() throws HibernateException
  {
    List<PropTermsCondDao> PropTermsCondDaos = new ArrayList<PropTermsCondDao>();
    Session session = sessionFactory.getCurrentSession();
    PropTermsCondDaos = session.createQuery("from PropTermsCondDao").list();
    return PropTermsCondDaos;
  }

  /**
   * @param PropTermsCondDaoid
   * @return
   */
  public PropTermsCondDao getPropTermsCondDaoById(int propTermCondId) throws HibernateException
  {
    PropTermsCondDao propTermsCondDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropTermsCondDao where propTermCondId = :propTermCondId";
    Query query = session.createQuery(queryString);
    query.setInteger("propTermCondId", propTermCondId);
    propTermsCondDao = (PropTermsCondDao) query.uniqueResult();
    return propTermsCondDao;
  }
}

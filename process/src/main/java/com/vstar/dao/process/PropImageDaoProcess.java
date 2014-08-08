package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropImageDao;

/**
 * PropImageDaoProcess
 * 
 */
public class PropImageDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropImageDao
   * @throws HibernateException
   */
  public PropImageDao addUpdatePropImageDao(PropImageDao propImageDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropImageDao)session.merge(propImageDao);
  }

  /**
   * 
   * @param PropImageDaoid
   * @throws HibernateException
   */
  public void deletePropImageDao(int propImageId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropImageDao propImageDao = (PropImageDao) session.load(PropImageDao.class, new Integer(
        propImageId));
    session.delete(propImageDao);
  }

  /**
   * @return
   */
  public List<PropImageDao> getAllPropImageDaos() throws HibernateException
  {
    List<PropImageDao> propImageDaos = new ArrayList<PropImageDao>();
    Session session = sessionFactory.getCurrentSession();
    propImageDaos = session.createQuery("from PropImageDao").list();
    return propImageDaos;
  }

  /**
   * @param PropImageDaoid
   * @return
   */
  public PropImageDao getPropImageDaoById(int propImageId) throws HibernateException
  {
    PropImageDao propImageDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropImageDao where propImageId = :propImageId";
    Query query = session.createQuery(queryString);
    query.setInteger("propImageId", propImageId);
    propImageDao = (PropImageDao) query.uniqueResult();
    return propImageDao;
  }
}

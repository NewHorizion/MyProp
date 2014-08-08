package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropCategryDao;

/**
 * PropCategryDaoProcess
 * 
 */
public class PropCategryDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropCategryDao
   * @throws HibernateException
   */
  public PropCategryDao addUpdatePropCategryDao(PropCategryDao propCategryDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropCategryDao)session.merge(propCategryDao);
  }

  /**
   * 
   * @param PropCategryDaoid
   * @throws HibernateException
   */
  public void deletePropCategryDao(int propCategryDaoid) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropCategryDao propCategryDao = (PropCategryDao) session.load(PropCategryDao.class, new Integer(
        propCategryDaoid));
    session.delete(propCategryDao);
  }

  /**
   * @return
   */
  public List<PropCategryDao> getAllPropCategryDaos() throws HibernateException
  {
    List<PropCategryDao> propCategryDaos = new ArrayList<PropCategryDao>();
    Session session = sessionFactory.getCurrentSession();
    propCategryDaos = session.createQuery("from PropCategryDao").list();
    return propCategryDaos;
  }

  /**
   * @param PropCategryDaoid
   * @return
   */
  public PropCategryDao getPropCategryDaoById(int propCategryDaoid) throws HibernateException
  {
    PropCategryDao propCategryDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropCategryDao where categryId = :categryId";
    Query query = session.createQuery(queryString);
    query.setInteger("categryId", propCategryDaoid);
    propCategryDao = (PropCategryDao) query.uniqueResult();
    return propCategryDao;
  }
}

package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropInfoDao;

/**
 * PropInfoDaoProcess
 * 
 */
public class PropInfoDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropInfoDao
   * @throws HibernateException
   */
  public PropInfoDao addUpdatePropInfoDao(PropInfoDao propInfoDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropInfoDao)session.merge(propInfoDao);
  }

  /**
   * 
   * @param PropInfoDaoid
   * @throws HibernateException
   */
  public void deletePropInfoDao(int propInfoId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropInfoDao propInfoDao = (PropInfoDao) session
        .load(PropInfoDao.class, new Integer(propInfoId));
    session.delete(propInfoDao);
  }

  /**
   * @return
   */
  public List<PropInfoDao> getAllPropInfoDaos() throws HibernateException
  {
    List<PropInfoDao> PropInfoDaos = new ArrayList<PropInfoDao>();
    Session session = sessionFactory.getCurrentSession();
    PropInfoDaos = session.createQuery("from PropInfoDao").list();
    return PropInfoDaos;
  }

  /**
   * @param PropInfoDaoid
   * @return
   */
  public PropInfoDao getPropInfoDaoById(int propInfoId) throws HibernateException
  {
    PropInfoDao propInfoDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropInfoDao where propInfoId = :propInfoId";
    Query query = session.createQuery(queryString);
    query.setInteger("propInfoId", propInfoId);
    propInfoDao = (PropInfoDao) query.uniqueResult();
    return propInfoDao;
  }
}

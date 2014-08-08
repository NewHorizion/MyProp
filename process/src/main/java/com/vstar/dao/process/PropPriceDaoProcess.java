package com.vstar.dao.process;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vstar.dao.PropPriceDao;

/**
 * PropPriceDaoProcess
 * 
 */
public class PropPriceDaoProcess
{
  private SessionFactory sessionFactory;

  /**
   * 
   * @param PropPriceDao
   * @throws HibernateException
   */
  public PropPriceDao addUpdatePropPriceDao(PropPriceDao propPriceDao) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    return (PropPriceDao)session.merge(propPriceDao);
  }

  /**
   * 
   * @param PropPriceDaoid
   * @throws HibernateException
   */
  public void deletePropPriceDao(int propSalePriceId) throws HibernateException
  {
    Session session = sessionFactory.getCurrentSession();
    PropPriceDao propPriceDao = (PropPriceDao) session.load(PropPriceDao.class, new Integer(
        propSalePriceId));
    session.delete(propPriceDao);
  }

  /**
   * @return
   */
  public List<PropPriceDao> getAllPropPriceDaos() throws HibernateException
  {
    List<PropPriceDao> PropPriceDaos = new ArrayList<PropPriceDao>();
    Session session = sessionFactory.getCurrentSession();
    PropPriceDaos = session.createQuery("from PropPriceDao").list();
    return PropPriceDaos;
  }

  /**
   * @param PropPriceDaoid
   * @return
   */
  public PropPriceDao getPropPriceDaoById(int propSalePriceId) throws HibernateException
  {
    PropPriceDao propPriceDao = null;
    Session session = sessionFactory.getCurrentSession();
    String queryString = "from PropPriceDao where propSalePriceId = :propSalePriceId";
    Query query = session.createQuery(queryString);
    query.setInteger("propSalePriceId", propSalePriceId);
    propPriceDao = (PropPriceDao) query.uniqueResult();
    return propPriceDao;
  }
}

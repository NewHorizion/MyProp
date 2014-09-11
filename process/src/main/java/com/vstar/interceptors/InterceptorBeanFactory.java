package com.vstar.interceptors;


import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import org.apache.struts2.ServletActionContext;

/**
 * Interceptors that need beans should retrieve them from this factory.
 */
public class InterceptorBeanFactory
{
  /**
   * @param beanName the name of the bean to create.
   * @param beanClass the type of the bean.
   * @return the Spring bean.
   */
  public static Object createBean(String beanName, Class beanClass) {
    ServletContext servletContext = ServletActionContext.getServletContext();
    WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    return context.getBean(beanName, beanClass);
  }
}

package com.vstar.interceptors;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.NoParameters;

public class JsonToParamInterceptor extends AbstractInterceptor {

	protected Map<String, Object> retrieveParameters(ActionContext ac) {
		return ac.getParameters();
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction().getClass();
		Field[] actionFields = invocation.getAction().getClass()
				.getDeclaredFields();
		Method[] actionMethods = invocation.getAction().getClass()
				.getDeclaredMethods();
		if (!(action instanceof NoParameters)) {
			ActionContext ac = invocation.getInvocationContext();
			Map parameters = retrieveParameters(ac);
			Gson gson = new Gson();

			if (parameters != null) {

				try {
					for (Object param : parameters.keySet()) {
						String key = (String) param;
						if ("jsonData".equals(key)) {

							String[] jsonData = (String[]) parameters
									.get(param);
							JSONObject json = new JSONObject(jsonData[0]);
							if (null != json) {
								for (Field field : actionFields) {
									if (json.has(field.getName())) {
										for (Method method : actionMethods) {
											if (method
													.getName()
													.equalsIgnoreCase(
															"set"
																	+ field.getName())) {
												try {
													String name = (String) field
															.getName();
													Object value = gson
															.fromJson(
																	json.getString(field
																			.getName()),
																	field.getType());
													ac.getValueStack()
															.setParameter(name,
																	value);
												} catch (Exception e) {
													ac.getConversionErrors()
															.put(jsonData[0],
																	method.getReturnType()
																			.getClass());
												}
											}
										}
									}
								}
							}
						}
					}

				} finally {
				}
			}
		}
		return invocation.invoke();
	}

}

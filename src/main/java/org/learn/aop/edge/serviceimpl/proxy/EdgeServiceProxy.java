package org.learn.aop.edge.serviceimpl.proxy;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.learn.edge.login.service.LoginEdgeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * EdgeService的方法拦截器，主要用于记录日志
 */
public class EdgeServiceProxy implements MethodInterceptor {
	static Logger logger = LoggerFactory.getLogger(EdgeServiceProxy.class);    
	public EdgeServiceProxy() {
		super();
	}

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		Object[] paramObj = methodInvocation.getArguments();
		/**
		 * 判断传入参数
		 * 
		 */
		Method method = methodInvocation.getMethod();
		Class<?> cls = method.getDeclaringClass();
		/**
		 * 判定代理的类和代理的方法名称
		 */
		if(cls == LoginEdgeService.class && method.getName() == "updatePassword"){
			long startTime = System.currentTimeMillis();
			Object rtnObj = null;
			try {
				rtnObj =  methodInvocation.proceed();
				return rtnObj;
			}
			finally {
				logServiceUsedTime(cls.getName(), method.getName(), startTime, paramObj, rtnObj);
			}
		}
		return methodInvocation.proceed();
	}
	/**
	 * 记录服务使用时间、参数、返回结果等
	 * @param serviceName
	 * @param methodName
	 * @param startTime
	 * @param obj
	 * @param rtnObj
	 */
	private void logServiceUsedTime(String serviceName, String methodName, long startTime, Object[] obj, Object rtnObj) {
		logger.info("Service [{}] method[{}] returned used [{}]ms", serviceName, methodName, System.currentTimeMillis()-startTime);
		logger.info("Service [{}] method[{}] parameter [{}] return [{}].", serviceName, methodName, JSON.toJSONString(obj), JSON.toJSONString(rtnObj));
	}
}

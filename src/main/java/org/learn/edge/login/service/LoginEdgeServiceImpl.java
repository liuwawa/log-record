package org.learn.edge.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class LoginEdgeServiceImpl implements LoginEdgeService {
	static Logger logger = LoggerFactory.getLogger(LoginEdgeServiceImpl.class);  
	@Override
	public Boolean updatePassword(String str) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("updatePassword success");
		return true;
	}

}

package org.learn.text;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.edge.login.service.LoginEdgeService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ServiceTest extends AbstractJUnit4SpringContextTests {
	@Resource
	protected LoginEdgeService loginEdgeService;
	
	 @Test  
		public void testReport() {
		 loginEdgeService.updatePassword("111111");
		}
	 
}

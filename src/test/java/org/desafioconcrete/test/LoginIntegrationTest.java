package org.desafioconcrete.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import desafio.concrete.config.PersistenceJPAConfig;
import desafio.concrete.dao.UserDao;
import desafio.concrete.model.User;
import desafio.concrete.service.JwtService;
import desafio.concrete.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceJPAConfig.class, UsuarioService.class, UserDao.class, JwtService.class }, loader = AnnotationConfigContextLoader.class)
public class LoginIntegrationTest {

	@Autowired
	private UsuarioService userService;
	
	private User user;
	
	@Before
	public void initUser() {
		user = new User();
		user.setEmail("Teste@gmail.com");
		
	}
	
	@Test
	public final void findUserByEmail() {
		userService.findUserByEmail(user);
		Assert.assertNotNull(user);
	}
	
	@Test
	public final void errorPassword() {
		User user1 = new User();
		user1.setPassword("1111");
		User user2 = new User();
		user2.setPassword("00000");
		Assert.assertFalse(userService.isEqualsPassword(user1.getPassword(), user2.getPassword()));
	}
	
	
}

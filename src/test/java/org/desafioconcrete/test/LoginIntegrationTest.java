package org.desafioconcrete.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import desafio.concrete.config.PersistenceJPAConfig;
import desafio.concrete.dao.UsuarioDao;
import desafio.concrete.model.Usuario;
import desafio.concrete.service.JwtService;
import desafio.concrete.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceJPAConfig.class, UsuarioService.class, UsuarioDao.class, JwtService.class }, loader = AnnotationConfigContextLoader.class)
public class LoginIntegrationTest {

	@Autowired
	private UsuarioService userService;
	
	@Test
	public final void create() {
		Usuario user = new Usuario();
		user.setName("Ruben");
		user.setEmail("Ruben@gmail.com");
		user.setPassword("1111");
		user.setDtCreated(new Date());
		user.setDtLastLogin(new Date());
		user.setDtLastModified(new Date());
		userService.create(user);
		Assert.assertNotNull(user);
	}
	
	@Test
	public final void findUserByEmail() {
		Usuario user = new Usuario();
		user.setEmail("Rubens@gmail.com");
		userService.findUserByEmail(user);
		Assert.assertNotNull(user);
	}
	
	@Test
	public final void errorPassword() {
		Usuario user1 = new Usuario();
		user1.setPassword("1111");
		Usuario user2 = new Usuario();
		user2.setPassword("00000");
		Assert.assertFalse(userService.isEqualsPassword(user1.getPassword(), user2.getPassword()));
	}
	
	
}

package org.desafioconcrete.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import desafio.concrete.config.PersistenceJPAConfig;
import desafio.concrete.dao.UsuarioDao;
import desafio.concrete.model.User;
import desafio.concrete.service.JwtService;
import desafio.concrete.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceJPAConfig.class, UsuarioService.class, UsuarioDao.class, JwtService.class }, loader = AnnotationConfigContextLoader.class)
public class CadastroIntegrationTest {

	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private JwtService jwtService;
	
	private User user;
	
	@Before
	public void initUser() {
		user = new User();
		user.setName("Teste");
		user.setEmail("Teste@gmail.com");
		user.setDtCreated(new Date());
		user.setDtLastLogin(new Date());
		user.setDtLastModified(new Date());
	}
	
	@Test
	public final void create() {
		if (userService.findUserByEmail(user) == null) {
			userService.create(user);
			Assert.assertNotNull(user);
		}
		
	}
	
	@Test(expected = DataIntegrityViolationException.class)
	public final void whenSameEmailIsCreatedTwice() {
		userService.create(user);
	}
	
	@Test
	public final void createToken() {
		Assert.assertNotNull(jwtService.createJWT(user));
	}
	
	
	@Test
	public final void findUserByEmail() {
		Assert.assertNotNull(userService.findUserByEmail(user));
	}
}

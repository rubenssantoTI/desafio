package org.desafioconcrete.test;

import org.junit.Assert;
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
public class PerfilIntegrationTest {

	@Autowired
	private JwtService jwtService;
    
			
	@Test
	public final void tokenNotFound() {
		User user1 = new User();
		user1.setEmail("teste1@gmail.com");
		user1.setToken(jwtService.createJWT(user1));
		
		User user2 = new User();
		user2.setToken("teste1@gmail.com");
		user2.setToken(jwtService.createJWT(user2));
		
		Assert.assertFalse(jwtService.isEqualsToken(user1.getToken(), user2.getToken()));
	}
	
	@Test
	public final void tokenInvalid() {
		Assert.assertFalse(jwtService.isTokenValido("XXdsfdskjsdsa"));
	}
	
	
}

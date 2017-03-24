package org.desafioconcrete.test;

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
public class PerfilIntegrationTest {

	@Autowired
	private JwtService jwtService;
    
			
	@Test
	public final void tokenNotFound() {
		Assert.assertFalse(jwtService.isEqualsToken("XXXX", "sdsadsad"));
	}
	
	@Test
	public final void tokenInvalid() {
		Usuario user = new Usuario();
		user.setToken("XXdsfdskjsdsa");
		Assert.assertFalse(jwtService.isTokenValido("XXdsfdskjsdsa"));
	}
	
	
}

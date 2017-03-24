package desafio.concrete.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import desafio.concrete.dao.IUsuarioDao;
import desafio.concrete.model.Usuario;

@Service
@Transactional
public class UsuarioService {
    
	@Autowired
	private JwtService jwtService;
	
    @Autowired
    private IUsuarioDao dao;

    public UsuarioService() {
        super();
    }

	public void create(Usuario entity) {
		entity.setToken(jwtService.createJWT(entity));
		dao.create(entity);
	}
	
	public Usuario update(Usuario entity) {
		return dao.update(entity);
	}

    public Usuario find(final long id) {
        return dao.findOne(id);
    }
    
    public Usuario findUserByEmail(final Usuario entity) {
        return dao.findUserByEmail(entity);
    }
    
    public Boolean isEqualsPassword(String pass1, String pass2) {
    	return pass1.equals(pass2); 
    }
}

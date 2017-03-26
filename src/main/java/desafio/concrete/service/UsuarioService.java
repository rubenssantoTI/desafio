package desafio.concrete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import desafio.concrete.dao.IUsuarioDao;
import desafio.concrete.model.User;

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
    
    /**
     * Create a User
     * @param entity
     */
	public void create(User entity) {
		entity.setToken(jwtService.createJWT(entity));
		dao.create(entity);
	}
	
	/**
     * update a User
     * @param entity
     */
	public User update(User entity) {
		return dao.update(entity);
	}

	/**
     * Find a User by id
     * @param entity
     */
    public User find(final long id) {
        return dao.findOne(id);
    }
    
    /**
     * Find a User by email
     * @param entity
     */
    public User findUserByEmail(final User entity) {
        return dao.findUserByEmail(entity);
    }
    
    /**
     * Verify is equal password
     * @param entity
     */
    public Boolean isEqualsPassword(String pass1, String pass2) {
    	return pass1.equals(pass2); 
    }
}

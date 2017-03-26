package desafio.concrete.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import desafio.concrete.model.User;

@Repository
public class UsuarioDao extends AbstractJpaDAO<User> implements IUsuarioDao {

    public UsuarioDao() {
        super();

        setClazz(User.class);
    }
    
    /**
     * Find the user by e-mail
     * @param enntity
     * @return
     */
    public User findUserByEmail(User enntity) {
    	User user = null;
    	try {
    		user = (User) super.entityManager.createNamedQuery("findUserByEmail").
    				setParameter("email", enntity.getEmail()).getSingleResult();
    	} catch(NoResultException e) {}
		return user;
    }
}

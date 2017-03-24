package desafio.concrete.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import desafio.concrete.model.Usuario;

@Repository
public class UsuarioDao extends AbstractJpaDAO<Usuario> implements IUsuarioDao {

    public UsuarioDao() {
        super();

        setClazz(Usuario.class);
    }
    
    /**
     * Find the user by e-mail
     * @param enntity
     * @return
     */
    public Usuario findUserByEmail(Usuario enntity) {
    	Usuario user = null;
    	try {
    		user = (Usuario) super.entityManager.createNamedQuery("findUserByEmail").
    				setParameter("email", enntity.getEmail()).getSingleResult();
    	} catch(NoResultException e) {}
		return user;
    }
    
    @SuppressWarnings("unchecked")
    public List<Usuario> findAll() {
        return entityManager.createQuery("select u from Usuario u LEFT JOIN FETCH  u.telefones t").getResultList();
    }

}

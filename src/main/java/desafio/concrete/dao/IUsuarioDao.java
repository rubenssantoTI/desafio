package desafio.concrete.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import desafio.concrete.model.Usuario;

@Repository
public interface IUsuarioDao {
    /**
     * Find user by id
     * 
     * @param id
     * @return
     */
    Usuario findOne(long id);
    /**
     * Find all users
     * 
     * @return
     */
    List<Usuario> findAll();
    /**
     * Create user
     * 
     * @param entity
     */
    void create(Usuario entity);
    /**
     * update user
     * 
     * @param entity
     * @return
     */
    Usuario update(Usuario entity);
    /**
     * Remove
     * 
     * @param entity
     */
    void delete(Usuario entity);
    /**
     * Remove by id
     * 
     * @param entity
     */
    void deleteById(long entityId);
   /**
    * Search user by e-mail
    * @param enntity
    * @return
    */
    Usuario findUserByEmail(Usuario enntity);
    
}

package desafio.concrete.dao;

import org.springframework.stereotype.Repository;

import desafio.concrete.model.User;

@Repository
public interface IUsuarioDao {
    /**
     * Find user by id
     * 
     * @param id
     * @return
     */
    User findOne(long id);
    /**
     * Create user
     * 
     * @param entity
     */
    void create(User entity);
    /**
     * update user
     * 
     * @param entity
     * @return
     */
    User update(User entity);
    /**
     * Remove
     * 
     * @param entity
     */
    void delete(User entity);
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
    User findUserByEmail(User enntity);
    
}

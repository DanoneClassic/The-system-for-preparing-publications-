package cvut.dao;

import cvut.model.AppUser;
import cvut.model.Autor;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;

@Repository
public class AutorDao extends BaseDao<Autor>{

    protected AutorDao(Class<Autor> type) {
        super(type);
    }

    public AppUser findByUsername(String username) {
        try {
            return em.createNamedQuery("autor.findByUsername", AppUser.class).setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}

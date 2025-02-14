package cvut.dao;

import cvut.model.AppUser;
import cvut.model.Reviewer;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewerDao extends BaseDao<Reviewer>{
    protected ReviewerDao() {
        super(Reviewer.class);
    }

    public AppUser findByUsername(String username) {
        try {
            return em.createNamedQuery("reviewer.findByUsername", AppUser.class).setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

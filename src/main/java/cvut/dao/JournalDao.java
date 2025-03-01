package cvut.dao;

import cvut.model.Journal;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;

@Repository
public class JournalDao extends BaseDao<Journal> {
    protected JournalDao(Class<Journal> type) {
        super(type);
    }

    public Journal findByName(String name) {
        try {
            return em.createNamedQuery("journal.findByName", Journal.class).setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

package cvut.dao;

import cvut.model.Review;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class ReviewDao extends BaseDao<Review>{
    protected ReviewDao() {
        super(Review.class);
    }

    public Review find(Integer id) {
        Objects.requireNonNull(id);
        return em.find(Review.class, id);
    }

}

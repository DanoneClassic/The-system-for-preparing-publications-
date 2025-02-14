package cvut.services;

import cvut.dao.ReviewDao;
import cvut.model.Review;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    private final ReviewDao reviewDao;


    public ReviewService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Transactional(readOnly = true)
    public Review find(Integer id) {
        return reviewDao.find(id);
    }
}

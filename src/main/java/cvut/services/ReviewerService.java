package cvut.services;

import cvut.dao.ReviewerDao;
import cvut.model.Review;
import cvut.model.ReviewState;
import cvut.model.Reviewer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewerService {

    private final ReviewerDao reviewerDao;
    private final PasswordEncoder passwordEncoder;
    final Reviewer currentUser = new Reviewer();

    public ReviewerService(ReviewerDao reviewerDao, PasswordEncoder passwordEncoder) {
        this.reviewerDao = reviewerDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public boolean exists(String username) {
        return reviewerDao.findByUsername(username) != null;
    }

    public void createReview(Reviewer reviewer) {
        final Review review = new Review();
        review.setCritiqueState(ReviewState.ACCEPTED);
        reviewer.addReview(review);
    }

    public Review getCurrentReview() {
        if (currentUser.getReviewList().isEmpty()){
            return null;
        }
        return currentUser.getReviewList().get(currentUser.getReviewList().size()-1);
    }
}

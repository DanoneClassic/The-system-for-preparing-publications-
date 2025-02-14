package cvut.dao;

import cvut.model.Article;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;


@Repository
public class ArticleDao extends BaseDao<Article>{
    protected ArticleDao(Class<Article> type) {
        super(type);
    }

    public Article findByTitle(String title) {
        try {
            return em.createNamedQuery("article.findByTitle", Article.class).setParameter("title", title)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

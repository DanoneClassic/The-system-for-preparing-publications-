package cvut.services;

import cvut.dao.ArticleDao;
import cvut.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ArticleService {
    private final ArticleDao dao;

    @Autowired
    public ArticleService(ArticleDao dao) {
        this.dao = dao;
    }

    @Transactional
    public Article findByTitle(String title) {
        Objects.requireNonNull(title, "Title cannot be null");
        return dao.findByTitle(title);
    }

    @Transactional
    public List<Article> findAll() {
        return dao.findAll();
    }

    @Transactional
    public void persist(Article article) {
        Objects.requireNonNull(article);
        dao.persist(article);
    }
}

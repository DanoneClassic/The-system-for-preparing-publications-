package cvut.services;

import cvut.dao.ArticleDao;
import cvut.dao.AutorDao;
import cvut.model.Article;
import cvut.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class AutorService {
    private final AutorDao dao;
    private final ArticleDao articleDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AutorService(AutorDao autorDao, ArticleDao articleDao, PasswordEncoder passwordEncoder) {
        this.dao = autorDao;
        this.articleDao = articleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public boolean exists(String username) {
        return dao.findByUsername(username) != null;
    }

    @Transactional
    public Autor findByUsername(String username) {
        Objects.requireNonNull(username, "Username cannot be null");
        return (Autor) dao.findByUsername(username);
    }
    
    @Transactional
    public List<Autor> findAll() {
        return dao.findAll();
    }

    @Transactional
    public void createArticle(Autor autor, String title, String content) {
        final Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAutor(autor);
        articleDao.persist(article);
    }

    @Transactional
    public void persist(Autor autor) {
        Objects.requireNonNull(autor);
        dao.persist(autor);
    }
}

package cvut;

import cvut.dao.ArticleDao;
import cvut.model.Article;
import cvut.model.Autor;
import cvut.services.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@AutoConfigureTestEntityManager
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles("test")
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private TestEntityManager em;

//    @BeforeEach
//    void setUp() {
//    }

    @Test
    void testFindByTitle() {
        Autor autor = new Autor("John", "Doe", "doejohn", "1243", "john@doe.cz");
        String title = "Lorem ipsum";
        String content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.";
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAutor(autor);
        articleDao.persist(article);

        Article result = articleService.findByTitle(title);
        assertEquals(title, result.getTitle());
    }
}

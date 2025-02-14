package cvut;

import cvut.dao.ArticleDao;
import cvut.dao.AutorDao;
import cvut.model.Article;
import cvut.model.Autor;
import cvut.services.AutorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AutorServiceTest {
    @Mock
    private AutorDao autorDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    private ArticleDao articleDao;
    private AutorService autorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        articleDao = new ArticleDao(Article.class);
        autorService = new AutorService(autorDao, articleDao, passwordEncoder);

    }

    @Test
    void testAutorExists() {
        String username = "testUser";
        when(autorDao.findByUsername(username)).thenReturn(new Autor());

        boolean result = autorService.exists(username);

        assertTrue(result);
        verify(autorDao).findByUsername(username);
    }

    @Test
    void testAutorDoesNotExist() {
        String username = "testUser";
        when(autorDao.findByUsername(username)).thenReturn(null);

        boolean result = autorService.exists(username);

        assertFalse(result);
        verify(autorDao).findByUsername(username);
    }

    @Test
    void testCreateAnArticle() {
        Autor autor = new Autor("John", "Doe", "doejohn", "1243", "john@doe.cz");
        String title = "Lorem ipsum";
        String content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.";
        autorService.createArticle(autor, title, content);

        final Article result = articleDao.findByTitle("Lorem ipsum");
        assertEquals(content, result.getContent());
    }
}

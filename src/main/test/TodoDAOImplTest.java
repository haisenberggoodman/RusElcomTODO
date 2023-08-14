import com.webvasev.ruselcomtodo.dao.TodoDAO;
import com.webvasev.ruselcomtodo.dao.TodoDAOImpl;
import com.webvasev.ruselcomtodo.entity.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TodoDAOImplTest {

    @Mock
    private EntityManager entityManager;

    private TodoDAO todoDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        todoDAO = new TodoDAOImpl(entityManager);
    }

    @Test
    void saveTest() {
        Todo todo = new Todo();
        todoDAO.save(todo);

        verify(entityManager, times(1)).persist(todo);
    }

    @Test
    void updateTest() {
        Todo todo = new Todo();
        todoDAO.update(todo);

        verify(entityManager, times(1)).merge(todo);
    }

    @Test
    void deleteTest() {
        Long id = 1L;
        Todo todo = new Todo();
        when(entityManager.find(Todo.class, id)).thenReturn(todo);

        todoDAO.delete(id);

        verify(entityManager, times(1)).refresh(todo);
    }

    @Test
    void getByIdTest() {
        Long id = 1L;
        Todo todo = new Todo();
        when(entityManager.find(Todo.class, id)).thenReturn(todo);

        Todo result = todoDAO.getById(id);

        assertEquals(todo, result);
    }

    @Test
    void getAllTest() {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo());
        todos.add(new Todo());
        TypedQuery<Todo> typedQuery = mock(TypedQuery.class);
        when(entityManager.createQuery("select t from Todo t", Todo.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(todos);

        List<Todo> result = todoDAO.getAll();

        assertEquals(todos, result);
    }
}
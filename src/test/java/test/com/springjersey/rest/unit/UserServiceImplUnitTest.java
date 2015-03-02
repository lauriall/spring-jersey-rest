package test.com.springjersey.rest.unit;

import com.springjersey.rest.usermanagement.entity.Role;
import com.springjersey.rest.usermanagement.entity.User;
import com.springjersey.rest.usermanagement.repository.UserRepository;
import com.springjersey.rest.usermanagement.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplUnitTest {

    @Mock
    private UserRepository repo;
    
    @InjectMocks
    private UserServiceImpl service;

    @Before
    public void setUp() throws Exception {
        service = new UserServiceImpl(repo);
    }
    
    @Test
    public void readAll() {
        service.readAll();
        verify(repo, times(1)).findAll();
    }
    
    @Test
    public void readOne() {
        service.read(1L);
        verify(repo, times(1)).findOne(1L);
    }
    
    @Test
    public void findByName() {
        service.readUser("foobar");
        verify(repo, times(1)).findByName("foobar");
    }
    
    @Test
    public void findByEmail() {
        service.readByEmail("mail@mail.nk");
        verify(repo, times(1)).findByEmail("mail@mail.nk");
    }

    @Test
    public void saveUserTest() {
        User user = new User("name", "mail@mail.ma", new ArrayList<Role>(){{add(new Role("role"));}});
        service.saveUser(user);
        verify(repo, times(1)).save(user);
    }

    @Test
    public void updateUser() {
        User user = new User("name", "mail@mail.ma", new ArrayList<Role>(){{add(new Role("role"));}});
        service.updateUser(user);
        verify(repo, times(1)).save(user);
    }
    
    @Test
    public void deleteUserTest() {
        User user = new User("name", "mail@mail.ma", new ArrayList<Role>(){{add(new Role("role"));}});
        service.deleteUser(user);
        verify(repo, times(1)).delete(user);
    }
    
    @Test
    public void deleteUserById() {
        service.deleteUserById(1L);
        verify(repo, times(1)).delete(1L);
    }
}
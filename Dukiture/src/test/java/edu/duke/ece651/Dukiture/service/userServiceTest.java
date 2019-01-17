package edu.duke.ece651.Dukiture.service;

import edu.duke.ece651.Dukiture.model.User;
import edu.duke.ece651.Dukiture.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class userServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByName(){
        User aMockUser = new User();
        aMockUser.setUsername("xl");
        aMockUser.setPassword("1234");

        when(userRepository.findByUsername(any(String.class))).thenReturn(aMockUser);

        User userFound = userService.findByUsername(null);

        assertEquals("xl", userFound.getUsername());
        assertEquals("1234", userFound.getPassword());
    }
}

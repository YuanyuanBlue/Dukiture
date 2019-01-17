package edu.duke.ece651.Dukiture.service;

import edu.duke.ece651.Dukiture.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class userServiceComp {

    @Autowired
    private UserService userService;

    @Test
    public void testSave() {

        User aNewUser = new User();
        aNewUser.setUsername("xl");
        aNewUser.setPassword("1234");

        userService.save(aNewUser);
        User userFound = userService.findByUsername("xl");

        assertNotNull(userFound);
        assertNotNull(userFound.getId());
        assertEquals("xl", userFound.getUsername());
//        assertEquals("1234", userFound.getPassword());
    }
}

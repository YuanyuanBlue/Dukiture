package edu.duke.ece651.Dukiture.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import  edu.duke.ece651.Dukiture.model.User;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class userRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        User aNewUser = new User();
        aNewUser.setUsername("xl");
//        aNewUser.setId((long) 2);
        aNewUser.setPassword("123456");

        entityManager.persist(aNewUser);

        User foundUser = userRepository.findByUsername("xl");

        assertThat(foundUser.getPassword(), is(equalTo("123456")));
    }

//    @Test
//    public void testFindByUsername_notExist() {
//        User aNewUser = new User();
//        aNewUser.setUsername("xl");
//        aNewUser.setId((long) 1);
//        aNewUser.setPassword("123456");
//
//        entityManager.persist(aNewUser);
//
//        User foundUser = userRepository.findByUsername("zz");
//
//        assertNull(foundUser);
////        assertThat(foundUser.getId(), is(equalTo(1)));
//
//    }
}
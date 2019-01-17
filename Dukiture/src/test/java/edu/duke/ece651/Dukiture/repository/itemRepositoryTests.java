package edu.duke.ece651.Dukiture.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import  edu.duke.ece651.Dukiture.model.User;
import  edu.duke.ece651.Dukiture.model.Item;
import java.util.List;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class itemRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUser_Username() {
        User aNewUser = new User();
        aNewUser.setUsername("xl");
//        aNewUser.setId((long) 1);
        aNewUser.setPassword("123456");

        entityManager.persist(aNewUser);

        User foundUser = userRepository.findByUsername("xl");

        assertThat(foundUser.getPassword(), is(equalTo("123456")));
//        assertThat(foundUser.getId(), is(equalTo(1)));

        Date present = new Date();
        Item aNewItem = new Item();
        aNewItem.setUser(aNewUser);
        aNewItem.setDate(present);
        aNewItem.setAddress("aaa");
        aNewItem.setPrice(1.23);

        entityManager.persist(aNewItem);

        List<Item> itemFounds = itemRepository.findByUser_Username("xl");
        assertThat(itemFounds.get(0).getDate(), is(equalTo(present)));
        assertThat(itemFounds.get(0).getAddress(), is(equalTo("aaa")));
        assertThat(itemFounds.get(0).getPrice(), is(equalTo(1.23)));

//        private Long id;
//        private double price;
//        private String itemName;
//        private String description;
//        private String ownerUsername;
//        private String contactInfo;
//        private String imagePath;
//        private String address;
//        private User user;
//        private Date date;


    }
}

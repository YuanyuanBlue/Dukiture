package edu.duke.ece651.Dukiture.service;

import edu.duke.ece651.Dukiture.model.Item;
import edu.duke.ece651.Dukiture.model.ItemForm;
import edu.duke.ece651.Dukiture.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class itemServiceComp {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Test
    public void testSave() {

        Date present = new Date();
        Item aNewItem = new Item();
        aNewItem.setItemName("item1");
        aNewItem.setDate(present);
        aNewItem.setAddress("aaa");
        aNewItem.setPrice(1.23);

        Item itemAdded = itemService.save(aNewItem);
        assertEquals(aNewItem, itemAdded);
    }

    @Test
    public void testSaveItemForm() {

        Date present = new Date();


        ItemForm aNewItemForm = new ItemForm();
        aNewItemForm.setDate(present);
        aNewItemForm.setContactInfo("aaa");
        aNewItemForm.setAddress("duke");
        aNewItemForm.setItemName("testSaveItemForm");
        aNewItemForm.setPrice(1.23);

        Item itemAdded = itemService.saveItemForm(aNewItemForm);

        Item aNewItem = new Item();
        aNewItem.setDate(aNewItemForm.getDate());
        aNewItem.setContactInfo(aNewItemForm.getContactInfo());
        aNewItem.setAddress(aNewItemForm.getAddress());
        aNewItem.setItemName(aNewItemForm.getItemName());
        aNewItem.setPrice(aNewItemForm.getPrice());

        assertEquals(aNewItem.getDate(), itemAdded.getDate());
        assertEquals(aNewItem.getContactInfo(), itemAdded.getContactInfo());
        assertEquals(aNewItem.getAddress(), itemAdded.getAddress());
        assertEquals(aNewItem.getItemName(), itemAdded.getItemName());
        assertEquals(aNewItem.getPrice(), itemAdded.getPrice(), 0.01);
    }

    @Test
    public void testGetAllItems() {

        Date present = new Date();
        Item aNewItem = new Item();
        aNewItem.setItemName("item1");
        aNewItem.setDate(present);
        aNewItem.setAddress("aaa");
        aNewItem.setPrice(1.23);

        Item aNewItem2 = new Item();
        aNewItem2.setItemName("item2");
        aNewItem2.setDate(present);
        aNewItem2.setAddress("aaa");
        aNewItem2.setPrice(1.23);

        itemService.save(aNewItem);
        itemService.save(aNewItem2);


        List<Item> newItems = new ArrayList<Item>();
        newItems.add(aNewItem);
        newItems.add(aNewItem2);

        List<Item> itemsFound = itemService.getAllItems();
        assertEquals(itemsFound.get(0).getItemName(), aNewItem.getItemName());
        assertEquals(itemsFound.get(1).getItemName(), aNewItem2.getItemName());
    }

    @Test
    public void testGetByUsername() {

        User aNewUser = new User();
        aNewUser.setUsername("xl");
        aNewUser.setPassword("123456");

        userService.save(aNewUser);

        User aNewUser2 = new User();
        aNewUser2.setUsername("xl2");
        aNewUser2.setPassword("123456");

        userService.save(aNewUser2);

        Date present = new Date();
        Item aNewItem = new Item();
        aNewItem.setItemName("item1");
        aNewItem.setUser(aNewUser);
        aNewItem.setDate(present);
        aNewItem.setAddress("aaa");
        aNewItem.setPrice(1.23);

        Item aNewItem2 = new Item();
        aNewItem2.setItemName("item2");
        aNewItem.setUser(aNewUser2);
        aNewItem2.setDate(present);
        aNewItem2.setAddress("aaa");
        aNewItem2.setPrice(1.23);

        List<Item> newItems = new ArrayList<>();
        newItems.add(aNewItem);
        List<Item> newItems2 = new ArrayList<>();
        newItems2.add(aNewItem2);

        itemService.save(aNewItem);
        itemService.save(aNewItem2);

        List<Item> itemsFound = itemService.getByUsername("xl");
        assertEquals(aNewItem.getItemName(), itemsFound.get(0).getItemName());
        assertEquals(aNewItem.getDate(), itemsFound.get(0).getDate());
        assertEquals(aNewItem.getAddress(), itemsFound.get(0).getAddress());
        assertEquals(aNewItem.getPrice(), itemsFound.get(0).getPrice(), 0.01);


        List<Item> itemsFound2 = itemService.getByUsername("xl2");
        assertEquals(aNewItem2.getItemName(), itemsFound2.get(0).getItemName());
        assertEquals(aNewItem2.getDate(), itemsFound2.get(0).getDate());
        assertEquals(aNewItem2.getAddress(), itemsFound2.get(0).getAddress());
        assertEquals(aNewItem2.getPrice(), itemsFound2.get(0).getPrice(), 0.01);

    }
}

package edu.duke.ece651.Dukiture.service;

import edu.duke.ece651.Dukiture.model.Item;
import edu.duke.ece651.Dukiture.model.User;
import edu.duke.ece651.Dukiture.repository.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class itemServiceTest {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllItems() {
        List<Item> newItems = new ArrayList<Item>();


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

        newItems.add(aNewItem);
        newItems.add(aNewItem2);

        when(itemRepository.findAll()).thenReturn(newItems);

        List<Item> itemsFound = itemService.getAllItems();

        assertThat(itemsFound, containsInAnyOrder(newItems.toArray()));
    }

    @Test
    public void testGetByUsername() {
        List<Item> newItems = new ArrayList<>();


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

        newItems.add(aNewItem);
        newItems.add(aNewItem2);

        when(itemRepository.findByUser_Username("item1")).thenReturn(Arrays.asList(aNewItem));
        when(itemRepository.findByUser_Username("item2")).thenReturn(Arrays.asList(aNewItem2));

        List<Item> Items1 = itemService.getByUsername("item1");
        assertEquals(Items1, Arrays.asList(aNewItem));

        List<Item> Items2 = itemService.getByUsername("item2");
        assertEquals(Items2, Arrays.asList(aNewItem2));
    }
}

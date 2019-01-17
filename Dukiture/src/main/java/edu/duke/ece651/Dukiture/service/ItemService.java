package edu.duke.ece651.Dukiture.service;

import edu.duke.ece651.Dukiture.model.Item;
import edu.duke.ece651.Dukiture.model.ItemForm;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    List<Item> getByUsername(String username);
    Item getById(long id);
    Item save(Item item);
    Item saveItemForm(ItemForm itemForm);
    void delete(long id);
}

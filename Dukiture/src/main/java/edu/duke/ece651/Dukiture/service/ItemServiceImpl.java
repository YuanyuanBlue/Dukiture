package edu.duke.ece651.Dukiture.service;

import edu.duke.ece651.Dukiture.converter.ItemFormToItem;
import edu.duke.ece651.Dukiture.model.Item;
import edu.duke.ece651.Dukiture.model.ItemForm;
import edu.duke.ece651.Dukiture.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepo;
    private ItemFormToItem itemFormToItem;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepo, ItemFormToItem itemFormToItem) {
        this.itemRepo = itemRepo;
        this.itemFormToItem = itemFormToItem;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        items.addAll(itemRepo.findAll());
        return items;
    }

    @Override
    public Item getById(long id) {
        return itemRepo.findOne(id);
    }

    @Override
    public List<Item> getByUsername(String username){ return itemRepo.findByUser_Username(username); }

    @Override
    public Item save(Item item) {
        itemRepo.save(item);
        return item;
    }

    @Override
    public Item saveItemForm(ItemForm itemForm) {

        Item item = save(itemFormToItem.convert(itemForm));
        return item;
    }

    @Override
    public void delete(long id) {
        itemRepo.delete(id);
    }
}

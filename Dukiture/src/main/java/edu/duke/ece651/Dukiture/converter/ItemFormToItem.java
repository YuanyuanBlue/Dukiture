package edu.duke.ece651.Dukiture.converter;


import edu.duke.ece651.Dukiture.model.ItemForm;
import edu.duke.ece651.Dukiture.model.Item;
import edu.duke.ece651.Dukiture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ItemFormToItem implements Converter<ItemForm, Item> {
    @Autowired
    private UserRepository users;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Item convert(ItemForm form) {
        Item item = new Item();
        item.setDescription(form.getDescription());
        item.setItemName(form.getItemName());
        item.setPrice(form.getPrice());
        item.setOwnerUsername(form.getOwnerUsername());
        item.setId(form.getId());
        item.setContactInfo(form.getContactInfo());
        item.setOwnerUsername(form.getOwnerUsername());
        item.setAddress(form.getAddress());
        item.setDate(form.getDate());
        item.setUser(users.findByUsername(form.getOwnerUsername()));
        return item;
    }

}

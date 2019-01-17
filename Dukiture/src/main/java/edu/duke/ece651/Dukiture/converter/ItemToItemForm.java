package edu.duke.ece651.Dukiture.converter;

import edu.duke.ece651.Dukiture.model.Item;
import edu.duke.ece651.Dukiture.model.ItemForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemForm implements Converter<Item, ItemForm> {
    @Override
    public ItemForm convert(Item item) {
        ItemForm form = new ItemForm();
        form.setDescription(item.getDescription());
        form.setItemName(item.getItemName());
        form.setPrice(item.getPrice());
        form.setOwnerUsername(item.getOwnerUsername());
        form.setId(item.getId());
        form.setContactInfo(item.getContactInfo());
        form.setOwnerUsername(item.getOwnerUsername());
        form.setAddress(item.getAddress());
        form.setDate(item.getDate());
        return form;
    }
}

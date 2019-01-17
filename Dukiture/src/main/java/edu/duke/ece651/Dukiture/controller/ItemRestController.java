package edu.duke.ece651.Dukiture.controller;

import edu.duke.ece651.Dukiture.service.ItemService;
import edu.duke.ece651.Dukiture.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@Secured({"ROLE_USER","ROLE_ADMIN"})
public class ItemRestController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/api/items/", method = RequestMethod.GET)
    public Map<String, String> getItem(HttpServletRequest request) {
        Item target = itemService.getById(Long.valueOf(request.getParameter("id")));
        if (target == null) {
            return new HashMap<>() ;
        }
        return itemToJson(target);
    }

    @RequestMapping(value = "/api/items/list", method = RequestMethod.GET)
    public List<Map<String, String>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        if (items.size() == 0) {
            return new ArrayList<>();
        }
        List<Map<String, String>> jsonList = new ArrayList<>();
        for (Item item : items) {
            Map<String, String> itemString = itemToJson(item);
            jsonList.add(itemString);
        }
        return jsonList;
    }

    private Map<String, String> itemToJson(Item item) {
        Map<String, String> tmp = new HashMap<>();
        tmp.put("itemName", item.getItemName());
        tmp.put("price", item.getPrice() + "");
        tmp.put("address", item.getAddress());
        tmp.put("owner", item.getOwnerUsername());
        tmp.put("contact", item.getContactInfo());
        tmp.put("description", item.getDescription());
        return tmp;
    }

}

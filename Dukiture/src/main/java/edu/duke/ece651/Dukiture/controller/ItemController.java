package edu.duke.ece651.Dukiture.controller;

import edu.duke.ece651.Dukiture.service.ItemService;
import edu.duke.ece651.Dukiture.converter.ItemToItemForm;
import edu.duke.ece651.Dukiture.model.Item;
import edu.duke.ece651.Dukiture.model.ItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class ItemController {
    private ItemService itemService;
    private ItemToItemForm itemToItemForm;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Autowired
    public void setItemToItemForm(ItemToItemForm itemToItemForm) {
        this.itemToItemForm = itemToItemForm;
    }


    @RequestMapping({"/items", "/items/list"})
    public String getAllItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "items/list";
    }

    @RequestMapping("/items/show/{id}")
    public String getItem(@PathVariable String id, Model model) {
        model.addAttribute("item", itemService.getById(Long.valueOf(id)));
        return "items/show";
    }

    @RequestMapping("/items/edit/{id}")
    public String editItem(HttpServletRequest request, @PathVariable String id, Model model) {
        Item item = itemService.getById(Long.valueOf(id));
        if (item.getOwnerUsername().compareTo(request.getRemoteUser()) != 0) {
            return "redirect:/items/list";
        }
        ItemForm itemForm = itemToItemForm.convert(item);
        model.addAttribute("itemForm", itemForm);
        return "items/itemform";
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public String saveOrUpdateItem(@Valid ItemForm itemForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "items/itemform";
        }
        itemForm.setDate(new Date());
        itemService.saveItemForm(itemForm);
        return "redirect:/items/list";
    }

    @RequestMapping("items/new")
    public String createItem(Model model) {
        ItemForm itemForm = new ItemForm();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        itemForm.setOwnerUsername(auth.getName());
        model.addAttribute("itemForm", itemForm);
        return "items/itemForm";
    }

    @RequestMapping("/items/delete/{id}")
    public String delete(HttpServletRequest request, @PathVariable String id) {
        Item toDelete = itemService.getById(Long.valueOf(id));
        if (toDelete.getOwnerUsername().compareTo(request.getRemoteUser()) != 0) {
            return "redirect:/items/list";
        }
        itemService.delete(Long.valueOf(id));
        return "redirect:/items/list";
    }
}

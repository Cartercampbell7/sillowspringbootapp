package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.PropertyBusinessServiceInterface;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gcu.model.PropertyModel;

@Controller
@RequestMapping("/orders")
public class OrdersController 
{
    @Autowired
    private PropertyBusinessServiceInterface propertyService;

    @GetMapping("/")
    public String showAllProperties(Model model)
    {
        List<PropertyModel> properties = propertyService.getProperties();
        model.addAttribute("title", "Available Properties");
        model.addAttribute("properties", properties);
        return "properties.html";
    }

    @GetMapping("/new")
    public String newProperty(Model model)
    {
        model.addAttribute("property", new PropertyModel());
        return "newProperty";
    }

    @PostMapping("/processNew")
    public String processNew(PropertyModel property)
    {
        propertyService.addOne(property);
        return "redirect:/orders/";
    }

    @PostMapping("/search")
    public String searchProduct(String searchTerm, Model model) 
    { 
    List<PropertyModel> properties;
    // Check for null search term
    if (searchTerm != null) {
        properties = propertyService.searchProperties(searchTerm.toLowerCase());
    } else {
        // Return all properties
        properties = propertyService.getProperties();
    }
    model.addAttribute("resultProperties", properties);
    return "searchResults";
    }


    @PostMapping("/delete/{nameOfProperty}")
    public String deleteProduct(@PathVariable(value="nameOfProperty")String nameOfProperty, Model model)
    {
        List<PropertyModel> properties = propertyService.getProperties();
        for(int i = 0; i < properties.size(); i++)
        {
            if(properties.get(i).getNameOfProperty().equals(nameOfProperty))
            {
                propertyService.deleteOne(nameOfProperty);
            }
        }
        return "redirect:/orders/";
    }

    @PostMapping("/{nameOfProperty}")
    public String updateProperty(@PathVariable String nameOfProperty, @ModelAttribute PropertyModel updatedProperty) {
        propertyService.updateOne(nameOfProperty, updatedProperty);
        return "redirect:/orders/";
    }

    @GetMapping("/{nameOfProperty}")
    public String showPropertyDetails(@PathVariable("nameOfProperty") String nameOfProperty, Model model)
    {
        PropertyModel property = propertyService.getPropertyByName(nameOfProperty);
        model.addAttribute("property", property);
        return "propertyDetails.html";
    }

    @GetMapping("/edit/{nameOfProperty}")
    public String editPropertyForm(@PathVariable String nameOfProperty, Model model) {
        PropertyModel property = propertyService.getPropertyByName(nameOfProperty);
        model.addAttribute("property", property);
        return "editProperty";
    }
    
    @PutMapping("/edit/{nameOfProperty}")
    public String editPropertySubmit(@PathVariable String nameOfProperty, @ModelAttribute PropertyModel property) {
        propertyService.updateOne(nameOfProperty, property);
        return "redirect:/orders/";
    }
}

package com.gcu.data;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gcu.data.PropertyDataAccessInterface;
import com.gcu.model.PropertyModel;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class PropertyFakeDAO implements PropertyDataAccessInterface 
{
    private List<PropertyModel> properties = new ArrayList<PropertyModel>();

    public PropertyFakeDAO()
    {   
        properties = new ArrayList<PropertyModel>();
        Date date = new Date();
       properties.add(new PropertyModel("Big House", "Phoenix", 7000, "bigphoto.jpg", "Really, really big house", 600000, "01/02/2023"));
       properties.add(new PropertyModel("Small House", "Phoenix", 1200, "smallphoto.jpg", "Really, really small house", 80000, "01/02/2023"));
       properties.add(new PropertyModel("Beach House", "California", 1900, "beachphoto.jpg", "Pretty beach house", 400000, "01/02/2023"));
       properties.add(new PropertyModel("Castle", "Phoenix", 20000, "castlephoto.jpg", "Large, old castle", 800000, "01/02/2023"));
       properties.add(new PropertyModel("Modern House", "Phoenix", 2300, "modernphoto.jpg", "Sleek, modern house", 290000, "01/02/2023"));

    }

    @Override
    public int addOne(PropertyModel newProperty) 
    {
        boolean success = properties.add(newProperty);
        System.out.println("I added one item. Now there are " + properties.size() + " items in the list.");
        if (success) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<PropertyModel> getProperties() 
    {
        return properties;
    }

    @Override
    public List<PropertyModel> searchProperties(String searchTerm) 
    {
        List<PropertyModel> foundItems = new ArrayList<PropertyModel>();
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getNameOfProperty().toLowerCase().contains(searchTerm.toLowerCase())) {
                foundItems.add(properties.get(i));
            }
        }
        System.out.println("I searched for " + searchTerm + " and found " + foundItems.size() + " items.");
        return foundItems;
    }

    @Override
    public boolean deleteOne(String nameOfProperty) {
        properties.removeIf(property -> property.getNameOfProperty() == nameOfProperty);
        return true;
    }

    @Override
    public PropertyModel updateOne(String nameOfProperty, PropertyModel updateProperty) {
        properties.stream().forEach(property -> {
            if(property.getNameOfProperty().equals(nameOfProperty))
            {
                property.setLocation(updateProperty.getLocation());
                property.setSquareFeet(updateProperty.getSquareFeet());
                property.setPhotoFileName(updateProperty.getPhotoFileName());
                property.setDescription(updateProperty.getDateOfConstruction());
                property.setValue(updateProperty.getValue());
                System.out.println("Updated property " + updateProperty);
            }
        });
        return null;
    }
    
    @Override
    public PropertyModel getPropertyByName(String nameOfProperty) {
        for (PropertyModel property : properties) {
            if (property.getNameOfProperty().equals(nameOfProperty)) {
                return property;
            }
        }
        return null;
    }
    
}

package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.model.PropertyModel;
import com.gcu.data.PropertyDataAccessInterface;

public class PropertyBusinessService implements PropertyBusinessServiceInterface
{
    @Autowired
    PropertyDataAccessInterface propertyDAO;

    @Override
    public List<PropertyModel> getProperties() {
       return propertyDAO.getProperties();
    }

    @Override
    public int addOne(PropertyModel newProperty) {
        return propertyDAO.addOne(newProperty);
    }

    @Override
    public List<PropertyModel> searchProperties(String searchTerm) {
        return propertyDAO.searchProperties(searchTerm);
    }

    @Override
    public boolean deleteOne(String nameOfProperty) {
        return propertyDAO.deleteOne(nameOfProperty);
    }

    @Override
    public PropertyModel updateOne(String nameOfProperty, PropertyModel updateProperty) {
       return propertyDAO.updateOne(nameOfProperty, updateProperty);
    }

    @Override
    public PropertyModel getPropertyByName(String nameOfProperty) {
        return propertyDAO.getPropertyByName(nameOfProperty);
    }


    
    
}

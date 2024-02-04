package com.gcu.business;

import java.util.List;

import com.gcu.model.PropertyModel;

public interface PropertyBusinessServiceInterface 
{
    public List<PropertyModel> getProperties();
    public int addOne(PropertyModel newProperty);
    public List<PropertyModel> searchProperties(String searchTerm);
    public boolean deleteOne(String nameOfProperty);
    public PropertyModel updateOne(String nameOfProperty, PropertyModel updateProperty);
    public PropertyModel getPropertyByName(String nameOfProperty);
}

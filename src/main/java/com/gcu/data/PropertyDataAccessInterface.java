package com.gcu.data;
import java.util.List;
import com.gcu.model.PropertyModel;

public interface PropertyDataAccessInterface 
{
    public List<PropertyModel> getProperties();
    public int addOne(PropertyModel newProperty);
    public List<PropertyModel> searchProperties(String searchTerm);
    public boolean deleteOne(String nameOfProperty);
    public PropertyModel updateOne(String nameOfProperty, PropertyModel updateProperty);
    public PropertyModel getPropertyByName(String nameOfProperty);
    //public PropertyModel updateProperty(long id, PropertyModel propertyModel);

}

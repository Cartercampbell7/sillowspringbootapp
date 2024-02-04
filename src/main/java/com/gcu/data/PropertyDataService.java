package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.PropertyMapper;
import com.gcu.model.PropertyModel;

@Repository
public class PropertyDataService implements PropertyDataAccessInterface
{
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public PropertyDataService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int addOne(PropertyModel newProperty) {
        return jdbcTemplate.update("insert into PROPERTIES (nameOfProperty, location, squareFeet, photoFileName, description, value, dateOfConstruction) values (?, ?, ?, ?, ?, ?, ?)",
        newProperty.getNameOfProperty(),
        newProperty.getLocation(),
        newProperty.getSquareFeet(),
        newProperty.getPhotoFileName(),
        newProperty.getDescription(),
        newProperty.getValue(),
        newProperty.getDateOfConstruction()
        );
    }

    @Override
    public boolean deleteOne(String nameOfProperty) {
        int updateResult = jdbcTemplate.update("delete from PROPERTIES where nameOfProperty = ?",
        new Object[] {nameOfProperty});
        return (updateResult > 0);
    }

    @Override
    public List<PropertyModel> getProperties() {
        List<PropertyModel> results = jdbcTemplate.query("select * from PROPERTIES", new PropertyMapper());
        return results;
    }

    @Override
    public List<PropertyModel> searchProperties(String searchTerm) {
        return jdbcTemplate.query("select * from PROPERTIES where nameOfProperty LIKE ?", 
        new PropertyMapper(), 
        new Object[] {"%" + searchTerm + "%"});
    }

    @Override
    public PropertyModel updateOne(String nameOfProperty, PropertyModel updateProperty) {

        int result = jdbcTemplate.update("update PROPERTIES set nameOfProperty = ?, location = ?, squareFeet = ?, photoFileName = ?, description = ?, value = ? where nameOfProperty = ?",
        updateProperty.getNameOfProperty(),
        updateProperty.getLocation(),
        updateProperty.getSquareFeet(),
        updateProperty.getPhotoFileName(),
        updateProperty.getDescription(),
        updateProperty.getValue(),
        nameOfProperty);
        if(result > 0)
        {
            return updateProperty;
        }
        else
        {
            return null;
        }
    }

    @Override
    public PropertyModel getPropertyByName(String nameOfProperty) {
        List<PropertyModel> results = jdbcTemplate.query("select * from PROPERTIES where nameOfProperty = ?", new PropertyMapper(), nameOfProperty);
        if (results.isEmpty()) {
            return null;
        } else {
            return results.get(0);
        }
    }

    
}

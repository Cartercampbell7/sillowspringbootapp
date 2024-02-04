package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PropertyMapper implements RowMapper<PropertyModel>
{
    public PropertyModel mapRow(ResultSet resultSet, int i) throws SQLException
    {
        PropertyModel property = new PropertyModel(
            resultSet.getString("nameOfProperty"),
            resultSet.getString("location"),
            resultSet.getInt("squareFeet"),
            resultSet.getString("photoFileName"),
            resultSet.getString("description"),
            resultSet.getDouble("value"),
            resultSet.getString("dateOfConstruction")
        );
        return property;
    }
}

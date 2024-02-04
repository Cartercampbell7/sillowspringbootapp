package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<LoginModel>
{
    public LoginModel mapRow(ResultSet resultSet, int i) throws SQLException
    {
        LoginModel user = new LoginModel(
            resultSet.getString("password"),
            resultSet.getString("username")
        );
        return user;
    }
}

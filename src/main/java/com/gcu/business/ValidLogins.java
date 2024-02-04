package com.gcu.business;
import com.gcu.model.LoginModel;
import com.gcu.model.UserMapper;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
// Class to define login values and check validation
public class ValidLogins implements SecurityServiceInterface
{
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public ValidLogins(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
    @Override
    public boolean isAuthenticated(LoginModel loginModel)
    {
        String[][] validLogins = new String[][]
		{
			{"cartercampbell", "password"},
			{"briancook", "password"}
		};

        boolean success = false;
		for(int i = 0; i < validLogins.length; i++)
		{
			if(loginModel.getUsername().equals(validLogins[i][0]) && loginModel.getPassword().equals(validLogins[i][1]))
			{
				success = true;
			}
		}
			if(success)
			{
                // login success
				return true;
			}
			else
			{
                // login failed
				return false;
			}
    }

	@Override
	public int addUser(LoginModel newUser) {
		return jdbcTemplate.update("insert into USERS (password, username) values (?, ?)",
		newUser.getPassword(),
		newUser.getUsername());
	}

	@Override
	public List<LoginModel> getUsers() {
		List<LoginModel> results = jdbcTemplate.query("select * from USERS", new UserMapper());
        return results;
	}
	
}

package com.gcu;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gcu.business.ValidLogins;
import com.gcu.data.PropertyDataAccessInterface;
import com.gcu.data.PropertyDataService;
import com.gcu.business.PropertyBusinessService;
import com.gcu.business.PropertyBusinessServiceInterface;
import com.gcu.business.SecurityServiceInterface;

// Class to handle dependency injection
@Configuration
public class SpringConfig
{
    @Bean(name="securityService")
    public SecurityServiceInterface getSecurityService()
    {
        return new ValidLogins(dataSource);
    }

    @Bean(name="propertyBusinessService")
    public PropertyBusinessServiceInterface getPropertyBusiness()
    {
        return new PropertyBusinessService();
    }
    @Autowired
    DataSource dataSource;
    @Bean(name="propertyDAO")
    public PropertyDataAccessInterface getDataSource()
    {
        return new PropertyDataService(dataSource);
    }
}

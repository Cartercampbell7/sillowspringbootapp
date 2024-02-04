package com.gcu.business;
import com.gcu.model.LoginModel;
import java.util.List;
// interface to check authentication
public interface SecurityServiceInterface 
{
    public boolean isAuthenticated(LoginModel loginModel);
    public int addUser(LoginModel newUser);
    public List<LoginModel> getUsers();
}

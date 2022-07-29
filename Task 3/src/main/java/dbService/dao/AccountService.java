package dbService.dao;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UserProfile;

public class AccountService {


    public AccountService(){
    }

    public void addNewUser(String login, String password){
        DBService dbService = new DBService();
        try{
            UserProfile user = dbService.addUser(login,password);
        }catch(DBException e){
            e.printStackTrace();
        }
    }

    public UserProfile getUserByLoginAndPass(String login,String password){
        DBService dbService = new DBService();
        try{
            return dbService.getUser(login,password);
        }catch(DBException e){
            e.printStackTrace();
        }
        return null;
    }
}

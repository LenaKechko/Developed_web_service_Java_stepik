package dbService.dao;

import dbService.dataSets.UserProfile;
import dbService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Зяблик
 * Date: 21.01.16
 * Time: 21:58
 * To change this template use File | Settings | File Templates.
 */
public class UsersDAO {
    private Executor executor;

    public UsersDAO(Connection connection){
        this.executor = new Executor(connection);
    }

    public void createTable() throws SQLException{
        executor.execUpdate("create table if not exists users (id bigint auto_increment, login varchar(256), password varchar(256), primary key (id))");
    }

    public void insertUser(String login, String password) throws SQLException{
        executor.execUpdate("insert into users (login, password) values ('" + login + "','" + password +"')" );
    }

    public UserProfile get(String login, String password) throws SQLException {
        return executor.execQuery("select * from users where login='" + login + "' and password='" +password +"'", result -> {
            result.next();
            return new UserProfile(result.getLong(1), result.getString(2), result.getString(3));
        });
    }

}

package dbService;

import dbService.dao.UsersDAO;
import dbService.dataSets.UserProfile;
import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private final Connection connection;

    public DBService(){
        this.connection = getH2Connection();
    }

    public static Connection getH2Connection(){
        try{
            String url = "jdbc:h2:./h2db";
            String name = "test";
            String pass = "test";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

            Connection connection = DriverManager.getConnection(url, name, pass);
            return connection;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public UserProfile addUser(String login, String password) throws DBException{
        try{
            connection.setAutoCommit(false);
            UsersDAO dao = new UsersDAO(connection);
            dao.createTable();
            dao.insertUser(login,password);
            connection.commit();
            return dao.get(login,password);
        }catch(SQLException e){
            try{
                connection.rollback();
            }catch(SQLException ignore){
            }
            throw new DBException(e);
        }finally{
            try{
                connection.setAutoCommit(true);
            }catch (SQLException ignore){
            }
        }
    }

    public UserProfile getUser(String login, String password) throws DBException {
        try {
            UsersDAO dao = new UsersDAO(connection);
            UserProfile user = dao.get(login, password);
            return user;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}

package dbService.dataSets;

public class UserProfile {
    private long id;
    private String login;
    private String password;

    public UserProfile(long id, String login, String password){
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getLogin(){
        return login;
    }

}


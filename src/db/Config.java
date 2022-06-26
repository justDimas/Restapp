package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class  Config {
    Properties properties;
    private String driverClassName;
    private String login;
    private String url;
    private String password;

    public Config() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("config/jdbc.properties"));
        driverClassName = properties.getProperty("driver-class-name");
        url = properties.getProperty("url");
        login = properties.getProperty("login");
        password = properties.getProperty("password");
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

}

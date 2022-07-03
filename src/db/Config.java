package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class  Config {
    private final String login;
    private final String url;
    private final String password;

    public Config() throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config/jdbc.properties"));
        Class.forName(properties.getProperty("driver-class-name"));
        url = properties.getProperty("url");
        login = properties.getProperty("login");
        password = properties.getProperty("password");
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

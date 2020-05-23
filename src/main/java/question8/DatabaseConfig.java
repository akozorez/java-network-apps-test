package question8;

public class DatabaseConfig {
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1";
    public String getDriver() {
        return driver;
    }
    public String getUrl() {
        return url;
    }
}

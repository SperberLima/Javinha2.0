package br.cefetmg.inf.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresqlJDBCConnection implements JDBCConnectionFactory {
    private final static String dbDriver = "org.postgresql.Driver";
    private final static String dbURL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static String pass = "123456";
    
    public PostgresqlJDBCConnection() {
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbDriver);
        Properties prop = new Properties();
        prop.setProperty("user", user);
        prop.setProperty("password",pass);
        prop.setProperty("sslmode","require");
        return DriverManager.getConnection(dbURL, prop);
    }
}

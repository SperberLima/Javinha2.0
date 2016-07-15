package br.cefetmg.inf.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresqlJDBCConnection implements JDBCConnectionFactory {

    private final static String dbDriver = "org.postgresql.Driver";
    private final static String dbURL = "jdbc:postgresql://ec2-54-235-68-4.compute-1.amazonaws.com:5432/degrcm4gastrfi";
    private final static String user = "svqygjqglpaoby";
    private final static String pass = "GTENaP1mrjiCB-wzAwG_pREpA6";
    
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

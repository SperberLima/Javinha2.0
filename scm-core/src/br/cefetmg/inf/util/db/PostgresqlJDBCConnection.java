package br.cefetmg.inf.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlJDBCConnection implements JDBCConnectionFactory {

    /*private final static String dbDriver = "org.postgresql.Driver";
    private final static String dbURL = "postgres://svqyjqglpaoby:GTENaP1mrjiCB-wzAwG_pREpA6@ec2-54-235-68-4.compute-1.amazonaws.com:5432/degrcm4gastrfi";
    private final static String user = "svqygjqglpaoby";
    private final static String pass = "GTENaP1mrjiCB-wzAwG_pREpA6";
*/
    
    private final static String dbDriver = "org.postgresql.Driver";
    private final static String dbURL = "postgres://localhost:5432/postgres";
    private final static String user = "postgres";
    private final static String pass = "123456";
    
    
    public PostgresqlJDBCConnection() {
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL, user, pass);
    }
}

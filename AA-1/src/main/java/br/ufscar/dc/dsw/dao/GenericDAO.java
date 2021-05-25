package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class GenericDAO {
    public GenericDAO() {
        try {
        	/* Setup Banco de dados MySQL */
        	Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
    	/* Conexão banco de dados MySQL */
    	String url = "jdbc:mysql://dsw.cdxlj1ktosxz.sa-east-1.rds.amazonaws.com:3306/DSW";
    	return DriverManager.getConnection(url, "admin", "Jycq6wCcDZssF2i");
    }
}
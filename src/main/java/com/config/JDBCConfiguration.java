package com.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {
	
	public static Connection getConnection() {
	String BDD = "maven";
	String url="jdbc:mysql://localhost:3306/"+BDD;
	String user="root";
	String password ="";
	
	Connection connection = null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url,user,password);
		System.out.println("Connecter");
	}catch (Exception e){
		e.printStackTrace();
		System.out.println("Erreur");
		System.exit(0);
	}
	return connection;
	}
}

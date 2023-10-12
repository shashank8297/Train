package com.infnite.train;


import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class connection {
	private static DataSource datasource = null;
	public static DataSource getDataSource(){
		if(datasource == null){
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl("jdbc:mysql://localhost:3306/train");
			//config.setDriverClassName("com.mysql.jdbc.Driver");
			config.setUsername("root");
			config.setPassword("mysql123@");
			config.setAutoCommit(true);
			config.addDataSourceProperty("cachePrepStmts", "true");
			config.addDataSourceProperty("PrepStmtsCacheSize","250");
			config.addDataSourceProperty("PrepStmtsCacheS1lLimit", "2048");
			datasource = new HikariDataSource(config);
		}	
		return datasource;
	}
	
}
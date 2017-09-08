package com.d;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public abstract class Dbutil {

	/*
	 * public static Connection createConnection(String dbName) {
	 */
	/*
	 * String conn=
	 * "JDBC:mysql://localhost:3306/"+dbName+"?user=root&password=root"; Connection
	 * conection = null;
	 */
	// System.out.println(conn);

	/*
	 * try { Class.forName("com.mysql.jdbc.Driver"); conection =
	 * DriverManager.getConnection(conn);
	 * 
	 * } catch(SQLException e) { System.out.println(e); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * System.out.println(e); }
	 * 
	 * return conection;
	 * 
	 * } public static void closeConection(Connection conn) { try { conn.close();
	 * System.out.println("Closed Successfully!"); }catch (SQLException e) {
	 * System.out.println(e);
	 */

	static ComboPooledDataSource ds = null;

	private static ComboPooledDataSource initDs() {
		if (ds == null) {
			ds = new ComboPooledDataSource();
			try {
				ds.setDriverClass("com.mysql.jdbc.Driver");
				ds.setJdbcUrl("JDBC:mysql://localhost:3306/Reg");// Reg is the name of the database
				ds.setUser("root");
				ds.setPassword("root");
				ds.setMinPoolSize(5);
				ds.setAcquireIncrement(5);
				ds.setMaxPoolSize(20);

			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // loads the jdbc driver

		}
		/**/
		return ds;
	}

	public static Connection getConnection() throws SQLException {
		initDs();
		return ds.getConnection();
	}

	/*public static void closeConnection(Statement pst, Connection conection) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conection != null) {
			try {
				conection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
}

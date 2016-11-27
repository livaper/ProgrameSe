package info.programese.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;

/* 
 * Posteriormente criar executaQuery com retorno de apenas um elemento se for necessário
 */
public class JDBCConnection {

	public static Connection getConnection() {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProgrameSeData", "postgres",
					"admin");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

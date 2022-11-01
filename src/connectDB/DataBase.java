package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {
	public static Connection con=null;
	public static DataBase instance=new DataBase();
	public static DataBase getInstance() {
		return instance;
	}
	
	public static  void connect() {
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=BanSach";
		String user="sa";
		String password="vietthanh123";
		try {
			con = DriverManager.getConnection(url,user,password);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		if(con!=null) {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() {
		if(con == null)
			connect();
		return con;
	}

}
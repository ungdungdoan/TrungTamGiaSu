package connectdatabase;
import java.sql.*;
import javax.swing.*;
public class ConnectDatabase {
	 Connection con=null;
	public static Connection getconnection(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +  
			         "databaseName=TrungTamGiaSu;integratedSecurity=True");
			JOptionPane.showMessageDialog(null, "Ket noi thanh cong");
			return con;
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
}

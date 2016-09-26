package do_an;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiDuLieuDatabase {
	private static Connection con;
	private KetNoiDuLieuDatabase(){
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +  
			         "databaseName=TrungTamGiaSu;integratedSecurity=True");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized static Connection getConnection(){
		if(con==null)
			new KetNoiDuLieuDatabase();
		return con;
	}
}

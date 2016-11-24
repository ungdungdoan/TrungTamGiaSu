package giasu_implement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.*;

public class DanhSachGiaSu {

		public String getDSGS() {
			String url = "jdbc:sqlserver://localhost:1433;databasename =TrungTamGiaSu";
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection(url, "sa", "sa");
				Statement st = con.createStatement();
				String sql = "select MaGiaSu,HoGiaSu,TenGiaSu,GioiTinh,NgaySinh,NoiSinh,DiaChi,SoDienThoai,Email FROM GiaSu ";
				ResultSet rs = st.executeQuery(sql);
				JSONObject gs ;
				JSONArray arr = new JSONArray();
				while (rs.next()) {
					gs = new JSONObject();
					gs.put("MaGiaSu", rs.getString("MaGiaSu"));
					gs.put("HoGiaSu", rs.getString("HoGiaSu"));
					gs.put("TenGiaSu", rs.getString("TenGiaSu"));
					gs.put("GioiTinh", rs.getString("GioiTinh"));
					gs.put("NgaySinh", rs.getString("NgaySinh"));
					gs.put("NoiSinh", rs.getString("NoiSinh"));
					gs.put("DiaChi", rs.getString("DiaChi"));
					gs.put("SoDienThoai", rs.getString("SoDienThoai"));
					gs.put("Email", rs.getString("Email"));
					arr.add(gs);
				}
				JSONObject response = new JSONObject();
				response.put("gslist", arr);
				return response.toString();
			} catch (Exception e) {
				return e.toString();
			}
		}
	}


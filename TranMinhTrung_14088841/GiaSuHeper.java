package do_an;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiaSuHeper {
	public List<GiaSu> getAllGiaSu() {
		List<GiaSu> listds = new ArrayList<GiaSu>();
		
		Connection con = KetNoiDuLieuDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("select * from GiaSu");
			rs = stmt.executeQuery();
			while(rs.next()){
				listds.add(new GiaSu(rs.getString("MaGiaSu"), rs.getString("HoGiaSu"), rs.getString("TenGiaSu"),rs.getString("GioiTinh"), 
						rs.getString("NgaySinh"), rs.getString("NoiSinh"),rs.getString("DiaChi"), rs.getString("SoDienThoai"), rs.getString("Email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseUtils.close(rs, stmt);
		}
		
		
		return listds;
	}
}

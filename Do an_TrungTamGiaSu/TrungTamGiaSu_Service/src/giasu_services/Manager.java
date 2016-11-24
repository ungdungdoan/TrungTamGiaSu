package giasu_services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException; 
import javax.swing.JOptionPane;

import connectdatabase.ConnectDatabase;
public class Manager{
	public static Connection con;
	public Manager(){
		ConnectDatabase db = new ConnectDatabase();
		this.con = db.getconnection();
	}
	public void AddGiaSu(String maGiaSu, String hoGiaSu, String tenGiaSu,
			String gioiTinh, String ngaysinh, String noiSinh, String diaChi,
			String dienThoai, String email) {
		try {
			String query="insert into GiaSu (MaGiaSu,HoGiaSu,TenGiaSu,GioiTinh,NgaySinh,NoiSinh,DiaChi,SoDienThoai,Email) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
		
			pst.setString(1,maGiaSu);
			pst.setString(2,hoGiaSu);
			pst.setString(3,tenGiaSu);
			pst.setString(4,gioiTinh);
			pst.setString(5,ngaysinh);
			pst.setString(6,noiSinh);
			pst.setString(7,diaChi);
			pst.setString(8,dienThoai);
			pst.setString(9,email);
	
			pst.execute();
			JOptionPane.showMessageDialog(null, "Thêm thành công");
			pst.close();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void deleteGiaSu(String maGiaSu){
		try {
			String query="delete from GiaSu where MaGiaSu=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,maGiaSu);
			pst.execute();
			JOptionPane.showMessageDialog(null,"Xóa thành công");
			pst.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Edit(String maGiaSu, String hoGiaSu, String tenGiaSu,
			String gioiTinh, String ngaysinh, String noiSinh, String diaChi,
			String dienThoai, String email) {
		try {
			String query="Update GiaSu set MaGiaSu=?,HoGiaSu=?,TenGiaSu=?,GioiTinh=?,NgaySinh=?,NoiSinh=?,DiaChi=?,SoDienThoai=?,Email=? where MaGiaSu=? ";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,maGiaSu);
			pst.setString(2,hoGiaSu);
			pst.setString(3,tenGiaSu);
			pst.setString(4,gioiTinh);
			pst.setString(5,ngaysinh);
			pst.setString(6,noiSinh);
			pst.setString(7,diaChi);
			pst.setString(8,dienThoai);
			pst.setString(9,email);
			pst.execute();
			JOptionPane.showMessageDialog(null,"Chỉnh sửa thành công");
			pst.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


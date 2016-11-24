package giasu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class GiaSu implements java.io.Serializable{
	private String maGiaSu;
	private String hoGiaSu;
	private String tenGiaSu;
	private String gioiTinh;
	private String ngaysinh;
	private String noiSinh;
	private String diaChi;
	private String dienThoai;
	private String email;
	public GiaSu(String maGiaSu, String hoGiaSu, String tenGiaSu,
			String gioiTinh, String ngaysinh, String noiSinh, String diaChi,
			String dienThoai, String email) {
		super();
		this.maGiaSu = maGiaSu;
		this.hoGiaSu = hoGiaSu;
		this.tenGiaSu = tenGiaSu;
		this.gioiTinh = gioiTinh;
		this.ngaysinh = ngaysinh;
		this.noiSinh = noiSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
	}
	public GiaSu() {
		this("maGiaSu");
	}
	public GiaSu(String maGiaSu) {
		this.maGiaSu = maGiaSu;
	}
	public String getMaGiaSu() {
		return maGiaSu;
	}
	public void setMaGiaSu(String maGiaSu) {
		this.maGiaSu = maGiaSu;
	}
	public String getHoGiaSu() {
		return hoGiaSu;
	}
	public void setHoGiaSu(String hoGiaSu) {
		this.hoGiaSu = hoGiaSu;
	}
	public String getTenGiaSu() {
		return tenGiaSu;
	}
	public void setTenGiaSu(String tenGiaSu) {
		this.tenGiaSu = tenGiaSu;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getNoiSinh() {
		return noiSinh;
	}
	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maGiaSu == null) ? 0 : maGiaSu.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaSu other = (GiaSu) obj;
		if (maGiaSu == null) {
			if (other.maGiaSu != null)
				return false;
		} else if (!maGiaSu.equals(other.maGiaSu))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GiaSu [maGiaSu=" + maGiaSu + ", hoGiaSu=" + hoGiaSu
				+ ", tenGiaSu=" + tenGiaSu + ", gioiTinh=" + gioiTinh
				+ ", ngaysinh=" + ngaysinh + ", noiSinh=" + noiSinh
				+ ", diaChi=" + diaChi + ", dienThoai=" + dienThoai
				+ ", email=" + email + "]";
	}
	
}

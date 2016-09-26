package do_an;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import connectdatabase.ConnectDatabase;

public class QuanLyGiaSu extends JFrame {
	Connection connection=null;
	private PreparedStatement stmt ;  
	private ResultSet rs ; 
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private JTable tableGaSu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyGiaSu frame = new QuanLyGiaSu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void showgiasu(){
	Vector cols=new Vector();
	cols.addElement("MaGiaSu");
	cols.addElement("HoGiaSu");
	cols.addElement("TenGiaSu");
	cols.addElement("GioiTinh");
	cols.addElement("NgaySinh");
	cols.addElement("NoiSinh");
	cols.addElement("DiaChi");
	cols.addElement("SoDienThoai");
	cols.addElement("Email");
	Vector data=new Vector();
	String SQL="SELECT 8 FROM GiaSu";
	try{
		PreparedStatement pst=connection.prepareStatement(SQL);
		ResultSet rs=pst.executeQuery();
		while (rs.next()) {  
			Vector giasu=new Vector();
			giasu.addElement(rs.getString("MaGiaSu"));
			giasu.addElement(rs.getString("HoGiaSu"));
			giasu.addElement(rs.getString("TenGiaSu"));
			giasu.addElement(rs.getString("GioiTinh"));
			giasu.addElement(rs.getString("NgaySinh"));
			giasu.addElement(rs.getString("NoiSinh"));
			giasu.addElement(rs.getString("DiaChi"));
			giasu.addElement(rs.getString("SoDienThoai"));
			giasu.addElement(rs.getString("Email"));
			data.add(giasu);
		}
		
	}catch(Exception e){
		
	}
	tableGaSu.setModel(new DefaultTableModel(null, cols));
	}
	public QuanLyGiaSu() {
		showgiasu();
		connection = ConnectDatabase.getconnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(261, 11, 192, 53);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(0, 54, 741, 468);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 367, 180);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTaiKhoan = new JLabel("Tài Khoản:");
		lblTaiKhoan.setBounds(10, 37, 104, 38);
		panel_1.add(lblTaiKhoan);
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setBounds(10, 97, 104, 38);
		panel_1.add(lblMatKhau);
		lblMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(124, 46, 233, 27);
		panel_1.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(124, 106, 233, 26);
		panel_1.add(txtMatKhau);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(374, 0, 361, 180);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnngNhp = new JButton("Login");
		btnngNhp.setBounds(21, 36, 192, 38);
		panel_2.add(btnngNhp);
		btnngNhp.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Register-icon.png"));
		btnngNhp.setForeground(Color.GREEN);
		btnngNhp.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(21, 97, 192, 38);
		panel_2.add(btnCancel);
		btnCancel.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Close-2-icon (1).png"));
		btnCancel.setForeground(Color.GREEN);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnXemDanhSch = new JButton("Xem danh sách Gia sư");
		btnXemDanhSch.setBounds(476, 419, 255, 38);
		panel.add(btnXemDanhSch);
		btnXemDanhSch.setForeground(Color.GREEN);
		btnXemDanhSch.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		tableGaSu = new JTable();
		tableGaSu.setBounds(0, 225, 735, 180);
		panel.add(tableGaSu);
	}
}

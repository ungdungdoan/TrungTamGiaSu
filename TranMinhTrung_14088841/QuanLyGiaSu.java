package do_an;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class QuanLyGiaSu extends JFrame {
	Connection connection=null;
	private PreparedStatement stmt ;  
	private ResultSet rs ; 
	private JPanel contentPane;
	private JTable tableGaSu;
	private JTextField txtSearch;
	private JTextField txtHo;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtGioiTinh;
	private JTextField txtNoiSinh;
	private JTextField txtDiaChi;
	private JTextField txtDienThoai;
	private JTextField txtEmail;
	private JTextField txtNgaySinh;

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
	
	public QuanLyGiaSu() {
		
		connection = ConnectDatabase.getconnection();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 896);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(350, 11, 248, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into GiaSu (MaGiaSu,HoGiaSu,TenGiaSu,GioiTinh,NgaySinh,NoiSinh,DiaChi,SoDienThoai,Email) values (?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, txtMa.getText());
					pst.setString(2,txtHo.getText());
					pst.setString(3, txtTen.getText());
					pst.setString(4, txtGioiTinh.getText());
					pst.setString(5, txtNgaySinh.getText());
					pst.setString(6, txtNoiSinh.getText());
					pst.setString(7,txtDiaChi.getText());
					pst.setString(8, txtDienThoai.getText());
					pst.setString(9, txtEmail.getText());
			
					pst.execute();
					JOptionPane.showMessageDialog(null, "Lưu thành công");
					pst.close();
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(729, 70, 181, 38);
		contentPane.add(btnAdd);
		btnAdd.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Actions-list-add-icon.png"));
		btnAdd.setForeground(Color.GREEN);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(729, 319, 181, 38);
		contentPane.add(btnCancel);
		btnCancel.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Actions-dialog-cancel-icon.png"));
		btnCancel.setForeground(Color.GREEN);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtSearch = new JTextField();
		txtSearch.setBounds(201, 319, 339, 30);
		contentPane.add(txtSearch);
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String query="SELECT * FROM GiaSu WHERE TenGiaSu like ? ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, txtSearch.getText());
					ResultSet rs=pst.executeQuery();
					tableGaSu.setModel(DbUtils.resultSetToTableModel(rs));
				
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		txtSearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 360, 900, 370);
		contentPane.add(scrollPane);
		
		tableGaSu = new JTable();
		tableGaSu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row=tableGaSu.getSelectedRow();
					String Magiasu=(tableGaSu.getModel().getValueAt(row, 0)).toString();
					String query="SELECT * FROM GiaSu WHERE MaGiaSu='"+Magiasu+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
					
					ResultSet rs=pst.executeQuery();
					while(rs.next()){
						txtMa.setText(rs.getString("MaGiaSu"));
						txtHo.setText(rs.getString("HoGiaSu"));
						txtTen.setText(rs.getString("TenGiaSu"));
						txtGioiTinh.setText(rs.getString("GioiTinh"));
						txtNgaySinh.setText(rs.getString("NgaySinh"));
						txtNoiSinh.setText(rs.getString("NoiSinh"));
						txtDiaChi.setText(rs.getString("DiaChi"));
						txtDienThoai.setText(rs.getString("SoDienThoai"));
						txtEmail.setText(rs.getString("Email"));
						
					}
				
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(tableGaSu);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(550, 314, 151, 33);
		contentPane.add(btnSearch);
		btnSearch.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Zoom-icon.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSearch.setForeground(Color.GREEN);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnXemDanhSch = new JButton("DS Gia sư");
		btnXemDanhSch.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Actions-view-calendar-icon.png"));
		btnXemDanhSch.setBounds(10, 315, 181, 34);
		contentPane.add(btnXemDanhSch);
		btnXemDanhSch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="SELECT * FROM GiaSu";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					tableGaSu.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					rs.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnXemDanhSch.setForeground(Color.GREEN);
		btnXemDanhSch.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="delete from GiaSu where MaGiaSu='"+txtMa.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null,"Xóa thành công");
					pst.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDelete.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Close-2-icon (1).png"));
		btnDelete.setForeground(Color.GREEN);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(729, 129, 181, 38);
		contentPane.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="Update GiaSu set MaGiaSu='"+txtMa.getText()+"',HoGiaSu='"+txtHo.getText()+"',TenGiaSu='"+txtTen.getText()+"',GioiTinh='"+txtGioiTinh.getText()+"',NgaySinh='"+txtNgaySinh.getText()+"',NoiSinh='"+txtNoiSinh.getText()+"',DiaChi='"+txtDiaChi.getText()+"',SoDienThoai='"+txtDienThoai.getText()+"',Email='"+txtEmail.getText()+"' where MaGiaSu='"+txtMa.getText()+"'  ";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null,"Chỉnh sửa thành công");
					pst.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnEdit.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Text-Edit-icon.png"));
		btnEdit.setForeground(Color.GREEN);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEdit.setBounds(729, 194, 181, 38);
		contentPane.add(btnEdit);
		
		JLabel lblHo = new JLabel("Họ:");
		lblHo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHo.setBounds(63, 134, 48, 32);
		contentPane.add(lblHo);
		
		txtHo = new JTextField();
		txtHo.setColumns(10);
		txtHo.setBounds(105, 133, 225, 26);
		contentPane.add(txtHo);
		
		JLabel lblMa = new JLabel("Mã Gia Sư:");
		lblMa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMa.setBounds(10, 83, 101, 32);
		contentPane.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(105, 82, 228, 26);
		contentPane.add(txtMa);
		
		JLabel lblTen = new JLabel("Tên:");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTen.setBounds(53, 177, 58, 32);
		contentPane.add(lblTen);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(105, 182, 225, 26);
		contentPane.add(txtTen);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGioiTinh.setBounds(10, 220, 101, 32);
		contentPane.add(lblGioiTinh);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(105, 226, 227, 26);
		contentPane.add(txtGioiTinh);
		
		JLabel lblNoiSinh = new JLabel("Nơi Sinh:");
		lblNoiSinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoiSinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNoiSinh.setBounds(361, 83, 101, 32);
		contentPane.add(lblNoiSinh);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDiaChi.setBounds(370, 129, 90, 32);
		contentPane.add(lblDiaChi);
		
		JLabel lblDienThoai = new JLabel("Điện Thoại:");
		lblDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
		lblDienThoai.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDienThoai.setBounds(350, 180, 101, 30);
		contentPane.add(lblDienThoai);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(381, 220, 78, 32);
		contentPane.add(lblEmail);
		
		txtNoiSinh = new JTextField();
		txtNoiSinh.setColumns(10);
		txtNoiSinh.setBounds(466, 83, 237, 26);
		contentPane.add(txtNoiSinh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(466, 128, 237, 26);
		contentPane.add(txtDiaChi);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(468, 177, 236, 26);
		contentPane.add(txtDienThoai);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(466, 220, 236, 26);
		contentPane.add(txtEmail);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgaySinh.setBounds(10, 263, 101, 32);
		contentPane.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(105, 268, 227, 26);
		contentPane.add(txtNgaySinh);
		
		JButton btnRefesh = new JButton("Refesh");
		btnRefesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMa.setText(null);
				txtHo.setText(null);
				txtTen.setText(null);
				txtGioiTinh.setText(null);
				txtNgaySinh.setText(null);
				txtNoiSinh.setText(null);
				txtDiaChi.setText(null);
				txtDienThoai.setText(null);
				txtEmail.setText(null);
			}
		});
		btnRefesh.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Repeat-2-2-icon.png"));
		btnRefesh.setForeground(Color.GREEN);
		btnRefesh.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRefesh.setBounds(729, 257, 181, 38);
		contentPane.add(btnRefesh);
	}
}

package giaodien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DangNhap extends JFrame {

	/**
	 * 
	 */
	Connection connection=null;
	private PreparedStatement stmt ;  
	private ResultSet rs ; 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Đăng nhập");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(197, 11, 217, 58);
		contentPane.add(label);
		
		JLabel lblTaiKhoan = new JLabel("Tài Khoản:");
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTaiKhoan.setBounds(47, 79, 130, 38);
		contentPane.add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMatKhau.setBounds(47, 150, 130, 38);
		contentPane.add(lblMatKhau);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(170, 80, 367, 27);
		contentPane.add(txtTaiKhoan);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(170, 150, 367, 26);
		contentPane.add(txtMatKhau);
		
		JButton button = new JButton("Đăng nhập");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="INSERT INTO Account(username,password) VALUES(?,?)";
				try {
					String SQL = "SELECT  * FROM Account where TenDangNhap=? and MatKhau=?";
					PreparedStatement pst=connection.prepareStatement(SQL);
					pst.setString(1, txtTaiKhoan.getText());
					pst.setString(2, txtMatKhau.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while (rs.next()) {  
			               count=count+1;
			         }  
					if(count==1)
					{
						JOptionPane.showMessageDialog(null, "Username and Password is correct");
						
						QuanLyGiaSu lop= new QuanLyGiaSu();
						lop.setVisible(true);
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Dulicate Username and Password is correct");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and Password is not correct Try Again..");
						txtMatKhau.setText(null);
						txtTaiKhoan.setText(null);
					}
					rs.close();
					pst.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
			
		button.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Register-icon.png"));
		button.setForeground(Color.GREEN);
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBounds(54, 231, 169, 38);
		contentPane.add(button);
		
		JButton btnRefresh = new JButton("Làm mới");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTaiKhoan.setText(null);
				txtMatKhau.setText(null);
			}
			
		});
		btnRefresh.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Repeat-2-2-icon.png"));
		btnRefresh.setForeground(Color.GREEN);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRefresh.setBounds(233, 231, 169, 38);
		contentPane.add(btnRefresh);
		
		JButton button_2 = new JButton("Hủy bỏ");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_2.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Actions-dialog-cancel-icon.png"));
		button_2.setForeground(Color.GREEN);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_2.setBounds(412, 231, 154, 38);
		contentPane.add(button_2);
	}
}

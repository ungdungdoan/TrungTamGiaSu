package do_an;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import connectdatabase.ConnectDatabase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	Connection connection=null;
	private PreparedStatement stmt ;  
	private ResultSet rs ;  
	private JFrame frame;
	private JTextField txtTaiKhoan;
	private JPasswordField txtPassWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		
		connection=ConnectDatabase.getconnection();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 616, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbltieude = new JLabel("Login");
		lbltieude.setForeground(new Color(255, 0, 0));
		lbltieude.setHorizontalAlignment(SwingConstants.CENTER);
		lbltieude.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbltieude.setBounds(149, 26, 303, 58);
		frame.getContentPane().add(lbltieude);
		
		JLabel lblTaiKhoan = new JLabel("T\u00E0i Kho\u1EA3n:");
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTaiKhoan.setBounds(35, 95, 130, 38);
		frame.getContentPane().add(lblTaiKhoan);
		
		JLabel lblMatKhau = new JLabel("M\u1EADt Kh\u1EA9u:");
		lblMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMatKhau.setBounds(35, 156, 130, 38);
		frame.getContentPane().add(lblMatKhau);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(159, 95, 367, 27);
		frame.getContentPane().add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtPassWord = new JPasswordField();
		txtPassWord.setBounds(159, 165, 367, 26);
		frame.getContentPane().add(txtPassWord);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String sql="INSERT INTO Account(username,password) VALUES(?,?)";
				try {
					String SQL = "SELECT  * FROM Account where username=? and password=?";
					PreparedStatement pst=connection.prepareStatement(SQL);
					pst.setString(1, txtTaiKhoan.getText());
					pst.setString(2, txtPassWord.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while (rs.next()) {  
			               count=count+1;
			         }  
					if(count==1)
					{
						JOptionPane.showMessageDialog(null, "Username and Password is correct");
						frame.dispose();
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
					}
					rs.close();
					pst.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		btnLogin.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Register-icon.png"));
		btnLogin.setForeground(new Color(0, 255, 0));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(58, 243, 154, 38);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTaiKhoan.setText(null);
				txtPassWord.setText(null);
			}
		});
		btnReset.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Repeat-2-2-icon.png"));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setForeground(new Color(0, 255, 0));
		btnReset.setBounds(234, 243, 151, 38);
		frame.getContentPane().add(btnReset);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Close-2-icon (1).png"));
		btnCancel.setForeground(new Color(0, 255, 0));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBounds(407, 243, 154, 38);
		frame.getContentPane().add(btnCancel);
	}
}

package do_an;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dang_Ky {
	 
	
	private JFrame frame;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtEmail;
	private JPasswordField txtPass;
	private JTextField txtNgaySinh;
	private JTextField txtDienThoai;
	private JTextField txtDiaChi;
	private JTextField txtGioiTinh;
	private JTextField txtNoiSinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dang_Ky window = new Dang_Ky();
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
	public Dang_Ky() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 771, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblngK = new JLabel("\u0110\u0103ng k\u00FD");
		lblngK.setHorizontalAlignment(SwingConstants.CENTER);
		lblngK.setForeground(new Color(255, 0, 0));
		lblngK.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblngK.setBounds(174, 11, 414, 60);
		frame.getContentPane().add(lblngK);
		
		JLabel lblHo = new JLabel("H\u1ECD:");
		lblHo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHo.setBounds(52, 75, 101, 32);
		frame.getContentPane().add(lblHo);
		
		JLabel lblTen = new JLabel("T\u00EAn:");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTen.setBounds(366, 75, 101, 32);
		frame.getContentPane().add(lblTen);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(38, 118, 101, 32);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMatKhau = new JLabel("M\u1EADt Kh\u1EA9u:");
		lblMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatKhau.setBounds(21, 156, 101, 32);
		frame.getContentPane().add(lblMatKhau);
		
		JLabel lblGioiTinh = new JLabel("Gi\u1EDBi T\u00EDnh:");
		lblGioiTinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGioiTinh.setBounds(21, 245, 101, 32);
		frame.getContentPane().add(lblGioiTinh);
		
		JLabel lblNgaySinh = new JLabel("Ng\u00E0y Sinh:");
		lblNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgaySinh.setBounds(21, 202, 101, 32);
		frame.getContentPane().add(lblNgaySinh);
		
		JLabel lblNoiSinh = new JLabel("N\u01A1i Sinh:");
		lblNoiSinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoiSinh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNoiSinh.setBounds(386, 202, 101, 32);
		frame.getContentPane().add(lblNoiSinh);
		
		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa Ch\u1EC9:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDiaChi.setBounds(38, 331, 101, 32);
		frame.getContentPane().add(lblDiaChi);
		
		JLabel lblDienThoai = new JLabel("\u0110i\u1EC7n Tho\u1EA1i:");
		lblDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
		lblDienThoai.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDienThoai.setBounds(21, 288, 101, 32);
		frame.getContentPane().add(lblDienThoai);
		
		txtHo = new JTextField();
		txtHo.setBounds(133, 80, 249, 26);
		frame.getContentPane().add(txtHo);
		txtHo.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(459, 80, 249, 26);
		frame.getContentPane().add(txtTen);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(133, 118, 249, 26);
		frame.getContentPane().add(txtEmail);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(132, 161, 249, 26);
		frame.getContentPane().add(txtPass);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(133, 207, 249, 26);
		frame.getContentPane().add(txtNgaySinh);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(133, 288, 249, 26);
		frame.getContentPane().add(txtDienThoai);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(133, 331, 372, 26);
		frame.getContentPane().add(txtDiaChi);
		
		JButton btnngK = new JButton("\u0110\u0103ng K\u00FD");
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
			}
		});
		btnngK.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Register-icon.png"));
		btnngK.setForeground(Color.GREEN);
		btnngK.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnngK.setBounds(88, 399, 154, 38);
		frame.getContentPane().add(btnngK);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDiaChi.setText(null);
				txtDienThoai.setText(null);
				txtEmail.setText(null);
				txtHo.setText(null);
				txtNgaySinh.setText(null);
				txtPass.setText(null);
				txtTen.setText(null);
				
			}
		});
		btnReset.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Repeat-2-2-icon.png"));
		btnReset.setForeground(Color.GREEN);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(282, 399, 154, 38);
		frame.getContentPane().add(btnReset);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Close-2-icon (1).png"));
		btnCancel.setForeground(Color.GREEN);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBounds(477, 399, 154, 38);
		frame.getContentPane().add(btnCancel);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(133, 245, 249, 26);
		frame.getContentPane().add(txtGioiTinh);
		
		txtNoiSinh = new JTextField();
		txtNoiSinh.setColumns(10);
		txtNoiSinh.setBounds(477, 202, 249, 26);
		frame.getContentPane().add(txtNoiSinh);
	}
}

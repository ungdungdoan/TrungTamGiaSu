package do_an;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DangKyLopDay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLopDay;
	private JTextField txtMonDay;
	private JTextField txtKhuVucDay;
	private JTextField txtThoiGian;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKyLopDay frame = new DangKyLopDay();
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
	public DangKyLopDay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltieude = new JLabel("Đăng ký lớp dạy");
		lbltieude.setHorizontalAlignment(SwingConstants.CENTER);
		lbltieude.setForeground(Color.RED);
		lbltieude.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbltieude.setBounds(210, 24, 298, 54);
		contentPane.add(lbltieude);
		
		JLabel lblLop = new JLabel("Lớp dạy:");
		lblLop.setHorizontalAlignment(SwingConstants.CENTER);
		lblLop.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLop.setBounds(93, 95, 102, 37);
		contentPane.add(lblLop);
		
		txtLopDay = new JTextField();
		txtLopDay.setText("12");
		txtLopDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLopDay.setColumns(10);
		txtLopDay.setBounds(191, 89, 317, 31);
		contentPane.add(txtLopDay);
		
		JLabel lblMon = new JLabel("Môn dạy:");
		lblMon.setHorizontalAlignment(SwingConstants.CENTER);
		lblMon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMon.setBounds(93, 149, 102, 37);
		contentPane.add(lblMon);
		
		txtMonDay = new JTextField();
		txtMonDay.setColumns(10);
		txtMonDay.setBounds(191, 143, 317, 31);
		contentPane.add(txtMonDay);
		
		JLabel lblKhuVuc = new JLabel("Khu vực dạy:");
		lblKhuVuc.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhuVuc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKhuVuc.setBounds(67, 206, 128, 37);
		contentPane.add(lblKhuVuc);
		
		txtKhuVucDay = new JTextField();
		txtKhuVucDay.setColumns(10);
		txtKhuVucDay.setBounds(191, 201, 317, 31);
		contentPane.add(txtKhuVucDay);
		
		JLabel label_4 = new JLabel("Ví dụ: Quận 1, Quận 2, Quận 3...");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(191, 247, 242, 19);
		contentPane.add(label_4);
		
		JLabel lblThoiGian = new JLabel("Thời gian:");
		lblThoiGian.setHorizontalAlignment(SwingConstants.CENTER);
		lblThoiGian.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThoiGian.setBounds(93, 277, 102, 37);
		contentPane.add(lblThoiGian);
		
		txtThoiGian = new JTextField();
		txtThoiGian.setColumns(10);
		txtThoiGian.setBounds(191, 277, 317, 31);
		contentPane.add(txtThoiGian);
		
		JLabel label_6 = new JLabel("Ví dụ: T2-T4-T6, chiều 17h-19h");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(191, 325, 242, 19);
		contentPane.add(label_6);
		
		JButton btnDangKy = new JButton("Đăng Ký");
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnDangKy.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Register-icon.png"));
		btnDangKy.setForeground(Color.GREEN);
		btnDangKy.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDangKy.setBounds(111, 369, 154, 38);
		contentPane.add(btnDangKy);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtKhuVucDay.setText(null);
				txtLopDay.setText(null);
				txtMonDay.setText(null);
				txtThoiGian.setText(null);
			}
		});
		btnReset.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Repeat-2-2-icon.png"));
		btnReset.setForeground(Color.GREEN);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(311, 369, 154, 38);
		contentPane.add(btnReset);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Close-2-icon (1).png"));
		btnCancel.setForeground(Color.GREEN);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBounds(516, 369, 154, 38);
		contentPane.add(btnCancel);
	}
}

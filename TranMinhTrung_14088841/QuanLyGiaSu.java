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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class QuanLyGiaSu extends JFrame {
	Connection connection=null;
	private PreparedStatement stmt ;  
	private ResultSet rs ; 
	private JPanel contentPane;
	private JTable tableGaSu;
	private JTextField txtSearch;

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
		setBounds(100, 100, 853, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(261, 11, 248, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 473, 181, 38);
		contentPane.add(btnAdd);
		btnAdd.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Actions-list-add-icon.png"));
		btnAdd.setForeground(Color.GREEN);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(635, 473, 192, 38);
		contentPane.add(btnCancel);
		btnCancel.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Actions-dialog-cancel-icon.png"));
		btnCancel.setForeground(Color.GREEN);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		txtSearch = new JTextField();
		txtSearch.setBounds(10, 75, 367, 30);
		contentPane.add(txtSearch);
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String query="SELECT * FROM GiaSu WHERE TenGiaSu=? ";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					pst.setString(2, txtSearch.getText());
					tableGaSu.setModel(DbUtils.resultSetToTableModel(rs));
				//	while (rs.next()) {
				//	}
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		txtSearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 817, 333);
		contentPane.add(scrollPane);
		
		tableGaSu = new JTable();
		scrollPane.setViewportView(tableGaSu);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(387, 72, 161, 33);
		contentPane.add(btnSearch);
		btnSearch.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Zoom-icon.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSearch.setForeground(Color.GREEN);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnXemDanhSch = new JButton("DS Gia sư");
		btnXemDanhSch.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Actions-view-calendar-icon.png"));
		btnXemDanhSch.setBounds(558, 71, 192, 34);
		contentPane.add(btnXemDanhSch);
		btnXemDanhSch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="SELECT * FROM GiaSu";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					tableGaSu.setModel(DbUtils.resultSetToTableModel(rs));
					//while (rs.next()) {
				//	}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnXemDanhSch.setForeground(Color.GREEN);
		btnXemDanhSch.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Close-2-icon (1).png"));
		btnDelete.setForeground(Color.GREEN);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(211, 473, 192, 38);
		contentPane.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setIcon(new ImageIcon("E:\\webservice\\java\\TrungTamGiaSu\\img\\Text-Edit-icon.png"));
		btnEdit.setForeground(Color.GREEN);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEdit.setBounds(421, 473, 192, 38);
		contentPane.add(btnEdit);
	}
}

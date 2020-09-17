package com.maddy;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField emailTxt;
	private JTextField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 209, 204));
		contentPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Georgia", Font.BOLD, 17));
		lblEmail.setBounds(47, 188, 129, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Georgia", Font.BOLD, 17));
		lblPassword.setBounds(47, 281, 129, 16);
		contentPane.add(lblPassword);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(239, 182, 255, 22);
		contentPane.add(emailTxt);
		emailTxt.setColumns(10);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(239, 275, 255, 22);
		contentPane.add(passwordTxt);
		
		JButton btnLogin = new JButton("LOGIN ");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection = null;
				RegistrationForm rg = new RegistrationForm();
				Admin admin = new Admin();
				String email = rg.getEmailTxt().toString();
				String password = rg.getPassword().toString();
				
				
				try {

					connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/librarydatabase", "root", "Connection");
					String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
					PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
					statement.setString(1, emailTxt.getText());
					statement.setString(2, passwordTxt.getText());					
					ResultSet rs = statement.executeQuery();
					if(rs.next()){
						dispose();
						JOptionPane.showMessageDialog(null, "Login successful!");
						admin.setVisible(true);
						
						
						
					} else {
						JOptionPane.showMessageDialog(null, "Please check your details again");
					}				
					connection.close();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
		});
		btnLogin.setFont(new Font("Georgia", Font.BOLD, 15));
		btnLogin.setBounds(447, 385, 148, 25);
		contentPane.add(btnLogin);
		
		//REGISTRATION BUTTON
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegistrationForm register = new RegistrationForm();
				register.NewScreen();
			}
		});
		btnRegister.setFont(new Font("Georgia", Font.BOLD, 15));
		btnRegister.setBounds(47, 385, 138, 25);
		contentPane.add(btnRegister);
		
		JLabel lblForgotPasswordClick = new JLabel("Forgot password? Click here.");
		lblForgotPasswordClick.addMouseListener(new MouseAdapter() {
		});
		lblForgotPasswordClick.setFont(new Font("Georgia", Font.BOLD, 14));
		lblForgotPasswordClick.setBounds(415, 319, 223, 16);
		contentPane.add(lblForgotPasswordClick);
		
		JLabel lblTheStemLibrary = new JLabel("THE STEM LIBRARY");
		lblTheStemLibrary.setForeground(new Color(255, 255, 255));
		lblTheStemLibrary.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 30));
		lblTheStemLibrary.setBounds(158, 65, 342, 41);
		contentPane.add(lblTheStemLibrary);
		setUndecorated(true);
	}
}

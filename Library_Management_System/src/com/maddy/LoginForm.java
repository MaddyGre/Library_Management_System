package com.maddy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {
	/**
	 * @wbp.nonvisual location=-449,199
	 */
	private final JLabel lblLoginIntoLibrary = new JLabel("Login into Library System");
	private JTextField emailTxt;
	private JTextField passwordTxt;
	private javax.swing.JLabel lbl_Message;

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
		getContentPane().setBackground(new Color(153, 255, 153));
		getContentPane().setForeground(new Color(102, 255, 102));
		getContentPane().setLayout(null);
		
		JLabel lblLibraryManagementSystem = new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lblLibraryManagementSystem.setForeground(new Color(255, 255, 255));
		lblLibraryManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLibraryManagementSystem.setBounds(95, 11, 324, 37);
		getContentPane().add(lblLibraryManagementSystem);
		
		JLabel lblLoginAsUser = new JLabel("Email");
		lblLoginAsUser.setForeground(Color.WHITE);
		lblLoginAsUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoginAsUser.setBounds(22, 82, 114, 23);
		getContentPane().add(lblLoginAsUser);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(175, 85, 176, 20);
		getContentPane().add(emailTxt);
		emailTxt.setColumns(10);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			//login button
			public void actionPerformed(ActionEvent e) {
				boolean emailStatus = Validation.validateEmail(emailTxt.getText());
				boolean passwordStatus = Validation.validatePassword(passwordTxt.getText());
				
				if((emailStatus == true) & (passwordStatus == true)) {
					lbl_Message.setText("Login successful!");
				} else {
					lbl_Message.setText("Please try again");
				}
			}
		});
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		loginButton.setBounds(22, 178, 89, 23);
		getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("REGISTER");
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		registerButton.setBounds(399, 178, 89, 23);
		getContentPane().add(registerButton);
		
		passwordTxt = new JTextField();
		passwordTxt.setBounds(175, 119, 176, 20);
		getContentPane().add(passwordTxt);
		passwordTxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(22, 122, 73, 14);
		getContentPane().add(lblPassword);
	}
}

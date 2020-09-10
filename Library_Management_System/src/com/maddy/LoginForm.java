package com.maddy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 209, 204));
		contentPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTheStemLibrary = new JLabel("THE STEM LIBRARY");
		lblTheStemLibrary.setForeground(new Color(240, 255, 255));
		lblTheStemLibrary.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 20));
		lblTheStemLibrary.setBounds(115, 34, 226, 36);
		contentPane.add(lblTheStemLibrary);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Georgia", Font.BOLD, 15));
		lblEmail.setBounds(36, 104, 55, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Georgia", Font.BOLD, 15));
		lblPassword.setBounds(36, 149, 81, 16);
		contentPane.add(lblPassword);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(199, 101, 208, 22);
		contentPane.add(emailTxt);
		emailTxt.setColumns(10);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(199, 146, 208, 22);
		contentPane.add(passwordTxt);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Georgia", Font.BOLD, 15));
		btnLogin.setBounds(288, 196, 119, 25);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegistrationForm register = new RegistrationForm();
				register.NewScreen();
			}
		});
		btnRegister.setFont(new Font("Georgia", Font.BOLD, 15));
		btnRegister.setBounds(36, 196, 156, 25);
		contentPane.add(btnRegister);
		setUndecorated(true);
	}
}

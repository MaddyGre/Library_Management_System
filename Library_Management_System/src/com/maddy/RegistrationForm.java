package com.maddy;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;

public class RegistrationForm {

	private JFrame frame;
	private JTextField nameTxt;
	private JTextField surnameTxt;
	private JTextField usernameTxt;
	private JTextField emailTxt;
	private JTextField phoneTxt;
	private JPasswordField password;
	private JPasswordField confirmPassword;
	
	

	public JTextField getUsernameTxt() {
		return usernameTxt;
	}

	public void setUsernameTxt(JTextField usernameTxt) {
		this.usernameTxt = usernameTxt;
	}

	public JTextField getEmailTxt() {
		return emailTxt;
	}

	public void setEmailTxt(JTextField emailTxt) {
		this.emailTxt = emailTxt;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JPasswordField getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(JPasswordField confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm window = new RegistrationForm();
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
	public RegistrationForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(64, 224, 208));
		frame.getContentPane().setForeground(new Color(0, 206, 209));
		frame.setBounds(500, 500, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistrationForm = new JLabel("REGISTRATION FORM");
		lblRegistrationForm.setBounds(206, 13, 272, 40);
		lblRegistrationForm.setForeground(new Color(255, 255, 255));
		lblRegistrationForm.setFont(new Font("Georgia", Font.BOLD, 22));
		frame.getContentPane().add(lblRegistrationForm);
		
		JLabel label = new JLabel("Name");
		label.setFont(new Font("Georgia", Font.BOLD, 16));
		label.setBounds(12, 74, 67, 16);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Surname");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 130, 91, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Georgia", Font.BOLD, 16));
		lblPassword.setBounds(12, 235, 84, 16);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Georgia", Font.BOLD, 16));
		lblEmail.setBounds(12, 339, 55, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 16));
		lblNewLabel_1.setBounds(12, 179, 91, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone number");
		lblNewLabel_2.setFont(new Font("Georgia", Font.BOLD, 16));
		lblNewLabel_2.setBounds(12, 388, 126, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		nameTxt = new JTextField();		
		nameTxt.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
			}
			//name validation
			public void keyPressed(KeyEvent evt) {
				
				
				char c = evt.getKeyChar();
				
				if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
					//iso control used to perform edit operation (delete and backspace)
					nameTxt.setEditable(true);
				}else {
					nameTxt.setEditable(false);
				}


			}
		});
		nameTxt.setBounds(243, 68, 220, 22);
		frame.getContentPane().add(nameTxt);
		nameTxt.setColumns(10);
		
		surnameTxt = new JTextField();
		surnameTxt.addKeyListener(new KeyAdapter() {
			//SURNAME VALIDATION
			public void keyPressed(KeyEvent evt) {
				char c = evt.getKeyChar();

				if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
					//iso control used to perform edit operation (delete and backspace)
					surnameTxt.setEditable(true);
				}else {
					surnameTxt.setEditable(false);
				}
			}
		});
		surnameTxt.setColumns(10);
		surnameTxt.setBounds(243, 124, 220, 22);
		frame.getContentPane().add(surnameTxt);
		
		usernameTxt = new JTextField();
		usernameTxt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
					char c = evt.getKeyChar();

					if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
						//iso control used to perform edit operation (delete and backspace)
						usernameTxt.setEditable(true);
					}else {
						usernameTxt.setEditable(false);
					}
				}
			}
		);
		usernameTxt.setColumns(10);
		usernameTxt.setBounds(243, 173, 220, 22);
		frame.getContentPane().add(usernameTxt);
		
		emailTxt = new JTextField();
		emailTxt.setColumns(10);
		emailTxt.setBounds(243, 337, 220, 22);
		frame.getContentPane().add(emailTxt);
		
		phoneTxt = new JTextField();
		phoneTxt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				String phone = phoneTxt.getText();
				int length = phone.length();
				char c = evt.getKeyChar();
				
				
				if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
					if(length < 10){
						phoneTxt.setEditable(true);
					} else {
						// you cannot change it if the length is more than 10 digit
						phoneTxt.setEditable(false);
					}
				} else {
					//allow back space and delete for edit
					if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE){
						// than allow editable
						
						phoneTxt.setEditable(true);
					} else {
						phoneTxt.setEditable(false);
					}
				}
			}
		});
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(243, 386, 220, 22);
		frame.getContentPane().add(phoneTxt);
		
		//REGISTRATION BUTTON
		JButton btnRegisterForm = new JButton("SUBMIT");
		btnRegisterForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				Connection connection = null;
				
				String name = nameTxt.getText();
				String surname = surnameTxt.getText();
				String username = usernameTxt.getText();
				String passwordOne = password.getText();
				String email = emailTxt.getText();
				String phone = phoneTxt.getText();
				
				if(name.isEmpty() || surname.isEmpty() || username.isEmpty() || passwordOne.isEmpty() || email.isEmpty() || phone.isEmpty()){
					JOptionPane.showMessageDialog(null, "Fields cannot be empty");
				} else {
					
					try {
						
						connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/librarydatabase", "root", "Connection");
						String sql = "INSERT INTO user (first_name, last_name, user_name, password, email, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
						PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
						statement.setString(1, nameTxt.getText());
						statement.setString(2, surnameTxt.getText());
						statement.setString(3, usernameTxt.getText());
						statement.setString(4, password.getText());
						statement.setString(5, emailTxt.getText());
						statement.setString(6, phoneTxt.getText());
						
						statement.executeUpdate();
						JOptionPane.showMessageDialog(null, "Registration successful");
						connection.close();
					} catch(Exception e){
						JOptionPane.showMessageDialog(null, e);
					}
					
				}	
				
				
			}
						
			
	
		});
		
		
		
	
		btnRegisterForm.setFont(new Font("Georgia", Font.BOLD, 15));
		btnRegisterForm.setBounds(12, 447, 147, 25);
		frame.getContentPane().add(btnRegisterForm);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setFont(new Font("Georgia", Font.BOLD, 16));
		lblConfirmPassword.setBounds(12, 287, 151, 20);
		frame.getContentPane().add(lblConfirmPassword);
		
		
		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {			
		});
		
		
		password.setEchoChar('*');
		password.setBounds(243, 233, 220, 22);
		frame.getContentPane().add(password);
		
		confirmPassword = new JPasswordField();	
		confirmPassword.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				String firstPassword = password.getText();
				String secondPassword = confirmPassword.getText();
				
				if(!firstPassword.equals(secondPassword)){
					JOptionPane.showMessageDialog(null, "Password doesn't match, please check again");
				}			
				
			}
		});
		confirmPassword.setBounds(243, 285, 220, 22);
		frame.getContentPane().add(confirmPassword);
		//CLEAR BUTTON, CLEARS ALL TEXT FIELDS
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nameTxt.setText("");
				surnameTxt.setText("");
				usernameTxt.setText("");
				password.setText("");
				emailTxt.setText("");
				phoneTxt.setText("");
			}
		});
		btnClear.setFont(new Font("Georgia", Font.BOLD, 15));
		btnClear.setBounds(244, 447, 147, 25);
		frame.getContentPane().add(btnClear);
		
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();//Closes window
			}
		});
		btnClose.setFont(new Font("Georgia", Font.BOLD, 15));
		btnClose.setBounds(478, 447, 147, 25);
		frame.getContentPane().add(btnClose);
		frame.setUndecorated(true);
	}
}

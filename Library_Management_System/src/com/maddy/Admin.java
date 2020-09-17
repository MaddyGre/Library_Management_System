package com.maddy;

import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;









import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField title_TextField;
	private JTextField author_TextField;	
	private JScrollPane scrollPane;
	DefaultTableModel model;
	private JTable table;
	
	public Admin() {
			
		setBackground(new Color(72, 209, 204));
				
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1186, 728);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 209, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(440, 38, 716, 530);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBackground(new Color(220, 220, 220));
		model = new DefaultTableModel();
		Object[] column_headers = {"Author", "Title", "Subject", "Publisher", "Language"};
		model.setColumnIdentifiers(column_headers);
		table.setModel(model);
		scrollPane.setViewportView(table);
				
		JButton search_Button = new JButton("SEARCH");
		search_Button.setBounds(12, 605, 149, 25);
		search_Button.setFont(new Font("Georgia", Font.BOLD, 20));
		contentPane.add(search_Button);
		
		JButton update_Button = new JButton("UPDATE ");
		update_Button.setBounds(721, 605, 149, 25);
		update_Button.setFont(new Font("Georgia", Font.BOLD, 20));
		contentPane.add(update_Button);
		
		JButton delete_Button = new JButton("DELETE ");
		delete_Button.setBounds(979, 605, 149, 25);
		delete_Button.setFont(new Font("Georgia", Font.BOLD, 20));
		contentPane.add(delete_Button);
		
		JLabel lblName = new JLabel("TITLE");
		lblName.setBounds(12, 130, 80, 25);
		lblName.setFont(new Font("Georgia", Font.BOLD, 20));
		contentPane.add(lblName);
		
		JLabel lblSubject = new JLabel("SUBJECT");
		lblSubject.setBounds(12, 248, 105, 25);
		lblSubject.setFont(new Font("Georgia", Font.BOLD, 20));
		contentPane.add(lblSubject);
		
		JLabel lblPublisher = new JLabel("PUBLISHER");
		lblPublisher.setBounds(12, 374, 139, 25);
		lblPublisher.setFont(new Font("Georgia", Font.BOLD, 20));
		contentPane.add(lblPublisher);
		
		JLabel lblLanguage = new JLabel("LANGUAGE");
		lblLanguage.setBounds(12, 500, 139, 16);
		lblLanguage.setFont(new Font("Georgia", Font.BOLD, 20));
		contentPane.add(lblLanguage);
		
		JLabel lblAuthorName = new JLabel("AUTHOR");
		lblAuthorName.setBounds(12, 38, 105, 25);
		lblAuthorName.setFont(new Font("Georgia", Font.BOLD, 20));
		contentPane.add(lblAuthorName);
		
		//SUBJECT COMBOBOX
		String[] listOfSubjects = {"", "Science", "Technology", "Engineering", "Mathematics"};
		final JComboBox<String> subject_ComboBox = new JComboBox();	
		DefaultComboBoxModel<String> subject_model = new DefaultComboBoxModel<>(listOfSubjects);
		subject_ComboBox.setModel(subject_model);
		subject_ComboBox.setBounds(158, 251, 251, 22);
		contentPane.add(subject_ComboBox);
		
		//PUBLISHER COMBOBOX
		String[] listOfPublishers = {"", "Pearson", "Oxford Press University", "World of Books", "Bloomsbury", "Hutchinson"};
		final JComboBox<String> publisher_ComboBox = new JComboBox();
		DefaultComboBoxModel<String> publisher_model = new DefaultComboBoxModel<>(listOfPublishers);
		publisher_ComboBox.setModel(publisher_model);
		publisher_ComboBox.setBounds(163, 377, 246, 22);
		contentPane.add(publisher_ComboBox);
		
		//LANGUAGE COMBOBOX
		String[] listOfLanguages = {"", "German", "English", "French"};
		final JComboBox<String> language_ComboBox = new JComboBox();
		DefaultComboBoxModel<String> language_model = new DefaultComboBoxModel<>(listOfLanguages);
		language_ComboBox.setModel(language_model);
		language_ComboBox.setBounds(163, 499, 246, 22);
		contentPane.add(language_ComboBox);
		
		
		title_TextField = new JTextField();
		title_TextField.setBounds(161, 133, 248, 22);
		contentPane.add(title_TextField);
		title_TextField.setColumns(10);
		
		author_TextField = new JTextField();
		author_TextField.setBounds(161, 41, 248, 22);
		author_TextField.addKeyListener(new KeyAdapter() {
			//ensure text field only accepts letters
			@Override
			public void keyPressed(KeyEvent event) {
				
				char letters = event.getKeyChar();
				
				if(Character.isLetter(letters) || Character.isWhitespace(letters) || Character.isISOControl(letters)){
					author_TextField.setEditable(true);
				} else {
					author_TextField.setEditable(false);
				}
			}
		});
		contentPane.add(author_TextField);
		author_TextField.setColumns(10);
		
		//ADD BUTTON:  ADD DATA TO DATABASE BUTTON
				JButton add_Button = new JButton("ADD");
				add_Button.addActionListener(new ActionListener() {			
					public void actionPerformed(ActionEvent event) {
						Connection connection = null;			
						String aut = author_TextField.getText();
						String tit = title_TextField.getText();
						String sub = subject_ComboBox.getSelectedItem().toString();
						String pub = publisher_ComboBox.getSelectedItem().toString();
						String lang = language_ComboBox.getSelectedItem().toString();
						
						try {
							connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/librarydatabase", "root", "Connection");
							String sql = "INSERT INTO book (author, title, subject, publisher, language) VALUES (?, ?, ?, ?, ?)";
							PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
							statement.setString(1, aut);
							statement.setString(2, tit);				
							statement.setString(3, sub);
							statement.setString(4, pub);
							statement.setString(5, lang);
							
							statement.executeUpdate();
							JOptionPane.showMessageDialog(null, "The book has been added successfully");		
							connection.close();
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, e);
						}
						
					}
				});
				add_Button.setBounds(470, 605, 149, 25);
				add_Button.setFont(new Font("Georgia", Font.BOLD, 20));
				contentPane.add(add_Button);
				
		// CLEAR BUTTON
		JButton clear_Button = new JButton("CLEAR");
		clear_Button.setBounds(249, 605, 117, 25);
		clear_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				author_TextField.setText("");
				title_TextField.setText("");
				subject_ComboBox.setSelectedItem("");				
				publisher_ComboBox.setSelectedItem("");
				language_ComboBox.setSelectedItem("");
			}
		});
		clear_Button.setFont(new Font("Georgia", Font.BOLD, 20));
		contentPane.add(clear_Button);
			
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

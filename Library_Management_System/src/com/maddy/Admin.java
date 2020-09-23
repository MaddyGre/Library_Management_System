package com.maddy;

import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
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

import javax.swing.AbstractButton;
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
import java.util.Vector;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField title_TextField;
	private JTextField author_TextField;	
	private JScrollPane scrollPane;
	DefaultTableModel model;
	private JTable table_1;
	
		
	public DefaultTableModel getModel() {
		return model;
	}


	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
public void updateTable(){
		
		int c;
		
		PreparedStatement pStatement;
		Connection conn = null;
		ResultSet resultSet;
		
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/librarydatabase", "root", "Connection");
			pStatement = conn.prepareStatement("SELECT * FROM book");
			
			ResultSet result_set = pStatement.executeQuery();
			ResultSetMetaData rs_metadata = result_set.getMetaData();
			
			c = rs_metadata.getColumnCount();
			
			DefaultTableModel df_model = (DefaultTableModel) table_1.getModel();
			df_model.setRowCount(0);
			
				
			while(result_set.next()){
				Vector vector = new Vector<>();
				
				for(int index = 1; index <= c; index++){
					vector.add(result_set.getString("bookID"));
					vector.add(result_set.getString("author"));
					vector.add(result_set.getString("title"));
					vector.add(result_set.getString("subject"));
					vector.add(result_set.getString("publisher"));
					vector.add(result_set.getString("language"));
				}
				
				df_model.addRow(vector);
			}

			author_TextField.requestFocus();
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: please try again");
		}
	}
	
		
	public Admin() {
		
					
		setBackground(new Color(72, 209, 204));		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1186, 728);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(72, 209, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();

		
		scrollPane.setBounds(440, 38, 716, 530);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setColumnSelectionAllowed(false);
	
		table_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table_1.setBackground(new Color(245, 245, 245));
		model = new DefaultTableModel();
		Object[] column_headers = {"BookID", "Author", "Title", "Subject", "Publisher", "Language"};
		model.setColumnIdentifiers(column_headers);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"BookID", "Author", "Title", "Subject", "Publisher", "Language"
			}
		));
		
		scrollPane.setViewportView(table_1);
		
		//DELETE BUTTON
		JButton delete_Button = new JButton("DELETE ");
		delete_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model = (DefaultTableModel) table_1.getModel();
				
				try {
					
					int selectedRowIndex = table_1.getSelectedRow();
					model.removeRow(selectedRowIndex);
					
					JOptionPane.showMessageDialog(null, "Book deleted successfully");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			}


		}
				);
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
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String authorClicked = table_1.getValueAt(table_1.getSelectedRow(), 1).toString();
				String titleClicked = table_1.getValueAt(table_1.getSelectedRow(), 2).toString();
				String subjectClicked = table_1.getValueAt(table_1.getSelectedRow(), 3).toString();
				String publisherClicked = table_1.getValueAt(table_1.getSelectedRow(), 4).toString();
				String languageClicked = table_1.getValueAt(table_1.getSelectedRow(), 5).toString();
				
				author_TextField.setText(authorClicked);
				title_TextField.setText(titleClicked);
				subject_ComboBox.setSelectedItem(subjectClicked);
				publisher_ComboBox.setSelectedItem(publisherClicked);
				language_ComboBox.setSelectedItem(languageClicked);
								
			}
		});
		

		
		//ADD BUTTON:  ADD DATA TO DATABASE BUTTON AND DISPLAY ON TABLE
				JButton add_Button = new JButton("ADD");
				final Object[] add_row = new Object[6];
				add_Button.addActionListener(new ActionListener() {			
					public void actionPerformed(ActionEvent event) {
						Connection connection = null;	
						PreparedStatement statement;
			
						String aut = author_TextField.getText();
						String tit = title_TextField.getText();
						String sub = subject_ComboBox.getSelectedItem().toString();
						String pub = publisher_ComboBox.getSelectedItem().toString();
						String lang = language_ComboBox.getSelectedItem().toString();
												
						add_row[1] = author_TextField.getText();
						add_row[2] = title_TextField.getText();
						add_row[3] = subject_ComboBox.getSelectedItem().toString();
						add_row[4] = publisher_ComboBox.getSelectedItem().toString();
						add_row[5] = language_ComboBox.getSelectedItem().toString();
										
						model.addRow(add_row);
												
						try {
							connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/librarydatabase", "root", "Connection");
							String sql = "INSERT INTO book (author, title, subject, publisher, language) VALUES (?, ?, ?, ?, ?)";
							statement = (PreparedStatement) connection.prepareStatement(sql);
							statement.setString(1, aut);
							statement.setString(2, tit);				
							statement.setString(3, sub);
							statement.setString(4, pub);
							statement.setString(5, lang);
							
							statement.executeUpdate();
							JOptionPane.showMessageDialog(null, "The book has been added successfully");
							author_TextField.requestFocus();
							updateTable();
							connection.close();
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, "Error: please try again");
						}
						
					}
				});
				add_Button.setBounds(351, 605, 149, 25);
				add_Button.setFont(new Font("Georgia", Font.BOLD, 20));
				contentPane.add(add_Button);
								
				//UPDATE BUTTON - UPDATES SELECTED RECORD
				JButton update_Button = new JButton("UPDATE ");
				update_Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Connection connection = null;	
			
						
						int column;
						int row = table_1.getSelectedRow();
						String data = table_1.getValueAt(row, 2).toString();
						System.out.println(data);
																		
						try {
							Class.forName("com.mysql.jdbc.Driver");
							connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/librarydatabase", "root", "Connection");	
				            String sql = "UPDATE book SET author = ?, title = ?,subject = ?, publisher = ?, language = ? WHERE bookID = ?";
				            PreparedStatement pst = connection.prepareStatement(sql);
				            pst.setString(1, table_1.getValueAt(row, 1).toString());
				            pst.setString(2, table_1.getValueAt(row, 2).toString());
				            pst.setString(3, table_1.getValueAt(row, 3).toString());
				            pst.setString(4, table_1.getValueAt(row, 4).toString());
				            pst.setString(5, table_1.getValueAt(row, 5).toString());
				            pst.setString(6, table_1.getValueAt(row, 0).toString());
				            int a = pst.executeUpdate();
				            if (a > 0) {
				                JOptionPane.showMessageDialog(null, "Record updated successfully");
				            } else {
				            	JOptionPane.showMessageDialog(null, "Record failed to update");
				            }
							
					
					} catch (Exception e) {
						e.printStackTrace();
					}catch(Throwable e) 
					{
						e.printStackTrace();
					}
					}
				});
				update_Button.setBounds(648, 605, 149, 25);
				update_Button.setFont(new Font("Georgia", Font.BOLD, 20));
				contentPane.add(update_Button);
				
		// CLEAR BUTTON
		JButton clear_Button = new JButton("CLEAR");
		clear_Button.setBounds(93, 605, 117, 25);
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
	
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run()  {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JTable getTable_1() {
		return table_1;
	}
}

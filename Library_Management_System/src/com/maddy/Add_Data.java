package com.maddy;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

public class Add_Data {
	
	private JPanel contentPane;
	private JTextField title_TextField;
	private JTextField author_TextField;	
	private JScrollPane scrollPane;
	DefaultTableModel model;
	private JTable table_1;
	
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
	

}

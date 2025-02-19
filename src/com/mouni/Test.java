package com.mouni;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		//Dyanmic input
		//create table tablename(colums)
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","root");
		Statement st=con.createStatement();
		//String Option="";
		System.out.print("Enter the Table Name  :");
		String tableName=br.readLine();
		String Query="create table "+tableName+"(";
		while(true) {
			System.out.print("Column Name :");
			String columnName=br.readLine();
			
			System.out.print("Column Type");
			String columnType=br.readLine();
			
			System.out.print("Column Size   ");
			String columnSize=br.readLine();
			
			Query = Query + columnName + " "+columnType+"("+columnSize+"),";
			System.out.print("one more column[yes/no");
			String option=br.readLine();
			
			if (option.equalsIgnoreCase("yes")) {
				continue;
			}
			else {
				 Query = Query.substring(0, Query.length() - 1) + ")";
				break;
			}
		}
		System.out.println(Query);
		st.executeUpdate(Query);
		System.out.println("table created Successfully");
		con.close();
		br.close();
	
	}

}

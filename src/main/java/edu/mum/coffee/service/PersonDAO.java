package edu.mum.coffee.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.mum.coffee.domain.Person;

public class PersonDAO {

	Connection con;
	Statement stmt;

	public PersonDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_coffee?user=root&password=root");
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Person findByEmail(String email){
		Person p = new Person();
		try{
			String query = "SELECT * FROM Person WHERE email='"+email+"'";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				p.setId(rs.getLong("id"));
				p.setEmail(rs.getString("email"));
				p.setEnable(rs.getString("enable"));
				p.setFirstName(rs.getString("first_name"));
				p.setLastName(rs.getString("last_name"));
				p.setPassword(rs.getString("password"));
				p.setPhone(rs.getString("phone"));
				p.setRole(rs.getString("role"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;
	}
	
//	public static void main(String[] args){
//		System.out.println(new PersonDAO().findByEmail("samrat@gmail.com").toString());
//	}

}

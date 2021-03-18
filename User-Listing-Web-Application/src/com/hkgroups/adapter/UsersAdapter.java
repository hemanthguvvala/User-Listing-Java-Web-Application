package com.hkgroups.adapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hkgroups.dataresources.UsersData;

public class UsersAdapter {
	public List<UsersData> dataList(DataSource dataSource) {

		List<UsersData> users = new ArrayList<UsersData>();

		Connection connector = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			connector = dataSource.getConnection();
			String query = "select *from userlist";
			statement = connector.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				users.add(new UsersData(rs.getInt("user_id"), rs.getString("user_first_name"),
						rs.getString("user_last_name"), rs.getString("user_email"), rs.getString("gender")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;

	}

	public void adduser(UsersData userdata, DataSource dataSource) {

		Connection connector = null;
		PreparedStatement prest = null;
		try {
			connector = dataSource.getConnection();
			String userfirstname = userdata.getUser_first_name();
			String userlastname = userdata.getUser_last_name();
			String useremail = userdata.getUser_email();
			String gender = userdata.getGender();
			String query = "insert into userlist(user_first_name,user_last_name,user_email,gender) values(?,?,?,?)";
			prest = connector.prepareStatement(query);
			prest.setString(1, userfirstname);
			prest.setString(2, userlastname);
			prest.setString(3, useremail);
			prest.setString(4, gender);
			prest.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updatUuser(UsersData updateUserData, DataSource dataSource) {
		Connection connector = null;
		PreparedStatement prest = null;
		try {
			connector = dataSource.getConnection();
			int userid = updateUserData.getUser_id();
			String userfirstname = updateUserData.getUser_first_name();
			String userlastname = updateUserData.getUser_last_name();
			String useremail = updateUserData.getUser_email();
			String gender = updateUserData.getGender();
			String query = "update userlist set user_first_name= ?, user_last_name=?,user_email=?,gender=? where user_id=?";
			prest = connector.prepareStatement(query);
			prest.setString(1, userfirstname);
			prest.setString(2, userlastname);
			prest.setString(3, useremail);
			prest.setString(4, gender);
			prest.setInt(5, userid);
			prest.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteuser(DataSource dataSource, int userid) {
		
		Connection connector = null;
		PreparedStatement prest = null;
		
		try {
			connector = dataSource.getConnection();
			String  query= "delete from userlist where user_id=?";
			prest = connector.prepareStatement(query);
			prest.setInt(1, userid);
			prest.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

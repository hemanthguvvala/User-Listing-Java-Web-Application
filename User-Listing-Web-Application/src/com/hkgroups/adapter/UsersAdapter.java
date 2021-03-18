package com.hkgroups.adapter;

import java.sql.Connection;
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
}

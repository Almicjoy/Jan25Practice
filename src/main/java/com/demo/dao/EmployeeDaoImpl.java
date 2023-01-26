package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Employee;
import com.demo.utility.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public void save(Employee e) {
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into employee values (?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2,  e.getName());
			ps.setString(3, e.getDept());
			ps.setFloat(4, e.getSalary());
			
			int x = ps.executeUpdate();
			if(x != 0) {
				System.out.println("Data Inserted");		
			} else {
				System.out.println("Issue with query");
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

	@Override
	public List<Employee> retrieveEmployees() {
		Connection conn = DBConnection.getConnection();
		List<Employee> employees = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getFloat(4));
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void deleteById(Integer deleteById) {
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from employee where id=?");
			ps.setInt(1, deleteById);
			
			int x = ps.executeUpdate();
			if(x!=0) {
				System.out.println("data updated");
			} else {
				System.out.println("issue with query");
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateSalaryById(Integer updateSalaryId, Float salary) {
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("update employee set salary=? where id=?");
			ps.setFloat(1, salary);
			ps.setInt(2, updateSalaryId);
			
			int x = ps.executeUpdate();
			if(x!=0) {
				System.out.println("data updated");
			} else {
				System.out.println("issue with query");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}

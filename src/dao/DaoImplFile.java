package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.Employee;

public class DaoImplFile implements Dao {
	private File usersFile;

	@Override
	public void connect() {
		usersFile = new File(System.getProperty("user.dir") + File.separator + "files" + File.separator + "users.txt");
	}

	@Override
	public void disconnect() {
		usersFile = null;
	}

	@Override
	public Employee getEmployee(int employeeId, String password) {
		if (usersFile == null || !usersFile.exists()) {
			return null;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(usersFile))) {
			String line = br.readLine();
			while (line != null) {
				Employee employee = parseEmployee(line);
				if (employee != null && employee.getEmployeeId() == employeeId && password.equals(employee.getPassword())) {
					return employee;
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("No s'ha pogut llegir el fitxer d'usuaris: " + e.getMessage());
		}
		return null;
	}

	private Employee parseEmployee(String line) {
		String[] sections = line.split(";");
		int employeeId = 0;
		String name = "";
		String password = "";

		for (String section : sections) {
			String[] data = section.split(":", 2);
			if (data.length != 2) {
				continue;
			}
			switch (data[0].trim()) {
			case "Employee":
				employeeId = Integer.parseInt(data[1].trim());
				break;
			case "Name":
				name = data[1].trim();
				break;
			case "Password":
				password = data[1].trim();
				break;
			default:
				break;
			}
		}

		if (employeeId == 0 || password.isEmpty()) {
			return null;
		}
		return new Employee(employeeId, name, password);
	}
}

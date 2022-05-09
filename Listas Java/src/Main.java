import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import java.util.Scanner;

import entities.Employee;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scan = new Scanner(System.in);

		List<Employee> employeersList = new ArrayList<>();

		System.out.println("How many employees will be registered?");
		int employeerssAmount = scan.nextInt();

		for (int i = 1; i <= employeerssAmount; i++) {
			System.out.println("Employee #" + i);
			System.out.println("Id:");
			Integer id = scan.nextInt();

			while (hasId(employeersList, id)) {
				System.out.println("Id already taken! Try again.");
				System.out.println("Id:");
				id = scan.nextInt();
			}

			System.out.println("Name:");
			String name = scan.next();
			System.out.println("Salary:");
			Double salary = scan.nextDouble();

			Employee employee = new Employee(id, name, salary);

			employeersList.add(employee);

		}

		System.out.println("Enter the employee ID that you hava salary increase.");
		int idSalary = scan.nextInt();

		Employee employee = employeersList.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

		if (employee == null) {
			System.out.println("This id does not exist!");

		} else {
			System.out.println("Enter the percentage.");
			double percentage = scan.nextDouble();
			employee.increaseSalary(percentage);
		}

		System.out.println("List of employeers:");

		for (Employee emp : employeersList) {
			System.out.println(emp);
		}

		scan.close();

	}

	public static boolean hasId(List<Employee> employeersList, int idSalary) {
		Employee employee = employeersList.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		return employee != null;
	}

}
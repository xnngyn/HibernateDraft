package de.hft_stuttgart.main;

import de.hft_stuttgart.source.Employee;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
	static SessionFactory factory;

	// get/read values from database/table
	public static List<Employee> getEmployees() {

		List<Employee> employees; // created list named employees
		Session session = factory.openSession(); // open Session to create SQL argument
		employees = session.createQuery("FROM Employee").list();
		session.close();
		return employees;
	}

	// save object in database/table
	public static void save(Employee employee) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

	// delete object from database/table by id
	public static void delete(int id) {
		Session session = factory.openSession();
		session.beginTransaction();
		Employee emp = new Employee();
		emp.setId(id);
		session.delete(emp);
		session.getTransaction().commit();
		session.close();
	}

	public static void main(String[] args) {

		try {
			// open database connection
			factory = new Configuration().configure().buildSessionFactory();
			System.out.println("sessionFactory object created successfully. Connection to database is up.");
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		// create new object
		Employee emp1 = new Employee();
		emp1.setFirstName("Robin");
		emp1.setLastName("Stettner");
		// create new object
		Employee emp2 = new Employee();
		emp2.setFirstName("Ravinder");
		emp2.setLastName("Singh");

		// save new object in database/table
		/*save(emp1);
		  save(emp2);*/

		// delete object by id from database/table
		/*delete(107);
		  delete(106);*/

	

		
		// assume values from getEmployees() 
		List<Employee> employees = getEmployees();
		System.out.println("------------------------------------");
		System.out.print(String.format("%10s %10s %10s\n", "ID", "First Name", "Last Name"));
		System.out.println("------------------------------------");
		// Print values
		for (Employee myEmp : employees) {
			System.out.println(myEmp);
		}
		System.out.println("------------------------------------");
		
		// close database connection
		factory.close();
	}

}

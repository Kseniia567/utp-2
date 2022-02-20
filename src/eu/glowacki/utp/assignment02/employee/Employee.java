package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;


public abstract class Employee extends Person {



	//
	// attributes:

	private BigDecimal _salary;
	// * salary (use BigDecimal type for representing currency values)
	private final Manager _manager;
	// * manager (empty if at top of hierarchy)


	public BigDecimal getSal() {
		return _salary;
	}

	public Manager get_manager() {
		return _manager;
	}



	protected Employee(String firstName, String surname, LocalDate date, BigDecimal sal, Manager manager) {
		super(firstName, surname, date);
		_salary = sal;
		_manager = manager;
	}
}
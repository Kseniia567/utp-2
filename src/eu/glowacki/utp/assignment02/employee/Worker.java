package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Worker extends Employee {

	// attributes
	// * employment date
	private final LocalDate _employmentDate;
	// * bonus
	private final BigDecimal _bonus;


	public LocalDate get_employmentDate() {
		return _employmentDate;
	}

	public BigDecimal get_bonus() {
		return _bonus;
	}



	public Worker(String firstName, String surname, LocalDate date, BigDecimal sal, Manager manager, LocalDate empDate, BigDecimal bonus) {
		super(firstName, surname, date, sal, manager);
		_employmentDate = empDate;
		_bonus = bonus;

	}


	// for the highest seniority
	public long workDays() {

		return ChronoUnit.DAYS.between(_employmentDate, LocalDate.now());
	}



}
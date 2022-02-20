package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Trainee extends Employee {

	// attributes:
	// * apprenticeship start date
	private final LocalDate _startDate;
	private int _apprenticeship_length;
	// * apprenticeship length (in days)
	
	public Trainee(String firstName, String surname, LocalDate date, BigDecimal sal, Manager manager, LocalDate startDate, int a_Length) {
		super(firstName, surname, date, sal, manager);
		_startDate = startDate;
		_apprenticeship_length = a_Length;
	}

	public LocalDate get_startDate() {
		return _startDate;
	}


	public int get_apprenticeship_length() {
		return _apprenticeship_length;
	}


}
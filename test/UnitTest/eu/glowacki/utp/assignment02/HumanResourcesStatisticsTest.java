package eu.glowacki.utp.assignment02;

import eu.glowacki.utp.assignment02.employee.Employee;
import eu.glowacki.utp.assignment02.employee.Manager;
import eu.glowacki.utp.assignment02.employee.Trainee;
import eu.glowacki.utp.assignment02.employee.Worker;
import eu.glowacki.utp.assignment02.payroll.PayrollEntry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanResourcesStatisticsTest {

    // Create a HR structure which resembles the below one:
    //
    // Director (an instance of Manager class (Director does not have a manager)
    //   |- Manager01
    //        |- Worker
    //        |- Worker
    //        |- Trainee
    //        |- ...
    //   |- Manager02
    //        |- ...
    //   |- ...
    //   |- Worker
    //   |- Worker
    //   |- Trainee

    private List<Employee> _allEmployees;
    // all employees ---  i.e. Workers, Trainees and their Managers and top Director (also an instance of Manager class)


    @Before
    public void before (){
        _allEmployees = new ArrayList<>();

        List<Employee> level1 = new ArrayList<>();

        //the highest sal without bonus and the highest seniority
        Manager director = new Manager("Artemii","Fedorchenko", LocalDate.of(1973,12,22),new BigDecimal(9000),
                null, LocalDate.of(1992,6,6),new BigDecimal(100),level1);
        _allEmployees.add(director);

        List<Employee> level2m1 = new ArrayList<>();

        //the highest sal with bonus
        Manager manager1 = new Manager("Alina","Solopova", LocalDate.of(1980,5,11),new BigDecimal(8500),
                director,LocalDate.of(2000,2,21),new BigDecimal(700),level2m1);
        level1.add(manager1);
        _allEmployees.add(manager1);

        Worker w1m1 = new Worker("Anna","Ivanova",LocalDate.of(1979,12,5),new BigDecimal(1900),
                manager1,LocalDate.of(1999,9,21),new BigDecimal(100));
        _allEmployees.add(w1m1);

        Worker w2m1 = new Worker("Denis","Alihanov",LocalDate.of(1990,8,10),new BigDecimal(1000),
                manager1,LocalDate.of(2007,11,1),new BigDecimal(150));
        _allEmployees.add(w2m1);

        Trainee t1m1 = new Trainee("Mariia","Serova",LocalDate.of(2000,12,3),new BigDecimal(500),
                manager1,LocalDate.of(2013,11,1), 350);
        _allEmployees.add(t1m1);

        Trainee t2m1 = new Trainee("Sergei","Baranov",LocalDate.of(2002,8,13),new BigDecimal(600),
                manager1,LocalDate.of(2020,1,13), 200);
        _allEmployees.add(t2m1);

        level2m1.add(w1m1);
        level2m1.add(w2m1);
        level2m1.add(t1m1);
        level2m1.add(t2m1);              //1 person with surname A......

        List<Employee> level2m2 = new ArrayList<>();

        Manager manager2 = new Manager("Anastasia","Osokina", LocalDate.of(1991,2,4),new BigDecimal(7000),
                director,LocalDate.of(2014,2,1),new BigDecimal(1500),level2m2);
        level1.add(manager2);
        _allEmployees.add(manager2);

        Worker w1m2 = new Worker("Vasiliy","Livanov",LocalDate.of(2000,9,21),new BigDecimal(2500),
                manager2,LocalDate.of(2020,2,13),new BigDecimal(120));
        _allEmployees.add(w1m2);

        Worker w2m2 = new Worker("Alisa","Klimenko",LocalDate.of(1980,2,2),new BigDecimal(800),
                manager2,LocalDate.of(2006,6,28),new BigDecimal(100));
        _allEmployees.add(w2m2);

        Worker w3m2 = new Worker("Alexandr","Antropov",LocalDate.of(1990,5,2),new BigDecimal(700),
                manager2,LocalDate.of(2021,1,19),new BigDecimal(100));
        _allEmployees.add(w3m2);

        Trainee t1m2 = new Trainee("Viktoriia","Solntceva",LocalDate.of(2001,8,2),new BigDecimal(600),
                manager2,LocalDate.of(2007,11,1), 120);
        _allEmployees.add(t1m2);

        Trainee t2m2 = new Trainee("Viktor","Cherepanov",LocalDate.of(2000,4,2),new BigDecimal(200),
                manager2,LocalDate.of(2021,2,2), 230);
        _allEmployees.add(t2m2);

        Trainee t3m2 = new Trainee("Lev","Malinovski",LocalDate.of(1998,12,14),new BigDecimal(500),
                manager2,LocalDate.of(2020,2,1), 250);
        _allEmployees.add(t3m2);

        level2m2.add(w1m2);
        level2m2.add(w2m2);
        level2m2.add(w3m2);
        level2m2.add(t1m2);
        level2m2.add(t2m2);
        level2m2.add(t3m2); //1 person with surname A......

        List<Employee> level2m3 = new ArrayList<>();

        Manager manager3 = new Manager("Kseniia","Smirnova", LocalDate.of(1977,6,12),new BigDecimal(7000),
                director,LocalDate.of(2019,3,4),new BigDecimal(100),level2m3);
        level1.add(manager3);
        _allEmployees.add(manager3);

        Worker w1m3 = new Worker("Sofiia","Lisitsina",LocalDate.of(2001,9,11),new BigDecimal(2000),
                manager3,LocalDate.of(2020,6,13),new BigDecimal(100));
        _allEmployees.add(w1m3);

        Worker w2m3 = new Worker("Ekaterina","Romanovna",LocalDate.of(2002,2,12),new BigDecimal(1000),
                manager3,LocalDate.of(2021,6,17),new BigDecimal(100));
        _allEmployees.add(w2m3);

        //SENIOR
        Worker w3m3 = new Worker("Boris","Voronin",LocalDate.of(1980,1,5),new BigDecimal(900),
                manager3,LocalDate.of(2000,12,9),new BigDecimal(100));
        _allEmployees.add(w3m3);

        Trainee t1m3 = new Trainee("Vasilisa","Karpova",LocalDate.of(1996,12,21),new BigDecimal(650),
                manager3,LocalDate.of(2020,2,1), 450);
        _allEmployees.add(t1m3);

        Trainee t2m3 = new Trainee("Ruslan","Dolgov",LocalDate.of(1970,8,3),new BigDecimal(100),
                manager3,LocalDate.of(2013,6,13), 500);
        _allEmployees.add(t2m3);

        Trainee t3m3 = new Trainee("Yurii","Gagarin",LocalDate.of(2008,6,7),new BigDecimal(300),
                manager3,LocalDate.of(2021,10,3), 190);
        _allEmployees.add(t3m3);


        level2m3.add(w1m3);
        level2m3.add(w2m3);
        level2m3.add(w3m3);
        level2m3.add(t1m3);
        level2m3.add(t2m3);
        level2m3.add(t3m3);    //0 person with surname A......
    }



    @Test
    public void payroll() {
        List<PayrollEntry> payroll = HumanResourcesStatistics.payroll(_allEmployees);
        Assert.assertEquals(9100, payroll.get(0).get_salaryPlusBonus().intValue());
        Assert.assertEquals(300,payroll.get(payroll.size()-1).get_salaryPlusBonus().intValue());
    }

    @Test
    public void subordinatesPayroll() {
        Manager m = (Manager) _allEmployees.get(1);
        List<PayrollEntry> payroll = HumanResourcesStatistics.subordinatesPayroll(m);
        Assert.assertEquals(2000, payroll.get(0).get_salaryPlusBonus().intValue());
    }

    @Test
    public void bonusTotal() {
        BigDecimal total = HumanResourcesStatistics.bonusTotal(_allEmployees);
        Assert.assertEquals(new BigDecimal("3270"), total);
    }

    @Test
    public void maxSeniority() {
        Employee emp = HumanResourcesStatistics.maxSeniority(_allEmployees);
        Assert.assertEquals("Fedorchenko",emp.get_surname());

    }

    @Test
    public void longestSeniority() {
        Employee emp = HumanResourcesStatistics.maxSeniority(_allEmployees);
        Assert.assertEquals("Fedorchenko",emp.get_surname());
    }

    @Test
    public void maxSalWithoutBonus() {
        BigDecimal salary = HumanResourcesStatistics.maxSalWithoutBonus(_allEmployees);
        Assert.assertEquals(9000,salary.intValue());
    }

    @Test
    public void maxSalWithBonus() {
        BigDecimal salary = HumanResourcesStatistics.maxSalWithBonus(_allEmployees);
        Assert.assertEquals(9200, salary.intValue());
    }

    @Test
    public void startWithA() {
        Manager m = (Manager) _allEmployees.get(1);
        List<Employee> surnamesA = HumanResourcesStatistics.startWithA(m);
        if (surnamesA != null) {
            Assert.assertEquals(1,surnamesA.size());
        }
    }

    @Test
    public void earnMore1000() {
        List<Employee> earn1000 = HumanResourcesStatistics.earnsMore1000(_allEmployees);
        Assert.assertEquals(7,earn1000.size());
    }

    /// ...
    // rest of the methods specified in the assignment description
}
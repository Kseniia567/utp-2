package eu.glowacki.utp.assignment02;

import eu.glowacki.utp.assignment02.employee.Employee;
import eu.glowacki.utp.assignment02.employee.Manager;
import eu.glowacki.utp.assignment02.employee.Worker;
import eu.glowacki.utp.assignment02.payroll.PayrollEntry;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public final class HumanResourcesStatistics {

    public static List<PayrollEntry> payroll(List<Employee> employees) {
        if (employees == null) {
            return null;
        }
        List<PayrollEntry> payroll = employees
                .stream()
                .map(emp -> new PayrollEntry(emp, emp.getSal(),
                        emp instanceof Worker ? ((Worker) emp).get_bonus() : BigDecimal.ZERO))
                .collect(Collectors.toList());
        return payroll;

    }

    // payroll for all subordinates
    public static List<PayrollEntry> subordinatesPayroll(Manager manager) {
        return payroll(manager.allSub());
    }

    public static BigDecimal bonusTotal(List<Employee> employees) {
        if (employees == null) {
            return null;
        }

        BigDecimal totalBonus = employees
                .stream()
                .filter(emp -> emp instanceof Worker)
                .map(emp -> ((Worker) emp).get_bonus())
                .reduce(BigDecimal.ZERO, HumanResourcesStatistics::bonusTotal);

        return totalBonus;
    }

    /// ...
    // rest of the methods specified in the assignment description


    public static Employee maxSeniority(List<Employee> employees) {
        if (employees == null) {
            return null;
        }
        long max = employees
                .stream()
                .filter(emp -> emp instanceof Worker)
                .map(emp -> ((Worker) emp).workDays())
                .reduce(Long.valueOf(0), (maxDay, day) -> {
                    if (maxDay < day) {
                        return day;
                    } else {
                        return maxDay;
                    }
                });

        Employee senior = employees
                .stream()
                .filter(emp -> emp instanceof Worker && ((Worker) emp).workDays() == max)
                .collect(Collectors.toList())
                .get(0);

        return senior;
    }



    public static Employee longestSeniority(List<Employee> employees) {
        if (employees == null) {
            return null;
        }
        LocalDate max = employees
                .stream()
                .filter(emp -> emp instanceof Worker)
                .map(emp -> ((Worker) emp).get_employmentDate())
                .reduce(LocalDate.ofEpochDay(0), (maxDay, day) -> {
                    if (maxDay.isBefore(day)) {
                        return maxDay;
                    } else {
                        return day;
                    }
                });

        Employee senior = employees
                .stream()
                .filter(emp -> emp instanceof Worker && ((Worker) emp).get_employmentDate() == max)
                .collect(Collectors.toList())
                .get(0);

        return senior;
    }


    public static BigDecimal maxSalWithoutBonus(List<Employee> employees) {
        if (employees == null) {
            return null;
        }

        BigDecimal max = employees
                .stream()
                .map(emp -> emp.getSal())
                .reduce(BigDecimal.ZERO,
                        (maxSal, sal) -> sal.max(maxSal));
        return max;
    }

    public static BigDecimal maxSalWithBonus(List<Employee> employees) {
        if (employees == null) {
            return null;
        }

        BigDecimal maxSal = employees
                .stream()
                .filter(emp -> emp instanceof Worker)
                .map(emp -> ((Worker) emp).get_bonus().add(emp.getSal()))
                .reduce(BigDecimal.ZERO, HumanResourcesStatistics::maxSal);

        return maxSal;
    }

    public static List<Employee> startWithA(Manager manager) {
        if (manager.get_subordinates() == null) {
            return null;
        }
        List<Employee> s = manager.get_subordinates()
                .stream()
                .filter(emp -> emp.get_surname().startsWith("A"))
                .collect(Collectors.toList());

        return s;
    }


    public static List<Employee> earnsMore1000(List<Employee> employee) {
        if (employee == null) {
            return null;
        }

        List<Employee> list = employee
                .stream()
                .filter(emp -> emp.getSal().compareTo(BigDecimal.valueOf(1000)) > 0)
                .collect(Collectors.toList());

        return list;
    }


    /**
     * samples for functional processing in Java
     */
    public static List<Short> getAges(List<Employee> employees) {
        if (employees == null) {
            return null;
        }
        List<Short> ages = employees //
                .stream() //
                .map(emp -> emp.getAge()) //
                .collect(Collectors.toList());
        return ages;
    }

    public static void printAges(List<Employee> employees) {
        if (employees == null) {
            return;
        }
        employees //
                .stream() //
                .map(emp -> (int) emp.getAge()) //
                .forEach(age -> System.out.print(age + ", "));
    }

    //
    // average age for the Employees whose first name starts with 'A' and they are older than 20
    public static short getAverageAgeInline(List<Employee> employees) {
        if (employees == null) {
            return 0;
        }
        int employeeTotalAge = employees //
                .stream() //
                .filter(emp -> emp.getFirstName().startsWith("A") && emp.getAge() > 20) //
                .map(emp -> (int) emp.getAge()) //
                .reduce(0, //
                        (total, age) -> total + age);

        long filteredEmployeesCount = employees //
                .stream() //
                .filter(emp -> emp.getFirstName().startsWith("A") && emp.getAge() > 20) //
                .count();

        return (short) (employeeTotalAge / filteredEmployeesCount);
    }

    public static short getAverageAgeMethodReference(List<Employee> employees) {
        if (employees == null) {
            return 0;
        }
        int employeeTotalAge = employees //
                .stream() //
                .map(emp -> (int) emp.getAge()) //
                .reduce(0, HumanResourcesStatistics::totalAge);
        return (short) (employeeTotalAge / employees.size());
    }

    public static short getMaxAgeInline(List<Employee> employees) {
        short employeeMaxAge = employees //
                .stream() //
                .map(emp -> emp.getAge()) //
                .reduce((short) 0, //
                        (maxAge, age) -> {
                            if (maxAge < age) {
                                return age;
                            } else {
                                return maxAge;
                            }
                        });
        return employeeMaxAge;
    }

    public static short getMaxAgeMethodReference(List<Employee> employees) {
        short employeeMaxAge = employees //
                .stream() //
                .map(emp -> emp.getAge()) //
                .reduce((short) 0, HumanResourcesStatistics::maxAge);
        return employeeMaxAge;
    }

    private static int totalAge(int totalAge, int age) {
        return totalAge + age;
    }

    private static short maxAge(short maxAge, short age) {
        if (maxAge < age) {
            return age;
        } else {
            return maxAge;
        }
    }

    private static BigDecimal bonusTotal(BigDecimal bonusTotal, BigDecimal bonus) {
        return bonusTotal.add(bonus);
    }

    private static BigDecimal maxSal(BigDecimal sal, BigDecimal maxSal) {
        return maxSal.max(sal);
    }


}
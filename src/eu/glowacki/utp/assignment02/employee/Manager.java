package eu.glowacki.utp.assignment02.employee;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Manager extends Worker {

    // attributes
    // * subordinates (a list of immediate subordinates)
    private final List<Employee> _subordinates;
    // * all subordinates (derived --- i.e. calculated on the fly --- a list of subordinates in all hierarchy)

    public List<Employee> allSub() {
        List<Employee> allSub = new ArrayList<>();

        for (Employee temp : _subordinates) {
            allSub.add(temp);

            if (temp instanceof Manager) {
                if (((Manager) temp).get_subordinates() != null) {
                    allSub.addAll(((Manager) temp).get_subordinates());
                }
            }
        }


        return allSub;
    }


    public Manager(String firstName, String surname, LocalDate date, BigDecimal sal, Manager manager, LocalDate empDate, BigDecimal bonus, List<Employee> sub) {
        super(firstName, surname, date, sal, manager, empDate, bonus);

        _subordinates = sub;
    }


    public List<Employee> get_subordinates() {
        return _subordinates;
    }
}
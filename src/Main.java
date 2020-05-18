import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Thread( ()->System.out.println("Printing from the Runnable")
         ).start();

    Employee john = new Employee("john doe",21);
    Employee john2 = new Employee("john2 doe",22);
    Employee john3 = new Employee("john3 doe",23);
    Employee john4 = new Employee("john4 doe",24);

    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(john);
    employeeList.add(john2);
    employeeList.add(john3);
    employeeList.add(john4);

//        Collections.sort(employeeList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        Collections.sort(employeeList,( employee1, employee2)->
                employee1.getName().compareTo(employee2.getName()));

    for (Employee employee: employeeList){
        System.out.println(employee.getName());
    }


    }

}
//class CodeToRun implements  Runnable{
//
//    @Override
//    public void run() {
//
//        System.out.println("Printing from the Runnable");
//    }
//}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

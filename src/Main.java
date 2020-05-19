import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("Printing from the Runnable")
        ).start();

        Employee john = new Employee("john doe", 21);
        Employee john2 = new Employee("john2 doe", 22);
        Employee john3 = new Employee("john3 doe", 23);
        Employee john4 = new Employee("john4 doe", 24);

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

        Collections.sort(employeeList, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for (Employee employee : employeeList) {
            System.out.println(employee.getName());
        }

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employeeList.get(0).getName(), employeeList.get(1).getName());

        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String sillyString = doStringStuff(uc,
                employeeList.get(0).getName(), employeeList.get(1).getName());

        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {

        return uc.upperAndConcat(s1, s2);

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

class Employee {
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

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
//        public String doSomething(){
//            System.out.println("The AnotherClass Name is "+ this.getClass().getSimpleName());
//            return  Main.doStringStuff(new UpperConcat() {
//                @Override
//                public String upperAndConcat(String s1, String s2) {
//                    System.out.println("The annonymous class Name is "+ this.getClass().getSimpleName());
//
//                    return s1.toUpperCase()+s2.toUpperCase();
//                }
//            }, "String1", "String2");
//        }

    public String doSomething() {
        System.out.println("The AnotherClass Name is " + this.getClass().getSimpleName());
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The annonymous class Name is " + this.getClass().getSimpleName());
            return s1.toUpperCase() + s2.toUpperCase();
        };
        return Main.doStringStuff(uc, "String1", "String2");
    }

}


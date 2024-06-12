
package COLLECTION;

import java.util.ArrayList;
import java.util.Collections;

public class ARRAYLIST {


    public static void main(String[] args) {
        Employee employee = new Employee( 11,"abc ","java");
        Employee employee1 = new Employee( 12,"xyz"," sr java");
        Employee employee2 = new Employee( 13,"def ","java");
        Employee employee3 = new Employee( 14,"klm"," sr java");
        ArrayList<Employee> arrayList1=new ArrayList<>();
        arrayList1.add(employee);
        arrayList1.add(employee1);
        arrayList1.add(employee2);
        arrayList1.add(employee3);
        Collections.sort(arrayList1,new EmployeeByName());
        System.out.println(arrayList1);

    }
    }

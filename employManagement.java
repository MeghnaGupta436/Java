package weeklyAssignment2;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class employManagement {
    //Object of Scanner class to input integer
    static Scanner obj = new Scanner(System.in);
    //Object of Scanner class to input String
//    static Scanner objS = new Scanner(System.in);
    static Map<Integer, Employee> Employees = new HashMap<>();
    static double TotalSalaryEarnedByEmployees = 0.0;
    static double ToatalSalaryOfAllEmployees = 0.0;
    class Employee{
        int employeeID;
        String employeeName;
        String position;
        String employmentType;
        double salary;
        double timeWorked;
        double totalSalaryEarned;

        Employee(int id, String name, String pos, String type, double sal, double time){
            employeeID = id;
            employeeName = name;
            position = pos;
            employmentType = type;
            salary = sal;
            timeWorked = time;
            calEmpTotalSalary(salary, timeWorked);
        }

        public void calEmpTotalSalary(double sal, double time){
            totalSalaryEarned = sal * time * 12;
        }

        public void display(){
            System.out.println("Employee ID : " + employeeID);
            System.out.println("Name : " + employeeName);
            System.out.println("Position : " + position);
            System.out.println("Employment Type : " + employmentType);
            System.out.println("Salary : " + salary + "/month");
            System.out.println("Working Since : " + timeWorked + " months");
            System.out.println("Total Salary earned till now : " + totalSalaryEarned);
        }
    }

    //function to input id
    public int inputID(){
        System.out.print("Enter the employee Id : ");
        int id = obj.nextInt();
        if(Employees.containsKey(id)){
            System.out.println("Employee ID already exist...!!");
            inputID();
        }
        return id;
    }

    //function to input name
    public String nameInput(){
        System.out.print("Enter the Name of the Employee (Only Alphabets allowed): ");
        String name = obj.nextLine();
        boolean flag = false;
        for(int i = 0; i < name.length(); i++){
            char ch = name.charAt(i);
            if(ch != ' ' && !Character.isAlphabetic(ch)){
                flag = true;
            }
        }
        if(flag){
            System.out.println("Invalid Name...!!");
            return name = nameInput();
        }

        return name;
    }
    //function to take input for type of position
    public String posInput(ArrayList<String> positions){
        System.out.println("Enter the Position of the Employee: ");
        System.out.println("Choose from : ");
        for(int i = 0; i < positions.size(); i++){
            System.out.println((i+1) + ". " + positions.get(i));
        }
        int pos = obj.nextInt();
        if(pos > positions.size()){
            System.out.println("Invalid Input...!!");
            return posInput(positions);
        }
        return positions.get(pos-1);
    }
    //function to take input for type of employement
    public String typeInput(ArrayList<String> typeEmployment){
        System.out.println("Enter the type of the Employment: ");
        System.out.println("Choose from : ");
        for(int i = 0; i < typeEmployment.size(); i++){
            System.out.println((i+1) + ". " + typeEmployment.get(i));
        }
        int type = obj.nextInt();
        if(type > typeEmployment.size()){
            System.out.println("Invalid Input...!!");
            posInput(typeEmployment);
        }
        return typeEmployment.get(type-1);
    }
    //function to add employess
    public void addEmployee(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        //Taking input for no. of employees user want to add
        System.out.print("Enter no. of employees you want to add : ");
        int size = obj.nextInt();

        //Loop to take details of each employee
        for(int i = 0; i < size; i++){
            int id = inputID();
            String name = nameInput();
            String pos = posInput(positions);
            String type = typeInput(typeEmployment);
            System.out.print("Enter Salary of the employee : ");
            double sal =  obj.nextDouble();
            System.out.print("Enter time worked of the employee in months : ");
            double months =  obj.nextDouble();
            //creating a new employee from the taken input details
            Employee e = new Employee(id, name, pos, type, sal, months);
            //adding the employee to the list of all employees
            Employees.put(id, e);
        }
        mainMenu(menu, positions, typeEmployment, attributes);
    }

    //function to remove an employee
    public void removeEmployee(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        System.out.print("Enter the Employee id you want to remove : ");
        int id = obj.nextInt();
        if(Employees.containsKey(id)){
            Employees.remove(id);
            System.out.println("Employee removed successfully...!!");
        }
        else{
            System.out.println("Employee doesn't exist..!!");
            removeEmployee(menu, positions, typeEmployment, attributes);
        }
        mainMenu(menu, positions, typeEmployment, attributes);
    }
    //function to display employee details according to specified employee id
    public void displayEmployee(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        System.out.print("Enter Employee id who's details you want to see : ");
        int id = obj.nextInt();
        if(Employees.containsKey(id)){
            Employee emp = Employees.get(id);
            emp.display();
        }
        else{
            System.out.println("Employee doesn't exist..!!");
            displayEmployee(menu, positions, typeEmployment, attributes);
        }
        mainMenu(menu, positions, typeEmployment, attributes);
    }
    //function to display details of all the employees
    public void displayAllEmployees(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        for(Map.Entry<Integer, Employee> e : Employees.entrySet()){
            int id = e.getKey();
            Employee emp = e.getValue();
            emp.display();
        }
        mainMenu(menu, positions, typeEmployment, attributes);
    }
    //function to calculate total salaries sum
    public void calTotalSalAll(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        for(Map.Entry<Integer, Employee> e : Employees.entrySet()){
            Employee emp = e.getValue();
            TotalSalaryEarnedByEmployees += emp.totalSalaryEarned;
            ToatalSalaryOfAllEmployees += emp.salary;
        }
        System.out.println("Total Salary Earned By all the employees till date : " + TotalSalaryEarnedByEmployees);
        System.out.println("Total Salary given per month by the company to their employees : " + ToatalSalaryOfAllEmployees);
        mainMenu(menu, positions, typeEmployment, attributes);
    }
    class EmployeeComparator implements Comparator<Employee>{
        // Overriding compare()method of Comparator
        // for ascending order of salary
        public int compare(Employee emp1, Employee emp2) {
            if (emp1.salary > emp2.salary)
                return 1;
            else if (emp1.salary < emp2.salary)
                return -1;
            return 0;
        }
    }

    //function to sort employees in ascending order of their salaries
    public void sortDescSalary(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        int size = Employees.size();
        PriorityQueue<Employee> pq = new PriorityQueue<>(size, new EmployeeComparator());
        for(Map.Entry<Integer, Employee> emp : Employees.entrySet()){
            pq.add(emp.getValue());
        }
        while(!pq.isEmpty()){
            pq.peek().display();
            pq.poll();
        }

        mainMenu(menu, positions, typeEmployment, attributes);
    }

    //function to search employee by name
    public void searchByName(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        String name = nameInput();
        boolean flag = false;
        for(Map.Entry<Integer, Employee> e : Employees.entrySet()){
            Employee emp = e.getValue();
            if(emp.employeeName.equals(name)){
                emp.display();
                flag = true;
            }
        }
        if(!flag){
            System.out.print("Employee doesn't exist...!!");
        }
        mainMenu(menu, positions, typeEmployment, positions);
    }
    //function to search employee according to their positions
    public void searchByPos(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        String pos = posInput(positions);
        boolean flag = false;
        for(Map.Entry<Integer, Employee> e : Employees.entrySet()){
            Employee emp = e.getValue();
            if(emp.position.equals(pos)){
                emp.display();
                flag = true;
            }
        }
        if(!flag){
            System.out.print("Employee doesn't exist...!!");
        }
        mainMenu(menu, positions, typeEmployment, attributes);
    }

    //function to search employee according to their salary
    public void searchSalRange(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        System.out.print("Enter minimum salary : ");
        double low =  obj.nextDouble();
        System.out.print("Enter Maximum salary : ");
        double high = obj.nextDouble();
        boolean flag = false;
        for(Map.Entry<Integer, Employee> e : Employees.entrySet()){
            Employee emp = e.getValue();
            if(emp.salary >= low && emp.salary <= high){
                emp.display();
                flag = true;
            }
        }
        if(!flag){
            System.out.print("Employee doesn't exist...!!");
        }
        mainMenu(menu, positions, typeEmployment, attributes);
    }
    //function to search an employee according to their name , position and salary
    public void searchEmployee(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        System.out.println("Enter on which basis you want to search : ");
        System.out.println("1. Name \n 2. Position \n 3. Salary");
        int choice = obj.nextInt();
        switch (choice){
            case 1:
                searchByName(menu, positions, typeEmployment, attributes);
                break;
            case 2:
                searchByPos(menu, positions, typeEmployment, attributes);
                break;
            case 3:
                System.out.print("Enter the salary range : ");
                searchSalRange(menu, positions, typeEmployment, attributes);
                break;
            default:
                System.out.print("Invalid Input...!!");
                searchEmployee(menu, positions, typeEmployment, attributes);
        }
        mainMenu(menu, positions, typeEmployment, attributes);
    }

    //function to update employee information
    public void updateEmployee(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        System.out.print("Enter employee id of the employee you want to update : ");
        int id = obj.nextInt();
        if(!Employees.containsKey(id)){
            System.out.println("Employee doesn't exist...!!");
            updateEmployee(menu, positions, typeEmployment,attributes);
        }
        Employee emp = Employees.get(id);
        System.out.println("What you want to update : ");
        for(int i = 0; i < attributes.size(); i++){
            System.out.println((i+1) + ". " + attributes.get(i));
        }
        int choice = obj.nextInt();
        switch (choice){
            case 1:
                System.out.print("Enter new Employee ID : ");
                int updateID = obj.nextInt();
                if(Employees.containsKey(updateID)){
                    System.out.println("Another employee has the same id...!!");
                    updateEmployee(menu, positions, typeEmployment, attributes);
                }
                else{
                    emp.employeeID = updateID;
                    Employees.remove(id);
                    Employees.put(updateID, emp);
                    System.out.println("Employee ID updated successfully...!!");
                }
                break;
            case 2:
                System.out.print("Enter the new name : ");
                String newName = obj.nextLine();
                emp.employeeName = newName;
                System.out.println("Employee Name updated successfully...!!");
                break;
            case 3:
                System.out.println("Enter new position : ");
                System.out.println("Choose from : ");
                for(int i = 0; i < positions.size(); i++){
                    System.out.println((i+1) + ". " + positions.get(i));
                }
                int pos = obj.nextInt();
                emp.position = positions.get(pos - 1);
                System.out.println("Employee position updated successfully...!!");
                break;
            case 4:
                System.out.println("Enter new Employment Type : ");
                System.out.println("Choose from : ");
                for(int i = 0; i < typeEmployment.size(); i++){
                    System.out.println((i+1) + ". " + typeEmployment.get(i));
                }
                int type = obj.nextInt();
                if(type >= typeEmployment.size()){
                    System.out.println("Invalid Input...!!");
                    updateEmployee(menu, positions, typeEmployment, attributes);
                }
                emp.position = positions.get(type - 1);
                System.out.println("Employee's employment type updated successfully...!!");
                break;
            case 5:
                System.out.print("Enter new salary of the employee : ");
                double sal = obj.nextDouble();
                emp.salary = sal;
                System.out.println("Employee's salary type updated successfully...!!");
                break;
            case 6:
                System.out.print("Enter new time worked of the employee : ");
                double months = obj.nextDouble();
                emp.salary = months;
                System.out.println("Employee's months type updated successfully...!!");
                break;
            default:
                System.out.println("Invalid Input...!!!");
                updateEmployee(menu, positions, typeEmployment, attributes);
                break;
        }
        mainMenu(menu, positions, typeEmployment, attributes);
    }
    public void mainMenu(ArrayList<String> menu, ArrayList<String> positions, ArrayList<String> typeEmployment, ArrayList<String> attributes){
        System.out.println("Main Menu");
        System.out.println("Enter your choice : ");
        for(int i = 0; i < menu.size(); i++){
            System.out.println((i+1) + ". " + menu.get(i));
        }
        int choice = obj.nextInt();
        switch (choice){
            case 1:
                addEmployee(menu, positions, typeEmployment, attributes);
                break;
            case 2:
                removeEmployee(menu, positions, typeEmployment, attributes);
                break;
            case 3:
                displayEmployee(menu, positions, typeEmployment, attributes);
                break;
            case 4:
                displayAllEmployees(menu, positions, typeEmployment, attributes);
                break;
            case 5:
                calTotalSalAll(menu, positions, typeEmployment, attributes);
                break;
            case 6:
                sortDescSalary(menu, positions, typeEmployment, attributes);
                break;
            case 7:
                searchEmployee(menu, positions, typeEmployment, attributes);
                break;
            case 8:
                updateEmployee(menu, positions, typeEmployment, attributes);
                break;
            default:
                System.out.println("Invalid Input....!!");
                mainMenu(menu, positions, typeEmployment, attributes);
                break;
        }
    }
    public static void main(String[] args) {
        ArrayList<String> Positions = new ArrayList<>();
        Positions.add("Senior Manager");
        Positions.add("Manager");
        Positions.add("HR Manager");
        Positions.add("Mern Developer");
        Positions.add("Java Developer");
        Positions.add("ML Developer");
        Positions.add("Android Developer");
        ArrayList<String> Type = new ArrayList<>();
        Type.add("Full-Time");
        Type.add("Intern");
        ArrayList<String> employeeAttributes = new ArrayList<>();
        employeeAttributes.add("EmployeeID");
        employeeAttributes.add("Employee Name");
        employeeAttributes.add("Position");
        employeeAttributes.add("Employment Type");
        employeeAttributes.add("Salary");
        employeeAttributes.add("Work Time");
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Add Employees");
        menu.add("Remove An Employee");
        menu.add("Display Info of An Employee");
        menu.add("Display details of all Employees");
        menu.add("Calculate total Salary");
        menu.add("Sort employees by salary");
        menu.add("Search employee");
        menu.add("Update employee information");

        //object of employeeManagement
        employManagement object = new employManagement();

        System.out.println("Welcome...!!");
        object.mainMenu(menu, Positions, Type, employeeAttributes);
    }
}
package Feb21.CSV;
import java.io.*;
import java.util.*;
public class ReadCSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter file name you want to read (csv) : ");
            String Name = sc.next();

            List<Employee> employees;
            employees = fileReader(Name);
            if (employees != null) {
                int size = employees.size();
                int sum = 0;
                for (Employee employee : employees) {
                    sum = (int) (sum + employee.getSALARY());
                }
                double average=((double) sum /size);
                System.out.println("Average Salary is : " +average);
                System.out.println("Enter threshold salary on basis of which new file will be Created :");
                double salary= sc.nextDouble();
                createFile(employees,salary,sc);
            }
        }

        catch(InputMismatchException e){
            System.out.println("Invalid Input");
        }
    }


    static  List<Employee>fileReader(String FName)
    {
        File file=new File(FName);
        if(file.exists()) {
            List<Employee> employees = new ArrayList<>();
            try (BufferedReader bf = new BufferedReader(new FileReader("employees.csv"))) {
                String line;
                bf.readLine();
                // Read each line from the CSV file
                while ((line = bf.readLine()) != null) {
                    String[] data = line.split(","); // Split the line by comma (CSV format)
                    // Assuming the CSV structure is: name, age, salary
                    int id = Integer.parseInt(data[0]);
                    String Name = (data[1]);
                    String lName = (data[2]);
                    double salary = Double.parseDouble(data[7]);
                    employees.add(new Employee(id, Name, lName, salary));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return employees;
        }
        else
            System.out.println("File Does Not Exist");
        return null;
    }
    static void createFile(List<Employee>employees,double salary,Scanner sc)
    {
        System.out.println("Enter new file Name : ");
        String Name =sc.next();
        File fo=new File(Name);
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(Name))) {
            bf.write("First Name,Last Name,Salary");
            bf.newLine();
            for (Employee employee : employees) {
                if (employee.getSALARY() > salary) {
                    bf.write(employee.getFIRST_NAME() + "," + employee.getLAST_NAME() + "," + employee.getSALARY());
                    bf.newLine();
                }
            }
            System.out.println("File Created Successfully :\nFile Name : "+Name);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

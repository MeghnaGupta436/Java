package Feb20;
import java.io.*;
import java.util.*;
public class FileSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                // Display menu options
                System.out.println("1: Create A new File");
                System.out.println("2: Display the content of the File");
                System.out.println("3: Operation (sort Employee according to Salary)");
                System.out.println("Enter Your Choice");
                int choice = sc.nextInt();
                if (choice > 4)
                    throw new InputMismatchException(); // Throw exception for invalid choice
                switch (choice) {
                    case 1:
                        CreateFile(sc); // Create a new file
                        break;
                    case 2:
                        Readfile(sc); // Display content of the file
                        break;
                    case 3:
                        System.out.println("Enter File Name");
                        String Name = sc.next();
                        operation(Name); // Perform operation (sort Employee according to Salary)
                        break;
                    case 4:
                        System.out.println("Exiting the System");
                        System.exit(0); // Exit the system
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
            }

        }
    }

    // Function to create a new file
    static void CreateFile( Scanner sc) {
        HashMap<String, Integer> Employee = new HashMap<>();
        System.out.println("Enter The File Name (with Extension)  : ");
        String FName = sc.next();
        System.out.println("Enter total no of Employee  : ");
        int no = sc.nextInt();
        System.out.println("Enter Employee Details : ");
        for (int i = 0; i < no; i++) {
            System.out.println("Enter the Name of " + (i + 1) + " Employee : ");
            String Name = sc.next();
            System.out.println("Enter Salary " + (i + 1) + " Employee : ");
            int id = sc.nextInt();
            Employee.put(Name, id);
        }
        serializeHashMapToFile(Employee,FName); // Serialize data and write to file
    }

    // Function to read file content
    static void Readfile(Scanner sc) {
        System.out.println("Enter The File Name");
        String FName = sc.next();
        File file = new File(FName);
        if (file.exists()) {
            if(file.length()==0) {
                System.out.println("File is Empty");
                return;
            }
            HashMap<String, Integer> deserializedHashMap = deserializeHashMapFromFile(FName); // Deserialize data from file
            System.out.println(deserializedHashMap);
        } else
            System.out.println("File Does not exist");
    }

    // Function to perform operation (sort Employee according to Salary)
    static void operation(String Name) {
        File file = new File(Name);
        HashMap<String,Integer>student=new HashMap<>();
        if (file.exists()) {
            HashMap<String, Integer> deserializedHashMap = deserializeHashMapFromFile(Name);
            Map<String, Integer> sortedHashMap = sortHashMapByValueDescending(deserializedHashMap);
            System.out.println(sortedHashMap);
        } else
            System.out.println("File does not exist");
    }

    // Function to serialize HashMap to file
    public static void serializeHashMapToFile(HashMap<String, Integer> hashMap, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(hashMap);
            System.out.println("HashMap serialized to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error serializing HashMap: " + e.getMessage());
        }
    }

    // Function to deserialize HashMap from file
    public static HashMap<String, Integer> deserializeHashMapFromFile(String filePath) {
        HashMap<String, Integer> hashMap = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            hashMap = (HashMap<String, Integer>) ois.readObject();
            System.out.println("HashMap deserialized from file: " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing HashMap: " + e.getMessage());
        }
        return hashMap;
    }

    // Function to sort HashMap by value (salary) in descending order
    public static HashMap<String, Integer> sortHashMapByValueDescending(HashMap<String, Integer> hashMap) {
        List<HashMap.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entryList, (entry1, entry2) -> {
            // Sort by value in reverse order (decreasing order)
            return entry2.getValue().compareTo(entry1.getValue());
        });

        HashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}



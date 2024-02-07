package Feb7;
import java.lang.reflect.Array;
import java.util.*;

    public class GroupAnagrams {

        static ArrayList<ArrayList<String>> group(String[] stringArray) {
            //ans array to store the result
            ArrayList<ArrayList<String>> ans = new ArrayList<>();
            //map to store possible solutions
            Map<String, ArrayList<String>> mp = new HashMap<>();

            //iterate over the string
            for (String it : stringArray) {
                String str = it; // temporary str variable to store the original string
                char temp[] = it.toCharArray();
                Arrays.sort(temp);
                String s = new String(temp); // sorted string

                //mapping the original string into the
                // map according to sorted string
                if (mp.containsKey(s)) {
                    ArrayList<String> t = new ArrayList<>(mp.get(s));
                    t.add(str);
                    mp.put(s, t);
                } else {
                    ArrayList<String> t = new ArrayList<>();
                    t.add(str);
                    mp.put(s, t);
                }
            }
            //edge case when empty array is passed
            if (mp.isEmpty()) {
                ArrayList<String> t = new ArrayList<>();
                ans.add(t);
            }
            //iterating the map and updating the ans array accordingly
            for (Map.Entry<String, ArrayList<String>> e : mp.entrySet()) {
                ans.add(e.getValue());
            }
            return ans;
        }

        public static void main(String[] args) {
            //defining an object of scanner
            // class in order to take input from user
            Scanner obj = new Scanner(System.in);

            Scanner obj1 = new Scanner(System.in);

            System.out.print("Enter the size of the string array : ");
            //taking the value from the user and
            // storing it in size using nextInt() function.
            int size = obj.nextInt();
            String[] stringArray = new String[size];

            System.out.print("Enter array elements : ");
            for (int i = 0; i < size; i++) {
                stringArray[i] = obj1.nextLine();
            }

            ArrayList<ArrayList<String>> ans = group(stringArray);

            System.out.print("[");
            for (ArrayList<String> it : ans) {
                System.out.print("[");
                for (int i = 0; i < it.size(); i++) {
                    System.out.print(it.get(i) + " , ");
                }
                System.out.print("],");
            }
            System.out.print("]");
        }
    }

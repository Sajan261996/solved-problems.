import java.util.Hashtable;
import java.util.Scanner;


class Airlinebording{
    public static void main(String[] args) {
        Hashtable<Integer, String> boardingPass = new Hashtable<Integer, String>();
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of boarding passes
        int size = scanner.nextInt();
        int arr[] = new int[size];
        
        // Read boarding pass numbers
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Check for duplicates
        for (int i : arr) {
            // Check whether the pass already exists in the hash table
            if (boardingPass.containsKey(i)) {
                // Print the duplicate pass number
                System.out.println(i);
                return; // Exit after finding the first duplicate
            } else {
                // Add the pass to the hash table
                boardingPass.put(i, "Checked");
            }
        }
        
        // If no duplicates found
        System.out.println("No duplicates found.");
}
}
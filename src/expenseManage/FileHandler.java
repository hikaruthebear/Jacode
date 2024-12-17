/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expenseManage;

/**
 *
 * @author hikaru
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class FileHandler {   
    // Function to read the file content and return the list of transactions
    public static String getFormattedDate() {
        LocalDate currentDate = LocalDate.now(); // Get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
        return currentDate.format(formatter); // Format the date
    }
    
    public static List<Record> readFile(String filePath) {
        List<Record> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerPassed = false;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                // Skip the header
                if (line.equalsIgnoreCase("time, type, amount, name")) {
                    headerPassed = true;
                }
                // Process transactions
                else if (headerPassed && !line.isEmpty()) {
                    String[] parts = line.split(",\\s*");
                    if (parts.length == 4) {
                        String time = parts[0];
                        String type = parts[1];
                        double amount = Double.parseDouble(parts[2]);
                        String name = parts[3];
                        transactions.add(new Record(time, type, amount, name));
                    }
                }
            }

            System.out.println("Transactions:");
            for (Record r : transactions) {
                System.out.println(r);
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return transactions;
    }

    // Function to clear and write data back to the file
    public static void writeFile(String filePath, List<Record> transactions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            // Write header
            writer.write("time, type, amount, name");
            writer.newLine();

            // Write transactions
            for (Record r : transactions) {
                writer.write(r.toString());
                writer.newLine();
            }

            System.out.println("File has been successfully updated!");

        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "Record/" + getFormattedDate() + ".txt";

        // Step 1: Read existing file data
        List<Record> transactions = readFile(filePath);

        // Example: Modify the transaction list (add a new record)
        transactions.add(new Record("18:30", "income", 600.0, "bonus"));

        // Step 2: Clear and write updated data back to the file
        writeFile(filePath, transactions);
    }
}

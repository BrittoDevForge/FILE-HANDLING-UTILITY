import java.io.*;
import java.util.Scanner;

public class FileOperations {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String filePath = "example.txt";

        while (true) {
            System.out.println("\n--- File Operations ---");
            System.out.println("1. Read File");
            System.out.println("2. Write to File");
            System.out.println("3. Modify File (Replace Content)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    readFile(filePath);
                    break;
                case 2:
                    writeFile(filePath);
                    break;
                case 3:
                    modifyFile(filePath);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("\n--- File Content ---");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("--------------------");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void writeFile(String filePath) {
        System.out.print("Enter text to write (appends to file): ");
        String text = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(text);
            writer.newLine();
            System.out.println("Text written to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void modifyFile(String filePath) {
        System.out.print("Enter new content (will replace old content): ");
        String newText = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(newText);
            writer.newLine();
            System.out.println("File content replaced.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}

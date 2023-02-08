import java.util.Scanner;

public class Lab2 {
  static String[] names = new String[1024];
  static int nameCount = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("\nMenu");
      System.out.println("1. Enter a name");
      System.out.println("2. Search for a name");
      System.out.println("3. Remove a name");
      System.out.println("4. Show all names");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Enter a name: ");
          names[nameCount] = scanner.nextLine();
          nameCount += 1;
          System.out.println("Name added successfully");
          break;
        case 2:
          System.out.print("Enter a name to search: ");
          String searchName = scanner.nextLine();

          boolean c_name = false; // checking if the name to search is present
          int index = -1;
          for (int i = 0; i < nameCount; i++) {
            if (names[i].equals(searchName)) {
              c_name = true;
              index = i;
              break;
            }
          }

          if (c_name) {
            System.out.println("Name found at index: " + index);
          } else {
            System.out.println("Name not found");
          }
          break;
        case 3:
          System.out.print("Enter a name to remove: ");
          String removeName = scanner.nextLine();

          c_name = false;   // checking if the name to remove is present
          index = -1;
          for (int i = 0; i < nameCount; i++) {
            if (names[i].equals(removeName)) {
              c_name = true;
              index = i;
              break;
            }
          }

          if (c_name) {
            for (int i = index; i < nameCount - 1; i++) {
              names[i] = names[i + 1];
            }
            nameCount--;
            System.out.println("Name removed successfully");
          } else {
            System.out.println("Name not found");
          }
          break;
        case 4:
          if (nameCount == 0) {
            System.out.println("No names to show");
          } else {
            System.out.println("All names: ");
            for (int i = 0; i < nameCount; i++) {
              System.out.println(names[i]);
            }
          }
          break;
        case 5:
          System.out.println("Exiting program");
          break;
        default:
          System.out.println("Invalid choice. Try again");
        }
      } while (choice != 5);
    }
  }

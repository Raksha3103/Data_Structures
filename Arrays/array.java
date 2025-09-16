import java.util.Scanner;

 class ArrayOperations {
    static int[] arr;
    static int size = 0;     // current number of elements
    static int capacity;     // max size of the array

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter capacity of array: ");
        capacity = scanner.nextInt();
        arr = new int[capacity];

        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int element = scanner.nextInt();
                    insert(element);
                    break;
                case 2:
                    System.out.print("Enter element to delete: ");
                    int delElement = scanner.nextInt();
                    delete(delElement);
                    break;
                case 3:
                    System.out.print("Enter element to search: ");
                    int searchElement = scanner.nextInt();
                    int index = search(searchElement);
                    if (index == -1) {
                        System.out.println("Element not found.");
                    } else {
                        System.out.println("Element found at index: " + index);
                    }
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Insert element at the end
    public static void insert(int element) {
        if (size == capacity) {
            System.out.println("Array is full. Cannot insert.");
            return;
        }
        arr[size++] = element;
        System.out.println(element + " inserted.");
    }

    // Delete first occurrence of element
    public static void delete(int element) {
        int index = search(element);
        if (index == -1) {
            System.out.println("Element not found. Cannot delete.");
            return;
        }
        // Shift elements left to overwrite the deleted element
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        System.out.println(element + " deleted.");
    }

    // Search for element and return index, else -1
    public static int search(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    // Display current elements
    public static void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private static ArrayList<String> pendingTasks = new ArrayList<>();
    private static ArrayList<String> completedTasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Show Pending Tasks");
            System.out.println("5. Show Completed Tasks");
            System.out.println("6. Task Summary");
            System.out.println("7. Log Out");
            System.out.print("Select any option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    showPendingTasks();
                    break;
                case 5:
                    showCompletedTasks();
                    break;
                case 6:
                    showTaskSummary();
                    break;
                case 7:
                    System.out.println("Logging out... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String task = scanner.nextLine();
        pendingTasks.add(task);
        System.out.println(" Task added successfully!");
    }

    private static void removeTask() {
        if (pendingTasks.isEmpty()) {
            System.out.println("❌ No tasks to remove.");
            return;
        }

        System.out.println("\nPending Tasks:");
        for (int i = 0; i < pendingTasks.size(); i++) {
            System.out.println((i + 1) + ". " + pendingTasks.get(i));
        }

        System.out.print("Enter task number to remove: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (taskIndex > 0 && taskIndex <= pendingTasks.size()) {
            System.out.println(" Removed: " + pendingTasks.remove(taskIndex - 1));
        } else {
            System.out.println(" Invalid task number.");
        }
    }

    private static void completeTask() {
        if (pendingTasks.isEmpty()) {
            System.out.println(" No pending tasks to complete.");
            return;
        }

        System.out.println("\nPending Tasks:");
        for (int i = 0; i < pendingTasks.size(); i++) {
            System.out.println((i + 1) + ". " + pendingTasks.get(i));
        }

        System.out.print("Enter task number to mark as completed: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (taskIndex > 0 && taskIndex <= pendingTasks.size()) {
            String completedTask = pendingTasks.remove(taskIndex - 1);
            completedTasks.add(completedTask);
            System.out.println(" Task marked as completed: " + completedTask);
        } else {
            System.out.println(" Invalid task number.");
        }
    }

    private static void showPendingTasks() {
        if (pendingTasks.isEmpty()) {
            System.out.println(" No pending tasks!");
        } else {
            System.out.println("\n Pending Tasks:");
            for (String task : pendingTasks) {
                System.out.println("- " + task);
            }
        }
    }

    private static void showCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println(" No completed tasks.");
        } else {
            System.out.println("\n Completed Tasks:");
            for (String task : completedTasks) {
                System.out.println("- " + task);
            }
        }
    }

    private static void showTaskSummary() {
        System.out.println("\nTask Summary:");
        System.out.println("Pending Tasks: " + pendingTasks.size());
        System.out.println("Completed Tasks: " + completedTasks.size());
    }
}

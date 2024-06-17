import java.util.Scanner;

public class Main {
    private static final ToDoList toDoList = new ToDoList();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        toDoList.addTask(description);
        System.out.println("Task added.");
    }

    private static void viewTasks() {
        System.out.println("\nTasks:");
        List<Task> tasks = toDoList.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void completeTask() {
        System.out.print("Enter task number to complete: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());
        toDoList.completeTask(taskNumber - 1);
        System.out.println("Task marked as complete.");
    }

    private static void deleteTask() {
        System.out.print("Enter task number to delete: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());
        toDoList.deleteTask(taskNumber - 1);
        System.out.println("Task deleted.");
    }
}

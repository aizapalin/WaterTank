import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        WaterTank tank = null;
        while (tank == null) {
            System.out.print("Enter water tank capacity (liters): ");
            try {
                double capacity = console.nextDouble();
                tank = new WaterTank(capacity);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try using numbers.");
                console.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean systemRun = true;
        while (systemRun) {
            System.out.println("\n === Water Tank ===");
            System.out.println("1. Fill tank");
            System.out.println("2. Drain Tank");
            System.out.println("3. Check current water level");
            System.out.println("4. Check if tank is Full");
            System.out.println("5. Check if tank is Empty");
            System.out.println("6. Display Tank Visualization");
            System.out.println("7. Exit");
            int choice = -1;
            
            try {
                System.out.print("Enter your choice (1 to 7): ");
                choice = console.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please enter a number.");
                console.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter liters to add: ");
                        double add = console.nextDouble();
                        tank.fill(add);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a number.");
                        console.nextLine();
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Enter liters to drain: ");
                        double drainWater = console.nextDouble();
                        tank.drain(drainWater);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a number.");
                        console.nextLine();
                    }
                    break;

                case 3:
                    System.out.println("Current water level: " + tank.getCurrentLevel());
                    break;

                case 4:
                        if (tank.isFull()) {
                        System.out.println("Tank is Full");
                        tank.displayTank();
                    } else {
                        System.out.println("The tank is not full, current water level: " + tank.getCurrentLevel());
                        tank.displayTank();
                    }
                    break;
                    

                case 5:
                    if (tank.isEmpty()) {
                        System.out.println("Tank is currently Empty.");
                        tank.displayTank();
                    } else {
                        System.out.println("Tank is still at: " + tank.getCurrentLevel() + " liters and not empty.");
                        tank.displayTank();
                    }
                    break;

                case 6:
                    tank.displayTank();
                    break;

                case 7:
                    System.out.println("babye :(");
                    systemRun = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1–7.");
            }
        }
    }
}

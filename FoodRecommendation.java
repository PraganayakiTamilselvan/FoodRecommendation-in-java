import java.util.*;

public class FoodRecommendation {

    static class Food {
        String name;
        String category;

        Food(String name, String category) {
            this.name = name;
            this.category = category;
        }

        @Override
        public String toString() {
            return name + " (" + category + ")";
        }
    }

    private List<Food> foods = new ArrayList<>();

    // Add a food item
    void addFood(Food food) {
        foods.add(food);
    }

    // Get recommendations based on category
    void getRecommendations(String category) {
        boolean found = false;
        for (Food food : foods) {
            if (food.category.equalsIgnoreCase(category)) {
                System.out.println(food);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No recommendations found for category: " + category);
        }
    }

    public static void main(String[] args) {
        FoodRecommendationSystem system = new FoodRecommendationSystem();
        Scanner scanner = new Scanner(System.in);

        // Adding some food items
        system.addFood(new Food("Pancakes", "breakfast"));
        system.addFood(new Food("Burger", "lunch"));
        system.addFood(new Food("Pizza", "dinner"));
        system.addFood(new Food("Smoothie", "breakfast"));
        system.addFood(new Food("Sushi", "lunch"));

        while (true) {
            System.out.println("\n1. Get Food Recommendations");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter category (breakfast, lunch, dinner): ");
                String category = scanner.nextLine();
                system.getRecommendations(category);
            } else if (choice == 2) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

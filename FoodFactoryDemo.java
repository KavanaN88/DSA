
import java.util.*;

interface Food {
    String getType();
}

class Pizza implements Food {

    public String getType() {
        return "Someone ordered Fast Food!";
    }
}

class Cake implements Food {

    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {

    public Food getFood(String order) {

        if (order.equalsIgnoreCase("pizza")) {
            return new Pizza();
        }
        else if (order.equalsIgnoreCase("cake")) {
            return new Cake();
        }

        return null;
    }
}

public class FoodFactoryDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String order = sc.nextLine();

        FoodFactory factory = new FoodFactory();

        Food food = factory.getFood(order);

        System.out.println("The factory returned class "
                + food.getClass().getName());

        System.out.println(food.getType());

        sc.close();
    }
}

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class SliceOHeaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public String storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public double pizzaPrice;
    public String sides;
    public String drinks;
    private String orderID;
    private double orderTotal;
    public static final String DEF_ORDER_ID = "DEF-SOH-099";
    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public static final double DEF_ORDER_TOTAL = 15.00;

    public SliceOHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    public SliceOHeaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String[] ingredients = scanner.nextLine().split(" ");
        String ing1 = ingredients[0];
        String ing2 = ingredients[1];
        String ing3 = ingredients[2];

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSize = scanner.nextLine();

        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.nextLine();

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String sideDish = scanner.nextLine();

        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        String drinks = scanner.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.nextLine();

        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }
    }
    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your birthday (format: yyyy-MM-dd):");
        String birthdateStr = scanner.nextLine();
        LocalDate birthdate = LocalDate.parse(birthdateStr);

        LocalDate now = LocalDate.now();
        Period period = Period.between(birthdate, now);
        int age = period.getYears();

        if (age < 18 && birthdate.getDayOfYear() == now.getDayOfYear()) {
            System.out.println("Congratulations! You pay only half the price for your order");
        } else {
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
        }
    }
    public void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your card number:");
        long cardNumber = scanner.nextLong();

        System.out.println("Please enter the card's expiry date (format: yyyy-MM):");
        String expiryDate = scanner.next();

        System.out.println("Please enter the card's cvv number:");
        int cvv = scanner.nextInt();

        processCardPayment(cardNumber, expiryDate, cvv);
    }
    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        String cardNumberStr = Long.toString(cardNumber);
        int cardLength = cardNumberStr.length();
        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
            return;
        }

        int firstCardDigit = Integer.parseInt(cardNumberStr.substring(0, 1));

        long blacklistedNumber = 12345678901234L; 
        if (cardNumber == blacklistedNumber) {
            System.out.println("Card is blacklisted. Please use another card");
            return;
        }

        int lastFourDigits = Integer.parseInt(cardNumberStr.substring(cardNumberStr.length() - 4));

        String cardNumberToDisplay = cardNumberStr.charAt(0) +
                cardNumberStr.substring(1, cardNumberStr.length() - 4).replaceAll(".", "*") +
                cardNumberStr.substring(cardNumberStr.length() - 4);
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        StringBuilder specialInfo = new StringBuilder();
        specialInfo.append("pizzaOfTheDay ").append(pizzaOfTheDay)
              .append("sideOfTheDay ").append(sideOfTheDay)
              .append("specialPrice ").append(specialPrice);
        System.out.println(specialInfo.toString());
    }
    public void printReceipt() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Sides: " + sides);
        System.out.println("Drinks: " + drinks);
        System.out.println("Order Total: " + orderTotal);
    }
}

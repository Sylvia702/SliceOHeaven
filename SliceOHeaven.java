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
    public static final long BLACKLISTED_NUMBER = 12345678901234L; 

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
        int ingChoice1, ingChoice2, ingChoice3;
        String ing1, ing2, ing3;
        int sizeChoice;
        String pizzaSize;
        String extraCheese;
        int sideDishChoice;
        String sideDish;
        int drinkChoice;
        String drinks;
        String wantDiscount;
        do {
            System.out.println("Please pick any three of the following ingredients:");
            System.out.println("1. Mushroom");
            System.out.println("2. Paprika");
            System.out.println("3. Sun-dried tomatoes");
            System.out.println("4. Chicken");
            System.out.println("5. Pineapple");
            System.out.println("Enter any three choices (1, 2, 3,...) separated by spaces:");
            ingChoice1 = scanner.nextInt();
            ingChoice2 = scanner.nextInt();
            ingChoice3 = scanner.nextInt();
            scanner.nextLine(); 

            if (ingChoice1 < 1 || ingChoice1 > 5 || ingChoice2 < 1 || ingChoice2 > 5 || ingChoice3 < 1 || ingChoice3 > 5) {
                System.out.println("Invalid choice(s). Please pick only from the given list:");
            }
        } while (ingChoice1 < 1 || ingChoice1 > 5 || ingChoice2 < 1 || ingChoice2 > 5 || ingChoice3 < 1 || ingChoice3 > 5);

        switch (ingChoice1) {
            case 1: ing1 = "Mushroom";
             break;
            case 2: ing1 = "Paprika";
             break;
            case 3: ing1 = "Sun-dried tomatoes";
             break;
            case 4: ing1 = "Chicken";
             break;
            case 5: ing1 = "Pineapple";
             break;
            default: ing1 = "";
        }
        switch (ingChoice2) {
            case 1: ing2 = "Mushroom";
             break;
            case 2: ing2 = "Paprika";
             break;
            case 3: ing2 = "Sun-dried tomatoes";
             break;
            case 4: ing2 = "Chicken";
             break;
            case 5: ing2 = "Pineapple";
             break;
            default: ing2 = "";
        }
        switch (ingChoice3) {
            case 1: ing3 = "Mushroom";
             break;
            case 2: ing3 = "Paprika";
             break;
            case 3: ing3 = "Sun-dried tomatoes";
             break;
            case 4: ing3 = "Chicken";
             break;
            case 5: ing3 = "Pineapple";
             break;
            default: ing3 = "";
        }
        do {
            System.out.println("What size should your pizza be?");
            System.out.println("1. Large");
            System.out.println("2. Medium");
            System.out.println("3. Small");
            System.out.println("Enter only one choice (1, 2, or 3):");
            sizeChoice = scanner.nextInt();
            scanner.nextLine(); 

            if (sizeChoice < 1 || sizeChoice > 3) {
                System.out.println("Invalid choice. Please pick only from the given list:");
            }
        } while (sizeChoice < 1 || sizeChoice > 3);

        switch (sizeChoice) {
            case 1: pizzaSize = "Large";
             break;
            case 2: pizzaSize = "Medium";
             break;
            case 3: pizzaSize = "Small";
             break;
            default: pizzaSize = "";
        }
        System.out.println("Do you want extra cheese (Y/N):");
        extraCheese = scanner.nextLine();
        do {
            System.out.println("Following are the side dish that go well with your pizza:");
            System.out.println("1. Calzone");
            System.out.println("2. Garlic bread");
            System.out.println("3. Chicken puff");
            System.out.println("4. Muffin");
            System.out.println("5. Nothing for me");
            System.out.println("What would you like? Pick one (1, 2, 3,...):");
            sideDishChoice = scanner.nextInt();
            scanner.nextLine(); 

            if (sideDishChoice < 1 || sideDishChoice > 5) {
                System.out.println("Invalid choice. Please pick only from the given list:");
            }
        } while (sideDishChoice < 1 || sideDishChoice > 5);

        switch (sideDishChoice) {
            case 1: sideDish = "Calzone";
             break;
            case 2: sideDish = "Garlic bread";
             break;
            case 3: sideDish = "Chicken puff";
             break;
            case 4: sideDish = "Muffin";
             break;
            case 5: sideDish = "Nothing for me";
             break;
            default: sideDish = "";
        }
        do {
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
            System.out.println("1. Coca Cola");
            System.out.println("2. Cold coffee");
            System.out.println("3. Cocoa Drink");
            System.out.println("4. No drinks for me");
            System.out.println("Enter your choice:");
            drinkChoice = scanner.nextInt();
            scanner.nextLine();

            if (drinkChoice < 1 || drinkChoice > 4) {
                System.out.println("Invalid choice. Please pick only from the given list:");
            }
        } while (drinkChoice < 1 || drinkChoice > 4);

        switch (drinkChoice) {
            case 1: drinks = "Coca Cola";
             break;
            case 2: drinks = "Cold coffee";
             break;
            case 3: drinks = "Cocoa Drink";
             break;
            case 4: drinks = "No drinks for me";
             break;
            default: drinks = "";
        }

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        wantDiscount = scanner.nextLine();

        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }
    }

    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        LocalDate now = LocalDate.now();
        LocalDate fiveYearsAgo = now.minusYears(5);
        LocalDate oneTwentyYearsAgo = now.minusYears(120);

        String birthdateStr;
        LocalDate birthdate;

        do {
            System.out.println("Please enter your birthday (format: yyyy-MM-dd):");
            birthdateStr = scanner.nextLine();
            try {
                birthdate = LocalDate.parse(birthdateStr);
                if (birthdate.isAfter(now.minusYears(5)) || birthdate.isBefore(now.minusYears(120))) {
                    System.out.println("Invalid date. You are either too young or too dead to order.");
                    System.out.println("Please enter a valid date:");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter a valid date:");
            }
        } while (true);

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
        LocalDate now = LocalDate.now();
        long cardNumber;
        String expiryDate;
        int cvv;

        do {
            System.out.println("Please enter your card number:");
            cardNumber = scanner.nextLong();
            scanner.nextLine(); 
        } while (!isValidCardNumber(cardNumber));

        do {
            System.out.println("Please enter the card's expiry date (format: yyyy-MM):");
            expiryDate = scanner.next();
            scanner.nextLine(); 
            try {
                LocalDate expDate = LocalDate.parse(expiryDate + "-01");
                if (expDate.isBefore(now)) {
                    System.out.println("Invalid date. The expiry date must be in the future.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter a valid date:");
            }
        } while (true);

        System.out.println("Please enter the card's cvv number:");
        cvv = scanner.nextInt();

        processCardPayment(cardNumber, expiryDate, cvv);
    }

    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        String cardNumberStr = Long.toString(cardNumber);
        while (cardNumberStr.length() != 14 || cardNumber == BLACKLISTED_NUMBER) {
            System.out.println("Invalid card number. Please enter a 14-digit card number that is not blacklisted:");
            Scanner scanner = new Scanner(System.in);
            cardNumber = scanner.nextLong();
            cardNumberStr = Long.toString(cardNumber);
        }

        System.out.println("Card accepted");

        int firstCardDigit = Integer.parseInt(cardNumberStr.substring(0, 1));
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

    @Override
    public String toString() {
        return "Order ID: " + orderID + "\n" +
                "Pizza Ingredients: " + pizzaIngredients + "\n" +
                "Sides: " + sides + "\n" +
                "Drinks: " + drinks + "\n" +
                "Order Total: " + orderTotal;
    }

    private boolean isValidCardNumber(long cardNumber) {
        String cardNumberStr = Long.toString(cardNumber);
        return cardNumberStr.length() == 14 && cardNumber != BLACKLISTED_NUMBER;
    }

    public static void main(String[] args) {
        SliceOHeaven pizzaShop = new SliceOHeaven();
        pizzaShop.takeOrder();
        System.out.println(pizzaShop);
    }
}

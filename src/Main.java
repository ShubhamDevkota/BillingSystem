import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String validID = "User";
        String validPassword = "password";
        String validDiscount = "Dis20";
        System.out.println("Type quit to exit else press any key and enter");
        String close = in.nextLine();
        while(!close.equals("quit")) {
            if (close.equalsIgnoreCase("quit")) {
                break;
            }

            boolean loggedIn = false;
            while(!loggedIn) {
                System.out.println("Enter your id ");
                String ID = in.nextLine();
                if (ID.equalsIgnoreCase("quit")) {
                    return;
                }
                System.out.println("Enter your password");
                String password = in.nextLine();
                if (ID.equalsIgnoreCase("quit")) {
                    return;
                }


                if(ID.equals(validID) && password.equals(validPassword)) {
                    System.out.println("You have successfully logged in");
                    System.out.println("Press Enter to continue ");

                    loggedIn = true;


                }
                else {
                    System.out.println("Enter correct id password");
                }
            }
            close = in.nextLine();
            while(!close.equals("quit")) {
                ArrayList<Double> itemPrices = new ArrayList<>();

                System.out.println("Enter the number of items: ");
                String numItemsStr = in.nextLine();
                if (numItemsStr.equalsIgnoreCase("quit")) {
                    return;
                }
                int numItems = Integer.parseInt(numItemsStr);


                for (int i = 0; i < numItems; i++) {
                    System.out.println("Enter the price of item " + (i + 1) + ": ");
                    String priceStr = in.nextLine();
                    if (priceStr.equalsIgnoreCase("quit")) {
                        return;
                    }
                    double price = Double.parseDouble(priceStr);

                    itemPrices.add(price);
                }

                double totalCost = 0;
                for (double price : itemPrices) {
                    totalCost += price;


                }
                System.out.println("Do you want to add vat? Type 'true' for yes and 'false' for no'");
                String addVatStr = in.nextLine();
                in.nextLine();
                if (addVatStr.equalsIgnoreCase("quit")) {
                    return;
                }
                boolean addVat = Boolean.parseBoolean(addVatStr);


                if (addVat) {
                    totalCost = totalCost + totalCost * 13 / 100;
                }


                System.out.println("Enter if you have a discount coupon else press any key and enter");
                String dis = in.nextLine();
                if (dis.equalsIgnoreCase("quit")) {
                    return;
                }
                if (dis.equals(validDiscount)) {
                    totalCost = totalCost - 20 / 100 * totalCost;
                    System.out.println("Your total cost is " + totalCost);


                } else {
                    System.out.println("Your total cost is " + totalCost);
                }

                boolean enoMon = false;
                double money = 0;
                while (!enoMon) {
                    System.out.println("Give money");
                    money = in.nextInt();
                    if (money >= totalCost) {
                        enoMon = true;
                    } else {
                        System.out.println("Not enuogh");
                    }
                }

                int note = (int) (money - totalCost);
                if (note >= 1000) {
                    int times = note / 1000;
                    System.out.println("1000 *" + times);
                    note = note - (1000 * times);
                }


                if (note >= 500) {
                    int times = note / 500;
                    System.out.println("500 *" + times);
                    note = note - (500 * times);

                }
                if (note >= 100) {
                    int times = note / 100;
                    System.out.println("100 *" + times);
                    note = note - (100 * times);

                }
                if (note >= 50) {
                    int times = note / 50;
                    System.out.println("50 *" + times);
                    note = note - (50 * times);

                }
                if (note >= 20) {
                    int times = note / 20;
                    System.out.println("20 *" + times);
                    note = note - (20 * times);

                }
                if (note >= 10) {
                    int times = note / 10;
                    System.out.println("10 *" + times);
                    note = note - (10 * times);

                }
                if (note >= 5) {
                    int times = note / 5;
                    System.out.println("5 *" + times);
                    note = note - (5 * times);

                }

                close = "quit";


            }


        }


    }
}
import java.util.Scanner;


public class App {


    static final String RESET = "\u001B[0m"; // Reset color
    static final String RED = "\u001B[31m"; // Red text
    static final String BLUE = "\u001B[34m"; // Blue text


    static Menu[] menuArr = {
        new Menu("Double-Double Burger", 4, new String[]{"2 Beef Patties", "2 slices of Cheese", "Lettuce", "Tomatoes", "Onions", "Buns"}, new String[]{"burger", "big"}),
        new Menu("Cheeseburger", 3, new String[]{"Beef Patty", "Cheese", "Lettuce", "Tomato", "Onions", "Buns"}, new String[]{"burger"}),
        new Menu("Hamburger", 3, new String[]{"Beef Patty", "Lettuce", "Tomato", "Onions", "Buns"}, new String[]{"burger"}),
        new Menu("French Fries", 2, new String[]{"Potatoes", "Salt"}, new String[]{"vegetarian", "vegan","fries"}),
        new Menu("Chocolate Milkshake", 3, new String[]{"Milk", "Ice Cream", "Chocolate"}, new String[]{"vegetarian", "milkshake"}),
        new Menu("Strawberry Milkshake", 3, new String[]{"Milk", "Ice Cream", "Strawberry"}, new String[]{"vegetarian", "milkshake"}),
        new Menu("Vanilla Milkshake", 3, new String[]{"Milk", "Ice Cream", "Vanilla"}, new String[]{"vegetarian", "milkshake"}),
    };


    static String[] whichPrice = {
        "What item do you want the price of?",
        "Can you tell me which item you're looking for the price of?",  
        "Which item do you need the price of?"
    };
    static String[] itemPrice = {
        "The price is ",
        "It costs ",
        "We charge "
    };
    static String[] noComprendo = {
        "I'm sorry I didn't understand that. Could you try again?",
        "I'm sorry, I didn't get that. Could you repeat it?",
        "I apologize, I didn't quite understand. Could you please try again?"
    };
    static String[] whatNextP = {
        "What information do you want next?",
        "Anything else you would like to know?",
        "How about some recomendations?",
    };
    static String[] recomendThis = {
        "I think you'd like a ",
        "How about a ",
        "Would you like a "
    };
    static String[] recomendThisPlural = {
        "I think you'd like some ",
        "How about some ",
        "Would you like some "
    };
    static String[] recommendWhat = {
        "Which type of recommendation would you like?",
        "What kind of food would you like?",
        "Is there a specific kind of food that you would like recommended to you?"
    };
    static String[] havePreference = {
        "Do you have a preference for recommendations?",
        "Is there a certain kind of food you would like?",
        "Is there a specific kind of food that you would like recommended to you?"
    };
    static String[] itemIngredients = {
        "The ingredients of a ",
        "The ingredients in a ",
        "The ingredients of a "
    };
    static String[] itemIngredientsPlural = {
        "The ingredients of some ",
        "The ingredients in some ",
        "This is whats in some "
    };
    static String[] whichIngs = {
        "What item do you want the ingredients of?",
        "Can you tell me which item you're looking for the ingredients of?",  
        "Which item do you need the ingredients of?"
    };    
    static String[] whatNextR = {
        "What information do you want next?",
        "Anything else you would like to know?",
        "Would you like to know the ingredients?",
    };
    static String[] whatNextI = {
        "What information do you want next?",
        "Anything else you would like to know?",
        "Would you like to know the price?",
    };
    public static void main(String[] args) throws Exception {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println(RED + "Hello, welcome to In-N-Out. How can I help you?");
        System.out.println("I have all sorts of information about prices, menu items, and can give recommendations.");
        System.out.println("If  you want to exit the conversation or reset , type 'exit'.");
        System.out.println("What do you want information on?" + RESET);


        while (true) {
            System.out.print(BLUE);
            String response1 = scanner1.nextLine().toLowerCase();
            System.out.print(RESET);
            int randInt = (int)(Math.random() * 3);
            if (response1.contains("exit")) {
                System.out.println(RED + "Thank you for visiting! Goodbye!" + RESET);
                break;
            } else if (response1.contains("price") || response1.contains("cost")) {  
                boolean responseNeeded = true;
                for (int i = 0; i < menuArr.length; i++) {
                    if (response1.contains(menuArr[i].getName().toLowerCase())) {
                        responseNeeded = false;
                        randInt = (int)(Math.random() * 3);
                        System.out.println(RED + itemPrice[randInt] + menuArr[i].getPrice() + "$ for a " + menuArr[i].getName() + RESET);
                    } else if (response1.contains("menu") || (response1.contains("all") && response1.contains("item"))) {
                        responseNeeded = false;
                        randInt = (int)(Math.random() * 3);
                        System.out.println(RED + menuArr[i].getName() + " : " + menuArr[i].getPrice() + "$" + RESET);
                    }
                }
                while (responseNeeded) {
                    boolean noErrorP = false;
                    System.out.println(RED + whichPrice[randInt] + RESET);
                    Scanner scannerP2 = new Scanner(System.in);
                    System.out.print(BLUE);
                    String responseP2 = scannerP2.nextLine().toLowerCase();
                    System.out.print(RESET);
                    for (int i = 0; i < menuArr.length; i++) {
                        if (responseP2.contains("exit")) {
                            responseNeeded=false;
                            break;
                        } else if (responseP2.contains(menuArr[i].getName().toLowerCase())) {
                            randInt = (int)(Math.random() * 3);
                            System.out.println(RED + itemPrice[randInt] + menuArr[i].getPrice() + "$ for a " + menuArr[i].getName() + RESET);
                            noErrorP=true;
                            responseNeeded=false;
                            break;
                        }
                    }
                    if(noErrorP==false){
                        randInt = (int)(Math.random() * 3);
                        System.out.println(RED + noComprendo[randInt] + RESET);
                    }
               
            }
               
                randInt = (int)(Math.random() * 3);
                System.out.println(RED + whatNextP[randInt] + RESET);
            } else if (response1.contains("recommendation") || (response1.contains("recom") && response1.contains("dation")) ||
                       ((response1.contains("what") || response1.contains("which")) && (response1.contains("buy") || response1.contains("get") || response1.contains("choose")))) {
                if (isTag(response1)) {
                    respondIsTag(response1);
                } else if (!isTag(response1)) {
                    randInt = (int)(Math.random() * 3);
                    System.out.println(RED + havePreference[randInt] + RESET);
                    Scanner scannerR2 = new Scanner(System.in);
                    System.out.print(BLUE);
                    String responseR2 = scannerR2.nextLine().toLowerCase();
                    System.out.print(RESET);
                    if (responseR2.contains("exit")) {
                        System.out.println(RED + "Thank you for visiting! Goodbye!" + RESET);
                        break;
                    }else if (responseR2.contains("no") || (responseR2.contains("don't") && responseR2.contains("i"))) {
                        randInt = (int)(Math.random() * menuArr.length);
                        Menu menuAns = menuArr[randInt];
                        if (randInt == 4) {
                            randInt = (int)(Math.random() * 3);
                            System.out.println(RED + recomendThisPlural[randInt] + menuAns.getName() + RESET);
                        } else {
                            randInt = (int)(Math.random() * 3);
                            System.out.println(RED + recomendThis[randInt] + menuAns.getName() + RESET);
                        }
                    } else if (isTag(responseR2)) {
                        respondIsTag(responseR2);
                    } else {    
                        randInt = (int)(Math.random() * 3);
                        System.out.println(RED + noComprendo[randInt] + RESET);
                    }
                } else {    
                    randInt = (int)(Math.random() * 3);
                    System.out.println(RED + noComprendo[randInt] + RESET);
                }
                randInt = (int)(Math.random() * 3);
                System.out.println(RED + whatNextR[randInt] + RESET);
            } else if(response1.contains("ingredients")||(response1.contains("ing")&&response1.contains("dients"))
            ||(response1.contains("what")&&response1.contains("is")&&response1.contains("in"))){
                boolean responseNeeded = true;
                for (int i = 0; i < menuArr.length; i++) {
                    if (response1.contains(menuArr[i].getName().toLowerCase())) {
                        responseNeeded = false;
                        randInt = (int)(Math.random() * 3);
                        System.out.println(RED + itemIngredients[randInt] + menuArr[i].getName() +" are :"+ RESET);
                        printIngs(menuArr[i].getIngredients());
                    } else if (response1.contains(menuArr[4].getName().toLowerCase())) {      
                        responseNeeded = false;
                        randInt = (int)(Math.random() * 3);
                        System.out.println(RED + itemIngredientsPlural[randInt] + menuArr[4].getName() +" are :"+ RESET);
                        printIngs(menuArr[4].getIngredients());
                    } else if (response1.contains("menu") || (response1.contains("all") && response1.contains("item"))) {
                        responseNeeded = false;
                        System.out.println(RED + "The prices for the entire menu are:" + RESET);
                        printIngsMenu(menuArr);
                    }    
                }    
                while (responseNeeded) {
                    boolean errorI = true;
                    randInt = (int)(Math.random() * 3);
                    System.out.println(RED + whichIngs[randInt] + RESET);
                    Scanner scannerI2 = new Scanner(System.in);
                    System.out.print(BLUE);
                    String responseI2 = scannerI2.nextLine().toLowerCase();
                    System.out.print(RESET);
                    for (int i = 0; i < menuArr.length; i++) {
                        if (response1.contains("exit")) {
                            System.out.println(RED + "Thank you for visiting! Goodbye!" + RESET);
                            break;
                        } else if (responseI2.contains(menuArr[i].getName().toLowerCase())) {
                            randInt = (int)(Math.random() * 3);
                            System.out.println(RED + itemIngredients[randInt] + menuArr[i].getName() +" are :"+ RESET);
                            printIngs(menuArr[i].getIngredients());
                            errorI=false;
                            responseNeeded=false;
                            break;
                        }
                    }    
                    if(errorI){
                        randInt = (int)(Math.random() * 3);
                        System.out.println(RED + noComprendo[randInt] + RESET);
                    }
                }
            randInt = (int)(Math.random() * 3);
            System.out.println(RED + whatNextI[randInt] + RESET);
            }else {    
                randInt = (int)(Math.random() * 3);
                System.out.println(RED + noComprendo[randInt] + RESET);
            }
        }
    }


    public static Menu searchTag(Menu[] myMenu, String myTag) {
        Menu ans = null;
        int counter = 0;
        int maxInt = 0;
        for (int i = 0; i < myMenu.length; i++) {
            if (hasTag(myMenu[i], myTag)) {
                counter++;
                maxInt = i;
                ans = myMenu[i];
            }
        }
        if (counter > 1) {
            int rInt = (int)(Math.random() * counter + (maxInt - counter));
            ans = myMenu[rInt];
        }
        return ans;
    }


    public static boolean hasTag(Menu x, String tg) {
        boolean ans = false;
        for (int i = 0; i < x.getTag().length; i++) {
            if (x.getTag()[i].contains(tg)) {
                ans = true;
            }
        }
        return ans;
    }


    public static boolean isTag(String responseString) {
        boolean ans = false;
        int counter1 = 0;
        int counter2 = 0;
        for (Menu i : menuArr) {
            for (int l = 0; l < i.getTag().length; l++) {
                counter1++;
            }
        }
        String[] tagArr = new String[counter1];
        for (Menu i : menuArr) {
            for (int l = 0; l < i.getTag().length; l++) {
                tagArr[counter2] = i.getTag()[l];
                counter2++;
            }
        }
        for (String i : tagArr) {
            if (responseString.contains(i)) {
                ans = true;
            }
        }
        return ans;
    }


    public static void respondIsTag(String input) {
        Menu menuAns = new Menu(null, 0, null, null);
        int randInt;
        if (isTag(input)) {
            if (input.contains("vegan")) {
                menuAns = searchTag(menuArr, "vegan");
                randInt = (int)(Math.random() * 3);
                System.out.println(recomendThisPlural[randInt] + menuAns.getName());
            } else if (input.contains("vegetarian")) {
                menuAns = searchTag(menuArr, "vegetarian");
                randInt = (int)(Math.random() * 3);
                System.out.println(recomendThis[randInt] + menuAns.getName());
            } else if (input.contains("burger")) {
                menuAns = searchTag(menuArr, "burger");
                randInt = (int)(Math.random() * 3);
                System.out.println(recomendThis[randInt] + menuAns.getName());
            } else if (input.contains("big")) {
                menuAns = searchTag(menuArr, "big");
                randInt = (int)(Math.random() * 3);
                System.out.println(recomendThis[randInt] + menuAns.getName());  
            } else if (input.contains("milkshake")) {
                menuAns = searchTag(menuArr, "milkshake");
                randInt = (int)(Math.random() * 3);
                System.out.println(recomendThis[randInt] + menuAns.getName());    
            } else {    
                randInt = (int)(Math.random() * 3);
                System.out.println(noComprendo[randInt]);
            }
        } else {    
            randInt = (int)(Math.random() * 3);
            System.out.println(noComprendo[randInt]);
        }
    }
    public static void printIngs(String[] x){
        for (String i : x){
            System.out.println(RED+i+RESET);
        }
    }
   
    public static void printIngsMenu(Menu[] x){
        for (Menu i : x){
            System.out.println(RED+i.getName()+":"+RESET);
            printIngs(i.getIngredients());
        }
    }
}






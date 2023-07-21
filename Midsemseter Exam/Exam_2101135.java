import java.util.*;

class User {
    int userID;
    String name;
    String dateOfBirth;
    String address;
    String PAN;
}

class Admin extends User {
    String dateOfJoining;
    int salary;
    String permissibleOperations;
}

class General extends User {
    String dateOfJoining;
    int salary;
    int dutyHourPerDay;
}

class Item {

    Scanner sc = new Scanner(System.in);

    int itemCode;
    int price;
    int availableQty;

    Item(int itcode,int pr,int avQt){
        this.itemCode = itcode;
        this.price = pr;
        this.availableQty = avQt;
    }

    Item(){
        
    }

    public void addNewStock() {

        System.out.println("Enter item code:");
        int itemCode = sc.nextInt();
        this.itemCode = itemCode;

        System.out.println("Enter price:");
        int price = sc.nextInt();
        this.price = price;

        System.out.println("Enter available quantity:");
        int availableQty = sc.nextInt();
        this.availableQty = availableQty;
    }

    public void getDetails() {
        System.out.println("Item Code:" + this.itemCode);
        System.out.println("Price:" + this.price);
        System.out.println("Availabe Quantity:" + this.availableQty);
    }

    public void modifyPrice(int price) {
        this.price = price;
    }

    public void modifyQty(int qty) {
        this.availableQty = qty;
    }

    public boolean modifyStockSell(int qty) { // when an item is sold

        if (this.availableQty - qty < 0) {
            System.out.println("Insufficent quantity!");
            return false;
        }

        else {
            this.availableQty = this.availableQty - qty;
            return true;
        }

    }

    public void modifyStockReturn(int qty) {
        this.availableQty = this.availableQty + qty;
    }
}

class FoodItem extends Item {

    String dateOfExpiry;
}

class NonFoodItem extends Item {
    int returnCount;
}

class Sell {
    String dateOfSell;
    int itemCode;
    int quantity;
    int totalAmount;

    Sell(String dateOfSell, int itemCode, int quantity, int totalAmount) {
        this.dateOfSell = dateOfSell;
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }
}

class Return {
    String dateOfReturn;
    int itemCode;
    int quantity;
    int returnAmount;

    Return(String dateOfReturn, int itemCode, int quantity, int returnAmount) {
        this.dateOfReturn = dateOfReturn;
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.returnAmount = returnAmount;
    }
}

public class Exam_2101135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> arrayOfItems = new ArrayList<>();
        ArrayList<Sell> sellItems = new ArrayList<>();
        ArrayList<Return> returnItems = new ArrayList<>();

        String user = new String();

        user = args[1];

        System.out.println("This application is run by " + user + " User");
        System.out.println("Validating options as per " + user + " User");

        if (user.equals("Admin")) {
            while (true) {
                int choice;
                System.out.println("Welcome Admin");
                System.out.println("Choose any one of the given options");
                System.out.println("1.Add new item");
                System.out.println("2.Delete item");
                System.out.println("3.Modify item");
                System.out.println("4.Exit");
                choice = sc.nextInt();

                if (choice == 1) {
                    arrayOfItems.add(new Item());
                    arrayOfItems.get(arrayOfItems.size() - 1).addNewStock();
                }

                else if (choice == 2) {
                    int inpItemCode;
                    System.out.println("Enter item code of item to be deleted:");
                    inpItemCode = sc.nextInt();
                    int i=0;int flag = 0;
                    for (i = 0; i <= arrayOfItems.size() - 1; i++) {
                        if (arrayOfItems.get(i).itemCode == inpItemCode) {
                            flag = 1;
                            if (arrayOfItems.get(i).availableQty == 0) {
                                System.out.println("Deleteing item....");
                                arrayOfItems.remove(i);
                            } else {
                                System.out.println("Item quantity must be 0");
                            }
                        }
                    }
                    if (i == arrayOfItems.size() && flag!=1) {
                        System.out.println("No item with given input id!");
                    }
                }

                else if (choice == 3) {
                    int modChocice;
                    System.out.println("What is to be modified? 1. Price  2.Available Quantity");
                    modChocice = sc.nextInt();
                    if (modChocice == 1) {
                        int inpItemCode;
                        System.out.println("Enter item code of item to be modified:");
                        inpItemCode = sc.nextInt();
                        int i;int flag = 0;
                        for (i = 0; i <= arrayOfItems.size() - 1; i++) {
                            if (arrayOfItems.get(i).itemCode == inpItemCode) {
                                flag = 1;
                                int newPrice;
                                System.out.println("Enter new prcie:");
                                newPrice = sc.nextInt();
                                arrayOfItems.get(i).modifyPrice(newPrice);
                            }
                        }
                        if (i == arrayOfItems.size() && flag!=1) {
                            System.out.println("No item with given input id!");
                        }
                    }
                    if (modChocice == 2) {
                        int inpItemCode;
                        System.out.println("Enter item code of item to be modified:");
                        inpItemCode = sc.nextInt();
                        int i;int flag = 0;
                        for (i = 0; i <= arrayOfItems.size() - 1; i++) {
                            if (arrayOfItems.get(i).itemCode == inpItemCode) {
                                flag = 1;
                                int newQty;
                                System.out.println("Enter new quantity:");
                                newQty = sc.nextInt();
                                arrayOfItems.get(i).modifyQty(newQty);
                            }
                        }
                        if (i == arrayOfItems.size() && flag!=1) {
                            System.out.println("No item with given input id!");
                        }
                    }
                }

                else if (choice == 4) {
                    break;
                }

                else {
                    System.out.println("Invalid choice");
                }
            }
        }

        if (user.equals("General")) {
           arrayOfItems.add(new Item(100,100,100));
           arrayOfItems.add(new Item(101,100,100));
            while (true) {
                int choice;
                System.out.println("Welcome General User");
                System.out.println("Choose any one of the given options");
                System.out.println("1.Sell");
                System.out.println("2. Return ");
                System.out.println("3.Diplay stock");
                System.out.println("4. Exit");
                choice = sc.nextInt();

                if (choice == 1) {
                    int inpItemCode;
                    System.out.println("Enter item code of item to be sold");
                    inpItemCode = sc.nextInt();
                    int i;int flag = 0;
                    for (i = 0; i <= arrayOfItems.size() - 1; i++) {
                        if (arrayOfItems.get(i).itemCode == inpItemCode) {
                            flag = 1;
                            String dateOfSell;
                            int qty;
                            System.out.println("Enter date of sell (dd-mm-yyyy) format:");
                            dateOfSell = sc.next();
                            System.out.println("Enter quantity to be sold");
                            qty = sc.nextInt();
                            if (arrayOfItems.get(i).modifyStockSell(qty)) {
                                sellItems.add(new Sell(dateOfSell, arrayOfItems.get(i).itemCode, qty,
                                        (qty) * (arrayOfItems.get(i).price)));
                            }
                        }
                    }
                    if (i == arrayOfItems.size() && flag!=1) {
                        System.out.println("No item with given input id!");
                    }
                }

                else if (choice == 2) {
                    int inpItemCode;
                    System.out.println("Enter item code of item to be returned");
                    inpItemCode = sc.nextInt();
                    int i;int flag = 0;
                    for (i = 0; i <= arrayOfItems.size() - 1; i++) {
                        if (arrayOfItems.get(i).itemCode == inpItemCode) {
                            flag = 1;
                            String dateOfreturn;
                            int qty;
                            System.out.println("Enter date of return (dd-mm-yyyy) format:");
                            dateOfreturn = sc.next();
                            System.out.println("Enter quantity to be returned");
                            qty = sc.nextInt();
                            arrayOfItems.get(i).modifyStockReturn(qty);
                            returnItems.add(new Return(dateOfreturn, arrayOfItems.get(i).itemCode, qty,
                                    (qty) * (arrayOfItems.get(i).price)));
                        }
                    }
                    if (i == arrayOfItems.size() && flag != 1) {
                        System.out.println("No item with given input id!");
                    }
                }

                else if (choice == 3) {
                    int inpItemCode;
                    System.out.println("Enter item code of item:");
                    inpItemCode = sc.nextInt();
                    int i;int flag = 0;
                    for (i = 0; i <= arrayOfItems.size() - 1; i++) {
                        if (arrayOfItems.get(i).itemCode == inpItemCode) {
                            flag = 1;
                            arrayOfItems.get(i).getDetails();
                        }
                    }
                    if (i == arrayOfItems.size() && flag!=1) {
                        System.out.println("No item with given input id!");
                    }
                }

                else if (choice == 4) {
                    break;
                }

                else {
                    System.out.println("Invalid choice");
                }
            }
        }

        else {
            System.out.println("Thanks!");
        }
    }
}
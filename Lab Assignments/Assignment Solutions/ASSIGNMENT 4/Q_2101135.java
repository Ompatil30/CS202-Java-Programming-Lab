import java.util.Scanner;

class Account {
    public int accountNumber;
    private String accountType;
    private String serviceBranchIFSC;
    private float minimumBalance;
    private float availableBalance;
    private int customerID;
    private String customerName;
    private static int totalAccountCreated = 0;

    Scanner sc=new Scanner(System.in);

    Account() {

    }

    public void setDetails(int accountNumber, String accountType, String serviceBranchIFSC, float availableBalance,
            int customerID, String customerName) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.serviceBranchIFSC = serviceBranchIFSC;
        this.availableBalance = availableBalance;
        this.customerID = customerID;
        this.customerName = customerName;
    }

    public void getDetails(int accountNumber) {
        System.out.println("Account Number:");
        System.out.println(this.accountNumber);
        System.out.println("Account Type:");
        System.out.println(this.accountType);
        System.out.println("IFSC Code:");
        System.out.println(this.serviceBranchIFSC);
        System.out.println("Minimum Balance:");
        System.out.println(this.minimumBalance);
        System.out.println("Available Balance:");
        System.out.println(this.availableBalance);
        System.out.println("Customer ID:");
        System.out.println(this.customerID);
        System.out.println("Customer Name");
        System.out.println(this.customerName);
    }

    public void updateDetails() {
        int choice;
        System.out.println("Enter what you want to update:");
        System.out.println("1. Minimum balance.");
        System.out.println("2. Customer ID");
        choice=sc.nextInt();
        if(choice == 1){
            float newMinBal;
            System.out.println("Enter new minimum balance amount:");
            newMinBal=sc.nextFloat();
            this.minimumBalance=newMinBal;
        }
        if(choice == 2){
            int newcCustID;
            System.out.println("Enter new Customer ID:");
            newcCustID=sc.nextInt();
            this.customerID=newcCustID;
        }
    }

    public float getBalance(int accountNumber) {
        return this.availableBalance;
    }

    public void deposit(int accountNumber, float amount) {
        availableBalance += amount;
    }

    public void withdraw(int accountNumber, float amount) {
        if (availableBalance < amount) {
            System.out.println("You have insufficient funds in an account");
        } else {
            availableBalance -= amount;
        }
    }

    public static void totalAccount() {
        totalAccountCreated++;
    }

    public void compare(Account acc1) {
        if(acc1.availableBalance < this.availableBalance){
            System.out.println("Account number "+this.accountNumber+" has more balance");
        }
        else{
            System.out.println("Account number "+ acc1.accountNumber +" has more balance.");
        }
    }

    public int returnAccount(int accountNumber) {
        return accountNumber;
    }
}

public class Q_2101135 {
    public static void main(String[] args) {
        Account[] array = new Account[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Account();
        }

        Scanner sc = new Scanner(System.in);

        int track = 0;
        int accountNumber;
        String accountType;
        String serviceBranchIFSC;
        float availableBalance;
        float minimumBalance;
        int customerID;
        String customerName;

        System.out.println("Welcome to Bank Management System!");

        while (track < array.length) {
            int choice;
            System.out.println("Enter your choice");
            System.out.println("1. Set Details");
            System.out.println("2. Update Details");
            System.out.println("3. Get Details");
            System.out.println("4. Get Balance");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7.Compare");
            System.out.println("8. Exit");

            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Enter Account number of the account:");
                accountNumber = sc.nextInt();
                System.out.println("Enter Account type of the account:");
                accountType = sc.next();
                System.out.println("Enter IFSC code:");
                serviceBranchIFSC = sc.next();
                while (true) {
                    System.out.println("Enter minimum balance amount:");
                    minimumBalance = sc.nextFloat();
                    if (minimumBalance < 0) {
                        System.out.println("Minimum Account balance cant be negative. Try again!");
                        continue;
                    } 
                    else 
                    {
                        break;
                    }
                }
                while (true) {
                    System.out.println("Enter balance amount:");
                    availableBalance = sc.nextFloat();
                    if (availableBalance < minimumBalance) {
                        System.out.println("Balance amount cant be less than minum balance amount. Try again!");
                        continue;
                    } 
                    else 
                    {
                        break;
                    }
                }
                System.out.println("Enter Customer ID:");
                customerID = sc.nextInt();
                System.out.println("Enter Customer Name:");
                customerName = sc.next();
                array[track].setDetails(accountNumber, accountType, serviceBranchIFSC, availableBalance, customerID,
                        customerName);
                Account.totalAccount();
                track++;
                continue;
            }

            else if (choice == 2) {
                int reqAC;
                System.out.println("Enter account number:");
                reqAC = sc.nextInt();
                int i = 0;
                while (i < array.length) {
                    if (array[i].accountNumber == reqAC) {
                        array[i].updateDetails();
                        break;
                    }
                    i++;
                }
                if (i == array.length) {
                    System.out.println("No account with the input account number");
                    continue;
                } 
                else 
                {
                    continue;
                }
            }

            else if (choice == 3) {
                int reqAC;
                System.out.println("Enter account number:");
                reqAC = sc.nextInt();
                int i = 0;
                while (i < array.length) {
                    if (array[i].accountNumber == reqAC) {
                        array[i].getDetails(reqAC);
                        break;
                    }
                    i++;
                }
                if (i == array.length) {
                    System.out.println("No account with the input account number");
                    continue;
                } 
                else 
                {
                    continue;
                }
            }

            else if(choice == 4){
                int reqAC;
                System.out.println("Enter account number:");
                reqAC = sc.nextInt();
                int i = 0;
                while (i < array.length) {
                    if (array[i].accountNumber == reqAC) {
                        System.out.print("The balance amount is: ");
                        System.out.println(array[i].getBalance(reqAC));
                        break;
                    }
                    i++;
                }
                if (i == array.length) {
                    System.out.println("No account with the input account number");
                    continue;
                } 
                else 
                {
                    continue;
                }
            }

            else if(choice == 5){
                int reqAC;
                Float depAmt;
                System.out.println("Enter account number:");
                reqAC = sc.nextInt();
                int i = 0;
                while (i < array.length) {
                    if (array[i].accountNumber == reqAC) {
                        System.out.print("Enter amount to be deposited: ");
                        depAmt=sc.nextFloat();
                        array[i].deposit(reqAC, depAmt);
                        break;
                    }
                    i++;
                }
                if (i == array.length) {
                    System.out.println("No account with the input account number");
                    continue;
                } 
                else 
                {
                    continue;
                }
            }

            else if(choice == 6){
                int reqAC;
                Float withAmt;
                System.out.println("Enter account number:");
                reqAC = sc.nextInt();
                int i = 0;
                while (i < array.length) {
                    if (array[i].accountNumber == reqAC) {
                        System.out.print("Enter amount to be withdrawn: ");
                        withAmt=sc.nextFloat();
                        array[i].withdraw(reqAC, withAmt);
                        break;
                    }
                    i++;
                }
                if (i == array.length) {
                    System.out.println("No account with the input account number");
                    continue;
                } 
                else 
                {
                    continue;
                }
            }

            else if(choice == 7){
                int reqAC1;
                System.out.println("Enter account number:");
                reqAC1 = sc.nextInt();
                int i = 0;
                while (i < array.length) {
                    if (array[i].accountNumber == reqAC1) {
                        break;
                    }
                    i++;
                }
                int reqAC2;
                System.out.println("Enter account number:");
                reqAC2 = sc.nextInt();
                int j = 0;
                while (j < array.length) {
                    if (array[j].accountNumber == reqAC2) {
                        break;
                    }
                    j++;
                }

                array[i].compare(array[j]);


            }

            else if(choice == 8){
                System.out.println("Thank you for using our Bank Management System.");
                break;
            }

            else{
                System.out.println("Invalid choice!");
                continue;
            }
        }
    }
}
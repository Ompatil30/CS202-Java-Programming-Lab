import java.util.*;

class User {

    String firstName;
    String lastName;
    String PAN;
    String addressPIN;
    String emaildID;
    String dateOfBirth;

    Scanner sc = new Scanner(System.in);

    public void validate() {

        System.out.println("Enter first name:");
        String firstName = sc.next();
        this.firstName = firstName;
        System.out.println("Enter last name:");
        String lastName = sc.next();
        this.lastName = lastName;
        while (true) {
            System.out.println("Enter PAN:");
            String PAN = sc.next();
            if (PAN.matches("[A-Z\\d{}]*")) {
                this.PAN = PAN;
                break;
            } else {
                System.out.println("PAN must be aplhanumeric with all capital letters. Try again!");
                continue;
            }
        }
        while (true) {
            System.out.println("Enter PIN Code:");
            String addressPIN = sc.next();
            if (addressPIN.matches("\\d{6}")) {
                this.addressPIN = addressPIN;
                break;
            } else {
                System.out.println("PIN must contain only 6 digits. Try again!");
                continue;
            }
        }
        while (true) {
            System.out.println("Enter Email-ID:");
            String emailID = sc.next();
            if (emailID.contains("@") && emailID.endsWith("iiitg.ac.in")) {
                this.emaildID = emailID;
                break;
            } else {
                System.out.println("Invlaid mail ID. Plaese enter your institute mail ID.");
                continue;
            }
        }
        while (true) {
            System.out.println("Enter Date of Birth ():");
            String dateOfBirth = sc.next();
            if (dateOfBirth.matches("\\d{8}")) {
                this.dateOfBirth = dateOfBirth;
                break;
            } else {
                System.out.println("Please enter date of birth in ddmmyyyy format");
                continue;
            }
        }
    }

    public void showDetails() {

        System.out.println("First Name: " + this.firstName);
        System.out.println("Last Name: " + this.lastName);
        System.out.println("PAN Number: " + this.PAN);
        System.out.println("PIN code: " + this.addressPIN);
        System.out.println("E-mail ID:" + this.emaildID);
        System.out.println("Date of Birth: " + this.dateOfBirth);

    }

    public int extractYear(int inpYear){
        int start,end;
        end=this.dateOfBirth.length();
        start=end-4;
        String year=dateOfBirth.substring(start, end);
        int birthyYear=Integer.parseInt(year);
        return birthyYear;
    }

}

final class Student extends User {

    int rollno;
    float CPI;

    @Override
    public void validate() {
        super.validate();
        System.out.println("Enter your roll number:");
        int rollno = sc.nextInt();
        this.rollno = rollno;
        System.out.println("Enter your CPI:");
        float CPI = sc.nextFloat();
        this.CPI = CPI;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Roll Number:" + this.rollno);
        System.out.println("CPI :" + this.CPI);
    }

    public int showDetails(int inpYear){
        int birthYear=super.extractYear(inpYear);
        return birthYear;
    }

}

final class Faculty extends User {

    int employeeID;
    String department;

    @Override
    public void validate() {
        super.validate();
        System.out.println("Enter your employee ID:");
        int employeeID = sc.nextInt();
        this.employeeID = employeeID;
        System.out.println("Enter your department:");
        String department = sc.next();
        this.department = department;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Employee ID:" + this.employeeID);
        System.out.println("Department:" + this.department);
    }

    public int showDetails(int inpYear){
        int birthYear=super.extractYear(inpYear);
        return birthYear;
    }
}

public class Q_2101135 {

    public static void main(String[] args) {

        ArrayList<Student> objStudent = new ArrayList<>();
        ArrayList<Faculty> objFaculty = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int userType;
        while (true) {
            System.out.println("You are/want to register as?");
            System.out.println("1.Student ");
            System.out.println("2.Faculty ");
            System.out.println("3.Exit ");
            userType = sc.nextInt();
            if (userType == 1) {
                while (true) {
                    int choice;
                    System.out.println("Welcome!");
                    System.out.println("Enter your choice");
                    System.out.println("1.Set Details.");
                    System.out.println("2.Show Details");
                    System.out.println("Not a Student? Press 3 to exit from Student Portal.");
                    choice = sc.nextInt();

                    if (choice == 1) {
                        int track = 0;
                        objStudent.add(new Student());
                        objStudent.get(track).validate();
                        track++;
                    }

                    else if (choice == 2) {
                        int detailInput;
                        System.out.println(
                                "You want to see details on the basis of: 1.Roll number OR 2.Birth year. Enter the number 1 or 2:");
                        detailInput = sc.nextInt();

                        if (detailInput == 1) {
                            int inprollno;
                            System.out.println("Enter the user ID:");
                            inprollno = sc.nextInt();
                            int i;
                            int indicator = 0;
                            for (i = 0; i < objStudent.size(); i++) {
                                if (objStudent.get(i).rollno == inprollno) {
                                    objStudent.get(i).showDetails();
                                    indicator++;
                                }
                                if (i == objStudent.size() && indicator == 0) {
                                    System.out.println("No student registered with the input User ID.");
                                }
                            }
                        }

                        else if (detailInput == 2) {
                            int inpYear;
                            System.out.println("Enter birth year:");
                            inpYear = sc.nextInt();
                            int i;
                            int indicator = 0;
                            for (i = 0; i < objStudent.size(); i++) {
                                if (objStudent.get(i).showDetails(inpYear)==inpYear) {
                                    objStudent.get(i).showDetails();
                                    indicator++;
                                }
                                if (i == objStudent.size() && indicator == 0) {
                                    System.out.println("No students with input birth of year.");
                                }
                            }
                        }

                        else {
                            System.out.println("Invalid Choice.");
                        }
                    }

                    else if (choice == 3) {
                        break;
                    }

                    else {
                        System.out.println("Invalid input. Try again!");
                    }
                }
            }

            else if (userType == 2) {
                while (true) {
                    int choice;
                    System.out.println("Welcome!");
                    System.out.println("Enter your choice");
                    System.out.println("1.Set Details.");
                    System.out.println("2.Show Details");
                    System.out.println("Not a Faculty? Press 3 to exit from Faculty Portal.");
                    choice = sc.nextInt();

                    if (choice == 1) {
                        int track = 0;
                        objFaculty.add(new Faculty());
                        objFaculty.get(track).validate();
                        track++;
                    }

                    else if (choice == 2) {
                        int detailInput;
                        System.out.println(
                                "You want to see details on the basis of: 1.Employee ID OR 2.Birth year. Enter the number 1 or 2:");
                        detailInput = sc.nextInt();

                        if (detailInput == 1) {
                            int inpEmployeeID;
                            System.out.println("Enter the user ID:");
                            inpEmployeeID = sc.nextInt();
                            int i;
                            int indicator = 0;
                            for (i = 0; i < objFaculty.size(); i++) {
                                if (objFaculty.get(i).employeeID == inpEmployeeID) {
                                    objFaculty.get(i).showDetails();
                                    indicator++;
                                }
                                if (i == objFaculty.size() && indicator == 0) {
                                    System.out.println("No staff registered with the input User ID.");
                                }
                            }
                        }

                        else if (detailInput == 2) {
                            int inpYear;
                            System.out.println("Enter birth year:");
                            inpYear = sc.nextInt();
                            int i;
                            int indicator = 0;
                            for (i = 0; i < objFaculty.size(); i++) {
                                if (objFaculty.get(i).showDetails(inpYear) == inpYear) {
                                    objFaculty.get(i).showDetails();
                                    indicator++;
                                }
                                if (i == objFaculty.size() && indicator == 0) {
                                    System.out.println("No staff with input birth of year.");
                                }
                            }
                        }
                    }

                    else if (choice == 3) {
                        break;
                    }

                    else {
                        System.out.println("Invalid input. Try again!");
                    }

                }
            }

            else if (userType == 3) {
                break;
            }

            else {
                System.out.println("Invalid choice! The input must be same as indicated in the bracket. Try again.");
            }
        }
    }
}

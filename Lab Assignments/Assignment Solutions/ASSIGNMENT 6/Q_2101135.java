import java.util.Scanner;
import java.util.ArrayList;

class User{

    String name;
    String dateOfBirth;
    int userID;

    Scanner sc=new Scanner(System.in);
    User(String name,String dateOfBirth,int userID){
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.userID=userID;
    }

    public void setDetails(){
        System.out.println("Enter the name:");
        String name=sc.next();
        this.name=name;
        System.out.println("Enter date of birth in (dd-mm-yyyy) format:");
        String dateOfBirth=sc.next();
        this.dateOfBirth=dateOfBirth;
        System.out.println("Enter userID:");
        int userID=sc.nextInt();
        this.userID=userID;
    }

    public void showDetails(){
        System.out.println("Name:"+this.name);
        System.out.println("Date of Birth:"+this.dateOfBirth);
        System.out.println("User ID:"+this.userID);
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

class Student extends User{

    int rollNumber;
    int semester;
    float cpi;

    Student(String name,String dateOfBirth,int userID,int rollNumber,int semester,float cpi){
        super(name, dateOfBirth, userID);
        this.rollNumber=rollNumber;
        this.semester=semester;
        this.cpi=cpi;
    }

    @Override
    public void setDetails(){
        super.setDetails();
        System.out.println("Enter the roll number:");
        int rollNumber=sc.nextInt();
        this.rollNumber=rollNumber;
        System.out.println("Enter current semester:");
        int semester=sc.nextInt();
        this.semester=semester;
        System.out.println("Enter the CPI:");
        float cpi=sc.nextFloat();
        this.cpi=cpi;
        
    }

    @Override
    public void showDetails(){
        super.showDetails();
        System.out.println("Roll number:"+this.name);
        System.out.println("Semester:"+this.semester);
        System.out.println("CPI:"+this.cpi);
    }

    public int showDetails(int inpYear){
        int birthYear=super.extractYear(inpYear);
        return birthYear;
    }
}

class Staff extends User{

    int employeeID;
    String sectionName;
    String designation;

    Staff(String name,String dateOfBirth,int userID,int employeeID,String sectionName,String designation){
        super(name, dateOfBirth, userID);
        this.employeeID=employeeID;
        this.sectionName=sectionName;
        this.designation=designation;
    }

    public int checkDeisgnation(Staff s1, Staff s2){

        if(s1.designation==s2.designation){
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public void setDetails(){
        super.setDetails();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the employee ID:");
        int employeeID=sc.nextInt();
        this.employeeID=employeeID;
        System.out.println("Enter the section name:");
        String sectionName=sc.next();
        this.sectionName=sectionName;
        System.out.println("Enter the designation:");
        String designation=sc.next();
        this.designation=designation;
        //sc.close();
    }

    @Override
    public void showDetails(){
        super.showDetails();
        System.out.println("Employee ID:"+this.employeeID);
        System.out.println("Section Name:"+this.sectionName);
        System.out.println("Designation:"+this.designation);
    }

    public int showDetails(int inpYear){
        int birthYear=super.extractYear(inpYear);
        return birthYear;
    }

}

class Faculty extends User{

    int employeeID;
    String departmentName;
    int noOfPublications;

    Faculty(String name,String dateOfBirth,int userID,int employeeID,String departmentName,int noOfPublications){
        super(name, dateOfBirth, userID);
        this.employeeID=employeeID;
        this.departmentName=departmentName;
        this.noOfPublications=noOfPublications;
    }

    public int checkDepartment(Faculty f1,Faculty f2){
        
        if(f1.departmentName==f2.departmentName){
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public void setDetails(){
        super.setDetails();
        System.out.println("Enter the employee ID:");
        int employeeID=sc.nextInt();
        this.employeeID=employeeID;
        System.out.println("Enter the name of the department:");
        String departmentName=sc.next();
        this.departmentName=departmentName;
        System.out.println("Enter the number of publications:");
        int noOfPublications=sc.nextInt();
        this.noOfPublications=noOfPublications;
        //sc.close();
    }

    @Override
    public void showDetails(){
        super.showDetails();
        System.out.println("Employee ID:"+this.employeeID);
        System.out.println("Department Name:"+this.departmentName);
        System.out.println("Number of Publications:"+this.noOfPublications);
    }

    public int showDetails(int inpYear){
        int birthYear=super.extractYear(inpYear);
        return birthYear;
    }

}

public class Q_2101135{

    public static void main(String[] args){

        ArrayList<Student> objStudent=new ArrayList<>();
        ArrayList<Staff> objStaff=new ArrayList<>();
        ArrayList<Faculty> objFaculty=new ArrayList<>();

        Scanner sc=new Scanner(System.in);
        
        int userType;
        while(true){
            System.out.println("You are/want to register as?");
            System.out.println("1.Student ");
            System.out.println("2.Staff  ");
            System.out.println("3.Faculty ");
            System.out.println("4.Exit ");
            userType=sc.nextInt();
            if(userType==1){
                while (true) {
                    int choice;
                    System.out.println("Welcome!");
                    System.out.println("Enter your choice");
                    System.out.println("1.Set Details.");
                    System.out.println("2.Show Details");
                    System.out.println("Not a Student? Press 3 to exit from Student Portal.");
                    choice=sc.nextInt();

                    if(choice==1){
                        int track=0;
                        objStudent.add(new Student("NULL", "NULL", 0, 0, 0, 0));
                        objStudent.get(track).setDetails();
                        track++;
                    }

                    else if(choice==2){
                        int detailInput;
                        System.out.println("You want to see details on the basis of: 1.User ID OR 2.Birth year. Enter the number 1 or 2:");
                        detailInput=sc.nextInt();

                        if(detailInput==1){
                            int inpUserid;
                            System.out.println("Enter the user ID:");
                            inpUserid=sc.nextInt();
                            int i;int indicator=0;
                            for(i=0;i<objStudent.size();i++){
                                if(objStudent.get(i).userID == inpUserid){
                                    objStudent.get(i).showDetails();
                                    indicator++;
                                }
                                if(i==objStudent.size() && indicator==0){
                                    System.out.println("No student registered with the input User ID.");
                                }
                            }
                        }

                        else if(detailInput==2){
                            int inpYear;
                            System.out.println("Enter birth year:");
                            inpYear=sc.nextInt();
                            int i;int indicator=0;
                            for(i=0;i<objStudent.size();i++){
                                if(objStudent.get(i).showDetails(inpYear)==inpYear){
                                    objStudent.get(i).showDetails();
                                    indicator++;
                                }
                                if(i==objStudent.size() && indicator==0){
                                    System.out.println("No students with input birth of year.");
                                }
                            }
                        }

                        else{
                            System.out.println("Invalid Choice.");
                        }
                    }

                    else if(choice==3){
                        break;
                    }

                    else{
                        System.out.println("Invalid input. Try again!");
                    }
                }
            }

            else if(userType==2){
                while(true){
                    int choice;
                    System.out.println("Welcome!");
                    System.out.println("Enter your choice");
                    System.out.println("1.Set Details.");
                    System.out.println("2.Show Details");
                    System.out.println("Not a Staff Memeber? Press 3 to exit from Staff Portal.");
                    choice=sc.nextInt();

                    if(choice==1){
                        int track=0;
                        objStaff.add(new Staff("NULL", "NULL", 0, 0, "NULL", "NULL"));
                        objStaff.get(track).setDetails();
                        track++;
                    }

                    else if(choice==2){
                        int detailInput;
                        System.out.println("You want to see details on the basis of: 1.User ID OR 2.Birth year OR 3.Employee ID. Enter the number 1,2 or 3:");
                        detailInput=sc.nextInt();

                        if(detailInput==1){
                            int inpUserid;
                            System.out.println("Enter the user ID:");
                            inpUserid=sc.nextInt();
                            int i;int indicator=0;
                            for(i=0;i<objStaff.size();i++){
                                if(objStaff.get(i).userID == inpUserid){
                                    objStaff.get(i).showDetails();
                                    indicator++;
                                }
                                if(i==objStaff.size() && indicator==0){
                                    System.out.println("No staff registered with the input User ID.");
                                }
                            }
                        }

                        else if(detailInput==2){
                            int inpYear;
                            System.out.println("Enter birth year:");
                            inpYear=sc.nextInt();
                            int i;int indicator=0;
                            for(i=0;i<objStaff.size();i++){
                                if(objStaff.get(i).showDetails(inpYear)==inpYear){
                                    objStaff.get(i).showDetails();
                                    indicator++;
                                }
                                if(i==objStaff.size() && indicator==0){
                                    System.out.println("No staff with input birth of year.");
                                }
                            }
                        }

                        else if(detailInput==3){
                            int inpEmployeeID;
                            System.out.println("Enter the employee ID:");
                            inpEmployeeID=sc.nextInt();
                            int i;int indicator=0;
                            for(i=0;i<objStaff.size();i++){
                                if(objStaff.get(i).employeeID==inpEmployeeID){
                                    objStaff.get(i).showDetails();
                                    indicator++;
                                }
                                if(i==objStaff.size() && indicator==0){
                                    System.out.println("No staff with the input employee ID");
                                }
                            }
                        }

                        else{
                            System.out.println("Invalid Choice.");
                        }
                    }

                    else if(choice==3){
                        break;
                    }

                    else{
                        System.out.println("Invalid input. Try again!");
                    }
                }
            }

            else if(userType==3){
                while(true){
                    int choice;
                    System.out.println("Welcome!");
                    System.out.println("Enter your choice");
                    System.out.println("1.Set Details.");
                    System.out.println("2.Show Details");
                    System.out.println("Not a Faculty? Press 3 to exit from Faculty Portal.");
                    choice=sc.nextInt();

                    if(choice==1){
                        int track=0;
                        objFaculty.add(new Faculty("NULL", "NULL", 0, 0, "NULL", 0));
                        objFaculty.get(track).setDetails();
                        track++;
                    }

                    else if(choice==2){
                        int detailInput;
                        System.out.println("You want to see details on the basis of: 1.User ID OR 2.Birth year OR 3.Employee ID. Enter the number 1,2 or 3:");
                        detailInput=sc.nextInt();

                        if(detailInput==1){
                            int inpUserid;
                            System.out.println("Enter the user ID:");
                            inpUserid=sc.nextInt();
                            int i;int indicator=0;
                            for(i=0;i<objFaculty.size();i++){
                                if(objFaculty.get(i).userID == inpUserid){
                                    objFaculty.get(i).showDetails();
                                    indicator++;
                                }
                                if(i==objFaculty.size() && indicator==0){
                                    System.out.println("No staff registered with the input User ID.");
                                }
                            }
                        }

                        else if(detailInput==2){
                            int inpYear;
                            System.out.println("Enter birth year:");
                            inpYear=sc.nextInt();
                            int i;int indicator=0;
                            for(i=0;i<objFaculty.size();i++){
                                if(objFaculty.get(i).showDetails(inpYear)==inpYear){
                                    objFaculty.get(i).showDetails();
                                    indicator++;
                                }
                                if(i==objFaculty.size() && indicator==0){
                                    System.out.println("No staff with input birth of year.");
                                }
                            }
                        }

                        else if(detailInput==3){
                            int inpEmployeeID;
                            System.out.println("Enter the employee ID:");
                            inpEmployeeID=sc.nextInt();
                            int i;int indicator=0;
                            for(i=0;i<objFaculty.size();i++){
                                if(objFaculty.get(i).employeeID==inpEmployeeID){
                                    objFaculty.get(i).showDetails();
                                    indicator++;
                                }
                                if(i==objFaculty.size() && indicator==0){
                                    System.out.println("No staff with the input employee ID");
                                }
                            }
                        }

                        else{
                            System.out.println("Invalid Choice.");
                        }
                    }

                    else if(choice==3){
                        break;
                    }

                    else{
                        System.out.println("Invalid input. Try again!");
                    }
                    

                }
            }

            else if(userType==4){
                break;
            }

            else{
                System.out.println("Invalid choice! The input must be same as indicated in the bracket. Try again.");
            }
        }
    }
}
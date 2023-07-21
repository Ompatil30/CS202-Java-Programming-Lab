import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*; 
import java.util.*;

class Student {
	String RollNumer;
	String Name;

	Student(String r, String n) {
		this.RollNumer = r;
		this.Name = n;
	}

	public boolean check(String r, String n) {
		if (this.Name == n && this.RollNumer == r) {
			return true;
		} else {
			return false;
		}
	}
}

public class Lab_2101135 extends JFrame implements ActionListener,Serializable{

	ArrayList<Student> records = new ArrayList<>();

	JMenu AdminMenu;
	JMenuItem a1, a2, a3;

	JButton b1;
	JButton b2;

	Lab_2101135() {
		super("Student Information Records");

		b1 = new JButton("Admin");
		b1.setBounds(100, 150, 80, 30);

		b2 = new JButton("User");
		b2.setBounds(200, 150, 80, 30);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JMenu AdminMenu;
				JMenuItem a1, a2, a3;

				remove(b1);
				remove(b2);

				AdminMenu = new JMenu("Clcik here to perform tasks");
				JMenuBar m1 = new JMenuBar();
				m1.setBorderPainted(true);
				a1 = new JMenuItem("Add Deatils");
				a2 = new JMenuItem("Delete Details");
				a3 = new JMenuItem("Modify Details");
				AdminMenu.add(a1);
				AdminMenu.add(a2);
				AdminMenu.add(a3);
				m1.add(AdminMenu);
				setJMenuBar(m1);

				a1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame f1 = new JFrame("Admin - ADD DETAILS");
						JLabel l11 = new JLabel("Enter Name:");
						l11.setBounds(50, 70, 150, 20);
						JTextField tf11 = new JTextField();
						tf11.setBounds(200, 70, 200, 20);

						f1.add(l11);
						f1.add(tf11);

						JLabel l21 = new JLabel("Enter Roll Number:");
						l21.setBounds(50, 100, 150, 20);
						JTextField tf12 = new JTextField();
						tf12.setBounds(200, 100, 200, 20);

						f1.add(l21);
						f1.add(tf12);

						JButton sub1 = new JButton("Submit");
						sub1.setBounds(100, 150, 200, 20);
						f1.add(sub1);

						sub1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String roll = tf11.getText();
								String name = tf12.getText();

								records.add(new Student(roll, name));

								try{
									FileOutputStream fileout = new FileOutputStream("objects.ser");
									ObjectOutputStream out = new ObjectOutputStream(fileout);

									out.writeObject(new Student(roll, name));

									out.close();
									fileout.close();
								}
								catch(Exception ex){
									System.out.println("Unable to serialise.");
								}

								f1.remove(tf11);
								f1.remove(tf12);
								f1.remove(sub1);

								JFrame end1 = new JFrame();
								JLabel con = new JLabel("Details Added");
								con.setBounds(100, 100, 200, 200);
								end1.add(con);

								end1.setSize(400, 500);
								end1.setLayout(null);
								end1.setVisible(true);
								end1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

							}
						});

						f1.setSize(400, 500);
						f1.setLayout(null);
						f1.setVisible(true);
						f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					}
				});

				a2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame f2 = new JFrame("Admin - DELETE DETAILS");
						JLabel l21 = new JLabel("Enter Name:");
						l21.setBounds(50, 70, 150, 20);
						JTextField tf21 = new JTextField();
						tf21.setBounds(200, 70, 200, 20);

						f2.add(l21);
						f2.add(tf21);

						JLabel l22 = new JLabel("Enter Roll Number:");
						l22.setBounds(50, 100, 150, 20);
						JTextField tf22 = new JTextField();
						tf22.setBounds(200, 100, 200, 20);

						f2.add(l22);
						f2.add(tf22);

						JButton sub2 = new JButton("Submit");
						sub2.setBounds(100, 150, 200, 20);
						f2.add(sub2);

						sub2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String roll = tf21.getText();
								String name = tf22.getText();

								try{
									FileInputStream filein = new FileInputStream("objects.ser");
									ObjectInputStream ois = new ObjectInputStream(filein);

									while(true){
										Student st = (Student) ois.readObject();
										records.add(st);
									}
								}
								catch(Exception ex){
									System.out.println("Unable to deserialize");
								}

								int flag = 0;
								for (int i = 0; i < records.size(); i++) {
									if (records.get(i).Name == name && records.get(i).RollNumer == roll) {
										flag = 1;
										records.remove(i);
										JFrame end1 = new JFrame();
										JLabel con = new JLabel("Details Deleted");
										con.setBounds(100, 100, 200, 200);
										end1.add(con);

										end1.setSize(400, 500);
										end1.setLayout(null);
										end1.setVisible(true);
										end1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
									}
								}

								if (flag == 0) {

									JFrame end1 = new JFrame();
									JLabel con = new JLabel("No Student with given details");
									con.setBounds(100, 100, 200, 200);
									end1.add(con);

									end1.setSize(400, 500);
									end1.setLayout(null);
									end1.setVisible(true);
									end1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

								}
							}
						});

						f2.setSize(400, 500);// 400 width and 500 height
						f2.setLayout(null);// using no layout managers
						f2.setVisible(true);// making the frame visible
						f2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					}
				});

				a3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFrame f3 = new JFrame("Admin - MODIFY DETAILS");
						JLabel l31 = new JLabel("Enter Name:");
						l31.setBounds(50, 70, 150, 20);
						JTextField tf31 = new JTextField();
						tf31.setBounds(200, 70, 200, 20);

						f3.add(l31);
						f3.add(tf31);

						JLabel l32 = new JLabel("Enter Roll Number:");
						l32.setBounds(50, 100, 150, 20);
						JTextField tf32 = new JTextField();
						tf32.setBounds(200, 100, 200, 20);

						f3.add(l32);
						f3.add(tf32);

						JButton sub3 = new JButton("Submit");
						sub3.setBounds(100, 150, 200, 20);
						f3.add(sub3);

						sub3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

							}
						});

						f3.setSize(400, 500);// 400 width and 500 height
						f3.setLayout(null);// using no layout managers
						f3.setVisible(true);// making the frame visible
						f3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					}
				});

				setSize(400, 400);
				setLocation(200, 200);
				setLayout(null);
				setVisible(true);
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JMenu UserMenu;
				JMenuItem a1, a2;

				remove(b1);
				remove(b2);

				UserMenu = new JMenu("Clcik here to view details");
				JMenuBar m2 = new JMenuBar();
				m2.setBorderPainted(true);
				a1 = new JMenuItem("Details by roll number");
				a2 = new JMenuItem("Details by Name");

				UserMenu.add(a1);
				UserMenu.add(a2);

				m2.add(UserMenu);
				setJMenuBar(m2);

				a1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ex){
						JFrame f1 = new JFrame("USER - SEARCH BY ROLL NUMBER");

						JLabel l21 = new JLabel("Enter Roll Number:");
						l21.setBounds(50, 100, 150, 20);
						JTextField tf12 = new JTextField();
						tf12.setBounds(200, 100, 200, 20);

						f1.add(l21);
						f1.add(tf12);

						JButton sub4 = new JButton("Submit");
						sub4.setBounds(100, 150, 200, 20);
						f1.add(sub4);

						sub4.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){

								String roll = tf12.getText();
								try{
									FileInputStream filein = new FileInputStream("objects.ser");
									ObjectInputStream ois = new ObjectInputStream(filein);

									while(true){
										Student st = (Student) ois.readObject();
										records.add(st);
									}
								}
								catch(Exception ex){
									System.out.println("Unable to deserialize");
								}

								int flag = 0;
								for (int i = 0; i < records.size(); i++) {
									if (records.get(i).RollNumer == roll) {
										flag = 1;
										records.remove(i);
										JFrame end1 = new JFrame();
										JLabel con = new JLabel("Details Deleted");
										con.setBounds(100, 100, 200, 200);
										end1.add(con);

										end1.setSize(400, 500);
										end1.setLayout(null);
										end1.setVisible(true);
										end1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
									}
								}

								if (flag == 0) {

									JFrame end1 = new JFrame();
									JLabel con = new JLabel("No Student with given details");
									con.setBounds(100, 100, 200, 200);
									end1.add(con);

									end1.setSize(400, 500);
									end1.setLayout(null);
									end1.setVisible(true);
									end1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

							}
					}});

						f1.setSize(400, 500);
						f1.setLayout(null);
						f1.setVisible(true);
						f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

					}
				});
				a2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
					}
				});

				setSize(400, 400);
				setLocation(200, 200);
				setLayout(null);
				setVisible(true);
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

			}
		});

		add(b1);
		add(b2);

		setSize(600, 700);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) throws Exception{
		new Lab_2101135();

		System.out.println("Connecting to server... ");
		
		Socket socket = new Socket("localhost",3333);  
		
		System.out.println("Connected to server... ");
	}

}
import javax.swing.*;
import java.awt.event.*;
//import java.net.*; 

public class Lab extends JFrame implements ActionListener {

	JMenu AdminMenu;
	JMenuItem a1, a2, a3;

	JButton b1;
	JButton b2;

	Lab() {
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
						JTextField tf21 = new JTextField();
						tf21.setBounds(200, 100, 200, 20);

						f1.add(l21);
						f1.add(tf21);

						JButton sub1 = new JButton("Submit");
						sub1.setBounds(100, 150, 200, 20);
						f1.add(sub1);

						sub1.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){

							}
						});

						f1.setSize(400, 500);// 400 width and 500 height
						f1.setLayout(null);// using no layout managers
						f1.setVisible(true);// making the frame visible
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

						sub2.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								
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

						sub3.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								
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

				a1.addActionListener(this);
				a2.addActionListener(this);

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

	public static void main(String[] args) {
		new Lab();

	}

}
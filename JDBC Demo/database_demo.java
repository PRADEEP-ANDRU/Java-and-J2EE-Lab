
import java.io.*;
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import com.mysql.jdbc.*;

public class database_demo extends JFrame {
	public static JPanel cp;
	public JTextField rname;
	public JLabel lrname;
	public JLabel lrnum;
	JTextField rnum;
	JLabel lrcomm;
	JTextField rcomm;
	JLabel lrate;
	JComboBox<String> rate;
	JLabel lcname;
	JTextField cname;
	JTextField cnum;
	JLabel lclimit;
	JLabel lcnum;
	JTextField climit;
	JLabel lcrnum;
	JTextField crnum;
	JLabel cusd;
	JButton sub;
	static Connection conn;
	
	public database_demo() {
		setSize(400,400);
		cp=new JPanel();
		setContentPane(cp);
		cp.setLayout(null);
		
		JPanel panel=new JPanel();
		cp.add(panel);
		
		lrnum=new JLabel("Representative Number: ");
		lrnum.setBounds(20,20,140,20);
		cp.add(lrnum);
		
		rnum=new JTextField();
		rnum.setBounds(160,20,90,20);
		cp.add(rnum);
		
		lrname=new JLabel("Representative Name: ");
		lrname.setBounds(20,50,140,20);
		cp.add(lrname);
		
		rname=new JTextField();
		rname.setBounds(160,50,90,20);
		cp.add(rname);
		
		lrcomm=new JLabel("Commmision Rate : ");
		lrcomm.setBounds(20,80,140,20);
		cp.add(lrcomm);
		
		rcomm=new JTextField();
		rcomm.setBounds(160,80,90,20);
		cp.add(rcomm);
		
		lrate=new JLabel("Rate ");
		lrate.setBounds(20,110,140,20);
		cp.add(lrate);
		
		String[] rates= {"7","7.5","8.4","9.2","10.5"};
		rate=new JComboBox<String>(rates);
		rate.setBounds(160,110,60,20);
		cp.add(rate);
		
		cusd=new JLabel("Customer Details");
		cusd.setBounds(20,145,140,20);
		cusd.setFont(new Font("Lucida Console", Font.BOLD, 12));
		cp.add(cusd);
		
		lcname=new JLabel("Customer Name: ");
		lcname.setBounds(20,180,140,20);
		cp.add(lcname);
		
		cname=new JTextField();
		cname.setBounds(160,180,90,20);
		cp.add(cname);
		
		lcnum=new JLabel("Customer Number: ");
		lcnum.setBounds(20,210,140,20);
		cp.add(lcnum);
		
		cnum=new JTextField();
		cnum.setBounds(160,210,90,20);
		cp.add(cnum);
		
		lclimit=new JLabel("Credit Limit: ");
		lclimit.setBounds(20,240,140,20);
		cp.add(lclimit);	
		
		climit=new JTextField();
		climit.setBounds(160,240,90,20);
		cp.add(climit);
		
		lcrnum=new JLabel("Rep Number: ");
		lcrnum.setBounds(20,270,140,20);
		cp.add(lcrnum);	
		
		crnum=new JTextField();
		crnum.setBounds(160,270,90,20);
		cp.add(crnum);
		
		sub=new JButton("Submit");
		sub.setBounds(160,310,90,20);
		cp.add(sub);
		sub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rnu=Integer.parseInt(rnum.getText());
				String rna=rname.getText();
				double ra=Double.parseDouble(rate.getItemAt(rate.getSelectedIndex()));
				int cra=Integer.parseInt(rcomm.getText());
				
				String cna=cname.getText();
				int cno=Integer.parseInt(cnum.getText());
				int cl=Integer.parseInt(climit.getText());
				int rno=Integer.parseInt(crnum.getText());
				
				
				try {
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
					System.out.println("Connection Succesful!");
					PreparedStatement ps1=conn.prepareStatement("INSERT INTO rep VALUES (?,?,?,?)");
					ps1.setInt(1, rnu);
					ps1.setString(2, rna);
					ps1.setInt(3, cra);
					ps1.setDouble(4, ra);
					int i=ps1.executeUpdate();
					
					if(i>0) System.out.println("inserted rep!");
					
					PreparedStatement ps2=conn.prepareStatement("INSERT INTO cus VALUES (?,?,?,?)");
					ps2.setString(1, cna);
					ps2.setInt(2, cno);
					ps2.setInt(3, cl);
					ps2.setInt(4, rno);
					i=ps2.executeUpdate();
					
					if(i>0) System.out.println("inserted cus!");
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					database_demo frame = new database_demo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

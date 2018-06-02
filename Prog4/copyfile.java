import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class copyfile {

	public static void main(String[] args) {

		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 300);
		f.setLayout(null);
		
		JLabel l1=new JLabel("SOURCE FILE : ");
		l1.setBounds(40,70 , 100, 40);
		f.add(l1);
		
		JTextField src=new JTextField();
		src.setBounds(140, 80, 100, 20);
		f.add(src);
		
		JLabel l2=new JLabel("DESTINATION FILE : ");
		l2.setBounds(260,70 , 140, 40);
		f.add(l2);
		
		JTextField des=new JTextField();
		des.setBounds(380, 80, 100, 20);
		f.add(des);
		
		JProgressBar prog=new JProgressBar(0,100);
		prog.setBounds(140,130, 340, 20);
		f.add(prog);
		prog.setVisible(false);
		
		JButton copy=new JButton("COPY");
		copy.setBounds(180,170, 80, 20);
		f.add(copy);
		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			prog.setString("COPYING");
			prog.setStringPainted(true);
			prog.setForeground(Color.BLUE);
			prog.setIndeterminate(true);
			prog.setVisible(true);
			String sr=src.getText();
			String de=des.getText();
			try {
				String content=new String(Files.readAllBytes(Paths.get(sr)));
				PrintWriter pw=new PrintWriter(de);
				pw.println(content);
				pw.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
				
			}
		});
		
		JButton stop=new JButton("STOP");
		stop.setBounds(320,170, 80, 20);
		f.add(stop);
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prog.setVisible(false);
				String msg ="";
				try {
					msg = new String(Files.readAllBytes(Paths.get(src.getText())));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(new JFrame(), msg);
				
			}
		});
		
		f.setVisible(true);
	}

}

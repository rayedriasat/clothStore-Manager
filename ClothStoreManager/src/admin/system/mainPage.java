package admin.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mainPage extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2701872842309756120L;

	mainPage(){
		
		getContentPane().setBackground(Color.WHITE);
		
		setTitle("Store Management System");
		JLabel heading = new JLabel("Store Management System");
		heading.setBounds(400, 10, 1200,60);
		heading.setFont(new Font("serif", Font.PLAIN, 40));
		add(heading);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(50,100,1050, 500);
		add(image);
		
		JButton b1 = new JButton("Click here to Continue");
		b1.setBounds(400, 400, 300, 70);
		b1.setBackground(Color.gray);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		image.add(b1);
		
		setSize(1170, 650);
		setLocation(200, 50);
		setLayout(null);
		setVisible(true);
	}
	
	public static void main(String args[]){

		new mainPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		new Login();
	}
}


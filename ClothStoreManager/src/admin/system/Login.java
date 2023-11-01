package admin.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame{
	private static final long serialVersionUID = -1067649712148231652L;

	Login(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		// Label for username
		JLabel usernameJLabel = new JLabel("Username");
		usernameJLabel.setBounds(40,20,100,30);
		add(usernameJLabel);
		
		//Username textfield
		JTextField usernameField = new JTextField();
		usernameField.setBounds(150, 20, 150, 30);
		add(usernameField);
		
		//Label for password
		JLabel passJLabel = new JLabel("Password");
		passJLabel.setBounds(40,70,100,30);
		add(passJLabel);
		
		// Password textfield
		JTextField passField = new JTextField();
		passField.setBounds(150, 70, 150, 30);
		add(passField);
		
		
		//Button 
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(150, 140, 150, 30);
		loginButton.setBackground(Color.gray);
		loginButton.setForeground(Color.WHITE);
		add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				HomePage h = new HomePage();
			}
		});
		setSize(600,300);
		setLocation(450,600);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Login();
	}
}

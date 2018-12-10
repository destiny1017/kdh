package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Home extends JFrame implements ActionListener {
	
	private JTextField textField;
	JButton btnLogin = new JButton("Login");
	JButton btnJoin = new JButton("Join");
	JPanel testPan = new JPanel();
	private JPasswordField passwordField;

	public Home() {
		
		setSize(1200,850);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 71));
		panel.setBounds(0, 0, 1184, 811);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255, 110));
		panel_1.setBounds(77, 0, 231, 811);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255, 110));
		panel_2.setBounds(875, 0, 231, 811);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255, 110));
		panel_3.setBounds(0, 57, 1184, 170);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Bookstore ERP System");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 48));
		lblNewLabel_2.setBounds(322, 39, 535, 101);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255, 190));
		panel_4.setBounds(355, 270, 475, 462);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(163, 158, 218, 37);
		panel_4.add(textField);
		textField.setColumns(10);
		
		btnLogin.setBounds(113, 328, 110, 44);
		panel_4.add(btnLogin);
		
		btnJoin.setBounds(255, 328, 110, 44);
		panel_4.add(btnJoin);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		lblNewLabel.setBounds(104, 157, 57, 37);
		panel_4.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW :");
		lblPw.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		lblPw.setBounds(104, 233, 57, 37);
		panel_4.add(lblPw);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
		lblNewLabel_1.setBounds(175, 45, 146, 58);
		panel_4.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 233, 218, 37);
		panel_4.add(passwordField);
		setVisible(true);
		
		btnJoin.addActionListener(this);
		btnLogin.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == btnLogin) {
			getContentPane().removeAll();
			getContentPane().add(new MainPan());
			revalidate();
			repaint();
		}
	}
	
	public static void main(String[] args) {
		new Home();
	}
}

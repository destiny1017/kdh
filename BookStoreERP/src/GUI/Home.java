package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import dataHandling.BookInput;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Home extends JFrame implements ActionListener {

	private JTextField textField;
	private JPasswordField passwordField;
	JButton btnLogin = new JButton("Login");
	JButton btnJoin = new JButton("Join");
	JPanel testPan = new JPanel();
	
	BookInput dao = new BookInput();

	public Home() {
		
		//UI�꽭�똿
		setBounds(200,100,1200,850);	
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 102));
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
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnLogin.doClick();
				}
			}
		});
		passwordField.setBounds(163, 233, 218, 37);
		panel_4.add(passwordField);
		setVisible(true);
		
		btnJoin.addActionListener(this);
		btnLogin.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//login/join 踰꾪듉 �겢由� �떆 �븸�뀡
		if(e.getSource() == btnLogin) {
			
			if(dao.checkId(textField.getText(), passwordField.getText())) {			
				getContentPane().removeAll();	//�봽�젅�엫 �궡�쓽 而댄룷�꼳�듃瑜� 紐⑤몢 �궘�젣
				getContentPane().add(new MainPan());	//硫붿씤硫붾돱 �뙣�꼸�쓣 異붽�
				revalidate();	//蹂�寃� �궡�슜�쑝濡� �깉濡쒓퀬移�
				repaint();
			}
			
		}else if(e.getSource() == btnJoin) {
			new BookMember();
		}
	}
	
	public static void main(String[] args) {
		new Home();
	}
	//qweqwe;;asdtest
	//testest222
	//testest333
}

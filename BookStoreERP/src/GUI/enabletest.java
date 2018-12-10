package GUI;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class enabletest extends JFrame {

	public enabletest() {
		setSize(200,200);
		JTextField jt = new JTextField(10);
		JTextField jt2 = new JTextField(10);
		setLayout(new FlowLayout());
		add(jt);
		add(jt2);
//		jt.setEnabled(false);
		jt.disable();
		jt.setBackground(new Color(230, 230, 230));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new enabletest();
	}

}

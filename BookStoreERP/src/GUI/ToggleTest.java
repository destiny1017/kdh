package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class ToggleTest extends JFrame{

	public ToggleTest() {
		setSize(300,300);
		setLayout(new FlowLayout());
		JToggleButton btn = new JToggleButton("뿅");
		add(btn);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(btn.isSelected()) {
					System.out.println("버튼 누름");
				}else if(!btn.isSelected()) {
					System.out.println("버튼 땜");
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ToggleTest();
	}

}

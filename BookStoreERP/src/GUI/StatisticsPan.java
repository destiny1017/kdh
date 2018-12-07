package GUI;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.*;

public class StatisticsPan extends JPanel implements ActionListener {
	
	
	JPanel panel = new JPanel();
	
	private StatisticsPan() {
		
		setBounds(0, 0, 1119, 606);
		setLayout(null);
		
		panel.setBackground(new Color(235, 235, 235));
		panel.setBounds(0, 0, 1119, 606);
		add(panel);
		panel.setLayout(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	private static StatisticsPan pan = new StatisticsPan();
	public static StatisticsPan getInstance() {
		return pan;
	}

}

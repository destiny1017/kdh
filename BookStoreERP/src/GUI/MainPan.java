package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPan extends JPanel implements ActionListener {

	JPanel panel = new JPanel();
	JButton btnOrder = new JButton("발주관리");
	JButton btnStock = new JButton("재고관리");
	JButton btnStatistics = new JButton("판매통계");
	
	public MainPan() {
		
		//ui세팅
		setSize(1184, 811);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 51, 71));
		panel_1.setBounds(0, 0, 1184, 811);
		add(panel_1);
		
		panel.setBackground(new Color(235, 235, 235));
		panel.setBounds(33, 172, 1119, 606);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255, 110));
		panel_2.setBounds(77, 0, 231, 811);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255, 110));
		panel_3.setBounds(875, 0, 231, 811);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(255, 255, 255, 0));
		panel_4.setBounds(0, 0, 1184, 155);
		panel_1.add(panel_4);
		
		JLabel label = new JLabel("Bookstore ERP System");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Arial", Font.BOLD, 44));
		label.setBounds(340, 10, 500, 54);
		panel_4.add(label);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 74, 1184, 81);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(255, 255, 255, 110));
		
		btnOrder.setBackground(new Color(255, 255, 255));
		btnOrder.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btnOrder.setBounds(0, 73, 231, 83);
		btnOrder.setBorderPainted(false);
		btnOrder.setFocusPainted(false);
		panel_2.add(btnOrder);
		
		btnStock.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btnStock.setBackground(new Color(255, 255, 255));
		btnStock.setBounds(472, 0, 231, 83);
		btnStock.setBorderPainted(false);
		btnStock.setFocusPainted(false);
		panel_5.add(btnStock);
		
		btnStatistics.setBackground(new Color(255, 255, 255));
		btnStatistics.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btnStatistics.setBounds(0, 75, 231, 81);
		btnStatistics.setBorderPainted(false);
		btnStatistics.setFocusPainted(false);
		panel_3.add(btnStatistics);
		
		btnOrder.addActionListener(this);
		btnStock.addActionListener(this);
		btnStatistics.addActionListener(this);
		
	}
	StockPan stockPan = StockPan.getInstance();
	StatisticsPan statisticsPan = StatisticsPan.getInstance();
	OrderPan orderPan = OrderPan.getInstance();

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//각 메뉴 클릭 시 액션처리
		if(e.getSource() == btnOrder) {
			panel.removeAll();
			panel.add(orderPan);
			panel.revalidate();
			panel.repaint();
			
		}else if(e.getSource() == btnStock) {
			panel.removeAll();
			panel.add(stockPan);
			panel.revalidate();
			panel.repaint();
			
		}else if(e.getSource() == btnStatistics) {
			panel.removeAll();
			panel.add(statisticsPan);
			panel.revalidate();
			panel.repaint();
		}
	}

}

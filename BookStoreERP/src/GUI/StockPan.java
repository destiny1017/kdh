package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import insert.DB.DataDAO;
import insert.DB.DataDTO;
import javax.swing.table.DefaultTableModel;

public class StockPan extends JPanel implements ActionListener {

	JButton btnOrder = new JButton("발주관리");
	JButton btnStock = new JButton("재고관리");
	JButton btnStatistics = new JButton("판매통계");
	private JTextField textField;
	
	public StockPan() {
		
		setSize(1184, 811);
		setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 1184, 155);
		add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(255, 255, 255, 110));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 74, 1184, 81);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(255, 255, 255, 190));
		
		btnStock.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btnStock.setBackground(new Color(255, 255, 255));
		btnStock.setBounds(472, 0, 231, 83);
		btnStock.setBorderPainted(false);
		btnStock.setFocusPainted(false);
		panel_5.add(btnStock);
		panel_5.add(btnOrder);
		
		btnOrder.setBackground(new Color(255, 255, 255));
		btnOrder.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btnOrder.setBounds(77, 0, 231, 83);
		btnOrder.setBorderPainted(false);
		btnOrder.setFocusPainted(false);
		btnStatistics.setBounds(874, 1, 231, 81);
		panel_5.add(btnStatistics);

		btnStatistics.setBackground(new Color(255, 255, 255));
		btnStatistics.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		btnStatistics.setBorderPainted(false);
		btnStatistics.setFocusPainted(false);
		
		JLabel label = new JLabel("Bookstore ERP System");
		label.setBounds(342, 10, 493, 54);
		panel_4.add(label);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Bell MT", Font.BOLD, 48));

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 51, 71));
		panel_1.setBounds(0, 0, 1184, 811);
		add(panel_1);
		
		JButton btnWarehousing = new JButton("입고관리");
		btnWarehousing.setFocusPainted(false);
		btnWarehousing.setBorderPainted(false);
		btnWarehousing.setBounds(33, 166, 97, 23);
		panel_1.add(btnWarehousing);
		
		JButton btnBack = new JButton("반품관리");
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setBounds(54, 166, 97, 23);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(235, 235, 235));
		panel.setBounds(33, 190, 1119, 588);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(235, 235, 235));
		panel_6.setBounds(12, 5, 1095, 23);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_1 = new JLabel(" 도서 검색 :");
		label_1.setBounds(0, 0, 67, 22);
		panel_6.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(73, 0, 147, 22);
		panel_6.add(textField);
		textField.setColumns(10);
		
		//입고패널
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(12, 32, 1095, 546);
		panel.add(panel_7);
		
		DataDAO dao = new DataDAO();
		ArrayList<DataDTO> books = dao.showStock();
		String[] column = {"ISBN", "분류", "제목", "출판사", "저자", "가격", "재고"};
		String[][] line = new String[books.size()][7];
		
		for (int i = 0; i < 20; i++) {		
			line[i][0] = books.get(i).getIsbn();
			line[i][1] = books.get(i).getClassification();
			line[i][2] = books.get(i).getTitle();
			line[i][3] = books.get(i).getPublisher();
			line[i][4] = books.get(i).getWriter();
			line[i][5] = "" + books.get(i).getPrice() + "원";
			line[i][6] = "" + books.get(i).getStock();
		}
		panel_7.setLayout(null);
		
		JTable table = new JTable(line, column);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setMaxWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setMaxWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 1095, 546);
		panel_7.add(scroll);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255, 110));
		panel_2.setBounds(77, 0, 231, 811);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		panel_2.add(btnBack);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255, 110));
		panel_3.setBounds(875, 0, 231, 811);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnOrder) {
			
		}else if(e.getSource() == btnStock) {
			
		}else if(e.getSource() == btnStatistics) {
			
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1200, 850);
		f.getContentPane().add(new StockPan());
		f.setVisible(true);
	}
}

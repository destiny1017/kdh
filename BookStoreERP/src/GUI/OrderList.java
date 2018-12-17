package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import dataHandling.BooksOrderDTO;
import dataHandling.OrderDAO;

import javax.swing.JLabel;

public class OrderList extends JFrame implements ActionListener {

	OrderDAO dao = new OrderDAO();
	JTable table = null;
	JScrollPane scroll = null;
	
	JPanel panel = new JPanel();
	JPanel orderListPan = new JPanel();
	JPanel orderDetailPan = new JPanel();
	
	ArrayList<BooksOrderDTO> books = new ArrayList<>();
	
	public OrderList() {
		
		setSize(990,562);
		getContentPane().setLayout(null);
		
		panel.setBounds(12, 10, 950, 502);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		orderListPan.setBounds(12, 42, 300, 424);
		panel.add(orderListPan);
		orderListPan.setLayout(null);
		
		orderDetailPan.setBounds(324, 42, 614, 424);
		panel.add(orderDetailPan);
		orderDetailPan.setLayout(null);
		
		JPanel lbPan1 = new JPanel();
		lbPan1.setBounds(12, 10, 300, 27);
		panel.add(lbPan1);
		lbPan1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("발주 리스트", SwingConstants.CENTER);
		lblNewLabel.setBounds(89, 0, 98, 25);
		lbPan1.add(lblNewLabel);
		
		JPanel lbPan2 = new JPanel();
		lbPan2.setBounds(324, 10, 614, 27);
		panel.add(lbPan2);
		lbPan2.setLayout(null);
		
		JLabel label = new JLabel("발주 리스트 상세", SwingConstants.CENTER);
		label.setBounds(277, 0, 106, 25);
		lbPan2.add(label);
		setVisible(true);
		
		setList();
		
//		table.addRowSelectionInterval(index0, index1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public void setList() {

//		dao.booksOrderList();
		books = dao.booksOrderList();
		String[] column = { "No", "출판사", "date"};
		Object[][] line = new Object[books.size()][3];

		for (int i = 0; i < books.size(); i++) {
			line[i][0] = books.get(i).getNo();
			line[i][1] = books.get(i).getPublisher();
			line[i][2] = books.get(i).getTs();

		}
		orderListPan.setLayout(null);

		table = new JTable(line, column);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setMaxWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setMaxWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);

		scroll = new JScrollPane(table);

		scroll.setBounds(0, 0, 300, 424);

		orderListPan.removeAll();
		orderListPan.add(scroll);
		orderListPan.revalidate();
		orderListPan.repaint();

	}
	
	public static void main(String[] args) {
		new OrderList();
	}
}

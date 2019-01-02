package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dataHandling.BooksOrderDTO;
import dataHandling.DetailDTO;
import dataHandling.OrderDAO;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class OrderList extends JFrame implements ActionListener, MouseListener {

	OrderDAO dao = new OrderDAO();
	JTable table = null;
	JTable tableD = null;
	JScrollPane scroll = null;
	JScrollPane scrollD = null;
	JButton delDetailBtn = new JButton("삭제");
	JButton modDetailBtn = new JButton("수정");
	
	JPanel panel = new JPanel();
	JPanel orderListPan = new JPanel();
	JPanel orderDetailPan = new JPanel();
	
	ArrayList<BooksOrderDTO> books = new ArrayList<>();
	ArrayList<DetailDTO> booksD = new ArrayList<>();
	private final JButton whBtn = new JButton("입고");
	private final JButton delOrderBtn = new JButton("삭제");
	
	public OrderList() {
		
		setBounds(400,200,990,562);
		getContentPane().setLayout(null);
		panel.setBackground(new Color(204, 204, 204));
		
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
		lbPan1.setForeground(new Color(0, 0, 0));
		lbPan1.setBackground(new Color(0, 0, 0));
		lbPan1.setBounds(12, 10, 300, 27);
		panel.add(lbPan1);
		lbPan1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("발주 리스트", SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(100, 0, 98, 25);
		lbPan1.add(lblNewLabel);
		
		JPanel lbPan2 = new JPanel();
		lbPan2.setBackground(new Color(0, 0, 0));
		lbPan2.setBounds(324, 10, 614, 27);
		panel.add(lbPan2);
		lbPan2.setLayout(null);
		
		JLabel label = new JLabel("발주 리스트 상세", SwingConstants.CENTER);
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(277, 0, 106, 25);
		lbPan2.add(label);
		setVisible(true);
		
		setOrderList();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		delDetailBtn.setBounds(841, 476, 97, 23);
		panel.add(delDetailBtn);
		
		modDetailBtn.setBounds(742, 476, 97, 23);
		panel.add(modDetailBtn);
		whBtn.setBounds(12, 476, 97, 23);
		
		panel.add(whBtn);
		delOrderBtn.setBounds(111, 476, 97, 23);
		
		panel.add(delOrderBtn);
		table.addMouseListener(this);
		
		delDetailBtn.addActionListener(this);
		modDetailBtn.addActionListener(this);
		whBtn.addActionListener(this);
		delOrderBtn.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//삭제버튼
		if(e.getSource() == delDetailBtn) {
			int row[] = tableD.getSelectedRows();
			int row2 = table.getSelectedRow();
			for (int i = 0; i < row.length; i++) {			
				String isbn = (String) tableD.getValueAt(row[i], 0);
				int no = (int) table.getValueAt(row2, 0);
				dao.delete(isbn, no);
			}
			booksD = dao.detailList((int) table.getValueAt(row2, 0));
			setDetailList();	
		//수정버튼
		}else if(e.getSource() == modDetailBtn) {
			int row[] = tableD.getSelectedRows();
			int row2 = table.getSelectedRow();
			for (int i = 0; i < row.length; i++) {
				String isbn = (String) tableD.getValueAt(row[i], 0);
				System.out.println(tableD.getValueAt(row[i], 4));
				int quantity = Integer.parseInt((String) tableD.getValueAt(row[i], 4));
				int no = (int) table.getValueAt(row2, 0);
				dao.modify(isbn, quantity, no);		
			}
			booksD = dao.detailList((int) table.getValueAt(row2, 0));
			setDetailList();
		//발주항목 삭제버튼
		}else if(e.getSource() == delOrderBtn) {
			int row = table.getSelectedRow();
			int no = (int) table.getValueAt(row, 0);
			dao.deleteOrder(no);
			setOrderList();
			booksD = dao.detailList(1);
			setDetailList();
		//입고버튼
		}else if(e.getSource() == whBtn) {
			
			int row = tableD.getRowCount();
			for (int i = 0; i < row; i++) {
				String isbn = (String) tableD.getValueAt(i, 0);
				int quantity = Integer.parseInt("" + tableD.getValueAt(i, 4));
				dao.insertStock(isbn, quantity);
			}
			delOrderBtn.doClick();
		}
	}
	
	public void setDetailList() {

//		booksD = dao.detailList();
		String[] column = { "ISBN", "분류", "제목", "저자", "수량"};
		Object[][] line = new Object[booksD.size()][5];

		int lineCount = 0;
		for (int i = 0; i < booksD.size(); i++) {			
				line[lineCount][0] = booksD.get(i).getIsbn();
				line[lineCount][1] = booksD.get(i).getClassification();
				line[lineCount][2] = booksD.get(i).getTitle();
				line[lineCount][3] = booksD.get(i).getWriter();
				line[lineCount][4] = booksD.get(i).getQuantity();
				lineCount++;
		}
		
		orderDetailPan.setLayout(null);

		tableD = new JTable(line, column);
//		table.getColumnModel().getColumn(0).setPreferredWidth(10);
//		table.getColumnModel().getColumn(1).setPreferredWidth(90);
//		table.getColumnModel().getColumn(2).setPreferredWidth(110);

		scrollD = new JScrollPane(tableD);

		scrollD.setBounds(0, 0, 614, 424);

		orderDetailPan.removeAll();
		orderDetailPan.add(scrollD);
		orderDetailPan.revalidate();
		orderDetailPan.repaint();

	}
	
	public void setOrderList() {

		books = dao.booksOrderList();
		String[] column = { "No", "출판사", "date"};
		Object[][] line = new Object[books.size()][3];

		for (int i = 0; i < books.size(); i++) {
			line[i][0] = books.get(i).getNo();
			line[i][1] = books.get(i).getPublisher();
			line[i][2] = books.get(i).getTs();

		}
		orderListPan.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(line, column) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);

		scroll = new JScrollPane(table);

		scroll.setBounds(0, 0, 300, 424);

		orderListPan.removeAll();
		orderListPan.add(scroll);
		orderListPan.revalidate();
		orderListPan.repaint();
		table.addMouseListener(this);

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		booksD = dao.detailList((int) table.getValueAt(row, 0));
		setDetailList();
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}

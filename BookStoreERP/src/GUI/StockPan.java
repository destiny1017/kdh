package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import insert.DB.DataDAO;
import insert.DB.DataDTO;

public class StockPan extends JPanel implements ActionListener {

	JButton btnOrder = new JButton("발주관리");
	JButton btnStock = new JButton("재고관리");
	JButton btnStatistics = new JButton("판매통계");
	JButton searchBtn = new JButton("검색");
	JButton whBtn = new JButton("입고");
	JButton removeBtn = new JButton("초기화");
	JButton addBtn = new JButton("도서등록");
	JButton btnWarehousing = new JButton("입고관리");
	JButton btnBack = new JButton("반품관리");
	
	DataDAO dao = new DataDAO();
	JPanel panel_7 = new JPanel();
	JTable table = null;
	JScrollPane scroll = null;
	private JTextField searchField;
	
	ArrayList<DataDTO> books = new ArrayList<>();
	ArrayList<String> insertBooks = new ArrayList<>();
	Object[][] line;
	
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
		
		btnWarehousing.setFocusPainted(false);
		btnWarehousing.setBorderPainted(false);
		btnWarehousing.setBounds(33, 166, 97, 23);
		panel_1.add(btnWarehousing);
		
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
		
		searchField = new JTextField();
		searchField.setBounds(73, 0, 147, 22);
		panel_6.add(searchField);
		searchField.setColumns(10);
		
		searchBtn.setBounds(225, 0, 72, 22);
		panel_6.add(searchBtn);
		
		//입고패널
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(12, 32, 1095, 517);
		panel.add(panel_7);
		
		//리스트 출력
		setList();
		
		addBtn.setBounds(814, 555, 97, 23);
		panel.add(addBtn);
		whBtn.setBounds(1010, 555, 97, 23);
		panel.add(whBtn);
		removeBtn.setBounds(716, 555, 97, 23);
		panel.add(removeBtn);
		
		JButton btnReturn = new JButton("반품");
		btnReturn.setBounds(912, 555, 97, 23);
		panel.add(btnReturn);
		addBtn.addActionListener(this);
		
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
		
		searchBtn.addActionListener(this);
		btnBack.addActionListener(this);
		addBtn.addActionListener(this);
		whBtn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnOrder) {
			
		}else if(e.getSource() == btnStock) {
			
		}else if(e.getSource() == btnStatistics) {
			
		}else if(e.getActionCommand() == "검색") {
			
			setList();
			
		}else if(e.getActionCommand().equals("입고")) {

			System.out.println("입고누름");
			
			int num = 0;
			for (int i = 0; i < table.getRowCount(); i++) {
				if(!table.getValueAt(i, 7).equals("")) {
					String info = (String) table.getValueAt(i, 0) + "/" + (String) table.getValueAt(i, 6) + "/" +
							(String) table.getValueAt(i, 7);
					dao.insertStock(info);
					books = dao.showStock();
					num++;
				}
			}
			if(num>0) {
				JOptionPane.showMessageDialog(null, "정상적으로 입고되었습니다.");
				setList();
			}
		}else if(e.getActionCommand().equals("도서등록")) {
			
			new InsertBook();
			
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1200, 850);
		f.getContentPane().add(new StockPan());
		f.setVisible(true);
	}
	
	public void setList() {
		
		dao.showStock();
		books = dao.searchBook(searchField.getText());
		String[] column = {"ISBN", "분류", "제목", "출판사", "저자", "가격", "재고","입고수량"};
		Object[][] line = new Object[books.size()][8];
		
		for (int i = 0; i < books.size(); i++) {		
			line[i][0] = books.get(i).getIsbn();
			line[i][1] = books.get(i).getClassification();
			line[i][2] = books.get(i).getTitle();
			line[i][3] = books.get(i).getPublisher();
			line[i][4] = books.get(i).getWriter();
			line[i][5] = "" + books.get(i).getPrice() + "원";
			line[i][6] = "" + books.get(i).getStock();
			line[i][7] = "";
		}
		panel_7.setLayout(null);
		
		table = new JTable(line, column);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setMaxWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setMaxWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		scroll = new JScrollPane(table);
		
		scroll.setBounds(0, 0, 1095, 515);
		
		panel_7.removeAll();
		panel_7.add(scroll);
		
		panel_7.revalidate();
		panel_7.repaint();
		
	}
	
//	class MyTableCellRenderer extends DefaultTableCellRenderer {
//
//
//	    @Override
//
//	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//
//	    Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//
//	    if (!isSelected) {
//
//	    if (row == 7) {
//	        cell.setBackground(new Color(0, 0, 100));
//	    } else {
//	        cell.setBackground(Global.convert_Color());
//	    }
//
//	    }
//
//	    return cell;
//
//	    }
//
//	}
	

	
	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		JSpinner sp;

		public TableCell() {	
			sp = new JSpinner();
		}

		public Object getCellEditorValue() {
			return null;
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return sp;
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			return sp;
		}
	}
}

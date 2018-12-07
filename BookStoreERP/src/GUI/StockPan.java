package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import dataHandling.StockDAO;
import dataHandling.StockDTO;

public class StockPan extends JPanel implements ActionListener {

	JButton searchBtn = new JButton("검색");
	JButton whBtn = new JButton("입고");
	JButton btnReturn = new JButton("반품");
	JButton removeBtn = new JButton("도서삭제");
	JButton addBtn = new JButton("도서등록");
	JButton btnSearchOrder = new JButton("발주목록에서 검색");
	JRadioButton[] rdbtnNewRadioButton = new JRadioButton[5];
	ButtonGroup group = new ButtonGroup();
	
	StockDAO dao = new StockDAO();
	JPanel panel_7 = new JPanel();
	JTable table = null;
	JScrollPane scroll = null;
	JTextField searchField;
	
	ArrayList<StockDTO> books = new ArrayList<>();
	ArrayList<String> insertBooks = new ArrayList<>();
	Object[][] line;
	
	String select = "제목";
	
	private StockPan() {
		
		setBounds(0, 0, 1119, 606);
		setLayout(null);

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(235, 235, 235));
		panel.setBounds(0, 0, 1119, 606);
		add(panel);
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
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER) {
					searchBtn.doClick();
				}
			}
		});
		searchField.setBounds(73, 0, 147, 22);
		panel_6.add(searchField);
		searchField.setColumns(10);
		searchBtn.setFont(new Font("돋움", Font.BOLD, 12));
		
		searchBtn.setBounds(225, 0, 72, 22);
		panel_6.add(searchBtn);
		
		String[] clf = {"제목", "ISBN", "출판사", "저자", "분류"};
		for (int i = 0; i < rdbtnNewRadioButton.length; i++) {
			rdbtnNewRadioButton[i] = new JRadioButton(clf[i]);
			rdbtnNewRadioButton[i].setBounds((310 + i*70), 0, 70, 22);
			rdbtnNewRadioButton[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			group.add(rdbtnNewRadioButton[i]);
			panel_6.add(rdbtnNewRadioButton[i]);
		}
		rdbtnNewRadioButton[0].setSelected(true);
		
		//입고패널
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(12, 32, 1095, 537);
		panel.add(panel_7);
		
		//리스트 출력
		setList();
		
		addBtn.setBounds(814, 573, 97, 23);
		panel.add(addBtn);
		whBtn.setBounds(1010, 573, 97, 23);
		panel.add(whBtn);
		removeBtn.setFont(new Font("돋움", Font.BOLD, 12));
		removeBtn.setBounds(716, 573, 97, 23);
		panel.add(removeBtn);
		
		btnReturn.setBounds(912, 573, 97, 23);
		panel.add(btnReturn);
		btnSearchOrder.setFont(new Font("돋움체", Font.BOLD, 12));
		btnSearchOrder.setBounds(551, 573, 163, 23);
		
		panel.add(btnSearchOrder);
		
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);
		btnReturn.addActionListener(this);
		whBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "검색") {
			
			Enumeration<AbstractButton> btns = group.getElements();
			while(btns.hasMoreElements()) {
				AbstractButton btn = btns.nextElement();
				if(btn.isSelected()) {
					select = btn.getText();
				}
			}
			setList();
			select = "제목";
		}else if(e.getActionCommand().equals("입고")) {

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
		}else if(e.getActionCommand().equals("반품")){
			
			int num = 0;
			for (int i = 0; i < table.getRowCount(); i++) {
				if(!table.getValueAt(i, 7).equals("")) {
					int sum = Integer.parseInt((String)table.getValueAt(i, 7));
					String info = (String) table.getValueAt(i, 0) + "/" + (String) table.getValueAt(i, 6) + "/" +
							(sum-sum*2);
					dao.insertStock(info);
					books = dao.showStock();
					num++;
				}
			}
			if(num>0) {
				JOptionPane.showMessageDialog(null, "정상적으로 반품되었습니다.");
				setList();
			}
			
		}else if(e.getActionCommand().equals("도서등록")) {		
			new InsertBook();
		}else if(e.getActionCommand().equals("도서삭제")) {
			int[] selected = table.getSelectedRows();
			int del = JOptionPane.showConfirmDialog(null, selected.length + "개 항목을 삭제하시겠습니까?");
			if(del == 0) {				
				for (int i = 0; i < selected.length; i++) {		
					dao.deleteBook((String) table.getValueAt(selected[i], 0));
				}
				JOptionPane.showMessageDialog(null, "정상적으로 삭제되었습니다.");
				setList();
			}
		}
	}
	
	
	public void setList() {
		
		dao.showStock();
		books = dao.searchBook(select, searchField.getText());
		String[] column = {"ISBN", "분류", "제목", "출판사", "저자", "가격", "재고","입고/반품수량"};
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
		
		scroll.setBounds(0, 0, 1095, 537);
		
		panel_7.removeAll();
		panel_7.add(scroll);
		
		panel_7.revalidate();
		panel_7.repaint();
		
	}
	
	private static StockPan pan = new StockPan();
	public static StockPan getInstance() {
		return pan;
	}

}

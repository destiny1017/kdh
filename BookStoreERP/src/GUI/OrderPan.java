package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import dataHandling.OrderDAO;
import dataHandling.OrderDTO;
import dataHandling.StatisticsDAO;
import dataHandling.StatisticsDTO;
import dataHandling.StockDAO;
import dataHandling.StockDTO;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class OrderPan extends JPanel implements ActionListener {

	JPanel panel = new JPanel();
	JPanel listPan = new JPanel();
	JPanel orderListPan = new JPanel();
	JPanel panel_1 = new JPanel();
	JButton searchBtn = new JButton("검색");
	JButton orderListBtn = new JButton("발주리스트");

	JTable table = null;
	JScrollPane scroll = null;
	JTable orderTable = null;
	JScrollPane orderScroll = null;
	StockDAO dao = new StockDAO();
	OrderDAO orderDao = new OrderDAO();
	StatisticsDAO sttsDao = new StatisticsDAO();
	ArrayList<StockDTO> books = new ArrayList<>();
	ArrayList<StockDTO> orderBooks = new ArrayList<>();
	ArrayList<StatisticsDTO> salesBooks = new ArrayList<>();
	String select = "제목";
	
	DecimalFormat df = new DecimalFormat("00");
	Calendar cal = Calendar.getInstance();
	String today = "" + cal.get(cal.YEAR) + "-" + (cal.get(cal.MONTH) + 1) + "-" + df.format(cal.get(cal.DAY_OF_MONTH));

	JTextField searchField;
	JRadioButton[] rdbtnNewRadioButton = new JRadioButton[5];
	ButtonGroup group = new ButtonGroup();

	private OrderPan() {

		setBounds(0, 0, 1119, 606);
		setLayout(null);

		panel.setBounds(0, 0, 1119, 606);
		add(panel);
		panel.setLayout(null);

		listPan.setBounds(12, 38, 613, 522);
		panel.add(listPan);
		listPan.setLayout(null);

		orderListPan.setBounds(688, 38, 419, 522);
		panel.add(orderListPan);
		orderListPan.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("발주할 도서 목록");
		lblNewLabel_1.setBounds(688, 10, 101, 22);
		panel.add(lblNewLabel_1);

		panel_1.setBounds(12, 10, 1095, 22);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("도서검색", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 0, 66, 22);
		panel_1.add(lblNewLabel);

		searchField = new JTextField();
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBtn.doClick();
				}
			}
		});
		searchField.setBounds(65, 0, 128, 22);
		panel_1.add(searchField);
		searchField.setColumns(10);

		searchBtn.setBounds(199, 0, 66, 22);
		panel_1.add(searchBtn);
		resetBtn.setBounds(990, 0, 105, 22);
		
		panel_1.add(resetBtn);
		addOrderBtn.setBounds(632, 238, 44, 44);

		panel.add(addOrderBtn);
		outBtn.setBounds(632, 295, 44, 44);

		panel.add(outBtn);
		orderBtn.setBounds(1019, 570, 88, 26);

		panel.add(orderBtn);
		
		orderListBtn.setBounds(914, 570, 101, 26);
		panel.add(orderListBtn);
		SaleOrderBtn.setBounds(809, 570, 101, 26);
		
		panel.add(SaleOrderBtn);
		
		textField = new JTextField();
		textField.setBounds(688, 570, 116, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("판매량 발주");
		lblNewLabel_2.setBounds(612, 575, 72, 15);
		panel.add(lblNewLabel_2);

		String[] clf = { "제목", "ISBN", "출판사", "저자", "분류" };
		for (int i = 0; i < rdbtnNewRadioButton.length; i++) {
			rdbtnNewRadioButton[i] = new JRadioButton(clf[i]);
			rdbtnNewRadioButton[i].setBounds((270 + i * 70), 0, 70, 22);
			rdbtnNewRadioButton[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			group.add(rdbtnNewRadioButton[i]);
			panel_1.add(rdbtnNewRadioButton[i]);
		}
		rdbtnNewRadioButton[0].setSelected(true);

		setList();
		setOrderList();

		searchBtn.addActionListener(this);
		addOrderBtn.addActionListener(this);
		outBtn.addActionListener(this);
		orderBtn.addActionListener(this);
		orderListBtn.addActionListener(this);
		SaleOrderBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		
		System.out.println(today);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == searchBtn) {

			Enumeration<AbstractButton> btns = group.getElements();
			while (btns.hasMoreElements()) {
				AbstractButton btn = btns.nextElement();
				if (btn.isSelected()) {
					select = btn.getText();
				}
			}
			// 리스트 출력
			setList();
			select = "제목";

		} else if (e.getSource() == addOrderBtn) {

			// 선택된 테이블의 행 인덱스 배열 생성
			int[] selected = table.getSelectedRows();
			// selected 배열 각 행에 해당하는 데이터 삭제반복
			for (int i = 0; i < selected.length; i++) {
				int exist = 0;
				String isbn = (String) table.getValueAt(selected[i], 0);
				String title = (String) table.getValueAt(selected[i], 2);
				String publisher = (String) table.getValueAt(selected[i], 3);
				for (int j = 0; j < orderBooks.size(); j++) {
					if (orderBooks.get(j).getIsbn().equals(isbn)) {
						exist = 1;
					}
				}
				if (exist != 1)
					orderBooks.add(new StockDTO(isbn, title, publisher));
			}
			setOrderList();

		} else if (e.getSource() == outBtn) {

			int[] selected = orderTable.getSelectedRows();

			// selected 배열 각 행에 해당하는 데이터 삭제반복
			for (int i = selected.length - 1; i >= 0; i--) {
				orderBooks.remove(selected[i]);
			}
			setOrderList();
		} else if (e.getSource() == orderBtn) {

			// selected 배열 각 행에 해당하는 데이터 삭제반복
			for (int i = 0; i < orderTable.getRowCount(); i++) {
				System.out.println(i + "번째");
				String isbn = (String) orderTable.getValueAt(i, 0);
				String publisher = (String) orderTable.getValueAt(i, 2);
				String tempQuantity = "" + orderTable.getValueAt(i, 3);
				int quantity = tempQuantity.equals("") ? 0 : Integer.parseInt(tempQuantity);
				if (quantity != 0) orderDao.insert(new OrderDTO(isbn, quantity), today, publisher);
			}
			JOptionPane.showMessageDialog(null, "발주가 정상적으로 처리되었습니다.");
			orderBooks.clear();
			setOrderList();
		} else if(e.getSource() == orderListBtn) {
			new OrderList();
		} else if(e.getSource() == SaleOrderBtn) {
			setSalesOrderList();
		} else if(e.getSource() == resetBtn) {
			orderBooks = new ArrayList<>();
			setOrderList();
		}
	}

	// 변동 사항 있을 때마다 테이블 리스트를 다시 세팅(새로고침)해주는 메서드
	public void setList() {

		dao.showStock();
		books = dao.searchBook(select, searchField.getText());
		String[] column = { "ISBN", "분류", "제목", "출판사", "저자", "재고" };
		Object[][] line = new Object[books.size()][6];

		for (int i = 0; i < books.size(); i++) {
			line[i][0] = books.get(i).getIsbn();
			line[i][1] = books.get(i).getClassification();
			line[i][2] = books.get(i).getTitle();
			line[i][3] = books.get(i).getPublisher();
			line[i][4] = books.get(i).getWriter();
			line[i][5] = "" + books.get(i).getStock();
		}
		listPan.setLayout(null);

		table = new JTable(line, column);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setMaxWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setMaxWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		scroll = new JScrollPane(table);

		scroll.setBounds(0, 0, 613, 522);

		listPan.removeAll();
		listPan.add(scroll);
		listPan.revalidate();
		listPan.repaint();

	}

	public void setSalesOrderList() {
		
		salesBooks = sttsDao.fileLoad(textField.getText());
		String[] column = { "ISBN", "제목", "출판사", "발주수량" };
		Object[][] line = new Object[salesBooks.size()][4];

		for (int i = 0; i < salesBooks.size(); i++) {
			line[i][0] = salesBooks.get(i).getIsbn();
			line[i][1] = salesBooks.get(i).getTitle();
			line[i][2] = salesBooks.get(i).getPublisher();
			line[i][3] = salesBooks.get(i).getSalesVolume();
		}
		orderListPan.setLayout(null);

		orderTable = new JTable(line, column);
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		orderTable.getColumnModel().getColumn(1).setMaxWidth(150);
		orderTable.getColumnModel().getColumn(2).setPreferredWidth(30);
		orderTable.getColumnModel().getColumn(3).setPreferredWidth(20);
		orderScroll = new JScrollPane(orderTable);

		orderScroll.setBounds(0, 0, 419, 522);

		orderListPan.removeAll();
		orderListPan.add(orderScroll);
		orderListPan.revalidate();
		orderListPan.repaint();

	}
	
	public void setOrderList() {

		String[] column = { "ISBN", "제목", "출판사", "발주수량" };
		Object[][] line = new Object[orderBooks.size()][4];

		for (int i = 0; i < orderBooks.size(); i++) {
			line[i][0] = orderBooks.get(i).getIsbn();
			line[i][1] = orderBooks.get(i).getTitle();
			line[i][2] = orderBooks.get(i).getPublisher();
			line[i][3] = "";
		}
		orderListPan.setLayout(null);

		orderTable = new JTable(line, column);
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		orderTable.getColumnModel().getColumn(1).setMaxWidth(150);
		orderTable.getColumnModel().getColumn(2).setPreferredWidth(30);
		orderTable.getColumnModel().getColumn(3).setPreferredWidth(20);
		orderScroll = new JScrollPane(orderTable);

		orderScroll.setBounds(0, 0, 419, 522);

		orderListPan.removeAll();
		orderListPan.add(orderScroll);
		orderListPan.revalidate();
		orderListPan.repaint();

	}

	private static OrderPan pan = new OrderPan();
	private final JButton addOrderBtn = new JButton(">");
	private final JButton outBtn = new JButton("<");
	private final JButton orderBtn = new JButton("발주");
	private final JButton SaleOrderBtn = new JButton("목록 추가");
	private JTextField textField;
	private final JButton resetBtn = new JButton("목록 초기화");

	public static OrderPan getInstance() {
		return pan;
	}
}

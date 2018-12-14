package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import dataHandling.StatisticsDAO;
import dataHandling.StatisticsDTO;
import javax.swing.ImageIcon;

public class StatisticsPan extends JPanel implements ActionListener {

	JPanel panel = new JPanel();
	JPanel panel_5 = new JPanel();
	JScrollPane scroll = null;
	JTable table = null;

	JLabel totalLb = new JLabel("");
	JLabel societyLb = new JLabel("");
	JLabel economyLb = new JLabel("");
	JLabel scienceLb = new JLabel("");
	JLabel examinationLb = new JLabel("");
	JLabel artLb = new JLabel("");
	JLabel historyLb = new JLabel("");
	JLabel dayLb1 = new JLabel("0000년00월00일");
	JLabel dayLb2 = new JLabel("0000년00월00일");
	JTextField choiceDayLb;
	JTextField periodLb1;
	JTextField periodLb2;

	JRadioButton todayRdbtn = new JRadioButton("당일 매출");
	JRadioButton choiceRdbtn = new JRadioButton("날짜 선택");
	JRadioButton periodRdbtn = new JRadioButton("기간 지정");
	JRadioButton monthRdbtn = new JRadioButton("월별");
	ButtonGroup group = new ButtonGroup();
	JButton confirmBtn = new JButton("확인");
	JToggleButton tgBtn = new JToggleButton("");

	StatisticsDAO file = new StatisticsDAO();

	Calendar cal = Calendar.getInstance();
	DecimalFormat f1 = new DecimalFormat("###,###,###,###원");
	DecimalFormat dayF = new DecimalFormat("00");
	String today = "" + cal.get(cal.YEAR) + (cal.get(cal.MONTH) + 1) + dayF.format(cal.get(cal.DAY_OF_MONTH));
	String[] yComboModel = new String[6];
	String[] mComboModel = new String[12];
	JComboBox<String> monthCombo = new JComboBox<String>();
	JComboBox<String> yearCombo = new JComboBox<String>();

	ArrayList<StatisticsDTO> sales;
	HashMap<String, Integer> clfSales;
	HashMap<String, Integer> previousClfSales;

	private StatisticsPan() {

		// ui세팅
		setBounds(0, 0, 1119, 606);
		setLayout(null);

		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 1119, 606);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 8, 214, 586);
		panel_1.setLayout(null);
		panel.add(panel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_3.setBackground(new Color(255, 250, 245));
		panel_3.setBounds(0, 0, 214, 48);
		panel_3.setLayout(null);
		panel_1.add(panel_3);

		dayLb1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		dayLb2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		dayLb1.setBounds(8, 4, 108, 20);
		dayLb2.setBounds(101, 23, 113, 20);
		panel_3.add(dayLb1);
		panel_3.add(dayLb2);
		dayLb1.setText(today.substring(0, 4) + "년" + today.substring(4, 6) + "월" + today.substring(6) + "일");
		dayLb2.setText(today.substring(0, 4) + "년" + today.substring(4, 6) + "월" + today.substring(6) + "일");

		JLabel label_8 = new JLabel("~");
		label_8.setBounds(86, 24, 14, 20);
		panel_3.add(label_8);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(128, 128, 128)));
		panel_4.setBounds(0, 52, 214, 534);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel label = new JLabel("총 매출 :");
		label.setFont(new Font("돋움", Font.BOLD, 12));
		label.setBounds(10, 4, 57, 30);
		panel_4.add(label);

		JLabel label_1 = new JLabel("사회정치 :", SwingConstants.RIGHT);
		label_1.setBounds(12, 73, 67, 15);
		panel_4.add(label_1);

		JLabel label_2 = new JLabel("경제경영 :", SwingConstants.RIGHT);
		label_2.setBounds(12, 98, 67, 15);
		panel_4.add(label_2);

		JLabel label_3 = new JLabel("자연과학 :", SwingConstants.RIGHT);
		label_3.setBounds(12, 123, 67, 15);
		panel_4.add(label_3);

		JLabel label_4 = new JLabel("수험서 :", SwingConstants.RIGHT);
		label_4.setBounds(22, 148, 57, 15);
		panel_4.add(label_4);

		JLabel label_5 = new JLabel("예술 :", SwingConstants.RIGHT);
		label_5.setBounds(22, 173, 57, 15);
		panel_4.add(label_5);

		JLabel label_6 = new JLabel("역사 :", SwingConstants.RIGHT);
		label_6.setBounds(22, 198, 57, 15);
		panel_4.add(label_6);

		totalLb.setForeground(Color.BLUE);
		totalLb.setFont(new Font("돋움", Font.BOLD, 14));
		totalLb.setBounds(67, 4, 147, 30);
		panel_4.add(totalLb);

		societyLb.setBounds(91, 73, 101, 15);
		panel_4.add(societyLb);

		economyLb.setBounds(91, 98, 101, 15);
		panel_4.add(economyLb);

		scienceLb.setBounds(91, 123, 101, 15);
		panel_4.add(scienceLb);

		examinationLb.setBounds(91, 148, 101, 15);
		panel_4.add(examinationLb);

		artLb.setBounds(91, 173, 101, 15);
		panel_4.add(artLb);

		historyLb.setBounds(91, 198, 101, 15);
		panel_4.add(historyLb);

		JLabel lblNewLabel = new JLabel("서가별 매출");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel.setBounds(67, 47, 82, 15);
		panel_4.add(lblNewLabel);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(192, 192, 192));
		panel_6.setBounds(0, 36, 214, 1);
		panel_4.add(panel_6);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(232, 8, 875, 28);
		panel_2.setLayout(null);
		panel.add(panel_2);

		todayRdbtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		todayRdbtn.setBounds(0, 0, 83, 29);
		todayRdbtn.setSelected(true);
		panel_2.add(todayRdbtn);

		choiceRdbtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		choiceRdbtn.setBounds(87, 0, 83, 29);
		panel_2.add(choiceRdbtn);

		periodRdbtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		periodRdbtn.setBounds(486, 0, 83, 29);
		panel_2.add(periodRdbtn);

		monthRdbtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		monthRdbtn.setBounds(263, 1, 52, 27);
		panel_2.add(monthRdbtn);

		group.add(todayRdbtn);
		group.add(choiceRdbtn);
		group.add(periodRdbtn);
		group.add(monthRdbtn);

		// 년도별 콤보박스 생성
		yearCombo.setBackground(new Color(255, 255, 255));
		yearCombo.setBounds(323, 5, 76, 21);
		panel_2.add(yearCombo);

		int index = 0;
		for (int i = 2018; i >= 2013; i--) {
			yComboModel[index] = i + "년";
			index++;
		}
		yearCombo.setModel(new DefaultComboBoxModel<>(yComboModel));

		// 월별 콤보박스 생성
		monthCombo.setBackground(new Color(255, 255, 255));
		monthCombo.setBounds(411, 5, 63, 21);
		panel_2.add(monthCombo);

		for (int i = 0; i < mComboModel.length; i++) {
			mComboModel[i] = i + 1 + "월";
		}
		monthCombo.setModel(new DefaultComboBoxModel<>(mComboModel));

		choiceDayLb = new JTextField();
		// 날짜 입력창에서 엔터칠 시 확인버튼 클릭
		choiceDayLb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					confirmBtn.doClick();
				}
			}
		});

		choiceDayLb.setBounds(170, 4, 76, 22);
		choiceDayLb.setColumns(10);
		panel_2.add(choiceDayLb);

		periodLb1 = new JTextField();
		periodLb1.setColumns(10);
		periodLb1.setBounds(569, 4, 76, 22);
		panel_2.add(periodLb1);
		// 날짜 입력창에서 엔터칠 시 확인버튼 클릭
		periodLb1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					confirmBtn.doClick();
				}
			}
		});

		periodLb2 = new JTextField();
		periodLb2.setColumns(10);
		periodLb2.setBounds(665, 4, 76, 22);
		panel_2.add(periodLb2);
		periodLb2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					confirmBtn.doClick();
				}
			}
		});

		JLabel label_7 = new JLabel("~");
		label_7.setBounds(651, 8, 14, 15);
		panel_2.add(label_7);

		sales = file.fileLoad(today);
		clfSales = file.classificatonSale(sales);
		setList(); // 최초에는 당일 매출로 테이블 세팅
		choiceDayLb.setText("");

		confirmBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		confirmBtn.setBounds(757, 3, 57, 22);
		panel_2.add(confirmBtn);

		panel_5.setBounds(232, 42, 875, 554);
		panel.add(panel_5);

		choiceDayLb.setEnabled(false);
		periodLb1.setEnabled(false);
		periodLb2.setEnabled(false);
		monthCombo.setEnabled(false);
		yearCombo.setEnabled(false);
		tgBtn.setIcon(new ImageIcon("D:\\스샷\\101.png"));

		tgBtn.setBounds(830, 0, 30, 28);
		panel_2.add(tgBtn);
		tgBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				confirmBtn.doClick();
			}
		});

		confirmBtn.addActionListener(this);
		choiceRdbtn.addActionListener(this);
		todayRdbtn.addActionListener(this);
		periodRdbtn.addActionListener(this);
		monthRdbtn.addActionListener(this);

	}

	String select = "";

	@Override
	public void actionPerformed(ActionEvent e) {

		choiceDayLb.setEnabled(false);
		periodLb1.setEnabled(false);
		periodLb2.setEnabled(false);
		monthCombo.setEnabled(false);
		yearCombo.setEnabled(false);

		// 현재 라디오 버튼이 위치해있는 곳에 해당하는 값을 select변수에 대입
		Enumeration<AbstractButton> btns = group.getElements();
		while (btns.hasMoreElements()) {
			AbstractButton btn = btns.nextElement();
			if (btn.isSelected()) {
				select = btn.getText();
			}
		}

		// 라디오 버튼 클릭에 따른 버튼 활성화처리
		if (select.equals(choiceRdbtn.getText())) {
			choiceDayLb.setEnabled(true);
		} else if (select.equals(periodRdbtn.getText())) {
			periodLb1.setEnabled(true);
			periodLb2.setEnabled(true);
		} else if (select.equals(monthRdbtn.getText())) {
			monthCombo.setEnabled(true);
			yearCombo.setEnabled(true);
		}

		if (e.getActionCommand().equals("확인")) {

			int[] dayOfMomth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

			previousClfSales = file.classificatonSaleP(sales);

			if (select.equals("당일 매출")) {

				sales = file.fileLoad(today);
				clfSales = file.classificatonSale(sales);
				choiceDayLb.setText(today);
				setList(); // 당일 매출로 테이블 세팅
				choiceDayLb.setText("");
				dayLb1.setText(today.substring(0, 4) + "년" + today.substring(4, 6) + "월" + today.substring(6) + "일");
				dayLb2.setText(today.substring(0, 4) + "년" + today.substring(4, 6) + "월" + today.substring(6) + "일");

			} else if (select.equals("날짜 선택")) {

				sales = file.fileLoad(choiceDayLb.getText());
				clfSales = file.classificatonSale(sales);
				setList();
				String day = choiceDayLb.getText();
				String dayF = day.substring(0, 4) + "년" + day.substring(4, 6) + "월" + day.substring(6) + "일";
				dayLb1.setText(dayF);
				dayLb2.setText(dayF);

			} else if (select.equals("월별")) {

				String date = yComboModel[yearCombo.getSelectedIndex()] + mComboModel[monthCombo.getSelectedIndex()];
				String[] dateSplit = date.split("년");
				int splitedMonth = Integer.parseInt(dateSplit[1].substring(0, dateSplit[1].length() - 1));
				String dateRs = dateSplit[0] + dayF.format(splitedMonth);
				sales = file.fileLoadTotal(dateRs);
				clfSales = file.classificatonSale(sales);
				setList();
				dayLb1.setText(date + "1일");
				dayLb2.setText(date + dayOfMomth[splitedMonth - 1] + "일");
			} else if (select.equals("기간 지정")) {

				sales = file.fileLoadTotal(periodLb1.getText(), periodLb2.getText());
				clfSales = file.classificatonSale(sales);
				setList();
				String day = periodLb1.getText();
				String dayF = day.substring(0, 4) + "년" + day.substring(4, 6) + "월" + day.substring(6) + "일";
				dayLb1.setText(dayF);
				day = periodLb2.getText();
				dayF = day.substring(0, 4) + "년" + day.substring(4, 6) + "월" + day.substring(6) + "일";
				dayLb2.setText(dayF);
			}

		}
	}

	// 변경사항시마다 리스트를 새로고침해줄 메서드
	public void setList() {

		String[] column = { "ISBN", "분류", "제목", "가격", "판매량", "총 판매액" };
		String[][] row = new String[sales.size()][6];

		long totalSale = 0;

		for (int i = 0; i < sales.size(); i++) {
			row[i][0] = sales.get(i).getIsbn();
			row[i][1] = sales.get(i).getClassification();
			row[i][2] = sales.get(i).getTitle();
			row[i][3] = "" + sales.get(i).getPrice();
			row[i][4] = "" + sales.get(i).getSalesVolume();
			row[i][5] = "" + f1.format(sales.get(i).getSalesVolume() * sales.get(i).getPrice());
			totalSale += sales.get(i).getSalesVolume() * sales.get(i).getPrice();
		}

		panel.setLayout(null);

		table = new JTable(row, column);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setMaxWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		panel_5.setLayout(null);
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 875, 554);

		if (tgBtn.isSelected()) {

			JFreeChart chart = getChart();
			ChartPanel cf = new ChartPanel(chart);

			cf.setBounds(0, 0, 875, 554);

			panel_5.removeAll();
			panel_5.add(cf);
			panel_5.revalidate();
			panel_5.repaint();

		} else {

			panel_5.removeAll();
			panel_5.add(scroll);
			panel_5.revalidate();
			panel_5.repaint();
		}

		totalLb.setText("" + f1.format(totalSale));
		societyLb.setText("" + f1.format(clfSales.get("사회정치")));
		economyLb.setText("" + f1.format(clfSales.get("경제경영")));
		scienceLb.setText("" + f1.format(clfSales.get("자연과학")));
		examinationLb.setText("" + f1.format(clfSales.get("수험서")));
		artLb.setText("" + f1.format(clfSales.get("예술")));
		historyLb.setText("" + f1.format(clfSales.get("역사")));

	}

	public JFreeChart getChart() {

		JFreeChart chart = ChartFactory.createBarChart(getClass().getName(), // title
				"Category", // categoryAxisLabel
				"Value", // valueAxisLabel
				getDataSet(), // dataset
				PlotOrientation.VERTICAL, // orientation
				true, // legend
				true, // tooltips
				false); // url

		return chart;
	}

	private DefaultCategoryDataset getDataSet() {

		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		String category1 = "Selected";
		String category2 = "Previous";
		String test1 = "Society";
		String test2 = "Economy";
		String test3 = "Science";
		String test4 = "Examination";
		String test5 = "Art";
		String test6 = "History";

		// addValue() 메서드를 이용해서 값을 추가함
		dataSet.addValue(clfSales.get("사회정치"), category1, test1);
		dataSet.addValue(clfSales.get("경제경영"), category1, test2);
		dataSet.addValue(clfSales.get("자연과학"), category1, test3);
		dataSet.addValue(clfSales.get("수험서"), category1, test4);
		dataSet.addValue(clfSales.get("예술"), category1, test5);
		dataSet.addValue(clfSales.get("역사"), category1, test6);
		// addValue() 메서드를 이용해서 값을 추가함
		dataSet.addValue(previousClfSales.get("사회정치"), category2, test1);
		dataSet.addValue(previousClfSales.get("경제경영"), category2, test2);
		dataSet.addValue(previousClfSales.get("자연과학"), category2, test3);
		dataSet.addValue(previousClfSales.get("수험서"), category2, test4);
		dataSet.addValue(previousClfSales.get("예술"), category2, test5);
		dataSet.addValue(previousClfSales.get("역사"), category2, test6);

		return dataSet;
	}

	// 객체 싱글톤 패턴으로 생성
	private static StatisticsPan pan = new StatisticsPan();

	public static StatisticsPan getInstance() {
		return pan;
	}
}

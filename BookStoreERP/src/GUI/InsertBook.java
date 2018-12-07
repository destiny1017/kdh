package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dataHandling.StockDAO;
import dataHandling.StockDTO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InsertBook extends JFrame implements ActionListener {
	
	JComboBox comboBox = new JComboBox();
	JButton btnNewButton = new JButton("등록");
	JButton button = new JButton("취소");
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public InsertBook() {
		setBounds(400,300,500,424);
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 255));
		panel.setBounds(0, 0, 484, 461);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("도서등록");
		label.setFont(new Font("함초롬돋움", Font.BOLD, 22));
		label.setBounds(194, 10, 94, 37);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(12, 52, 460, 320);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIsbn = new JLabel("ISBN :", SwingConstants.RIGHT);
		lblIsbn.setFont(new Font("굴림", Font.PLAIN, 14));
		lblIsbn.setBounds(24, 32, 60, 24);
		panel_1.add(lblIsbn);
		
		textField = new JTextField();
		textField.setBounds(96, 32, 326, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 245, 245));
		panel_2.setBounds(12, 10, 436, 301);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("분류 :", SwingConstants.RIGHT);
		label_1.setFont(new Font("굴림", Font.PLAIN, 14));
		label_1.setBounds(12, 58, 60, 24);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("제목 :", SwingConstants.RIGHT);
		label_2.setFont(new Font("굴림", Font.PLAIN, 14));
		label_2.setBounds(12, 92, 60, 24);
		panel_2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(84, 92, 326, 24);
		panel_2.add(textField_2);
		
		JLabel label_3 = new JLabel("출판사 :", SwingConstants.RIGHT);
		label_3.setFont(new Font("굴림", Font.PLAIN, 14));
		label_3.setBounds(12, 126, 60, 24);
		panel_2.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(84, 126, 326, 24);
		panel_2.add(textField_3);
		
		JLabel label_4 = new JLabel("저자 :", SwingConstants.RIGHT);
		label_4.setFont(new Font("굴림", Font.PLAIN, 14));
		label_4.setBounds(12, 160, 60, 24);
		panel_2.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(84, 160, 326, 24);
		panel_2.add(textField_4);
		
		JLabel label_5 = new JLabel("가격 :", SwingConstants.RIGHT);
		label_5.setFont(new Font("굴림", Font.PLAIN, 14));
		label_5.setBounds(12, 194, 60, 24);
		panel_2.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER) {
					btnNewButton.doClick();					
				}
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(84, 194, 326, 24);
		panel_2.add(textField_5);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"사회정치", "경제경영", "역사", "자연과학", "예술", "수험서"}));
		comboBox.setBounds(84, 58, 92, 24);
		panel_2.add(comboBox);
		
		btnNewButton.setBounds(106, 243, 104, 37);
		panel_2.add(btnNewButton);
		
		button.setBounds(232, 243, 104, 37);
		panel_2.add(button);
		setVisible(true);
		
		btnNewButton.addActionListener(this);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnNewButton) {
			StockDTO dto = new StockDTO(textField.getText(), (String)comboBox.getSelectedItem(),
					textField_2.getText(), textField_3.getText(), textField_4.getText(),
					Integer.parseInt(textField_5.getText()));
			int result = new StockDAO().addBook(dto);
			
			StockPan stock = StockPan.getInstance();
			if(result == 0) {
				stock.searchField.setText(textField_2.getText());
			}
			stock.setList();
			setVisible(false);
		}else if(e.getSource() == button) {
			setVisible(false);
		}
		
	}
}

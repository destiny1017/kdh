package manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookManager extends JFrame implements ActionListener{
	
	//텍스트필드 및 버튼 초기화
	JTextField id;
	JTextField title;
	JTextField publisher;
	JTextField price;
	JButton saveBtn = new JButton("저장");
	JButton loadBtn = new JButton("불러오기");

	public BookManager() {
		setTitle("BookManager");
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(400,361);			
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//컴포넌트 배치
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(12, 10, 360, 43);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("도서 관리 프로그램");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(99, 10, 171, 24);
		panel.add(label);
		label.setFont(new Font("휴먼모음T", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		panel_1.setBounds(12, 63, 83, 210);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblid = new JLabel("도서ID");
		lblid.setFont(new Font("굴림", Font.PLAIN, 16));
		lblid.setBounds(12, 22, 53, 26);
		panel_1.add(lblid);
		
		JLabel label_1 = new JLabel("도서명");
		label_1.setFont(new Font("굴림", Font.PLAIN, 16));
		label_1.setBounds(12, 67, 53, 26);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("도서가격");
		label_2.setFont(new Font("굴림", Font.PLAIN, 16));
		label_2.setBounds(12, 163, 71, 26);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("출판사");
		label_3.setFont(new Font("굴림", Font.PLAIN, 16));
		label_3.setBounds(12, 118, 71, 26);
		panel_1.add(label_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		panel_2.setBounds(96, 63, 276, 210);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		id = new JTextField();
		id.setBounds(0, 10, 276, 39);
		panel_2.add(id);
		id.setColumns(10);
		
		title = new JTextField();
		title.setColumns(10);
		title.setBounds(0, 59, 276, 39);
		panel_2.add(title);
		
		publisher = new JTextField();
		publisher.setColumns(10);
		publisher.setBounds(0, 108, 276, 39);
		panel_2.add(publisher);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(0, 157, 276, 39);
		panel_2.add(price);
		
		saveBtn.setFont(new Font("굴림", Font.PLAIN, 16));
		saveBtn.setBounds(71, 278, 103, 33);
		getContentPane().add(saveBtn);
		
		loadBtn.setFont(new Font("굴림", Font.PLAIN, 16));
		loadBtn.setBounds(203, 278, 103, 32);
		getContentPane().add(loadBtn);
		setVisible(true);
		
		saveBtn.addActionListener(this);
		loadBtn.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//읽기,쓰기를 담당하는 BookFile클래스 객체 생성
		BookFile file = new BookFile();
		
		//저장 클릭 시
		if(e.getSource() == saveBtn) {
			try {
				//텍스트필드의 값들을 매개변수로 전달하여 파일을 저장하는 메서드 호출
				file.write(new BookDTO(id.getText(), title.getText(), 
						publisher.getText(), Integer.parseInt(price.getText())));	
				//정상적으로 저장되었을 시 텍스트필드의 입력 값 초기화
				id.setText("");
				title.setText("");
				publisher.setText("");
				price.setText("");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "입력 값이 없거나 올바르지 않은 항목이 있습니다.");
			}
		
		//불러오기 클릭 시
		}else if(e.getSource() == loadBtn) {
			
			try {
				//입력받은 id와 현재 클래스를 매개변수로 전달하여 파일을 불러오는 메서드 호출
				//매개변수 this는 메서드에서 바로 textFiled에 값을 세팅해주기 위한 목적
				file.read(JOptionPane.showInputDialog("도서 id입력"), this);			
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "입력한 id의 도서가 존재하지 않습니다.");
			}
		}
	}
	
	public static void main(String[] args) {
		new BookManager();
	}
}

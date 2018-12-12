package money;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

public class BankManager extends JFrame implements ActionListener {
	
	//컴포넌트 세팅
	JPanel panel1 = new JPanel();
	JPanel pan1 = new JPanel();
	JButton searchBtn = new JButton("검색");
	JButton insertBtn = new JButton("삽입");
	JButton modBtn = new JButton("수정");
	JButton delBtn = new JButton("삭제");
	JButton refreshBtn = new JButton("갱신");
	JTextField searchField = new JTextField();
	
	//crud기능을 수행할 dao객체 생성
	BankDAO dao = new BankDAO();
	//회원정보를 받아올 리스트 객체 생성
	ArrayList<BankDTO> list = dao.list();
	
	//J테이블 추가를 위한 변수 선언
	String[] column = {"ID","이름","나이","연락처"};
	String[][] row;
	JTable table;
	JScrollPane scroll;
	
	public BankManager() {
		
		//UI세팅
		setSize(500,500);
		getContentPane().add(pan1);
		pan1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 255));
		panel.setBounds(12, 10, 460, 45);
		pan1.add(panel);
		panel.setLayout(null);
		
		JLabel titleLb = new JLabel("은행 고객관리 프로그램");
		titleLb.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 16));
		titleLb.setBounds(142, 0, 187, 45);
		panel.add(titleLb);
		
		panel1.setBounds(12, 65, 460, 353);
		pan1.add(panel1);
		insertBtn.setFont(new Font("굴림", Font.BOLD, 12));
		
		insertBtn.setBounds(186, 429, 70, 23);
		pan1.add(insertBtn);
		
		modBtn.setBounds(258, 429, 69, 23);
		pan1.add(modBtn);
		
		delBtn.setBounds(328, 429, 73, 23);
		pan1.add(delBtn);
		
		refreshBtn.setBounds(403, 429, 69, 23);
		pan1.add(refreshBtn);
		
		searchField.setBounds(12, 429, 103, 21);
		pan1.add(searchField);
		searchField.setColumns(10);
		
		searchBtn.setBounds(117, 428, 63, 23);
		pan1.add(searchBtn);	
		
		//프로그램 시작과 동시에 전체 회원 리스트를 받아와서 JTable에 세팅
		setList();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//버튼별 액션리스너 설정
		searchBtn.addActionListener(this);
		insertBtn.addActionListener(this);
		modBtn.addActionListener(this);
		refreshBtn.addActionListener(this);
		delBtn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new BankManager();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == insertBtn) {
			new Insert(); //회원정보 입력 클래스 객체 생성
		}else if(e.getSource() == modBtn) {
			new Modify(); //회원정보 수정 클래스 객체 생성
		}else if(e.getSource() == delBtn) {
			String id = (String) table.getValueAt(table.getSelectedRow(), 0); //선택된 행의 id값을 가져옴
			dao.delete(id); //삭제메서드에 id를 매개변수로 넘겨줌
		}else if(e.getSource() == refreshBtn) {
			list = dao.list(); //현재 리스트의 값을 전체회원 정보로 갱신
			setList(); //갱신된 리스트를 jtable에 세팅
		}else if(e.getSource() == searchBtn) {
			list = dao.search(searchField.getText()); //현재 리스트의 값을 검색창에 입력된 회원의 리스트로 갱신
			setList(); //갱신된 리스트를 jtable에 세팅
		}
	}
	
	//jtable의 값을 갱신해줄 메서드 선언
	public void setList() {
		
		row = new String[list.size()][4];
		
		//전역변수 리스트에 담긴 회원정보의 수만큼 jtable의 열 세팅 반복
		for (int i = 0; i < row.length; i++) {
			row[i][0] = list.get(i).getId();
			row[i][1] = list.get(i).getName();
			row[i][2] = "" + list.get(i).getAge();
			row[i][3] = list.get(i).getTel();
		}
		
		//j테이블 세팅
		table = new JTable(row, column);
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 460, 353);
		
		//패널안의 컴포넌트 모두 삭제 후 스크롤 추가
		panel1.removeAll();
		panel1.setLayout(null);
		panel1.add(scroll);
		panel1.revalidate();
		panel1.repaint();
		
	}

	//회원정보 입력 클래스
	class Insert extends JFrame {
		
		private JTextField idField;
		private JTextField nameField;
		private JTextField ageField;
		private JTextField telField;
		
		BankDAO dao = new BankDAO();
		
		public Insert() {
			
			//UI세팅
			setSize(300,259);
			setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 35, 284, 141);
			add(panel);
			panel.setLayout(null);
			
			JLabel idLb = new JLabel("ID :");
			idLb.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			idLb.setBounds(12, 10, 56, 22);
			panel.add(idLb);
			
			JLabel nameLb = new JLabel("이름 :");
			nameLb.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			nameLb.setBounds(12, 42, 56, 22);
			panel.add(nameLb);
			
			JLabel ageLb = new JLabel("나이 :");
			ageLb.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			ageLb.setBounds(12, 74, 56, 22);
			panel.add(ageLb);
			
			JLabel telLb = new JLabel("연락처 :");
			telLb.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			telLb.setBounds(12, 105, 56, 22);
			panel.add(telLb);
			
			idField = new JTextField();
			idField.setBounds(81, 11, 191, 21);
			panel.add(idField);
			idField.setColumns(10);
			
			nameField = new JTextField();
			nameField.setColumns(10);
			nameField.setBounds(80, 43, 191, 21);
			panel.add(nameField);
			
			ageField = new JTextField();
			ageField.setColumns(10);
			ageField.setBounds(80, 75, 191, 21);
			panel.add(ageField);
			
			telField = new JTextField();
			telField.setColumns(10);
			telField.setBounds(80, 106, 191, 21);
			panel.add(telField);
			
			JLabel lblNewLabel = new JLabel("고객정보입력");
			lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 13));
			lblNewLabel.setBounds(100, 10, 84, 15);
			add(lblNewLabel);
			
			JButton btnNewButton = new JButton("등록");
			btnNewButton.setBounds(97, 186, 97, 23);
			add(btnNewButton);
			setVisible(true);
			
			//액션리스너 설정
			btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//등록버튼 클릭 시 텍스트필드의 내용을 가져와서 DTO객체화하고, 이것을 매개변수로 회원등록 메서드 호출
					dao.insert(new BankDTO(idField.getText(), nameField.getText(), 
							Integer.parseInt(ageField.getText()), telField.getText()));
					
				}
			});
		}
		
		public void main(String[] args) {
			new Insert();
		}

	}
	
	class Modify extends JFrame {

		private JTextField idField;
		private JTextField nameField;
		private JTextField ageField;
		private JTextField telField;
		
		BankDAO dao = new BankDAO();

		public Modify() {
			
			//UI세팅
			setSize(300,259);
			setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 35, 284, 141);
			add(panel);
			panel.setLayout(null);
			
			JLabel idLb = new JLabel("ID :");
			idLb.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			idLb.setBounds(12, 10, 56, 22);
			panel.add(idLb);
			
			JLabel nameLb = new JLabel("이름 :");
			nameLb.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			nameLb.setBounds(12, 42, 56, 22);
			panel.add(nameLb);
			
			JLabel ageLb = new JLabel("나이 :");
			ageLb.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			ageLb.setBounds(12, 74, 56, 22);
			panel.add(ageLb);
			
			JLabel telLb = new JLabel("연락처 :");
			telLb.setFont(new Font("나눔고딕", Font.PLAIN, 13));
			telLb.setBounds(12, 105, 56, 22);
			panel.add(telLb);
			
			idField = new JTextField();
			idField.setBounds(81, 11, 191, 21);
			panel.add(idField);
			idField.setColumns(10);
			
			nameField = new JTextField();
			nameField.setColumns(10);
			nameField.setBounds(80, 43, 191, 21);
			panel.add(nameField);
			
			ageField = new JTextField();
			ageField.setColumns(10);
			ageField.setBounds(80, 75, 191, 21);
			panel.add(ageField);
			
			telField = new JTextField();
			telField.setColumns(10);
			telField.setBounds(80, 106, 191, 21);
			panel.add(telField);
			
			JLabel lblNewLabel = new JLabel("고객정보수정");
			lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 13));
			lblNewLabel.setBounds(100, 10, 84, 15);
			add(lblNewLabel);
			
			JButton btnNewButton = new JButton("수정");
			btnNewButton.setBounds(97, 186, 97, 23);
			add(btnNewButton);
			setVisible(true);
			
			//액션리스너 설정
			btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//수정버튼 클릭 시 텍스트필드의 내용을 가져와서 DTO객체화하고, 이것을 매개변수로 회원수정 메서드 호출
					dao.modify(new BankDTO(idField.getText(), nameField.getText(), 
							Integer.parseInt(ageField.getText()), telField.getText()));
					
				}
			});
		}
		
		public void main(String[] args) {
			new Modify();
		}

	}
}

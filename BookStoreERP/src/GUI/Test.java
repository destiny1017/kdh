package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Test extends JFrame implements ActionListener {
	
	
	JPanel mainPan = new JPanel();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JButton btn1 = new JButton("패널교체1");
	JButton btn2 = new JButton("패널교체2");
	private final JComboBox comboBox = new JComboBox();
	private final JButton button = new JButton("ㅅ시실싫실해행행");
	
	public Test() {
		
		//최초 세팅
		setSize(300,300);
		pan1.setLayout(new GridLayout(2, 1));
		pan1.add(new JLabel("1번 패널"));
		pan1.add(btn1);
			
		mainPan.add(pan1);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"첫번째", "두번째", "세번째"}));
		
		pan1.add(comboBox);
		
		pan1.add(button);
		getContentPane().add(mainPan); //프레임에는 메인패널 하나만 추가된 상태
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		btn1.addActionListener(this);	
		btn2.addActionListener(this);	
		button.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new Test();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(comboBox.getSelectedItem());
		
		if(e.getSource() == btn1) {
			
			//메인패널에 있는 컴포넌트를 모두 삭제
			mainPan.removeAll();
			mainPan.revalidate();
			
			//새로운 패널을 메인패널에 추가
			pan2 = new JPanel();
			pan2.setLayout(new GridLayout(2, 1));
			pan2.add(new JLabel("2번 패널"));
			pan2.add(btn2);
			mainPan.add(pan2);
			
		}else if(e.getSource() == btn2){

			//메인패널에 있는 컴포넌트를 모두 삭제
			mainPan.removeAll();
			mainPan.revalidate();
			
			//새로운 패널을 메인패널에 추가
			pan1 = new JPanel();
			pan1.setLayout(new GridLayout(2, 1));
			pan1.add(new JLabel("1번 패널"));	
			pan1.add(btn1);
			mainPan.add(pan1);
			
		}
	}
}

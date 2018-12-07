package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame implements ActionListener {
	
	
	JPanel mainPan = new JPanel();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JButton btn1 = new JButton("패널교체1");
	JButton btn2 = new JButton("패널교체2");
	
	public Test() {
		
		//최초 세팅
		setSize(300,300);
		pan1.setLayout(new GridLayout(2, 1));
		pan1.add(new JLabel("1번 패널"));
		pan1.add(btn1);
			
		mainPan.add(pan1);
		add(mainPan); //프레임에는 메인패널 하나만 추가된 상태
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		btn1.addActionListener(this);	
		btn2.addActionListener(this);	
		
	}
	
	public static void main(String[] args) {
		new Test();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
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

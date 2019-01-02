package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dataHandling.MemberDTO;
import dataHandling.BookInput;
import java.awt.Font;
import javax.swing.JPanel;

public class BookMember extends JFrame implements ActionListener {
   private JTextField textField;
   private JPasswordField passwordField;
   private JTextField textField_1;
   private JTextField textField_3;
   private JTextField textField_4;
   private JButton btnNewButton;
   JButton btnNewButton_1 = new JButton("취소");

   public BookMember() {
      getContentPane().setBackground(new Color(102, 153, 204));
      getContentPane().setLayout(null);

      btnNewButton = new JButton("등록");
      btnNewButton.setBounds(109, 345, 97, 23);
      getContentPane().add(btnNewButton);

      btnNewButton_1.setBounds(233, 345, 97, 23);
      getContentPane().add(btnNewButton_1);

      JLabel lblNewLabel = new JLabel("회원가입", SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 14));
      lblNewLabel.setForeground(new Color(255, 255, 255));
      lblNewLabel.setBounds(109, 15, 219, 26);
      getContentPane().add(lblNewLabel);

      JLabel lblNewLabel_1 = new JLabel("아이디", SwingConstants.CENTER);
      lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
      lblNewLabel_1.setForeground(new Color(72, 123, 174));
      lblNewLabel_1.setBackground(Color.CYAN);
      lblNewLabel_1.setBounds(34, 72, 57, 26);
      getContentPane().add(lblNewLabel_1);

      JLabel lblNewLabel_2 = new JLabel("패스워드", SwingConstants.CENTER);
      lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
      lblNewLabel_2.setForeground(new Color(72, 123, 174));
      lblNewLabel_2.setBounds(34, 122, 57, 26);
      getContentPane().add(lblNewLabel_2);

      JLabel lblNewLabel_3 = new JLabel("이름", SwingConstants.CENTER);
      lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 12));
      lblNewLabel_3.setForeground(new Color(72, 123, 174));
      lblNewLabel_3.setBounds(34, 173, 57, 26);
      getContentPane().add(lblNewLabel_3);

      JLabel lblNewLabel_5 = new JLabel("전화번호", SwingConstants.CENTER);
      lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 12));
      lblNewLabel_5.setForeground(new Color(72, 123, 174));
      lblNewLabel_5.setBounds(34, 233, 57, 15);
      getContentPane().add(lblNewLabel_5);

      JLabel lblNewLabel_6 = new JLabel("주소", SwingConstants.CENTER);
      lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 12));
      lblNewLabel_6.setForeground(new Color(72, 123, 174));
      lblNewLabel_6.setBounds(34, 288, 57, 15);
      getContentPane().add(lblNewLabel_6);

      textField = new JTextField();
      textField.setBounds(103, 73, 259, 26);
      getContentPane().add(textField);
      textField.setColumns(10);

      passwordField = new JPasswordField();
      passwordField.setBounds(103, 123, 259, 26);
      getContentPane().add(passwordField);

      textField_1 = new JTextField();
      textField_1.setBounds(103, 174, 259, 26);
      getContentPane().add(textField_1);
      textField_1.setColumns(10);

      textField_3 = new JTextField();
      textField_3.setBounds(103, 228, 259, 26);
      getContentPane().add(textField_3);
      textField_3.setColumns(10);

      textField_4 = new JTextField();
      textField_4.setBounds(103, 283, 259, 26);
      getContentPane().add(textField_4);
      textField_4.setColumns(10);
      
      JPanel panel = new JPanel();
      panel.setBackground(new Color(255, 255, 255, 150));
      panel.setBounds(23, 56, 389, 279);
      getContentPane().add(panel);

      btnNewButton.addActionListener(this);
      btnNewButton_1.addActionListener(this);

      setTitle("회원가입");
      setBounds(550, 350, 450, 424);

      setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      BookInput in = new BookInput();
      if (e.getSource() == btnNewButton) {
         MemberDTO library = new MemberDTO(textField.getText(), passwordField.getText(), textField_1.getText(),
                textField_3.getText(), textField_4.getText());
         in.input(library);
      }else if(e.getSource() == btnNewButton_1) {
    	  setVisible(false);
      }
         
   }

}
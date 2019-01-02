package dataHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BookInput {

	// 회원정보 등록
	public void input(MemberDTO library) {

		File file = new File("member/" + library.getId() + ".txt");

		if (file.exists()) {
			JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다.");
		} else if (library.getId().equals("")) {
			JOptionPane.showMessageDialog(null, "아이디가 입력되지 않았습니다.");
		} else {
			try {
				FileWriter writer = new FileWriter(file);
				writer.write(library.getId() + "\r\n");
				writer.write(library.getPw() + "\r\n");
				writer.write(library.getName() + "\r\n");
				writer.write(library.getTel() + "\r\n");
				writer.write(library.getAddr() + "\r\n");

				writer.flush();
				writer.close();

				JOptionPane.showMessageDialog(null, "정상적으로 가입되었습니다.");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.");
				e.printStackTrace();
			}
		}
	}

	public boolean checkId(String id, String pw) {
		
		File file = new File("member/" + id + ".txt");
		if(file.exists()) {		
			try {
				Scanner scan = new Scanner(file);
				
				scan.nextLine();
				String chkPw = scan.nextLine();
				if(chkPw.equals(pw)) {
					return true;
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
		}
		return false;
	}

}
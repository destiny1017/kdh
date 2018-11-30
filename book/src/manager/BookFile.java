package manager;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BookFile {
	
	public void write(BookDTO book) throws Exception {
		
		//전달 받은 id와 일치하는 txt파일 생성 및 내용 저장
		FileWriter write = new FileWriter(book.getId() + ".txt");
		write.write(book.getId() + "\r\n");
		write.write(book.getTitle() + "\r\n");
		write.write(book.getPublisher() + "\r\n");
		write.write(book.getPrice() + "\r\n");
		write.flush();
		write.close();
		
		JOptionPane.showMessageDialog(null, "도서 정보가 성공적으로 저장되었습니다.");
	}
	
	public void read(String id, BookManager main) throws Exception{
		
		//전달 받은 id와 일치하는 txt파일을 스캐너 객체로 생성 후 textFiled에 세팅
		Scanner scan = new Scanner(new File(id + ".txt"));	
		while(scan.hasNextLine()) {
			main.id.setText(scan.nextLine());
			main.title.setText(scan.nextLine());
			main.publisher.setText(scan.nextLine());
			main.price.setText(scan.nextLine());
		}	
		scan.close();
			
	}
}

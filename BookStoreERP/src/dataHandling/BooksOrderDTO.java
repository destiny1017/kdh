package dataHandling;

public class BooksOrderDTO {

	int no;
	String ts;
	String publisher;

	public BooksOrderDTO(int no, String ts, String publisher) {
		super();
		this.no = no;
		this.ts = ts;
		this.publisher = publisher;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}

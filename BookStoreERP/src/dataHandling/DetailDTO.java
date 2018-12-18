package dataHandling;

public class DetailDTO {

	int no;
	String isbn;
	String classification;
	String title;
	String writer;
	int quantity;

	public DetailDTO(int no, String isbn, String classification, String title, String writer, int quantity) {
		super();
		this.no = no;
		this.isbn = isbn;
		this.classification = classification;
		this.title = title;
		this.writer = writer;
		this.quantity = quantity;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

package dataHandling;

public class DetailDTO {

	String isbn;
	String classification;
	String title;
	String writer;
	int quantity;

	public DetailDTO(String isbn, String classification, String title, String writer, int quantity) {
		super();
		this.isbn = isbn;
		this.classification = classification;
		this.title = title;
		this.writer = writer;
		this.quantity = quantity;
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

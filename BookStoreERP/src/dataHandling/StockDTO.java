package dataHandling;

public class StockDTO {
	
	private String isbn;
	private String classification;
	private String title;
	private String publisher;
	private String writer;
	private int price;
	private int stock;
	
	
	public StockDTO(String isbn, String title, String publisher) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
	}

	public StockDTO(String isbn, String classification, String title, String publisher, String writer, int price) {
		super();
		this.isbn = isbn;
		this.classification = classification;
		this.title = title;
		this.publisher = publisher;
		this.writer = writer;
		this.price = price;
	}
	
	public StockDTO(String isbn, String classification, String title, String publisher, String writer, int price,
			int stock) {
		super();
		this.isbn = isbn;
		this.classification = classification;
		this.title = title;
		this.publisher = publisher;
		this.writer = writer;
		this.price = price;
		this.stock = stock;
	}

	public StockDTO(String isbn, String title, int price, String writer, String publisher) {
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.writer = writer;
		this.price = price;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}

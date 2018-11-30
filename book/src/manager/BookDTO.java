package manager;

public class BookDTO {
	
	private String id;
	private String title;
	private String publisher;
	private int price;
	
	public BookDTO(String id, String title, String publisher, int price) {
		super();
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", publisher=" + publisher + ", price=" + price + "]";
	}
	

}

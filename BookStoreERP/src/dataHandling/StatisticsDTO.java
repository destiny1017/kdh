package dataHandling;

import java.io.Serializable;

public class StatisticsDTO implements Serializable {

	private static final long serialVersionUID = -4238858308566145586L;
	
	private String isbn;
	private String classification;
	private String title;
	private int price;
	private int salesVolume;
	
	public StatisticsDTO() {}

	public StatisticsDTO(String isbn, String classification, String title, int price, int salesVolume) {
		super();
		this.isbn = isbn;
		this.classification = classification;
		this.title = title;
		this.price = price;
		this.salesVolume = salesVolume;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSalesVolume() {
		return salesVolume;
	}

	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
	}
	
	
}

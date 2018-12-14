package dataHandling;

public class BookTotalDTO {
	   
	   private String isbn;
	   private String classification;
	   private String title;
	   private String publisher;
	   private String writer;
	   private int price;
	   private int no;
	   private int quantity;
	   private String TS;
	   
	   public BookTotalDTO(String isbn, String classification, String title, String publisher, String writer, int price,
	         int no, int quantity, String tS) {
	      super();
	      this.isbn = isbn;
	      this.classification = classification;
	      this.title = title;
	      this.publisher = publisher;
	      this.writer = writer;
	      this.price = price;
	      this.no = no;
	      this.quantity = quantity;
	      TS = tS;
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

	   public int getNo() {
	      return no;
	   }

	   public void setNo(int no) {
	      this.no = no;
	   }

	   public int getQuantity() {
	      return quantity;
	   }

	   public void setQuantity(int quantity) {
	      this.quantity = quantity;
	   }

	   public String getTS() {
	      return TS;
	   }

	   public void setTS(String tS) {
	      TS = tS;
	   }

	   @Override
	   public String toString() {
	      return "BookTotalDTO [isbn=" + isbn + ", classification=" + classification + ", title=" + title + ", publisher="
	            + publisher + ", writer=" + writer + ", price=" + price + ", no=" + no + ", quantity=" + quantity
	            + ", TS=" + TS + "]";
	   }
	      
	}

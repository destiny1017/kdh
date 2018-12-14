package dataHandling;

public class OrderDTO {

	   private String isbn;
	   private int quantity;
	   
	   public OrderDTO(String isbn, int quantity) {
	      super();
	      this.isbn = isbn;
	      this.quantity = quantity;
	   }

	   public String getIsbn() {
	      return isbn;
	   }

	   public void setIsbn(String isbn) {
	      this.isbn = isbn;
	   }

	   public int getQuantity() {
	      return quantity;
	   }

	   public void setQuantity(int quantity) {
	      this.quantity = quantity;
	   }

	   @Override
	   public String toString() {
	      return "BookOrderDTO [isbn=" + isbn + ", quantity=" + quantity + "]";
	   }
	   
	}
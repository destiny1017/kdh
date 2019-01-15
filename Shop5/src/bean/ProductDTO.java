package bean;

public class ProductDTO {
	
	private String pId;
	private String name;
	private String explanation;
	private String price;
	private String sizeS;
	private String sizeM;
	private String sizeL;
	private String sizeXL;
	private String category;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductDTO(String pId, String name, String explanation, String price, String sizeS, String sizeM,
			String sizeL, String sizeXL, String category) {
		super();
		this.pId = pId;
		this.name = name;
		this.explanation = explanation;
		this.price = price;
		this.sizeS = sizeS;
		this.sizeM = sizeM;
		this.sizeL = sizeL;
		this.sizeXL = sizeXL;
		this.category = category;
	}



	public String getPId() {
		return pId;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSizeS() {
		return sizeS;
	}

	public void setSizeS(String sizeS) {
		this.sizeS = sizeS;
	}

	public String getSizeM() {
		return sizeM;
	}

	public void setSizeM(String sizeM) {
		this.sizeM = sizeM;
	}

	public String getSizeL() {
		return sizeL;
	}

	public void setSizeL(String sizeL) {
		this.sizeL = sizeL;
	}

	public String getSizeXL() {
		return sizeXL;
	}

	public void setSizeXL(String sizeXL) {
		this.sizeXL = sizeXL;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductDTO [pId=" + pId + ", name=" + name + ", explanation=" + explanation + ", price=" + price
				+ ", sizeS=" + sizeS + ", sizeM=" + sizeM + ", sizeL=" + sizeL + ", sizeXL=" + sizeXL + ", category="
				+ category + "]";
	}
	
	

}

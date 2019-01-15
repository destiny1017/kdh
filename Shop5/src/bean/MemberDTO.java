package bean;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String resNum;
	private String tel;
	private String address;
	private int amount;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDTO(String id, String pw, String name, String resNum, String tel, String address, int amount) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.resNum = resNum;
		this.tel = tel;
		this.address = address;
		this.amount = amount;
	}




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResNum() {
		return resNum;
	}
	public void setResNum(String resNum) {
		this.resNum = resNum;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}	
	
}

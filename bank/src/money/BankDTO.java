package money;

public class BankDTO {
	
	private String id;
	private String name;
	private int age;
	private String tel;
	
	public BankDTO(String id, String name, int age, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}

package bean;

public class CheckOutDTO {
	private String uid;
	private String pid;
	private String size;
	private String count;

	public CheckOutDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CheckOutDTO(String uid, String pid, String size, String count) {
		super();
		this.uid = uid;
		this.pid = pid;
		this.size = size;
		this.count = count;
	}


	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

}

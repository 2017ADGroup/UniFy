package jp.co.axiz.web.form;

public class DeleteForm {
	private String id;
	private String name;
	private String tel;
	private String pass;

	public DeleteForm() {
		super();
	}

	public void clear(){
		this.id="";
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	public String getTel() {
		return tel;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}

package jp.co.axiz.web.form;

public class SelectForm {
	private String id;

	private String name;
	private String tel;

	public void clear(){

		this.id="";
		this.name="";
		this.tel="";
	}
	public SelectForm() {
		super();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
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

	public void setTel(String tel) {
		this.tel = tel;
	}
}

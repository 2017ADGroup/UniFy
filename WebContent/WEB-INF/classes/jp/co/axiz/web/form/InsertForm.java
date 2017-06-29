package jp.co.axiz.web.form;

public class InsertForm {

	private String name;
	private String tel;
	private String pass;
	private String rePass;

	public InsertForm() {
		super();
	}
	public void clear(){

		this.name="";
		this.tel="";
	}
	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	public String getRePass() {
		return rePass;
	}

	public String getTel() {
		return tel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setRePass(String rePass) {
		this.rePass = rePass;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}

package jp.co.axiz.web.form;

public class UpdateForm {

	private String id;
	private String name;
	private String tel;
	private String pass;
	private String rePass;

	private String newName;
	private String newPass;
	private String newTel;

	public UpdateForm() {
		super();
	}
	public void clear(){

		this.id="";
		this.newPass="";
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNewName() {
		return newName;
	}

	public String getNewPass() {
		return newPass;
	}

	public String getNewTel() {
		return newTel;
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

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public void setNewTel(String newTel) {
		this.newTel = newTel;
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

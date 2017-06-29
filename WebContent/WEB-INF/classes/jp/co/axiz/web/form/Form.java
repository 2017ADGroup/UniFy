package jp.co.axiz.web.form;

//Formの内容を格納するクラス
public class Form {

	private String id;
	private String pass;

	public Form(){
		super();
	}

	public void clear(){
		this.id="";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}

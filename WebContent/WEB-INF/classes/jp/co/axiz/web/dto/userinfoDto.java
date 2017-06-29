package jp.co.axiz.web.dto;

import org.springframework.stereotype.Component;

@Component
public class userinfoDto {
	private long user_id;
	private String user_name;
	private String telephone;
	private String password;

	public userinfoDto() {
		super();
	}

	public userinfoDto(long user_id, String user_name, String telephone) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.telephone = telephone;
	}

	public userinfoDto(long user_id, String user_name, String telephone, String password) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.telephone = telephone;
		this.password = password;

	}

	public String getPassword() {
		return password;
	}

	public String getTelephone() {
		return telephone;
	}

	public long getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}

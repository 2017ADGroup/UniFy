package jp.co.axiz.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.dao.adminDao;
import jp.co.axiz.web.dto.adminDto;
import jp.co.axiz.web.form.Form;

@Controller
public class AuthController {

	@Autowired
	private adminDao admin;

	@RequestMapping("/login")
	public String login(@ModelAttribute("login") Form form) {

		return "login";
	}
	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public String logout(){

		return "logout";
	}
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)

	public String logincheck(@ModelAttribute("login") Form form, HttpSession session ,Model model) {

		String id = form.getId();

		List<adminDto> list = admin.login(id, form.getPass());
		if (!list.isEmpty()) {
			List<adminDto> dto = admin.syutoku(id);
			String name = dto.get(0).getAdmin_name();
			System.out.println(name);
			session.setAttribute("adminname", name);
			return "menu";
		} else {
			form.clear();
			String msg = "IDまたはPASSが間違っています。";
			model.addAttribute("msg",msg);
			return "login";
		}
	}
}
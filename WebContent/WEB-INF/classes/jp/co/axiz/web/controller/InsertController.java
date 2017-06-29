package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.dao.userinfoDao;
import jp.co.axiz.web.form.InsertForm;

@Controller
public class InsertController {

	@Autowired
	userinfoDao user;

	@RequestMapping("/insert")
	public String insert(@ModelAttribute("insert") InsertForm form, Model model) {

		return "insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST) // insertに飛ばす
	public String insertcheck(@ModelAttribute("insert") InsertForm form, HttpSession session, Model model) {
		String name = form.getName();
		String tel = form.getTel();
		String pass = form.getPass();
		if (tel.equals("") || name.equals("") || pass.equals("")) {
			form.clear();
			String msg = "すべて入力してください。";
			model.addAttribute("msg", msg);
			return "insert";
		} else {
			session.setAttribute("pass", pass);
			return "insertConfirm";
		}
	}

	@RequestMapping(value = "/insertConfirm", method = RequestMethod.POST)
	public String insertin(@ModelAttribute("insert") InsertForm form, HttpSession session, Model model) {
		String name = form.getName();
		String tel = form.getTel();
		String repass = form.getRePass();


		if (repass.equals("")) {
			String msg = "PASSを入力してください。";

			model.addAttribute("msg", msg);
			return "insertConfirm";
		} else {
			String oldpass = (String) session.getAttribute("pass");

			if (oldpass.equals(repass)) {
				System.out.println(oldpass);
				System.out.println(repass);
				user.insert(name, tel, repass);
			int list = user.MAX();

				int sid = list;

				session.setAttribute("sid", sid);
				return "insertResult";
			} else {
				String msg = "前回入力したパスワードと一致しません。";
				model.addAttribute("msg", msg);
				return "insertConfirm";
			}

		}

	}

}

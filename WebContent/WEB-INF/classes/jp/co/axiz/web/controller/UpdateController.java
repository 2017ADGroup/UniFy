package jp.co.axiz.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.dao.userinfoDao;
import jp.co.axiz.web.dto.userinfoDto;
import jp.co.axiz.web.form.UpdateForm;

@Controller
public class UpdateController {
	@Autowired
	userinfoDao user;

	@RequestMapping("/update")
	public String update(@ModelAttribute("update") UpdateForm form, Model model) {

		return "update";
	}

	@RequestMapping("/updateInput")
	public String updateInput(@ModelAttribute("update") UpdateForm form, Model model) {

		return "updateInput";
	}

	@RequestMapping(value = "/updateInput", method = RequestMethod.POST)
	public String updateInput(@ModelAttribute("update") UpdateForm form, HttpSession session, Model model) {
		String id = form.getId();
		if (id.equals("")) {
			String msg = "必須項目を入力してください。";
			model.addAttribute("msg", msg);
			return "update";
		} else {
			userinfoDto dto = user.syutoku(id);
			Long i = dto.getUser_id();
			String name = dto.getUser_name();
			String tel = dto.getTelephone();
			String pass = dto.getPassword();
			String d = String.valueOf(i);
			if (!d.equals(id)) {
				form.clear();
				String msg = "入力されたデータは存在しません。";
				model.addAttribute("msg", msg);
				return "update";
			}
			session.setAttribute("id", i);
			session.setAttribute("name", name);
			session.setAttribute("tel", tel);
			session.setAttribute("pass", pass);

			return "updateInput";
		}
	}

	@RequestMapping(value = "/updateConfirm", method = RequestMethod.POST)
	public String updateConfirm(@ModelAttribute("update") UpdateForm form, HttpSession session, Model model) {
		String oldname = (String) session.getAttribute("name");
		String oldtel = (String) session.getAttribute("tel");
		String oldpass = (String) session.getAttribute("pass");
		String name = form.getNewName();
		String tel = form.getNewTel();
		String pass = form.getNewPass();
		String p = null;

		if (oldname.equals(name) && oldtel.equals(tel) && oldpass.equals(pass)) {
			String msg = "1項目以上変更してください。";
			model.addAttribute("msg", msg);
			return "updateInput";
		}
		else if(pass.equals("")||tel.equals("")||name.equals("")){

			session.removeAttribute(oldpass);
			String msg = "すべて入力してください。";

			model.addAttribute("msg", msg);
			return "updateInput";
		}
		else {
			if (pass.equals(oldpass)) {
				p = pass;
			} else {
				p = "";
			}
			session.setAttribute("name", oldname);
			session.setAttribute("tel", oldtel);
			session.setAttribute("oldpass", oldpass);
			session.setAttribute("newname", name);
			session.setAttribute("newtel", tel);
			session.setAttribute("npass", pass);
			session.setAttribute("sai", p);

			return "updateConfirm";
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateupdate(@ModelAttribute("update") UpdateForm form, HttpSession session, Model model) {
		String repass = form.getRePass();
		String name = (String) session.getAttribute("newname");
		String tel = (String) session.getAttribute("newtel");
		String pass = (String) session.getAttribute("npass");
		Long id = (Long) session.getAttribute("id");

		if (pass.equals(repass)) {
			user.update(name, tel, pass, id);


			session.setAttribute("sid", id);
		} else {
			String msg = "前回入力したパスワードと一致しません。";


			model.addAttribute("msg", msg);
			session.setAttribute("sai", repass);
			return "updateConfirm";
		}
		return "updateResult";

	}
}

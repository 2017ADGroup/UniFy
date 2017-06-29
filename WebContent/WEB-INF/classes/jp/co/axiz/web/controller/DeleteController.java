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
import jp.co.axiz.web.form.DeleteForm;

@Controller
public class DeleteController {
	@Autowired
	userinfoDao user;

	@RequestMapping("/delete")
	public String delete(@ModelAttribute("delete") DeleteForm form, Model model) {

		return "delete";
	}

	//
	@RequestMapping(value = "/deleteConfirm", method = RequestMethod.POST)
	public String deletecheck(@ModelAttribute("delete") DeleteForm form, HttpSession session, Model model) {
		String id = form.getId();
		if (id.equals("")) {
			String msg = "必須項目を入力してください。";

			model.addAttribute("msg", msg);
			return "delete";
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
				return "delete";
			}
			session.setAttribute("id", i);
			session.setAttribute("name", name);
			session.setAttribute("tel", tel);
			session.setAttribute("pass", pass);
			return "deleteConfirm";
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletedelete(@ModelAttribute("delete") DeleteForm form, HttpSession session, Model model) {
		Long i = (Long) session.getAttribute("id");
		user.delete(i);

		return "deleteResult";

	}
}

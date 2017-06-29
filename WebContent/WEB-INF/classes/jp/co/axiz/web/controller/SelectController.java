package jp.co.axiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.dao.userinfoDao;
import jp.co.axiz.web.dto.userinfoDto;
import jp.co.axiz.web.form.SelectForm;

@Controller
public class SelectController {

	@Autowired
	private userinfoDao user;


	@RequestMapping("/select")
	public String login(@ModelAttribute("select") SelectForm form) {

		return "select";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String login(@ModelAttribute("select") SelectForm form, Model model) {
		String id = form.getId();
		String name = form.getName();
		String tel = form.getTel();
		if (id.equals("") && name.equals("") && tel.equals("")) {
			List<userinfoDto> list = user.select(id, name, tel);
			model.addAttribute("userlist", list);

		} else {
			List<userinfoDto> list = user.select(id, name, tel);
			if (list.isEmpty()) {
				form.clear();
				String msg = "入力されたデータは存在しません。";

				model.addAttribute("msg", msg);
				return "select";
			} else {
				model.addAttribute("userlist", list);
				return "selectResult";

			}
		}

		return "selectResult";
	}

}

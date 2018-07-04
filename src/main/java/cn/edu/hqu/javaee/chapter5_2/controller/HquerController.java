package cn.edu.hqu.javaee.chapter5_2.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import cn.edu.hqu.javaee.chapter5_2.Chapter52Application;
import cn.edu.hqu.javaee.chapter5_2.controller.formEntity.LoginForm;
import cn.edu.hqu.javaee.chapter5_2.controller.formEntity.RegisterForm;
import cn.edu.hqu.javaee.chapter5_2.entity.Hquer;
import cn.edu.hqu.javaee.chapter5_2.service.HquerService;

@Controller
@RequestMapping("/hquer")
public class HquerController {
	@Autowired
	HquerService hquerService;

	// 注册页面
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute(new RegisterForm());
		return "register";
	}

	// 注册处理器
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegister(@Valid RegisterForm registerForm, Errors errors, RedirectAttributes model)
			throws IOException {

		if (errors.hasErrors())
			return "register";
		else {
			Hquer hquer = new Hquer();
			hquer.setEmail(registerForm.getEmail());
			hquer.setFirstName(registerForm.getFirstName());
			hquer.setLastName(registerForm.getLastName());
			hquer.setPassword(registerForm.getPassword());
			hquer.setUserName(registerForm.getUserName());
			if (!hquerService.register(hquer)) {
				errors.rejectValue("userName", "用户已存在");
				return "register";
			} else {
				Files.copy(registerForm.getPicFile().getInputStream(),
						Paths.get(Chapter52Application.ROOT, hquer.getUserName() + ".jpeg"),
						StandardCopyOption.REPLACE_EXISTING);
				model.addFlashAttribute(hquer);
				return "redirect:/hquer/" + hquer.getUserName();
			}
		}
	}

	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public String hquerProfile(@PathVariable String userName, Model model) {
		if (!model.containsAttribute("hquer")) {
			Hquer hquer = hquerService.getUserDetail(userName);
			model.addAttribute(hquer);
		}
		return "hquer_profile";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		model.addAttribute(new LoginForm());
		return "login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(@Valid LoginForm loginForm, Errors erros, RedirectAttributes model) {
		Hquer hquer;
		if ((hquer = hquerService.login(loginForm.getUserName(), loginForm.getPassword())) == null)
			return "login";

		model.addFlashAttribute(hquer);
		return "redirect:/hquer/" + hquer.getUserName();

	}
}
package com.care.mvc_ex04;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.member.Member;

@Controller
public class QuizController {
	@RequestMapping("index")
	public String index() {
		return "redirect02/index";
	}
	
	@RequestMapping("result")
	public String result(Model model, HttpServletRequest request,RedirectAttributes ra ) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println("id : " + id);
		if(id.equals("abc")) {
			if(pwd.equals("1234")) {				
				//ra.addFlashAttribute("id", id);
				//ra.addFlashAttribute("pwd", pwd);
				return "redirect:rsOK";
			}
		}
		return "redirect:rsNO";
	}
	
	@RequestMapping("rsOK")
	public String rsOK(Model model, HttpServletRequest request) {
		model.addAttribute("id", request.getParameter("id"));
		model.addAttribute("pwd", request.getAttribute("pwd"));
		return "redirect02/rsOK";
	}
	
	@RequestMapping("rsNO")
	public String rsNO(Model model) {
		return "redirect02/index";
	}
	
	@RequestMapping("resultMember")
	public String resultMember(Model model, HttpServletRequest request, Member member) {
		member.setName(request.getParameter("name"));
		member.setAge(request.getParameter("age"));
		member.setAddr(request.getParameter("addr"));
		model.addAttribute("mem", member);
		//System.out.println(request.getParameter("id"));
		//System.out.println(request.getParameter("pwd"));
		return "redirect02/resultMember";
	}
}

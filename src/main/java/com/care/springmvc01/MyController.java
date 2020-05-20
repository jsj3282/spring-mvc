package com.care.springmvc01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jdk.nashorn.internal.objects.annotations.Getter;

@Controller
public class MyController {
	
	@RequestMapping("aaa")
	//RequestMapping은 server.xml의 context~ path:다음에 들어올 url이다
	public String memberIndex() {
		
		return "/member/index";
		//servlet-contextxml의 beans property를 참고해서 prefix, postfix가 붙는다
	}
	
	@RequestMapping(value="/logout")
	//@GetMapping(value="/logout")
	//@PostMapping(value="/logout")
	//getmapping을 쓰거나 postmapping을 쓰면 get 방식으로만 처리할 수 있거나 post 방식으로만 처리할 수 있다.
	public String memberLogout(Model model) {
		model.addAttribute("logout", "로그아웃");
		//데이터베이스 연동 후 결과값 가져옴 : Model
		return "/member/logout";
	}
	
	@GetMapping(value="/login")
	public ModelAndView memberLogin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("login", "로그인 성공!!!");
		mv.setViewName("member/login");
		return mv;
		//mv는 경로와 attribute를 동시에 만들어줌
	}
	
}

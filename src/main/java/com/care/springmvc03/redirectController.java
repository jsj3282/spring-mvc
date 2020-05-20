package com.care.springmvc03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class redirectController {
	@RequestMapping("index")
	public String index() {
		return "redirect01/index";
	}
	
	@RequestMapping("result")
	public String result(Model model, HttpServletRequest request 
			,RedirectAttributes ra
			) {
		//RedirectAttributes를 통해 모델에 있는 값을 넘겨줄 수 있다.
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		//model.addAttribute("test", "연습중!!!");
		//ra.addAttribute("test", "ra를 통해 넘어온 값");
		ra.addFlashAttribute("test", "ra를 통해 넘어온 값!!");
		if(id.equals("abc")) {
			return "redirect:rsOK";
			//return "redirect01/rsOK";
			//위처럼 쓰는 것은 단순히 페이지만 이동
		}
		return "redirect:rsNO";
		//밑에 메소드로 보내줌
		//이렇게 쓰는 이유는 사용자의 정보를 가져오면 내용이 조금 바뀔 수 있다.
	}
	
	@RequestMapping("rsOK")
	public String rsOK(Model model) {
		model.addAttribute("name", "홍길동");
		return "redirect01/rsOK";
	}
	
	@RequestMapping("rsNO")
	public String rsNO(//@RequestParam("test") String aaa,
			Model model, HttpServletRequest request) {
		//request의 attribute를 받아오려면 annotation을 이용해서 requestParam을 쓰거나 HttpServletRequest를 이용해서 받아온다
		//request와 redirect중에 redirect가 우선시된다. 
		//System.out.println(aaa);
		//System.out.println("req : " + request.getAttribute("test"));
		System.out.println("req : " + request.getParameter("test"));
		//model에 대한 값을 넘겨받을 때 attribute가 아니라 parameter로 넘겨받아야 한다.
		//model.addAttribute("test", "aaaaaa");
		return "redirect01/rsNO";
	}
}

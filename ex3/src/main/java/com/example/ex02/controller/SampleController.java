package com.example.ex02.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex/*")//ex02부터 모든경로는 무조건 이 컨트롤러오라는 뜻
@Log4j
public class SampleController {
	
	@RequestMapping(value="/basic", method = {RequestMethod.GET,RequestMethod.POST})
	//위에 경로 뒤에 /basic이라고 하면 이쪽으로 온나 라는뜻
	public void basic(HttpServletRequest req) {
		log.info("basic..." + req.getMethod());
	}
	
	@RequestMapping
	public void basic2() {
		log.info("basic2......");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basic
}

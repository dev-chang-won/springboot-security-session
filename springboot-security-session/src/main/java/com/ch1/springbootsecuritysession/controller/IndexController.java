package com.ch1.springbootsecuritysession.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch1.springbootsecuritysession.model.UserSchema;
import com.ch1.springbootsecuritysession.repository.UserRepository;

@Controller
public class IndexController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository; 
	
	@GetMapping("")
	public String home() {
		
		/*
		 * 뷰 설정 prefix:/WEB-INF/views/ , suffix:.html 
		 * */
		System.out.println("=== home ===");
		return "home";
	}
	

	@GetMapping("/loginForm")
	public String loginForm() {
		return "login-form";
	}
	@GetMapping("/joinForm")
	public String joinForm() {
		return "join-form";
	}
	
	@PostMapping("/joinProc")
	public String joinProc(UserSchema user) {
		System.out.println("user:"+user.toString());

		// 스프링시큐리티 사용을 위한 비번 암호화 처리
		String orgPwd = user.getPassword();
		String encPwd = bCryptPasswordEncoder.encode(orgPwd);
		
		user.setRole("ROLE_USER");
		user.setPassword(encPwd);
		
		userRepository.save(user);
		return loginForm();
	}	
	
	
	@GetMapping("/user")
	public @ResponseBody String user() {
		System.out.println("=== user ===");
		return "user";
	}	
	@GetMapping("/manager")
	public @ResponseBody String manager() {
		System.out.println("=== manager ===");
		return "manager";
	}	
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		System.out.println("=== admin ===");
		return "admin";
	}
	
	@Secured({"ROLE_MANAGER" , "ROLE_ADMIN"})	/* SecurityCofig 에서 지정되지 않음 별도의 정보 확인 */
	@GetMapping("/info1")
	public @ResponseBody String info1() {
		System.out.println("=== info1 ===");
		return "info1";
	}	
	
	@PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")	/*해당 메서드 실행전 권한 확인 */
	@PostAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")	/*해당 메서드 실행후 권한 확인 */
	@GetMapping("/info2")
	public @ResponseBody String info2() {
		System.out.println("=== info2 ===");
		return "info2";
	}	
}
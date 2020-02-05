package com.quyvu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quyvu.entity.DangNhap;

@Controller
@RequestMapping("/login")
public class DangNhapController {
	@GetMapping
	public String LoginRequirer() {
		return "login";
	}
	@PostMapping
	public String Login(@ModelAttribute DangNhap dangnhap, ModelMap modelMap) {
		modelMap.addAttribute("dangnhap", dangnhap);
		if (!dangnhap.getUserName().equals("quyvu"))
			return "login";
		return "trangchu";
	}
}

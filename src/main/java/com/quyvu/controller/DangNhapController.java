package com.quyvu.controller;

import com.quyvu.entity.NhanVien;
import com.quyvu.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/login")
public class DangNhapController {
	@Autowired
	NhanVienService nhanVienService;
	
	@GetMapping()
	public String Default(HttpSession httpSession, ModelMap modelMap) {
		if(httpSession.getAttribute("email")!=null){
			return "trangchu";
		}
		return "login";
	}
	@PostMapping
	public String SignUpNew(@RequestParam String email, @RequestParam String matkhau, @RequestParam String nhaplaimatkhau, ModelMap modelMap){
		if(isValidEmailAddress(email)){
			if(email.isEmpty() || matkhau.isEmpty() || nhaplaimatkhau.isEmpty()) {
				modelMap.addAttribute("Status", 2002);
			}
			else if(!matkhau.equals(nhaplaimatkhau)){
				modelMap.addAttribute("Status", 2003);
			}
			else{
				if(nhanVienService.KiemTraTonTai(email)){
					modelMap.addAttribute("Status", 2006);
					return "login";
				}
				NhanVien nhanVien=new NhanVien();
				nhanVien.setEmail(email);
				nhanVien.setMatkhau(matkhau);
				boolean status  = nhanVienService.SignUp(nhanVien);
				modelMap.addAttribute("Status", status?2001:2005);
			}
		}
		else 
			modelMap.addAttribute("Status", 2004);
		
		return "login";
	}
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean isValidEmailAddress(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		return matcher.find();
	}
}

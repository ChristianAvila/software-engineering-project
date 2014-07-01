package mx.itesm.chris.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String holaMundoSpring( HttpServletRequest req, Model model){
		String m = "Saludos desde spring";
		model.addAttribute("mensaje", m);
		return "index";
	}
}

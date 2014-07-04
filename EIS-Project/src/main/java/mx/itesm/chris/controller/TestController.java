package mx.itesm.chris.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Document;
import com.fourspaces.couchdb.Session;

@Controller
public class TestController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String holaMundoSpring( HttpServletRequest req, Model model){
		//creates a couchdb session
		Session dbSession = new Session("localhost", 5984);
		String dbname = "test";
		//retrieve document
		Database db = dbSession.getDatabase(dbname);
		Document doc = db.getDocument("0b9196efdc8fd2fae59a3c3620000e29");
		String json = doc.toString();
		System.out.println(json);
		
		HttpSession session = req.getSession();
		session.setAttribute("json_svariable",json);
		
		model.addAttribute("mensaje", json);
		
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String startPath( HttpServletRequest req, Model model){
		//creates a couchdb session
		Session dbSession = new Session("localhost", 5984);
		String dbname = "test";
		//retrieve document
		Database db = dbSession.getDatabase(dbname);
		Document doc = db.getDocument("0b9196efdc8fd2fae59a3c3620000e29");
		String json = doc.toString();
		System.out.println(json);
		
		HttpSession session = req.getSession();
		session.setAttribute("json_svariable",json);
		
		model.addAttribute("mensaje", json);
		
		return "index";
	}
	
}

package mx.itesm.chris.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fourspaces.couchdb.Database;
import com.fourspaces.couchdb.Session;
import com.fourspaces.couchdb.View;
import com.fourspaces.couchdb.ViewResults;

@Controller
public class TestController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String startPath( HttpServletRequest req, Model model){
		String year = req.getParameter("year");
		if(year != null)
			model.addAttribute("year","?year=" + year );	
		return "index";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getDataByYear", method = RequestMethod.GET, produces = "text/json")
	public String getDataByYear( HttpServletRequest req, Model model){
		
		//creates a couchdb session
		Session dbSession = new Session("localhost", 5984);
		String dbname = "meteorite";
		//retrieve document
		Database db = dbSession.getDatabase(dbname);
		
		String year = req.getParameter("year");
		if(year != null)
			year =  "%22" + year +"%22";
		else
			year =  "%221916%22";
		
		View vw = new View("test1/test2");
		vw.setKey(year);
		ViewResults resultAdHoc = db.view(vw );
		
		model.addAttribute("mensaje", resultAdHoc.toString());
		
		return resultAdHoc.toString();
	}
	
}

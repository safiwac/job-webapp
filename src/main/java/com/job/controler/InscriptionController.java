package com.job.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.job.entity.model.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.manager.ICandidatManager;
import com.service.manager.IPaysManager;

/*
 * @author EL HAHY Zakaria
 */
@Controller
public class InscriptionController {

	@Autowired
	IPaysManager iPaysManager;

	@Autowired
	ICandidatManager iCandidatManager;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Hi, Welcome to mysite");
		return "welcome";
	}
	
	

	@RequestMapping(value = { "/inscription" }, method = RequestMethod.GET)
	public String getInscription(Candidat candidat, Model model) {
		model.addAttribute("listcountry", iPaysManager.findAllCoutry());
		model.addAttribute("command", new Candidat());
		model.addAttribute("candidatForm", new Candidat());
		return "inscription";
	}

	@RequestMapping(value = { "/inscription" }, method = RequestMethod.POST)
	public String postInscription(@ModelAttribute("candidatForm") Candidat candidat, BindingResult result,
			Model model) {
		Candidat candidatSaved = iCandidatManager.save(candidat);
		System.out.println(candidatSaved);
		return "confirmationInscription";
	}




}
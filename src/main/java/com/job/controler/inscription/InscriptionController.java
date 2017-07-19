package com.job.controler.inscription;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.job.entity.model.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.job.utils.GlobalConstant;
import com.service.manager.ICandidatManager;
import com.service.manager.IPaysManager;

/*
 * @author EL HAHY Zakaria
 */
@Controller
@SessionAttributes( value=GlobalConstant.CANDIDAT_CONNECTED, types={Candidat.class} )
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
	public String getInscription(Model model,
		HttpServletRequest request, HttpSession session) {
		Candidat c =  new Candidat();
	    c.setNom("zakaria");
		session.setAttribute(GlobalConstant.CANDIDAT_CONNECTED, c);
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


	// confirmationInscription 
//	@RequestMapping(value = { "/confirmationInscription" }, method = RequestMethod.GET)
//	public String getConformationInscription(@ModelAttribute(GlobalConstant.CANDIDAT_CONNECTED) Candidat candidated, Model model) {
//		if(Objects.nonNull(candidated))
//			System.out.println(candidated.getNom());
//		else
//			System.out.println("non null");
//		return "confirmationInscription";
//	}

	@RequestMapping(value = { "/confirmationInscription" }, method = RequestMethod.GET)
	public String getConformationInscription( Model model) {
		
		return "confirmationInscription";
	}



}
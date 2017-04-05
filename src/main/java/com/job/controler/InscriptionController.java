package com.job.controler;

import org.job.entity.model.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/")
public class InscriptionController {
	
	@Autowired
	IPaysManager iPaysManager;
	
	@Autowired
	ICandidatManager iCandidatManager;

	@RequestMapping(value = { "/inscription"}, method = RequestMethod.GET)
	public String getInscription(Candidat candidat, Model model) {
		model.addAttribute("listcountry", iPaysManager.findAllCoutry());
		 model.addAttribute("command",new Candidat());
		 model.addAttribute("candidatForm",new Candidat());
		return "inscription";
	}

	@RequestMapping(value = { "/inscription"}, method = RequestMethod.POST)
	public String postInscription(@ModelAttribute("candidatForm") Candidat candidat,
			BindingResult result, Model model) {	
		Candidat candidatSaved = iCandidatManager.save(candidat);
		System.out.println(candidatSaved);
		return "inscription";
	}

	
	@RequestMapping(value = { "/products"}, method = RequestMethod.GET)
	public String productsPage(ModelMap model) {
		return "products";
	}

	@RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "contactus";
	}
	

}
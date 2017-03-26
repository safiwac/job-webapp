package com.job.controler;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.job.entity.model.Candidat;
import org.job.entity.model.Pays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * @author EL HAHY Zakaria
 */
@Controller
@RequestMapping("/")
public class InscriptionController {

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		Candidat candidat = new Candidat();
		candidat.setNom("zakariaiaiaiaiai");
		Pays pays = new Pays();
		pays.setNom("dkhhdfjhdgfjhdfghjdfghdf");
		candidat.setPays(pays);
		 model.addAttribute("command",candidat);
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Map referenceData(HttpServletRequest request) throws Exception {

		Map referenceData = new HashMap();

		Map<String,String> country = new LinkedHashMap<String,String>();
		country.put("US", "United Stated");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		referenceData.put("countryList", country);

		Map<String,String> javaSkill = new LinkedHashMap<String,String>();
		javaSkill.put("Hibernate", "Hibernate");
		javaSkill.put("Spring", "Spring");
		javaSkill.put("Apache Wicket", "Apache Wicket");
		javaSkill.put("Struts", "Struts");
		referenceData.put("javaSkillsList", javaSkill);

		return referenceData;
	}
}
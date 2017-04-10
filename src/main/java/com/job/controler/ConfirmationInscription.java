package com.job.controler;

import java.math.BigInteger;

import org.job.entity.enums.UserStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.manager.ICandidatManager;

/*
 * @author EL HAHY Zakaria
 */

@Controller
@RequestMapping(value = { "/confirmationInscription" })
public class ConfirmationInscription {

	@Autowired
	ICandidatManager iCandidatManager;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getPage(@RequestParam(value = "id", required = false) String id,ModelAndView mav) {
		System.out.println("--------------------"+id);
		iCandidatManager.aliveCandidat(new BigInteger(id), UserStatusEnum.CONFIRM_INSCRIPTION);
//		  if (!user.isAuthenticated()) {
//		        mav.setViewName("redirect:http://www.test.com/login.jsp");
//		        return mav;
//		    }
		return mav;
	}

}

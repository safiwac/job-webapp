package com.job.formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;

import org.job.entity.model.Pays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.service.manager.IPaysManager;

/*
 * @author EL HAHY Zakaria
 */
@Component
public class PaysFormatter implements Formatter<Pays> {
	
	@Autowired
	IPaysManager iPaysManager;

	@Override
	public String print(Pays arg0, Locale arg1) {
		return arg0.getNom();
	}

	@Override
	public Pays parse(String nameCountry, Locale arg1) throws ParseException {
		// TODO Auto-generated method stub
		Pays pays = iPaysManager.searchCountry(nameCountry);
		if(Objects.isNull(pays)){
			pays.setLibelle("Inconnu");
			pays.setNom("inconnu");
			pays.setPays_id(-1L);
		}
		return pays;
	}

}

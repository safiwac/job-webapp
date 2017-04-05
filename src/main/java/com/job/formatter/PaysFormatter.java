package com.job.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.job.entity.model.Pays;
import org.springframework.format.Formatter;

/*
 * @author EL HAHY Zakaria
 */
public class PaysFormatter implements Formatter<Pays> {

	@Override
	public String print(Pays arg0, Locale arg1) {
		return arg0.getNom();
	}

	@Override
	public Pays parse(String arg0, Locale arg1) throws ParseException {
		// TODO Auto-generated method stub
		Pays pays = new Pays();
		pays.setLibelle("kkdkjdjhfdf");
		pays.setNom("maroc");
		pays.setPays_id(9L);
		return pays;
	}

}

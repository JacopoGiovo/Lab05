package it.polito.tdp.anagrammi.model;

import java.util.*;
import it.polito.tdp.anagrammi.*;
import it.polito.tdp.anagrammi.DAO.*;
import it.polito.tdp.anagrammi.model.*;


public class Model {
	List <String> corrette;
	List <String> errate;
	List <String> totali;
	Ricorsione ricorsione = new Ricorsione();
	ParolaDAO pd=new ParolaDAO();
	
	public List <String> tuttiRisultati(String parola){
		totali=new LinkedList();
		totali=ricorsione.anagrammi(parola);
		return totali;
	}
	
	public String risultatiEsatti(String parola){
		String sol="";
		corrette=new ArrayList();
		errate=new ArrayList();
		totali=new ArrayList();
		totali=ricorsione.anagrammi(parola);
		for(String s: totali) {
			if(pd.isCorrect(s)==true)
			corrette.add(s);
		}
		for(String s: corrette)
		{
			sol=sol+s+"\n";
		}
		return sol;
	}
	public String risultatiErrati(String parola){
		String sol="";
		corrette=new ArrayList();
		errate=new ArrayList();
		totali=new ArrayList();
		totali=ricorsione.anagrammi(parola);
		for(String s: totali) {
			if(pd.isCorrect(s)==false)
			errate.add(s);
		}
		for(String s: errate)
		{
			sol=sol+s+"\n";
		}
		return sol;
	}

	

}

package it.polito.tdp.anagrammi.model;
import it.polito.tdp.anagrammi.DAO.*;
import it.polito.tdp.anagrammi.*;
import it.polito.tdp.anagrammi.model.*;
import java.util.*;

public class Ricorsione {
	public List <String> soluzione;
	
	public List <String> anagrammi (String parola) {
	parola=parola.toLowerCase();
	this.soluzione=new ArrayList<>();
	
	List <Character> disponibili=new ArrayList <>();
	for(int i=0;i<parola.length();i++) {
		disponibili.add(parola.charAt(i));
	}
	
	cerca("",0,disponibili);
	return this.soluzione;
	}
	
	
	// procedura ricorsiva per il calcolo dell'anagramma;
	// parziale: parte iniziale dell'anagramma costruito finora;
	//livello: livello della ricorsione,sempre uguale a parziale.length();
	//disponibili:insieme delle lettere non ancora utilizzate;
	private void cerca(String parziale,int livello, List <Character> disponibili) {
		if(disponibili.size()==0) {
			//caso terminale
			this.soluzione.add(parziale);
		}
		//caso normale,provo a aggiungere alla sol.parziale tutti i caratteri presenti tra i 'disponibili'
		for(Character ch:disponibili) {
			String tentativo=parziale+ch;
			List <Character> ridotta=new ArrayList<>(disponibili);
			ridotta.remove(ch);
			cerca(tentativo,livello+1,ridotta);
		}
	}
	
	//Dato di partenza: parola da anagrammare, di lunghezza N;
	//Soluzione parziale: una parte dell'anagramma già costruito(primi caratteri)
	//Livello:numero di lettere di cui è composta la soluzione parziale;
    // Caso terminale: salvare la soluzione trovata;
	// generare nuove soluzioni: scelgo una lettera tra quelle che non sono ancora utilizzate (nella soluzione parziale)
}

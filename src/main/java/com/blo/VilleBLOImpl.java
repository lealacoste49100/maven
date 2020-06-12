package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDAO;
	
	public ArrayList<Ville>  getInfoVille() {
		ArrayList<Ville>  listeville;
		
		//TODO dao
		listeville = villeDAO.getInfoVille();
		
		return listeville;
	}
	
	public void ajouterVille(String codePostal, String codeCommune, String nomCommune, String libelle, String ligne, String longitude, String latitude) {
		
		//TODO dao
		villeDAO.ajouterVille(codePostal,codeCommune,nomCommune,libelle,ligne,longitude,latitude);
		
	}
}

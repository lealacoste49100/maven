package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville>  getInfoVille();
	public void ajouterVille(String codePostal, String codeCommune, String nomCommune, String libelle, String ligne, String longitude, String latitude);

}

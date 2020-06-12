package com.blo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.dto.Ville;

@Service
public interface VilleBLO {
	public ArrayList<Ville>  getInfoVille();
	public void ajouterVille(String codePostal, String codeCommune, String nomCommune, String libelle, String ligne, String longitude, String latitude );
}

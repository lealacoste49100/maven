package com.blo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.dto.Ville;

@Service
public interface VilleBLO {
	public ArrayList<Ville>  getInfoVille();
	public void creerVille(Ville ville);
	public ArrayList<Ville> getVille(String codePostal);
	public boolean updateVille(Ville ville);
	public Ville getVilleCode(String codeCommune);
	public boolean deleteVille(String codeCommune);
}

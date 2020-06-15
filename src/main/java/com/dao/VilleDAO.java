package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville>  getInfoVille();
	public void setVille(Ville ville);
	public ArrayList<Ville> getVille(String codePostal);
	public boolean updateVille(Ville ville);
	public Ville getVilleCode(String codeCommune);
	public boolean deleteVille(String codeCommune);
}

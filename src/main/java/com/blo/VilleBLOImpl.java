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
	

	@Override
	public void creerVille(Ville ville) {
		villeDAO.setVille(ville);
	}
	
	@Override
	public ArrayList<Ville> getVille(String codePostal) {
		ArrayList<Ville> ville;
		ville = villeDAO.getVille(codePostal);
		return ville;
	}
	
	@Override
	public Ville getVilleCode(String codeCommune) {
		Ville ville;
		ville = villeDAO.getVilleCode(codeCommune);
		return ville;
	}
	
	@Override
	public boolean updateVille(Ville ville) {
		boolean result;
		result = villeDAO.updateVille(ville);
		return result;
	}
	
	@Override
	public boolean deleteVille(String codeCommune) {
		boolean result;
		result = villeDAO.deleteVille(codeCommune);
		return result;
	}
}

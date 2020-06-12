package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	public ArrayList<Ville> getInfoVille() {
		ArrayList<Ville> listeVilles = new ArrayList<Ville>();
		
		Connection conn = JDBCConfiguration.getConnection();
		ResultSet resultat = null;
		String requete = "SELECT * FROM ville_france";
		try {
			Statement stat = conn.createStatement();
			resultat= stat.executeQuery(requete);
			
			while(resultat.next()) {
				//System.out.println("rep: " + resultat.getString("Nom_commune"));
				Ville ville = new Ville();
				ville.setCodePostal(resultat.getString("Code_postal"));
				ville.setCodeComune(resultat.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultat.getString("Nom_commune"));
				ville.setLibelle(resultat.getString("Libelle_acheminement"));
				ville.setLigne(resultat.getString("Ligne_5"));
				ville.setLongitude(resultat.getString("Longitude"));
				ville.setLatitude(resultat.getString("Latitude"));
				listeVilles.add(ville);
			}
		}catch(SQLException e){
			
		}
		
		return listeVilles;
	}
	
	public void ajouterVille(String codePostal, String codeCommune, String nomCommune, String libelle, String ligne, String longitude, String latitude ) {
		
		Connection conn = JDBCConfiguration.getConnection();
		int resultat = 0;
		String requete = "INSERT INTO ville_france ('Code_commune_INSEE','Nom_commune','Code_postal','Libelle_acheminement','Ligne_5','Latitude','Longitude') VALUES ("+
		codePostal+","+codeCommune+","+nomCommune+","+libelle+","+ligne+","+longitude+","+latitude+")";
		try {
			Statement stat = conn.createStatement();
			resultat= stat.executeUpdate(requete);
			
			stat.close();
			conn.close();
			
		}catch(SQLException e){
			
		}
		
	}
}

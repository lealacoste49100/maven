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
	
	@Override
	public void setVille(Ville ville) {

		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"Insert into ville_france(Code_commune_INSEE,Nom_commune,Libelle_acheminement,Ligne_5,Latitude,Code_postal,Longitude)"
							+ " values(" + ville.getCodeComune() + ",'" + ville.getNomCommune() + "','"
							+ ville.getLibelle() + "','" + ville.getLigne() + "'," + ville.getLatitude() + ","
							+ ville.getCodePostal() + "," + ville.getLongitude()+ ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public ArrayList<Ville> getVille(String codePostal) {
		ResultSet resultat = null;
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		


		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			resultat = stmt.executeQuery(
					"SELECT * FROM ville_france WHERE Code_postal="+codePostal);
			while(resultat.next()) {
				Ville ville = new Ville();
				ville.setCodePostal(resultat.getString("Code_postal"));
				ville.setCodeComune(resultat.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultat.getString("Nom_commune"));
				ville.setLibelle(resultat.getString("Libelle_acheminement"));
				ville.setLigne(resultat.getString("Ligne_5"));
				ville.setLongitude(resultat.getString("Longitude"));
				ville.setLatitude(resultat.getString("Latitude"));
				listVille.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVille;
	}
	
	@Override
	public Ville getVilleCode(String codeCommune) {
		ResultSet resultat = null;
		Ville ville = new Ville();
		


		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			resultat = stmt.executeQuery(
					"SELECT * FROM ville_france WHERE Code_commune_INSEE="+codeCommune);
			while(resultat.next()) {
				ville.setCodePostal(resultat.getString("Code_postal"));
				ville.setCodeComune(resultat.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultat.getString("Nom_commune"));
				ville.setLibelle(resultat.getString("Libelle_acheminement"));
				ville.setLigne(resultat.getString("Ligne_5"));
				ville.setLongitude(resultat.getString("Longitude"));
				ville.setLatitude(resultat.getString("Latitude"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ville;
	}
	
	
	@Override
	public boolean updateVille(Ville ville) {
		int resultat = 0;
		
		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			String ok = "UPDATE ville_france SET Code_postal='"+ville.getCodePostal()+"',Nom_commune='"+ville.getNomCommune()+"',Libelle_acheminement='"+ville.getLibelle()+
					"',Code_commune_INSEE='"+ville.getCodeComune()+"',Ligne_5='"+ville.getLigne()+"',Longitude='"+ville.getLongitude()+"',Latitude='"+ville.getLatitude()+
					"' WHERE Code_commune_INSEE='"+ville.getCodeComune()+"'";
			System.out.println(ok);
			resultat = stmt.executeUpdate(
					 "UPDATE ville_france SET Code_postal='"+ville.getCodePostal()+"',Nom_commune='"+ville.getNomCommune()+"',Libelle_acheminement='"+ville.getLibelle()+
						"',Code_commune_INSEE='"+ville.getCodeComune()+"',Ligne_5='"+ville.getLigne()+"',Longitude='"+ville.getLongitude()+"',Latitude='"+ville.getLatitude()+
						"' WHERE Code_commune_INSEE='"+ville.getCodeComune()+"'");
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteVille(String codeCommune) {
		int resultat = 0;
		
		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			resultat = stmt.executeUpdate(
					"DELETE FROM ville_france WHERE Code_commune_INSEE="+codeCommune);
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}

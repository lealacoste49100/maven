package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dao.VilleDAO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public  ArrayList<Ville> appelGet() {
		System.out.println("Appel GET");
		
		 ArrayList<Ville> listeville = villeBLOService.getInfoVille();		
	
		
		return listeville;
	}
	
	//Method POST
	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
	@ResponseBody
	public  void appelPost(@RequestParam{required="false", value="codePostal"} String codePostal, String codeCommune, String nomCommune, String libelle, String ligne, String longitude, String latitude)) {
		System.out.println("Appel POST");
		
		 villeBLOService.ajouterVille(codePostal,codeCommune,nomCommune,libelle,ligne,longitude,latitude);		
	
		
	}
}

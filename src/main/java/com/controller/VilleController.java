package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dao.VilleDAO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {
	@Autowired
	VilleBLO villeService;

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codePostal") String monParam)
			throws ClassNotFoundException, SQLException {
		System.out.println("Appel GET");
		System.out.println("param = " + monParam);
		ArrayList<Ville> ville = villeService.getInfoVille();
		return ville;
	}

	// Methode POST
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<Ville> appelPost(@RequestBody Ville ville)
			throws ClassNotFoundException, SQLException {
		System.out.println("Appel POST");
		villeService.creerVille(ville);
		ArrayList<Ville> ville1 =null;
		return ville1;
	}
	
	// Methode GET
	@RequestMapping(value = "/villeCP", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGetCodePostal(@RequestParam(required = true, value = "codePostal") String codePostal)
			throws ClassNotFoundException, SQLException {
		System.out.println("Ma fonction");
		ArrayList<Ville> ville;
		ville = villeService.getVille(codePostal);
		return ville;
	}
	
	// Methode GET
	@RequestMapping(value = "/villeCC", method = RequestMethod.GET)
	@ResponseBody
	public Ville appelGetCodeCommune(@RequestParam(required = true, value = "codeCommune") String codeCommune)
			throws ClassNotFoundException, SQLException {
		System.out.println("Ma fonction");
		Ville ville;
		ville = villeService.getVilleCode(codeCommune);
		return ville;
	}
	
	// Methode PUT
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public boolean appelPut(@RequestBody Ville ville, @RequestParam(required = true, value = "codeCommune") String codeCommune )
			throws ClassNotFoundException, SQLException {
		System.out.println("Ma fonction");
		boolean result;
		result = villeService.updateVille(ville);
		return result;
	}
	
	// Methode DELETE
	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean appelDelete( @RequestParam(required = true, value = "codeCommune") String codeCommune )
			throws ClassNotFoundException, SQLException {
		System.out.println("Ma fonction");
		boolean result;
		result = villeService.deleteVille(codeCommune);
		return result;
	}
}

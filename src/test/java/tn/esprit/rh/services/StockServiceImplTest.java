package tn.esprit.rh.services;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;

import tn.esprit.rh.entities.DetailFacture;
import tn.esprit.rh.entities.Facture;
import tn.esprit.rh.entities.Operateur;
import tn.esprit.rh.entities.Reglement;
import tn.esprit.rh.services.IFactureService;
import tn.esprit.rh.services.IOperateurService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StockServiceImplTest {
	@Autowired
	IFactureService f;
	@Autowired
	IOperateurService s;
	@Test
	@Order(1)
	void all() {
		List<Facture> factures = f.retrieveAllFactures();
		Assertions.assertEquals(0, factures.size());
		
	
	}
	
	@Test
	@Order(2)
	void addFacture_ok() {
		List<Facture> factures = f.retrieveAllFactures();
		int currentSize = factures.size();
		Facture facture = new Facture();
		facture.setMontantFacture(250);
		facture.setMontantRemise(200);
		/*facture.setDateCreationFacture();*/
		/*facture.setDateDerniereModificationFacture();*/
		
		 Set<DetailFacture> detailsFacture  = new HashSet<>();
		facture.setDetailsFacture(detailsFacture);
		Set<Reglement> reglement = new  HashSet<>();
		facture.setReglements(reglement);
		/*Fournisseur fournisseur = new Fournisseur();
		facture.setFournisseur(fournisseur);*/
		
		
		Facture savedFacture = f.addFacture(facture);
		assertEquals(currentSize + 1, f.retrieveAllFactures().size());
	}
	
	@Test
	@Order(3)
	 void retriveFacture_ok() {
		Facture retrived = f.retrieveFacture(30l);
		Assertions.assertEquals(30l, retrived.getIdFacture());
	}
	
	@Test()
	@Order(3)
	@Transactional
	void assignSecteurActiviteToFournisseur() {
		f.assignOperateurToFacture(1L, 30L);                         
		Operateur oper =s.retrieveOperateur(1l);
		assertEquals(1, oper.getFactures().size());
		assertEquals(30L, Optional.ofNullable(oper.getFactures().iterator().next().getIdFacture()).get().longValue());
	}
	
	/*@Test
	@Order(4)
	void deleteFacture_ok() {
		f.deleteFacture(9L);
		Assertions.assertNull(f.retrieveFacture(9l));
	}*/



}

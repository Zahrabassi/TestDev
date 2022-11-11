package tn.esprit.rh.services;

import java.util.Date;
import java.util.List;

import tn.esprit.rh.entities.Facture;
import tn.esprit.rh.entities.Fournisseur;

public interface IFactureService {
	List<Facture> retrieveAllFactures();

	List<Facture> getFacturesByFournisseur(Long idFournisseur);

	Facture addFacture(Facture f);

	void cancelFacture(Long id);
	
	Facture updateFacture(Facture f);
		
	Facture retrieveFacture(Long id);
	
	void assignOperateurToFacture(Long idOperateur, Long idFacture);

	float pourcentageRecouvrement(Date startDate, Date endDate);

}

package tn.esprit.rh.services;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.entities.DetailFacture;
import tn.esprit.rh.entities.Facture;
import tn.esprit.rh.entities.Fournisseur;
import tn.esprit.rh.entities.Operateur;
import tn.esprit.rh.entities.Produit;
import tn.esprit.rh.repositories.DetailFactureRepository;
import tn.esprit.rh.repositories.FactureRepository;
import tn.esprit.rh.repositories.FournisseurRepository;
import tn.esprit.rh.repositories.OperateurRepository;
import tn.esprit.rh.repositories.ProduitRepository;

@Service
@Slf4j
@Transactional
public class FactureServiceImpl implements IFactureService {

	@Autowired
	FactureRepository factureRepository;
	@Autowired
	OperateurRepository operateurRepository;
	@Autowired
	DetailFactureRepository detailFactureRepository;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	ProduitRepository produitRepository;
    @Autowired
    ReglementServiceImpl reglementService;
	
	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		try {
			log.info("In Method retrieveAllFactures :");
			int i = 1/0;
		 factures = (List<Facture>) factureRepository.findAll();
		for (Facture facture : factures) {
		}
		log.info("out of Method retrieveAllFactures with succes");
		}catch (Exception e) {
			log.error("out of Method retrieveAllFactures with Errors + e");
		}
		return factures;
	}

	
	public Facture addFacture(Facture f) {
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		try {
			log.info("In Method addFacture :");
			int i = 1/0;
		 factures = (List<Facture>) factureRepository.findAll();
		for (Facture facture : factures) {
		}
		log.info("out of Method addFacture with succes");
		}catch (Exception e) {
			log.error("out of Method addFacture with Errors + e");
		}
		
		
		return factureRepository.save(f);
	}

	
	public Facture addDetailsFacture(Facture f, Set<DetailFacture> detailsFacture) {
		float montantFacture = 0;
		float montantRemise = 0;
		for (DetailFacture detail : detailsFacture) {
			//Récuperer le produit 
			Produit produit = produitRepository.findById(detail.getProduit().getIdProduit()).get();
			//Calculer le montant total pour chaque détail Facture
			float prixTotalDetail = detail.getQteCommandee() * produit.getPrix();
			//Calculer le montant remise pour chaque détail Facture
			float montantRemiseDetail = (prixTotalDetail * detail.getPourcentageRemise()) / 100;
			float prixTotalDetailRemise = prixTotalDetail - montantRemiseDetail;
			detail.setMontantRemise(montantRemiseDetail);
			detail.setPrixTotalDetail(prixTotalDetailRemise);
			//Calculer le montant total pour la facture
			montantFacture = montantFacture + prixTotalDetailRemise;
			//Calculer le montant remise pour la facture
			montantRemise = montantRemise + montantRemiseDetail;
			detailFactureRepository.save(detail);
		}
		f.setMontantFacture(montantFacture);
		f.setMontantRemise(montantRemise);
		return f;
	}

	@Override
	public void cancelFacture(Long factureId) {
		
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		try {
			log.info("In Method cancelFacture :");
			int i = 1/0;
		 factures = (List<Facture>) factureRepository.findAll();
		for (Facture facture : factures) {
		}
		log.info("out of Method cancelFacture with succes");
		}catch (Exception e) {
			log.error("out of Method cancelFacture with Errors + e");
		}
		
		Facture facture = factureRepository.findById(factureId).orElse(new Facture());
		facture.setArchivee(true);
		factureRepository.save(facture);
		//Méthode 02 (Avec JPQL)
		factureRepository.updateFacture(factureId);
	}

	@Override
	public Facture retrieveFacture(Long factureId) {

		Facture facture = factureRepository.findById(factureId).orElse(null);
		log.info("facture :" + facture);
		return facture;
	}

	@Override
	public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
		Fournisseur fournisseur = fournisseurRepository.findById(idFournisseur).orElse(null);
		Facture facture = factureRepository.findById(idFournisseur).orElse(null);
		return (List<Facture>) facture.getFournisseur();
	}

	@Override
	public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
		
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		try {
			log.info("In Method assignOperateurToFacture :");
			int i = 1/0;
		 factures = (List<Facture>) factureRepository.findAll();
		for (Facture facture : factures) {
		}
		log.info("out of Method assignOperateurToFacture with succes");
		}catch (Exception e) {
			log.error("out of Method assignOperateurToFacture with Errors + e");
		}
		Facture facture = factureRepository.findById(idFacture).orElse(null);
		Operateur operateur = operateurRepository.findById(idOperateur).orElse(null);
		operateur.getFactures().add(facture);

	}

	@Override
	public float pourcentageRecouvrement(Date startDate, Date endDate) {
		float totalFacturesEntreDeuxDates = factureRepository.getTotalFacturesEntreDeuxDates(startDate,endDate);
		float totalRecouvrementEntreDeuxDates =reglementService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
		float pourcentage=(totalRecouvrementEntreDeuxDates/totalFacturesEntreDeuxDates)*100;
		return pourcentage;
	}


	@Override
	public Facture updateFacture(Facture f) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
package tn.esprit.rh.services;

import java.util.List;

import tn.esprit.rh.dto.SecteurDTO;
import tn.esprit.rh.entities.SecteurActivite;


public interface ISecteurActiviteService {

	void deleteSecteurActivite(Long id);


	 public List<SecteurDTO> retrieveAllSecteurActivite2();
	 public SecteurDTO retrieveSecteurActivite2( Long id);
	 SecteurDTO addANDupdate2( SecteurDTO dto);

}

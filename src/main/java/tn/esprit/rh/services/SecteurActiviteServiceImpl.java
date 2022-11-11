package tn.esprit.rh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.rh.dto.ConverterSecteur;
import tn.esprit.rh.dto.SecteurDTO;
import tn.esprit.rh.entities.SecteurActivite;
import tn.esprit.rh.repositories.SecteurActiviteRepository;


@Service
public class SecteurActiviteServiceImpl implements ISecteurActiviteService{

	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;
	

	@Override
	public List<SecteurDTO> retrieveAllSecteurActivite2() {
		List<SecteurActivite> findAll = (List<SecteurActivite>) secteurActiviteRepository.findAll();
		return ConverterSecteur.entityToDto(findAll);
	}

	

	@Override
	public void deleteSecteurActivite(Long id) {
		secteurActiviteRepository.deleteById(id);
		
	}

	
	
	
	@Override
	public SecteurDTO retrieveSecteurActivite2( Long id) {
		SecteurActivite orElse = secteurActiviteRepository.findById(id).orElse(null);
		return ConverterSecteur.entityToDto(orElse);
		
	}
	
	@Override
public SecteurDTO addANDupdate2( SecteurDTO dto) {
		
		SecteurActivite secteurActivite = ConverterSecteur.dtoToEntity(dto);
		secteurActivite =  secteurActiviteRepository.save(secteurActivite );
		return ConverterSecteur.entityToDto(secteurActivite );
	}

}
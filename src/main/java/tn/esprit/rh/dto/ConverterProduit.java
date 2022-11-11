package tn.esprit.rh.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tn.esprit.rh.entities.Produit;

@Component
public class ConverterProduit {

	public static ProduitDTO entityToDto(Produit produit) {
		
		ProduitDTO dto = new ProduitDTO();

			dto.setCodeProduit(produit.getCodeProduit());
	 	dto.setIdProduit(produit.getIdProduit());
		dto.setLibelleProduit(produit.getLibelleProduit());

			return dto;
			
		
		}
		public static  List<ProduitDTO> entityToDto(List<Produit> produit) {
			
			return	produit.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
			
		}
		
		public static Produit dtoToEntity(ProduitDTO dto)
		
		{
		Produit pr = new Produit(null, null, null, 0);
		pr.setCodeProduit(dto.getCodeProduit());
	 pr.setIdProduit(dto.getIdProduit());
	 pr.setLibelleProduit(dto.getLibelleProduit());
			return pr;
			
		}
		
		public List<Produit> dtoToEntity(List<ProduitDTO> dto)
		{

			return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
		}

}

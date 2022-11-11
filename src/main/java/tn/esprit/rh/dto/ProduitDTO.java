package tn.esprit.rh.dto;






public class ProduitDTO {
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	
	public ProduitDTO(Long idProduit, String codeProduit, String libelleProduit) {
		super();
		this.idProduit = idProduit;
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
	}

	
	public ProduitDTO() {
		super();
		
	
	}


	public Long getIdProduit() {
		return idProduit;
	}


	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}


	public String getCodeProduit() {
		return codeProduit;
	}


	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}


	public String getLibelleProduit() {
		return libelleProduit;
	}


	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}
	
	
	
	
}
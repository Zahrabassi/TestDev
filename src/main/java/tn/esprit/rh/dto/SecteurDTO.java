package tn.esprit.rh.dto;

public class SecteurDTO {
	private Long idSecteurActivite;
	private String codeSecteurActivite;
	private String libelleSecteurActivite;
	public SecteurDTO(Long idSecteurActivite, String codeSecteurActivite, String libelleSecteurActivite) {
		super();
		this.idSecteurActivite = idSecteurActivite;
		this.codeSecteurActivite = codeSecteurActivite;
		this.libelleSecteurActivite = libelleSecteurActivite;
	}
	public SecteurDTO() {
		super();
	
	}
	public Long getIdSecteurActivite() {
		return idSecteurActivite;
	}
	public void setIdSecteurActivite(Long idSecteurActivite) {
		this.idSecteurActivite = idSecteurActivite;
	}
	public String getCodeSecteurActivite() {
		return codeSecteurActivite;
	}
	public void setCodeSecteurActivite(String codeSecteurActivite) {
		this.codeSecteurActivite = codeSecteurActivite;
	}
	public String getLibelleSecteurActivite() {
		return libelleSecteurActivite;
	}
	public void setLibelleSecteurActivite(String libelleSecteurActivite) {
		this.libelleSecteurActivite = libelleSecteurActivite;
	}
	
}

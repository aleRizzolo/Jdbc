package entita;

public class Videogame {
	public Videogame(String prodottoCodice_prodotto, String formato, String piattaforma) {
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
		this.formato = formato;
		this.piattaforma = piattaforma;
	}
	
	
	public String getProdottoCodice_prodotto() {
		return prodottoCodice_prodotto;
	}
	public void setProdottoCodice_prodotto(String prodottoCodice_prodotto) {
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public String getPiattaforma() {
		return piattaforma;
	}
	public void setPiattaforma(String piattaforma) {
		this.piattaforma = piattaforma;
	}


	private String prodottoCodice_prodotto;
	private String formato;
	private String piattaforma;
}

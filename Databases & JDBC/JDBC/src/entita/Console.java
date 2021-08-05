package entita;

public class Console {
	public Console(String prodottoCodice_prodotto, String versione) {
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
		this.versione = versione;
	}
	
	
	public String getProdottoCodice_prodotto() {
		return prodottoCodice_prodotto;
	}
	public void setProdottoCodice_prodotto(String prodottoCodice_prodotto) {
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
	}
	public String getVersione() {
		return versione;
	}
	public void setVersione(String versione) {
		this.versione = versione;
	}

	
	private String prodottoCodice_prodotto;
	private String versione;
}

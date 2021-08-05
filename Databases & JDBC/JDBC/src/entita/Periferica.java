package entita;

public class Periferica {
	public Periferica(String prodottoCodice_prodotto, String tipo) {
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
		this.tipo = tipo;
	}


	public String getProdottoCodice_prodotto() {
		return prodottoCodice_prodotto;
	}
	public void setProdottoCodice_prodotto(String prodottoCodice_prodotto) {
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	private String prodottoCodice_prodotto;
	private String tipo;
}

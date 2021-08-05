package entita;

public class Colore {
	public Colore(String prodottoCodice_prodotto, String nome_colore) {
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
		this.nome_colore = nome_colore;
	}
	
	
	public String getProdottoCodice_prodotto() {
		return prodottoCodice_prodotto;
	}
	public void setProdottoCodice_prodotto(String prodottoCodice_prodotto) {
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
	}
	public String getNome_colore() {
		return nome_colore;
	}
	public void setNome_colore(String nome_colore) {
		this.nome_colore = nome_colore;
	}


	private String prodottoCodice_prodotto;
	private String nome_colore;
}

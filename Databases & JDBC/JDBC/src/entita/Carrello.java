package entita;

public class Carrello {
	public Carrello(String ordineNordine, String prodottoCodice_prodotto, int quantit�) {
		this.ordineNordine = ordineNordine;
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
		this.quantit� = quantit�;
	}
	
	
	public String getOrdineNordine() {
		return ordineNordine;
	}
	public void setOrdineNordine(String ordineNordine) {
		this.ordineNordine = ordineNordine;
	}
	public String getProdottoCodice_prodotto() {
		return prodottoCodice_prodotto;
	}
	public void setProdottoCodice_prodotto(String prodottoCodice_prodotto) {
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
	}
	public int getQuantit�() {
		return quantit�;
	}
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}


	private String ordineNordine;
	private String prodottoCodice_prodotto;
	private int quantit�;
}

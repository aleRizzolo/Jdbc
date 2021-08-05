package entita;

public class Carrello {
	public Carrello(String ordineNordine, String prodottoCodice_prodotto, int quantità) {
		this.ordineNordine = ordineNordine;
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
		this.quantità = quantità;
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
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}


	private String ordineNordine;
	private String prodottoCodice_prodotto;
	private int quantità;
}

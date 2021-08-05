package entita;

public class Recensione {
	public Recensione(int clienteID, String prodottoCodice_prodotto, String titolo, String descrizione, int punteggio) {
		this.clienteID = clienteID;
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.punteggio = punteggio;
	}
	
	
	public int getClienteID() {
		return clienteID;
	}
	public void setClienteID(int clienteID) {
		this.clienteID = clienteID;
	}
	public String getProdottoCodice_prodotto() {
		return prodottoCodice_prodotto;
	}
	public void setProdottoCodice_prodotto(String prodottoCodice_prodotto) {
		this.prodottoCodice_prodotto = prodottoCodice_prodotto;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}


	private int clienteID;
	private String prodottoCodice_prodotto;
	private String titolo;
	private String descrizione;
	private int punteggio;
}

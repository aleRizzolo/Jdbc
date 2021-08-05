package entita;

public class Ordine {
	
	public Ordine(String n_ordine, String stato, float costo_totale, int clienteID, String spedizioneN_spedizione) {
		this.n_ordine = n_ordine;
		this.stato = stato;
		this.costo_totale = costo_totale;
		this.clienteID = clienteID;
		this.spedizioneN_spedizione = spedizioneN_spedizione;
	}

	public String getN_ordine() {
		return n_ordine;
	}
	public void setN_ordine(String n_ordine) {
		this.n_ordine = n_ordine;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public double getCosto_totale() {
		return costo_totale;
	}
	public void setCosto_totale(float costo_totale) {
		this.costo_totale = costo_totale;
	}
	public int getClienteID() {
		return clienteID;
	}
	public void setClienteID(int clienteID) {
		this.clienteID = clienteID;
	}
	public String getSpedizioneN_spedizione() {
		return spedizioneN_spedizione;
	}
	public void setSpedizioneN_spedizione(String spedizioneN_spedizione) {
		this.spedizioneN_spedizione = spedizioneN_spedizione;
	}

	private String n_ordine;
	private String stato;
	private float costo_totale;
	private int clienteID;
	private String spedizioneN_spedizione;
}

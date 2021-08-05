package entita;

public class Spedizione {
	public Spedizione(String n_spedizione, String corriere, String indirizzo_consegna, double costo_spedizione, int clienteID) {
		this.n_spedizione = n_spedizione;
		this.corriere = corriere;
		this.indirizzo_consegna = indirizzo_consegna;
		this.costo_spedizione = costo_spedizione;
		this.clienteID = clienteID;
	}
	
	
	public String getN_spedizione() {
		return n_spedizione;
	}
	public void setN_spedizione(String n_spedizione) {
		this.n_spedizione = n_spedizione;
	}
	public String getCorriere() {
		return corriere;
	}
	public void setCorriere(String corriere) {
		this.corriere = corriere;
	}
	public String getIndirizzo_consegna() {
		return indirizzo_consegna;
	}
	public void setIndirizzo_consegna(String indirizzo_consegna) {
		this.indirizzo_consegna = indirizzo_consegna;
	}
	public double getCosto_spedizione() {
		return costo_spedizione;
	}
	public void setCosto_spedizione(double costo_spedizione) {
		this.costo_spedizione = costo_spedizione;
	}
	public int getClienteID() {
		return clienteID;
	}
	public void setClienteID(int clienteID) {
		this.clienteID = clienteID;
	}


	private String n_spedizione;
	private String corriere;
	private String indirizzo_consegna;
	private double costo_spedizione;
	private int clienteID;
}

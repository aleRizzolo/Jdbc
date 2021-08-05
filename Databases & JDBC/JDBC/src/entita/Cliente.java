package entita;

public class Cliente {

	public Cliente(int ID, String nome, String cognome, int n_ordini, int eta) {
		this.ID = ID;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.n_ordini = n_ordini;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public int getN_ordini() {
		return n_ordini;
	}
	public void setN_ordini(int n_ordini) {
		this.n_ordini = n_ordini;
	}

	private int ID;
	private String nome;
	private String cognome;
	private int n_ordini;
	private int eta;
}

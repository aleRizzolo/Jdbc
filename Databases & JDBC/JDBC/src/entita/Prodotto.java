package entita;

public class Prodotto {
	public Prodotto(String codice_prodotto, String nome, String descrizione, float costo_unario) {
		this.codice_prodotto = codice_prodotto;
		this.nome = nome;
		this.descrizione = descrizione;
		this.costo_unario = costo_unario;
	}
	
	
	public String getCodice_prodotto() {
		return codice_prodotto;
	}
	public void setCodice_prodotto(String codice_prodotto) {
		this.codice_prodotto = codice_prodotto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public float getCosto_unario() {
		return costo_unario;
	}
	public void setCosto_unario(float costo_unario) {
		this.costo_unario = costo_unario;
	}

	private String codice_prodotto;
	private String nome;
	private String descrizione;
	private float costo_unario;
}

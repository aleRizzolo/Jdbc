package entita;

public class Appartiene {
	public Appartiene(String videogameProdottoCodice_prodotto, String genereNome_genere) {
		this.videogameProdottoCodice_prodotto = videogameProdottoCodice_prodotto;
		this.genereNome_genere = genereNome_genere;
	}
	
	
	public String getVideogameProdottoCodice_prodotto() {
		return videogameProdottoCodice_prodotto;
	}
	public void setVideogameProdottoCodice_prodotto(String videogameProdottoCodice_prodotto) {
		this.videogameProdottoCodice_prodotto = videogameProdottoCodice_prodotto;
	}
	public String getGenereNome_genere() {
		return genereNome_genere;
	}
	public void setGenereNome_genere(String genereNome_genere) {
		this.genereNome_genere = genereNome_genere;
	}


	private String videogameProdottoCodice_prodotto;
	private String genereNome_genere;
}

package connessione;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.io.*;
import entita.*;

@SuppressWarnings("unused")
public class ConnessioneMYsql {
	public static void main(String[] args) throws SQLException {
		Connection connessione; //connessione al DB
		//Statement state = null; //per costruire le query
		//ResultSet set; //i risultati delle query (quindi dei record)
		//String sql; //stringa contenete il codice
		
		/*CONNESSIONE*/
		//verifichiamo se la libreria è presente
		try {
			Class.forName("com.mysql.jdbc.Driver"); //verificare che sia presente la libreria che permette la connessione, caricamento del driver
		}
		catch (ClassNotFoundException e){ // se il driver non è caricato con successo
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} //fine try-catch
		
		//Creo la connessione al database
		//3306 è la porta, da controllare
		connessione = DriverManager.getConnection("jdbc:mysql://localhost:3306/progetto0?user=root&password=alessio97");
		
		int scelta=1;
		Scanner input = new Scanner (System.in); //oggetto per l'input

		System.out.println("1: inserisci un nuovo cliente.");
		System.out.println("2: inserisci un nuovo videogame.");
		System.out.println("3: inserisci una nuova recensione relativa ad un prodotto.");
		System.out.println("4: inserisci un nuovo ordine relativo ad un cliente.");
		System.out.println("5: stampa il numero totale di ordini effettuati da tutti i clienti.");
		System.out.println("6: stampa il costo totale di un ordine effettuato da un cliente.");
		System.out.println("7: stampa tutte le spedizioni eseguite sull’e-commerce.");
		System.out.println("8: stampa il numero di videogiochi per ogni genere.");
		System.out.println("9: stampa il costo totale medio per i clienti che hanno effettuato almeno un ordine.");
		
		
		System.out.println("Si scelga il numero dell'operazione da eseguire: ");
		scelta = input.nextInt();
			
		switch (scelta) {
			case 1:
				op1(connessione);
				break;
				
			case 2: 
				op2(connessione);
				break;
				
			case 3: 
				op3(connessione);
				break;
				
			case 4: 
				op4(connessione);
				break;
				
			case 5: 
				op5(connessione);
				break;
				
			case 6: 
				op6(connessione);
				break;
				
			case 7: 
				op7(connessione);
				break;
				
			case 8: 
				op8(connessione);
				break;
				
			case 9: 
				op9(connessione);
				break;
			
			default:
				System.out.println("Errore nell'op scelta.\n");
				break;
		} //fine switch
		
		
		input.close(); //chiusura scanner
		connessione.close(); //chiusura connessione
	}
	
	
	
	private static void op1(Connection connessione)throws SQLException {
		//OP1: inserisci un nuovo cliente
		
		Scanner input = new Scanner(System.in); //oggetto per l'input
		Scanner input_int = new Scanner(System.in); //oggetto per l'input
		Statement state = null; //per costruire le query
		String sql; //stringa contenete il codice
		
		System.out.println("\nInserisci ID cliente (numerico MAX 5 caratteri): ");
		int ID = input_int.nextInt();
		System.out.println("Inserisci nome cliente: ");
		String nome = input.nextLine();
		System.out.println("Inserisci cognome cliente: ");
		String cognome = input.nextLine();
		System.out.println("Inserisci età cliente: ");
		int eta = input_int.nextInt();
		
		Cliente cl = new Cliente(ID, nome, cognome, 0, eta);
		
		sql = "INSERT INTO cliente(ID, nome, cognome, nordini, eta) VALUES('" + cl.getID() + "','" + cl.getNome() + "','" + cl.getCognome() + "','0','" + cl.getEta() + "')";
		
		
		try {
			state = connessione.createStatement();
			int n = state.executeUpdate(sql);
			if (n == 1) {
				System.out.println("\n**Nuovo cliente inserito**");
			}
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
		
		input.close();
		input_int.close();
	}
	
	
	private static void op2(Connection connessione) {
		//OP2: inserisci un nuovo videogame
		
		Scanner input = new Scanner (System.in); //oggetto per l'input
		Scanner input_float = new Scanner (System.in); //oggetto per l'input
		Statement state = null; //per costruire le query
		ResultSet rs; //i risultati delle query (quindi dei record)
		String sql1;
		String sql2;
		
		System.out.println("\nInserisci codice prodotto: ");
		String codice_prodotto = input.nextLine();
		System.out.println("Inserisci nome prodotto: ");
		String nome_prodotto = input.nextLine();
		System.out.println("Inserisci descrizione_prodotto: ");
		String descrizione_prodotto = input.nextLine();
		System.out.println("Inserisci costo unario prodotto: ");
		float costo_unario = input_float.nextFloat();
		
		Prodotto pr = new Prodotto(codice_prodotto, nome_prodotto, descrizione_prodotto, costo_unario);
		
		System.out.println("Inserisci formato prodotto (Fisico o Digitale): ");
		String formato_videogame = input.nextLine();
		System.out.println("Inserisci piattaforma prodotto: ");
		String piattaforma_videogame = input.nextLine();
		
		Videogame vd = new Videogame(pr.getCodice_prodotto(), formato_videogame, piattaforma_videogame);
		
		sql1 = "INSERT INTO prodotto(codice_prodotto, nome, descrizione, costo_unario) VALUES('" + pr.getCodice_prodotto() + "','" +
				pr.getNome() + "','" + pr.getDescrizione() + "','" + pr.getCosto_unario() + "')";
		
		sql2 = "INSERT INTO videogame(prodotto_codiceprodotto, formato, piattaforma) VALUES('"
				+ vd.getProdottoCodice_prodotto() + "','" + vd.getFormato() + "','" + vd.getPiattaforma() + "')";
		
		try {
			state = connessione.createStatement();
			int n = state.executeUpdate(sql1);
			if (n == 1) {
				System.out.println("\n**Nuovo prodotto inserito**");
			}
			n = state.executeUpdate(sql2);
			if (n == 1) {
				System.out.println("\n**Nuovo videgioco associato**");
			}
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
		
		sql1 = "SELECT * FROM genere";
		
		System.out.println("Inserisci il genere del prodotto (già esistente): ");
		String nome_genere = input.nextLine();
		Genere gn = null;
		try {
			state = connessione.createStatement();
			rs = state.executeQuery(sql1);
			
			while (rs.next() == true) {
				if(rs.getString("nome_genere").equals(nome_genere)) {
					gn = new Genere(rs.getString("nome_genere"));
				}
			}
			
		} catch (SQLException e) {
	    	System.out.println("errore: "+ e.getMessage());
	    }
		
		Appartiene ap = new Appartiene(vd.getProdottoCodice_prodotto(), gn.getNome_genere());
		
		sql1 = "INSERT INTO appartiene(videogame_prodotto_codice_prodotto, genere_nome_genere) VALUES('" + vd.getProdottoCodice_prodotto() + "','" +
				gn.getNome_genere() + "')";
		
		try {
			state = connessione.createStatement();
			int n = state.executeUpdate(sql1);
			if (n == 1) {
				System.out.println("\n**Associazione tra genere e videogame creata**");
			}
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
		
		input.close();
		input_float.close();
	}
	
	
	private static void op3(Connection connessione) {
		//OP3: inserisci una nuova recensione relativa ad un prodotto
		
		Scanner input = new Scanner (System.in); //oggetto per l'input
		Scanner input_int = new Scanner (System.in); //oggetto per l'input
		Statement state = null; //per costruire le query
		String sql; //stringa contenete il codice
		
		System.out.println("\nInserisci l'ID del cliente (già esistente): ");
		int ID = input_int.nextInt();
		System.out.println("Inserisci il codice del prodotto (già esistente): ");
		String codice_prodotto = input.nextLine();
		System.out.println("Inserisci un titolo per la recensione: ");
		String titolo = input.nextLine();
		System.out.println("Inserisci una descrizione per la recensione: ");
		String descrizione = input.nextLine();
		System.out.println("Inserisci un punteggio (da 1 a 5) per la recensione: ");
		int punteggio = input_int.nextInt();
		for(;;) {
			if(punteggio <= 0 || punteggio >= 6) {
				System.out.println("Punteggio non valido, inserire di nuovo:");
				punteggio = input_int.nextInt();
			}
			else break;
		}
		
		Recensione rc = new Recensione(ID, codice_prodotto, titolo, descrizione, punteggio);
		
		sql = "INSERT INTO recensione(cliente_id, prodotto_codice_prodotto, titolo, descrizione, punteggio) VALUES('" + 
				rc.getClienteID() + "','" + rc.getProdottoCodice_prodotto() + "','" + rc.getTitolo() + "','" +
				rc.getDescrizione() + "','" + rc.getPunteggio() + "')";
		
		
		try {
			state = connessione.createStatement();
			int n = state.executeUpdate(sql);
			if (n == 1) {
				System.out.println("\n**Nuovo prodotto inserito**");
			}
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
		
		input.close();
		input_int.close();
	}
	
	
	private static void op4(Connection connessione) {
		//OP4: inserisci un nuovo ordine relativo ad un cliente
		//cliente id, spedizione a null, carrello
		
		Scanner input = new Scanner (System.in); //oggetto per l'input
		Scanner input_num = new Scanner (System.in);
		Scanner input_2 = new Scanner(System.in);
		Statement state = null; //per costruire le query
		ResultSet rs; //i risultati delle query (quindi dei record)
		String sql_or; //stringa contenete il codice sql dell'ordine
		String sql_car; //stringa contenete il codice sql del carrello
		String sql;
		float costo_tot = 0;
		
		System.out.println("\nInserisci il codice dell'ordine: ");
		String n_ordine = input.nextLine();
		System.out.println("Inserisci il codice del cliente (già esistente): ");
		int clienteID = input_num.nextInt();
		
		Ordine or = new Ordine(n_ordine, "IN CORSO", 0, clienteID, null);
		
		sql_or = "INSERT INTO ordine(nordine, stato, costo_totale, cliente_id) VALUES('" + 
				or.getN_ordine() + "','" + or.getStato() + "','" + or.getCosto_totale() + "','" + or.getClienteID() + "')";
		
		try {
			state = connessione.createStatement();
			int n = state.executeUpdate(sql_or);
			if (n == 1) {
				System.out.println("**Nuovo ordine inserito**");
			}
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
		
		int scelta = 1;
		while(scelta==1) {
			System.out.println("\nInserisci il codice del prodotto: ");
			String codice_prodotto = input_2.nextLine();
			System.out.println("\nInserisci la quantità di questo prodotto: ");
			int quantità = input_num.nextInt();
			
			Carrello cr = new Carrello(or.getN_ordine(), codice_prodotto, quantità);
			
			sql_car = "INSERT INTO carrello(ordine_nordine, prodotto_codiceProdotto2, quantità) VALUES('" + 
					cr.getOrdineNordine() + "','" + cr.getProdottoCodice_prodotto() + "','" + cr.getQuantità() + "')";
			
			try {
				state = connessione.createStatement();
				int n = state.executeUpdate(sql_car);
				if (n == 1) {
					System.out.println("**Nuovo carrello inserito**");
				}
			} catch (SQLException e) {
				System.out.println("Errore:" + e.getMessage());
			}
			
			sql = "SELECT costo_unario, codice_prodotto FROM carrello,prodotto,ordine WHERE ordine_nordine = nordine AND prodotto_codiceProdotto2 = codice_prodotto";
			
			try {
		           state = connessione.createStatement(); 
		           rs = state.executeQuery(sql);
		           
		           while (rs.next() == true) {
		        	   if(rs.getString("codice_prodotto").equals(cr.getProdottoCodice_prodotto()) && or.getN_ordine() == cr.getOrdineNordine()) {
		        		   costo_tot = costo_tot + (rs.getFloat("costo_unario") * cr.getQuantità());
		        		   //System.out.println(rs.getFloat("costo_unario"));
		        	   }
		           }
		        	   
		    } catch (SQLException e) {
		    	System.out.println("errore: "+ e.getMessage());
		    }
			
			
			System.out.println("\nInserire altri prodotti nel carrello? Sì = 1 | No = 0");
			scelta = input.nextInt();
		}
		
		
		or.setCosto_totale(costo_tot);
		
		
		
		sql_or = "UPDATE ordine SET costo_totale='" + or.getCosto_totale() + "'WHERE nordine='" + or.getN_ordine() + "'";
		
		try {
			state = connessione.createStatement();
			int n = state.executeUpdate(sql_or);
			if (n == 1) {
				System.out.println("**Ordine aggiornato con il costo totale**");
			}
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
		
		input.close();
		input_num.close();
		input_2.close();
	}


	private static void op5(Connection connessione) {
		//OP5: stampa il numero totale di ordini effettuati da tutti i clienti
		
		Statement state = null; //per costruire le query
		String sql = "SELECT * FROM cliente"; //stringa contenete il codice
		ResultSet rs; //i risultati delle query (quindi dei record)
		
		try {
			state = connessione.createStatement();
			rs = state.executeQuery(sql);
			System.out.println("ID      ORDINI EFFETTUATI");
			while(rs.next() == true) {
				System.out.println(rs.getString("ID") + "\t" + rs.getString("nordini"));
			}
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
	}
	
	
	private static void op6(Connection connessione) {
		//OP6: stampa il costo totale di un ordine effettuato da un cliente
		
		Scanner input = new Scanner (System.in); //oggetto per l'input
		Statement state = null; //per costruire le query
		String sql; //stringa contenete il codice
		ResultSet rs; //i risultati delle query (quindi dei record)
		
		
		System.out.println("\nInserisci n°ordine (già esistente): ");
		String n_ordine = input.nextLine();
		
		
		sql = "SELECT * FROM ordine WHERE nordine='" + n_ordine + "'";
		
		try {
			state = connessione.createStatement();
			rs = state.executeQuery(sql);
			while(rs.next() == true) {
				System.out.println("NORDINE  COSTO TOTALE");
				System.out.println(rs.getString("nordine") + "\t" + rs.getString("costo_totale"));
			}
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
		
		input.close();
	}
	
	
	private static void op7(Connection connessione) {
		//OP7: stampa tutte le spedizioni eseguite sull’e-commerce
		
		
		Statement state = null; //per costruire le query
		String sql; //stringa contenete il codice
		ResultSet rs; //i risultati delle query (quindi dei record)
		
		
		sql = "SELECT * FROM spedizione";
		
		try {
			state = connessione.createStatement();
			rs = state.executeQuery(sql);
			while(rs.next() == true) {
				System.out.println("\nNSPEDIZIONE    ID CLIENTE");
				System.out.println(rs.getString("nspedizione") + "        " + rs.getString("cliente1_ID"));
			}
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
		
	}
	
	
	private static void op8(Connection connessione) {
		//OP8: stampa il numero di videogiochi per ogni genere.
		
		
		Statement state = null; //per costruire le query
		String sql; //stringa contenete il codice
		ResultSet rs; //i risultati delle query (quindi dei record)
		
		sql = "SELECT genere_nome_genere, COUNT(*) as NumVideogame FROM appartiene GROUP BY genere_nome_genere";
		
		try {
			state = connessione.createStatement();
			rs = state.executeQuery(sql);
			System.out.println("\nGENERE          NUMVIDEOGAME");
			while(rs.next() == true) {
				if(rs.getString("genere_nome_genere").length() >= 7) {
					System.out.println(rs.getString("genere_nome_genere") + "\t" + rs.getString("NumVideogame"));
				} else {
					System.out.println(rs.getString("genere_nome_genere") + "\t\t" + rs.getString("NumVideogame"));
				}
				
			}
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
		
	}
	
	
	private static void op9(Connection connessione) {
		//OP9: stampa il costo totale medio per i clienti che hanno effettuato almeno un ordine
		
		
		Statement state = null; //per costruire le query
		String sql; //stringa contenete il codice
		ResultSet rs; //i risultati delle query (quindi dei record)
		
		sql = "SELECT cliente_id, avg(costo_totale) AS costo_totale_medio, nordini FROM ordine, cliente WHERE cliente_id = ID GROUP BY cliente_id";
		
		try {
			state = connessione.createStatement();
			rs = state.executeQuery(sql);
			System.out.println("\nID      COSTO MEDIO     NORDINI");
			while(rs.next() == true) {
				System.out.println(rs.getInt("cliente_id") + "\t" + rs.getFloat("costo_totale_medio") + "\t\t" + rs.getInt("nordini"));
			}
		} catch (SQLException e) {
			System.out.println("Errore:" + e.getMessage());
		}
		
	}
	
}

package it.biglietti;

import java.math.BigDecimal;
// gruppo 3
public class Biglietto {
	
	// costanti 
	private static final BigDecimal COSTO = new BigDecimal("0.21");
	private static final BigDecimal SCONTO_OVER_65= new BigDecimal("0.4");
	private static final BigDecimal SCONTO_UNDER_18= new BigDecimal("0.2");
	
	// attributi
	private int km;
	private int eta;
	
	// costruttore
	public Biglietto(int eta, int km) throws Exception {
		this.eta = eta;
		this.km = km;
		if(!isValidEta(eta)) {
			throw new Exception("Età non valida");
		}
		
		if(!isValidKm(km)) {
			throw new Exception("Km non validi");
		}
		}	
		public Biglietto() {
			
		}
	
	
	
	
	// metodo sconto
	private BigDecimal calcolaSconto() {
		BigDecimal sconto;
		if(eta < 18) {
			sconto= SCONTO_UNDER_18;
		} else if(eta >= 65) {
			sconto= SCONTO_OVER_65;
			
		} else {
			sconto= new BigDecimal("0");
		}
		return sconto;
	}
	
	// metodo prezzo
	public BigDecimal calcolaPrezzo() {
		BigDecimal kilometri = new BigDecimal(km); //abbiamo convertito int km in BigDecimal km
		BigDecimal prezzo = new BigDecimal("0");

			prezzo= kilometri.multiply(COSTO);
			prezzo.subtract(prezzo.multiply(calcolaSconto()));
		
		return prezzo;
	}
	
	// metodo boolean per validare km
	public boolean isValidKm(int km) {
		return km > 0;
		}
		
	// metodo boolean per validare eta
	public boolean isValidEta(int eta) {
		return eta > 0 && eta <= 110;
	}
}

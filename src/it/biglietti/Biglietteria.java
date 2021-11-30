package it.biglietti;
import java.util.Scanner;
public class Biglietteria {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int eta;
		int km;
		//Biglietto biglietto1 = new Biglietto();

		
		do {
		System.out.print("Inserisci la tua eta: ");
		eta = scan.nextInt();
		} while (eta < 0 || eta > 120);
		
		do {
		System.out.print("Inserisci il numero di km che vuoi percorrere: ");
		km = scan.nextInt();
		} while (km < 0);
		
		try {
			Biglietto biglietto = new Biglietto(eta, km);
			System.out.println("Il prezzo del biglietto è: " + biglietto.calcolaPrezzo());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		scan.close();

	}

}

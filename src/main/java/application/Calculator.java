package application;

import java.lang.Math;
/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		/* Hier auf Grund der vorhanden Werte entscheiden
		 * welche Methode unten aufgerufen werden muss.
		 */

		if(leistung != 0.0){
			if(spannung != 0.0){
				iAusPundU();
				rAusUundP();
			}
			if(strom != 0.0){
				uAusPundI();
				rAusPundI();
			}
			if(widerstand != 0.0){
				uAusPundR();
				iAusPundR();
			}
		}
		if(spannung != 0.0){
			if(strom != 0.0){
				pAusUundI();
				rAusUundI();
			}
			if(widerstand != 0.0){
				pAusUundR();
				iAusUundR();
			}
		}
		if(strom != 0.0){
			if(widerstand != 0.0){
				pAusRundI();
				uAusRundI();
			}
		}
	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */


	public void pAusUundI(){
		this.leistung = spannung*strom;
		System.out.println("pAusUundI Methode wurde abgerufen");
	}

	public void pAusRundI(){
		this.leistung = widerstand*Math.pow(strom, 2);
		System.out.println("pAusRundI Methode wurde abgerufen");
	}

	public void pAusUundR(){
		this.leistung = Math.pow(spannung, 2)/widerstand;
		System.out.println("pAusUundR Methode wurde abgerufen");
	}

	public void uAusRundI() {
		this.spannung = widerstand*strom;
		System.out.println("uAusRundI Methode wurde abgerufen");
	}

	public void uAusPundI() {
		this.spannung = leistung/strom;
		System.out.println("uAusPundI Methode wurde abgerufen");
	}

	public void uAusPundR(){
		this.spannung = Math.sqrt(leistung*widerstand);
		System.out.println("uAusPundR Methode wurde abgerufen");
	}

	public void iAusPundR(){
		this.strom = Math.sqrt(leistung/widerstand);
	}

	public void iAusPundU(){
		this.strom = leistung/spannung;
	}

	public void iAusUundR() {
		this.strom = spannung/widerstand;
	}

	public void rAusUundI(){
		this.widerstand = spannung/strom;
	}

	public void rAusPundI(){
		this.widerstand = leistung/Math.pow(strom, 2);
	}

	public void rAusUundP(){
		this.widerstand = Math.pow(spannung, 2)/leistung;
	}

}

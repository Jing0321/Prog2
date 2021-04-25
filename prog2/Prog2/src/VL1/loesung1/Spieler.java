package aufgaben.aufgabe1.loesung;

import java.util.Random;

import javax.swing.JOptionPane;

public class Spieler {
	private String name;
	private int aktStand;
	private Random r;
	
	Spieler(String name)
	{
		aktStand=0;
		this.name = name;
		r = new Random();
	}
	
	public int getAktStand()
	{
		return this.aktStand;
	}
	
	public boolean wuerfeln()
	{
		
		System.out.printf("%n%nSpieler %s ist an der Reihe (bisher %d Punkte) %n ----------------------------------------- %n" , this.name, this.aktStand);
		int reihe = 0;
		int wurf = 0;
		boolean ende = false;
		while(!ende)
		{
			wurf = r.nextInt(6)+1;
			System.out.printf("%s hat eine %d gewuerfelt %n" , this.name, wurf);
			if(wurf==6)
			{
				System.out.printf("Versuch zu Ende %n Aktueller Spielstand von %s : %d Punkte %n Der naechste Spieler ist dran%n", this.name, this.aktStand);
				ende = true;
			}
			else if(aktStand+reihe+wurf >= Spiel.siegPunkte)
			{
				System.out.printf("%s hat insgesamt %d Punkte und somit gewonnen !!!", this.name, (aktStand+reihe+wurf));
				return true;
			}
			else	 // eine 1..5 gewuerfelt und noch nicht gewonnen
			{
				reihe += wurf;
				System.out.printf("in diesem Versuch bisher %d Punkte -- insgesamt %d Punkte %n", reihe, (aktStand+reihe));
				int dialogResult = JOptionPane.showConfirmDialog (null, this.name+ ", wollen Sie weiter wuerfeln? ", "Weiter wuerfeln?", JOptionPane.YES_NO_OPTION);
				ende = !(dialogResult==JOptionPane.YES_OPTION);
				if(ende)
				{
					aktStand += reihe;
				}
			}
		}
		return false;
	}
	
}

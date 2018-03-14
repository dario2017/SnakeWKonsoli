import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnakeWKonsoli {

	public static void main(String[] args) {
		boolean graAktywna = true;
		String kierunek = "";
		int zjedzonychPokarmow = 0;
		int glowaX = 4;
		int glowaY = 4;
		List<Integer> cialoWeza = new ArrayList<>();
		int pokarmX = 5;
		int pokarmY = 4;
		boolean czyJestPokarm = true;

		
//	Tworz� i wype�niam plansz� pustymi polami
		String[][] plansza = new String[10][10];
		for (int i=0; i<plansza.length; i++) {
			for (int j=0; j<plansza.length; j++) {
				plansza[i][j] = "_";
			}
		}
		
//	Tworz� startowego w�a na planszy i dodaje cialo weza do listy cialoWeza
		plansza[3][3] = "*";
		plansza[3][4] = "*";
		plansza[4][4] = "*";
		plansza[5][4] = "^";
		cialoWeza.add(33);
		cialoWeza.add(34);
		cialoWeza.add(44);
				
		while (graAktywna) {
//  Je�li chcemy za ka�dym razem generowa� nowy pokarm
//			if (plansza[pokarmX][pokarmY].equals("^")){
//				plansza[pokarmX][pokarmY] = "_";
//			}

			while (!czyJestPokarm) {
				pokarmX = new Random().nextInt(10);
				pokarmY = new Random().nextInt(10);
				if (!(plansza[pokarmX][pokarmY].equals("*"))){
					plansza[pokarmX][pokarmY] = "^";
					czyJestPokarm = true;
				}
			}
//	rysuje aktualn� plansze na ekranie
			for (String[] each: plansza) {
				for (String eachLine: each) {
					System.out.print(eachLine);
				}
				System.out.println();
			}
			System.out.println("Wielko�� w�a = " + cialoWeza.size());
			System.out.println("W kt�r� stron� chcesz pojecha� w�em? (u�yj klawiszy WSAD i wci�nij enter) ");
			Scanner sc = new Scanner(System.in);
			kierunek = sc.nextLine();
//	ruch w g�re
			if (kierunek.equals("w")) {
				if (glowaX-1 < 0) {
					System.out.println("Wyjecha�e� poza plansze! Przegra�e�!!!");
					graAktywna = false;
					break;
				} else if (cialoWeza.get(cialoWeza.size()-2)/10 == glowaX-1) {
					System.out.println("Nie mo�esz pojecha� do ty�u");
				} else if (plansza[glowaX-1][glowaY].equals("^")) {
						plansza[glowaX-1][glowaY] = "*";
						glowaX -= 1;
						cialoWeza.add(glowaX*10+glowaY);
						zjedzonychPokarmow++;
						czyJestPokarm = false;
				} else if (plansza[glowaX-1][glowaY].equals("*")) {
					System.out.println("Ugryz�e� si�!! Przegra�e�!!!");
					graAktywna = false;
					break;
				
				} else {
					plansza[glowaX-1][glowaY] = "*";
					plansza[cialoWeza.get(0)/10][cialoWeza.get(0)%10] = "_";
					glowaX -= 1;
					cialoWeza.remove(0);
					cialoWeza.add(glowaX*10+glowaY);
				}
//	ruch w d�
			} else if (kierunek.equals("s")) {
				if (glowaX+1 > plansza.length-1) {
					System.out.println("Wyjecha�e� poza plansze! Przegra�e�!!!");
					graAktywna = false;
					break;
				} else if (cialoWeza.get(cialoWeza.size()-2)/10 == glowaX+1) {
					System.out.println("Nie mo�esz pojecha� do ty�u");
				} else if (plansza[glowaX+1][glowaY].equals("^")) {
					plansza[glowaX+1][glowaY] = "*";
					glowaX += 1;
					cialoWeza.add(glowaX*10+glowaY);
					zjedzonychPokarmow++;
					czyJestPokarm = false;
				} else if (plansza[glowaX+1][glowaY].equals("*")) {
					System.out.println("Ugryz�e� si�!! Przegra�e�!!!");
					graAktywna = false;
					break;
				
				} else {
					plansza[glowaX+1][glowaY] = "*";
					plansza[cialoWeza.get(0)/10][cialoWeza.get(0)%10] = "_";
					glowaX += 1;
					cialoWeza.remove(0);
					cialoWeza.add(glowaX*10+glowaY);
				}
//	ruch w prawo
			} else if (kierunek.equals("d")) {
				if (glowaY+1 > plansza.length-1) {
					System.out.println("Wyjecha�e� poza plansze! Przegra�e�!!!");
					graAktywna = false;
					break;
				} else if (cialoWeza.get(cialoWeza.size()-2)%10 == glowaY+1) {
					System.out.println("Nie mo�esz pojecha� do ty�u");
				} else if (plansza[glowaX][glowaY+1].equals("^")) {
					plansza[glowaX][glowaY+1] = "*";
					glowaY += 1;
					cialoWeza.add(glowaX*10+glowaY);
					zjedzonychPokarmow++;
					czyJestPokarm = false;
				} else if (plansza[glowaX][glowaY+1].equals("*")){
					System.out.println("Ugryz�e� si�!! Przegra�e�!!!");
					graAktywna = false;
					break;
				
				} else {
					plansza[glowaX][glowaY+1] = "*";
					plansza[cialoWeza.get(0)/10][cialoWeza.get(0)%10] = "_";
					glowaY += 1;
					cialoWeza.remove(0);
					cialoWeza.add(glowaX*10+glowaY);
				}
//	ruch w lewo
			} else if (kierunek.equals("a")) {
				if (glowaY-1 < 0) {
					System.out.println("Wyjecha�e� poza plansze! Przegra�e�!!!");
					graAktywna = false;
					break;
				} else if (cialoWeza.get(cialoWeza.size()-2)%10 == glowaY-1) {
					System.out.println("Nie mo�esz pojecha� do ty�u");
				} else if (plansza[glowaX][glowaY-1].equals("^")) {
					plansza[glowaX][glowaY-1] = "*";
					glowaY -= 1;
					cialoWeza.add(glowaX*10+glowaY);
					zjedzonychPokarmow++;
					czyJestPokarm = false;
				} else if (plansza[glowaX][glowaY-1].equals("^")) {
					System.out.println("Ugryz�e� si�!! Przegra�e�!!!");
					graAktywna = false;
					break;
				} else {
					plansza[glowaX][glowaY-1] = "*";
					plansza[cialoWeza.get(0)/10][cialoWeza.get(0)%10] = "_";
					glowaY -= 1;
					cialoWeza.remove(0);
					cialoWeza.add(glowaX*10+glowaY);
				}
			}
		}
		
		System.out.println("Uda�o Ci si� zje�� " + zjedzonychPokarmow + " pokarm�w");
	}
}

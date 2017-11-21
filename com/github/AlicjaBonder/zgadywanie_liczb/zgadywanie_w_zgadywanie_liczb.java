package com.github.AlicjaBonder.zgadywanie_liczb;

import java.util.Random;
import java.util.Scanner;

public class zgadywanie_w_zgadywanie_liczb {

	public static void main(String[] args) {
		zgaduj();

	}

	static void zgaduj() {

		Random r = new Random();
		int wylosowana_liczba = r.nextInt(100);

		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Zgadnij liczbę!");
			while (!scan.hasNextInt()) {

				scan.next();
				System.out.println("To nie jest liczba! Wpisz jeszcze raz!");
			}

			int wpisana_liczba = scan.nextInt();

			System.out.println("Wybrałeś liczbę " + wpisana_liczba);

			if (wpisana_liczba < wylosowana_liczba) {
				System.out.println("Za mało!");
			} else if (wpisana_liczba > wylosowana_liczba) {
				System.out.println("Za dużo!");
			} else {
				scan.close();
				break;
			}
			
		}
		
		System.out.println("Zgadłeś!");
		
	}
	
}

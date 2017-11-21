package com.github.AlicjaBonder.zgadywanie_liczb.vol2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class gra_zgadywanie_liczb_2 {

	public static void main(String[] args) {
		komputer_zgaduje();

	}

	static void komputer_zgaduje() {

		System.out.println("Pomyśl liczbę od 0 - 1000, a ją zgadnę w maksymalnie 10 próbach!");
		int max = 1000;
		int min = 0;
		ArrayList<String> odpowiedz_uzytkownika = new ArrayList<>();
		ArrayList<String> za_duzo = new ArrayList<>();
		ArrayList<String> za_malo = new ArrayList<>();
		ArrayList<String> zgadles = new ArrayList<>();
		za_duzo.add("za dużo");
		za_malo.add("za mało");
		zgadles.add("zgadłeś");
		odpowiedz_uzytkownika.add(" ");

		int guess = zgaduje(0, 1000);

		for (int i = 0; i <= 10; i++) {
			odpowiedz_uzytkownika.remove(0);
			System.out.println("Zgaduje: " + guess);
			System.out.println("Dostępne odpowiedzi:za dużo, za mało lub zgadłeś");

			Scanner scan = new Scanner(System.in);
			try {
				odpowiedz_uzytkownika.add(scan.nextLine());
				System.out.println("Twoja odpowiedz " + odpowiedz_uzytkownika);

				if (odpowiedz_uzytkownika.equals(za_duzo)) {
					guess = zgaduje(min, guess);

				} else if (odpowiedz_uzytkownika.equals(za_malo)) {
					guess = zgaduje(guess, max);

				} else if (odpowiedz_uzytkownika.equals(zgadles)) {
					System.out.println("Wygrałem!");
					scan.close();
					break;
				} else {
					System.out.println("Nie oszukuj!");
				}

			} catch (InputMismatchException e) {
				System.out.println("Niepoprawny format! Dostępne odpowiedzi:dużo, mało lub zgadłeś");
			}

		}
		System.out.println("Game over");
	}

	static int zgaduje(int min, int max) {

		int guess = (int) ((max - min) / 2 + min);
		return guess;
	}

}

package com.github.AlicjaBonder.kostka_do_gry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class kostka_do_gry {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj kod kostki!");
		ArrayList<String> lista = new ArrayList<String>();
		while (!scan.hasNext()) {

			scan.nextInt();
			System.out.println("Podaj właściwego Stringa!");

		}
		String rzut = scan.nextLine();
		scan.close();

		int modyfikator = 0;
		char c;

		for (int i = 0; i < rzut.length(); i++) {
			if (rzut.charAt(i) == '+') {
				StringTokenizer tok = new StringTokenizer(rzut, "+");

				while (tok.hasMoreTokens()) {

					String part1 = tok.nextToken();
					lista.add(part1);

				}
				modyfikator = Integer.parseInt(lista.get(1));

			} else if (rzut.charAt(i) == '-') {
				StringTokenizer tok = new StringTokenizer(rzut, "-");

				while (tok.hasMoreTokens()) {

					String part1 = tok.nextToken();
					lista.add(part1);

				}
				modyfikator -= Integer.parseInt(lista.get(1));

			}
		}

		String temp = lista.get(0);
		String[] tabTemp = temp.split("D");
		String part1 = tabTemp[0];
		String part2 = tabTemp[1];

		int oczka = Integer.parseInt(part2);
		int rzuty = Integer.parseInt(part1);
		int wynik = 0;

		for (int i = 0; i < rzuty; i++) {
			wynik += rzut_koscia(oczka);
		}
		if (modyfikator > 0) {
			wynik += modyfikator;
		} else if (modyfikator < 0) {
			wynik += modyfikator;

		}
		System.out.println(wynik);

	}

	static int rzut_koscia(int oczka) {

		Random r = new Random();

		int wynik = r.nextInt(oczka) + 1;

		System.out.println("wynik rzutu: " + wynik);
		return wynik;
	}
}
package com.github.AlicjaBonder.symulator_lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class symulator_lotto {

	public static void main(String[] args) {

		Integer[] tab1 = write_numbers();
		Integer[] tab2 = random();

		int trafione_liczby = 0;
		for (int i = 0; i < tab1.length; i++) {
			for (int j = 0; j < tab2.length; j++) {
				if (tab1[i] == tab2[j]) {
					System.out.println("Trafiona liczba!");
					trafione_liczby++;

				}
			}
		}
		if (trafione_liczby == 3) {
			System.out.println("Trafiłeś trójkę!");
		} else if (trafione_liczby == 4) {
			System.out.println("Udało Ci się trafić 4 liczby!");
		} else if (trafione_liczby == 3) {
			System.out.println("Udało Ci się trafić 5 liczb!");
		} else if (trafione_liczby == 6) {
			System.out.println("Gratulacje!Trafiłeś szóstkę!!");
		} else {
			System.out.println("Ilość trafionych liczb: " + trafione_liczby);
		}

		System.out.println("Game Over");

	}

	static Integer[] write_numbers() {
		Scanner scan = new Scanner(System.in);
		Integer[] user_numbers = new Integer[6];
		boolean ifChooseNumbers = false;

		while (!ifChooseNumbers) {
			System.out.println("Wytypuj 6 różnych liczb z zakresu od 1 do 49 oddzielając je przecinkiem ");
			String write_numbers[] = scan.nextLine().split(",");

			if (write_numbers.length != 6) {
				System.out.println("Wprowadzono niepoprawną liczbę cyfr, podaj liczby jeszcze raz");
			}
			if (write_numbers != null && write_numbers.length == 6) {

				boolean mistake = false;

				for (int i = 0; i < write_numbers.length; i++) {

					try {
						int liczba = Integer.valueOf(write_numbers[i]);

						if (liczba > 0 && liczba < 50) {
							user_numbers[i] = liczba;
						} else {
							throw new NumberFormatException();
						}

					}

					catch (NumberFormatException e) {
						mistake = true;
						System.out.println(write_numbers[i] + " Nie jest poprawną liczbą!");
						break;
					}
				}

				for (int j = 0; j < user_numbers.length - 1; j++) {
					if (user_numbers[j] == user_numbers[j + 1]) {
						System.out.println("Liczby muszą być różne!");
						mistake = true;
					}
				}

				if (mistake) {
					System.out.println("Podaj liczby jeszcze raz");

				} else {
					ifChooseNumbers = true;
				}

			}

		}
		Arrays.sort(user_numbers);
		System.out.println(Arrays.toString(user_numbers));
		scan.close();
		return user_numbers;
	}

	static Integer[] random() {

		Integer[] arr = new Integer[49];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		System.out.println(Arrays.toString(arr));
		Collections.shuffle(Arrays.asList(arr));
		// System.out.println(Arrays.toString(arr));
		Integer[] wylosowane_liczby = Arrays.copyOf(arr, 6);
		System.out.println(Arrays.toString(wylosowane_liczby));
		return wylosowane_liczby;
	}
}

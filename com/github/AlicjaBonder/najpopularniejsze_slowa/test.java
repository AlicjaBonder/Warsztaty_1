package com.github.AlicjaBonder.najpopularniejsze_slowa;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {

//	public static void main(String[] args) {
//
//		writeToFile(linesToWords(page("https://www.onet.pl")), "popular_words.txt");
//		writeToFile(mostCommonWords(readFromFile("popular_words.txt"), 10), "most_popular_words.txt");
//
//	}

	static ArrayList<String> readFromFile(String fileName) {

		Path file = Paths.get(fileName);
		ArrayList<String> in = new ArrayList<>();

		try {
			for (String line : Files.readAllLines(file)) {
				in.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return in;
	}

	static ArrayList<String> mostCommonWords(ArrayList<String> list, int wordsNumber) {

		ArrayList<String> resultList = new ArrayList<>();

		for (int i = 0; i < wordsNumber; i++) {
			resultList.add(mostCommon(list));
			removeMostCommon(list, resultList.get(i));

		}
		return resultList;
	}

	static ArrayList<String> page(String url) {

		ArrayList<String> list = new ArrayList<>();
		Connection connect = Jsoup.connect(url);

		try {
			Document document = connect.get();
			Elements links = document.select("span.title");
			for (Element elem : links) {
				list.add(elem.text());
		}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;

	}

	static ArrayList<String> linesToWords(ArrayList<String> out) {

		ArrayList<String> words = new ArrayList<>();

		for (String line : out) {
			StringTokenizer tok = new StringTokenizer(line, " ,.:\"-?!");

			while (tok.hasMoreTokens()) {
				String temp = tok.nextToken();

				if (temp.length() > 2) {
					words.add(temp.toLowerCase());
				}
			}
		}

		return words;

	}

	static void writeToFile(ArrayList<String> out, String fileName) {

		Path file = Paths.get(fileName);

		if (!Files.exists(file)) {
			try {
				Files.createFile(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			Files.write(file, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static String mostCommon(ArrayList<String> words) {

		String[] tab = { "EMPTY", "0" };

		for (String word : words) {
			int count = 0;

			for (String word2 : words) {

				if (word2.equals(word)) {
					count++;
				}
			}

			if (Integer.parseInt(tab[1]) < count) {
				tab[0] = word;
				tab[1] = count + "";
			}

		}

		return tab[0];
	}

	static ArrayList<String> removeMostCommon(ArrayList<String> list, String word) {

		while (list.remove(word)) {
	}

		return list;

	}
} 


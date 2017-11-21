package com.github.AlicjaBonder.najpopularniejsze_slowa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class wyszukiwarka {

	public static void main(String[] args) {
		
			getHeader("http://www.onet.pl/","popular_words.txt");
			getHeader("https://www.wp.pl/","popular_words.txt");
			
			

			ArrayList<String> lista = new ArrayList<String>();			
			lista = readFile("popular_words.txt");
			
			writeToFile(mostCommonWords(makes_words(lista),10),"most_popular_words.txt");
			
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
	static ArrayList<String> makes_words(ArrayList<String> out) {

		ArrayList<String> words = new ArrayList<>();

		for (String line : out) {
			StringTokenizer tok = new StringTokenizer(line, " ,.:\"-?!");

			while (tok.hasMoreTokens()) {
				String temp = tok.nextToken();

				if (temp.length() > 3) {
					words.add(temp.toLowerCase());
				}
			}
		}

		return words;

	}
	static ArrayList<String> mostCommonWords(ArrayList<String> list, int wordsNumber) {

		ArrayList<String> resultList = new ArrayList<>();

		for (int i = 0; i < wordsNumber; i++) {
			resultList.add(mostCommon(list));
			removeMostCommon(list, resultList.get(i));

		}
		return resultList;
	}
	static void getHeader(String url,String file) {
		
		Connection connect = Jsoup.connect(url);
		try {
		    Document document = connect.get();
		    Elements links = document.select("span.title");
		    BufferedWriter  writer = null;
	        try
	        {
	            writer = new BufferedWriter( new FileWriter(file,true));
	            writer.write(document.select("html").text());
	            writer.close();
	        }
	        catch ( IOException e)
	        {
	        }
//		    for (Element elem : links) {
//		        System.out.println(elem.text());
//		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	static ArrayList<String> readFile(String fileName) {

		Path path = Paths.get(fileName);
		ArrayList<String> lista = new ArrayList<>();
		try {
			for (String line : Files.readAllLines(path)) {
					lista.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	

static void writeToFile(ArrayList<String> lista,String filename) {
	
	Path file = Paths.get(filename);
	
	if(!Files.exists(file)) {
		try {
		Files.createFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Files.write(file, lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		
	}
	

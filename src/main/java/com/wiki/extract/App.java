package com.wiki.extract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.ParseException;


public class App 
{
    public static void main( String[] args ) throws ParseException, IOException
    {
    	URL url = new URL("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Google");
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	con.setRequestMethod("GET");
    	BufferedReader in = new BufferedReader(new InputStreamReader( con.getInputStream())); 
    	String inputLine =in.readLine();
    	System.out.println(inputLine); 
    	in.close();
    }
}

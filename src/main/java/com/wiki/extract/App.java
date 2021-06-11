package com.wiki.extract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.apache.http.ParseException;


public class App 
{
    public static void main( String[] args ) throws ParseException, IOException
    {
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Search here:");
    	String str = scan.nextLine();
    	URL url = new URL("https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles="+str);
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	con.setRequestMethod("GET");
    	BufferedReader in = new BufferedReader(new InputStreamReader( con.getInputStream())); 
    	String inputLine =in.readLine();
 
    	String ch[]=inputLine.split("\"extract\":\"");
    	System.out.println(ch[1].replace("\"}}}}","" ));
    	in.close();
    	
    }
}

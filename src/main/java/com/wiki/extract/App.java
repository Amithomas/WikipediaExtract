package com.wiki.extract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import javax.xml.transform.stream.StreamSource;

import org.apache.http.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;

public class App {
	public static void main(String[] args) throws ParseException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("search here:");
		String str = sc.nextLine();
		try {
			URL url = new URL(
					"https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles="
							+ str);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine = in.readLine();

			Object obj = JSONValue.parse(inputLine);
			JSONObject jsonObject = (JSONObject) obj;
			String extract = (String) jsonObject.get("query").toString();
			jsonObject = (JSONObject) JSONValue.parse(extract);
			extract = (String) jsonObject.get("pages").toString();
			System.out.println(extract);
		} catch (Exception e) {
			System.out.println(str + " not found");
		}
		sc.close();
	}
}

package com.example.demo;

import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CController {
	
	private int m_number;
	private String m_string;
	
	public CController()
	{
		m_number = 0;
		m_string = "hello";
	}
	
	public int getNumber()
	{
		return m_number;
	}
	
	public String getString()
	{
		return m_string;
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET) //similar to GET request	
	public String test() //returns a file (no @ResponseBody)
	{
		return "/index.html";		
	}
	
	@RequestMapping(value = "/C", method = RequestMethod.GET) //similar to GET request	
	@ResponseBody //return content of http packet
	public String C()
	{
		return "<img src=\"https://png.icons8.com/color/1600/c-programming\" alt=\"Error\" width=\"100px\">";
	}
	
	
	@RequestMapping(value="/response")
	@ResponseBody
	public String response(HttpServletResponse response) //to add headers
	{
		response.addHeader("Access-Control-Allow-Origin", "*");
		JSONObject json1 = new JSONObject(this);
		
		CVariable var = new CVariable();
		JSONObject json = new JSONObject(var); //convert to JSON (add jar files to project)
		
		return json1.toString();
	}
	
	@RequestMapping(value="/redirect")
	@ResponseBody
	public String redirect()
	{
		System.out.print("redirect called\n");
		try
		{
			URL url = new URL("https://www.reddit.com");
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			HttpURLConnection.setFollowRedirects(false);
			connect.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"); // Do as if you're using Chrome 41 on Windows 7.
			connect.setRequestMethod("GET");
			connect.connect();
			//int responseCode = connect.getResponseCode();
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                connect.getInputStream()));
	        String inputLine;
	        StringBuilder output = new StringBuilder("");
	        while ((inputLine = in.readLine()) != null) 
	            output.append(inputLine);
	        in.close();
	        return output.toString();
		}
		catch (Exception e)
		{
			return "Error: " + e.getMessage();
		}
	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET) //similar to GET request	
	public String home() //returns a file (no @ResponseBody)
	{
		return "/login.html";		
	}

}

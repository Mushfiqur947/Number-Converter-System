package com.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/***
 * This is a simple class to perform string comparison on a local file.
 */
@SuppressWarnings("serial")
public class Authenticator{
	private String uname = null;
	private String pwd = null;
	private String stored_username = null;
	private String stored_password = null;

	//Constructor
	Authenticator (String uname, String pwd) throws IOException{
		this.uname = uname;
		this.pwd = pwd;
	}

	
	public boolean authenticateUser() throws IOException{	
		return readUserFile() ? true : false;
	}

	/*
	 * NOTE: This is a simple persistent data storage facility.
	 */
	private boolean readUserFile() throws IOException{
		boolean status = false;
		File f = new File("C:\\Users\\DELL\\Desktop\\team-j\\mushfiq.txt");
		//created txt. file.

		if(f.exists()){
			this.stored_username = "admin";
			this.stored_password = "123";
			
			if(uname.equals(this.stored_username) && pwd.equals(this.stored_password)){
				status = true;
			}
		}
		return status;
	}

	public String getAuthenticationMessage(){
		return "Username or password is incorrect";
	}

	public String getUsername(){
		return this.stored_username;
	}
}

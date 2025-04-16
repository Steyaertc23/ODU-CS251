package com.odu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Accounts {
	private String userType;
	private HashMap<String, String> accounts = new HashMap<>();
	
	public Accounts(String userType) {
		this.userType = userType;
		this.setAccounts();
	}

	public String getUserType() {
		return userType;
	}

	public HashMap<String,String> getAccounts() {
		return accounts;
	}

	private void setAccounts() {
		try {
			new File(this.userType+".txt").createNewFile();
			BufferedReader reader = new BufferedReader(new FileReader(this.userType+".txt"));
			String line;
			while ((line=reader.readLine())!= null) {
				String[] arr = line.split(" ");
				accounts.put(arr[0], arr[1]);
			}
			reader.close();
		} catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public void addAccount(String username, String password) {
		if (accounts.containsKey(username)) {
			System.out.println("This account already exists, please sign in.");
		} else {
			accounts.put(username, password);
			addAccountTxt(username,password);
			System.out.println("Account Created.");
		}
	}
	
	private void addAccountTxt(String username, String password) {
		try {
			FileWriter fw = new FileWriter(this.userType+".txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(username+" "+password);
			bw.newLine();
			bw.close();
		}catch(Exception e) {
			System.out.println();
		}
	}
	
	public boolean signIn(String username, String password) {
		if(password.equals(this.accounts.get(username))) {return true;}
		System.out.println("Incorrect Password/Username");
		return false;
	}
}

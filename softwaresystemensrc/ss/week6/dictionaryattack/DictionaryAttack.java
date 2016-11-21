package ss.week6.dictionaryattack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.codec.binary.Hex;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws IOException 
	 */
    public void readPasswords(String filename) throws IOException {
            Scanner in = new Scanner(new File(filename));
            passwordMap = new HashMap<String, String>();
            while(in.hasNextLine()) {
            	String line = in.nextLine();
            	passwordMap.put(line.split(": ")[0], line.split(": ")[1]);
            }
            in.close();
    }

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
        MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        byte[] hash = digest.digest(password.getBytes());
        return Hex.encodeHexString(hash);
        
    }
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
    public boolean checkPassword(String user, String password) {
        if (!passwordMap.containsKey(user)) return false;
        return getPasswordHash(password).equals(passwordMap.get(user));
    }

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 * @throws FileNotFoundException 
	 */
    public void addToHashDictionary(String filename) throws IOException {
        Scanner in = new Scanner(new File(filename));
        hashDictionary = new HashMap<String, String>();
        while(in.hasNextLine()) {
            String word = in.nextLine();
            hashDictionary.put(getPasswordHash(word), word);
        }
        in.close();
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		int i = 0;
		for ( String user : passwordMap.keySet() ) {
			String plain = hashDictionary.get(passwordMap.get(user));
			if (plain != null) {
				System.out.println(user + ": " + plain);
				i++;
			}
		}
		System.out.println("Progress: " + i + "/" + passwordMap.size());
	}
	
    public static void main(String[] args) {
        DictionaryAttack da = new DictionaryAttack();
		try {
			da.readPasswords("bigsimplecorp_pw_hashes.txt");
	        da.addToHashDictionary("linuxwords.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		da.doDictionaryAttack();
	}

}

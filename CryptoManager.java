// Programmer name: Tsegazeab Berhie
// Date: 03/10/2020

public class CryptoManager {

	private static final int LOWER_BOUND = 32;
	private static final int UPPER_BOUND = 95;
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII
	 * codes according to the LOWER_BOUND and UPPER_BOUND characters
	 * 
	 * @param plainText a string to be encrypted, if it is within the allowable
	 *                  bounds
	 * @return true if all characters are within the allowable bounds, false if any
	 *         character is outside
	 */
	public static boolean stringInBounds(String plainText) {
		// determines if a string is within the allowable bounds of ASCII
		boolean check = true;
		// check LOWER_BOUND and UPPER_BOUND characters.
		for (int i = 0; i < plainText.length(); i++) {
			// false if any character is outside the bounds
			if (!((int) plainText.charAt(i) >= LOWER_BOUND && (int) plainText.charAt(i) <= UPPER_BOUND)) {
				check = false;
				break;
			}
		}
		return check;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in plainText is replaced by the character
	 * \"offset\" away from it
	 * 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key       an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String encryptedText = "";
		// encrypt characters while at in range
		if (stringInBounds(plainText)) {
			for (int i = 0; i < plainText.length(); i++) {
				char thisChar = plainText.charAt(i);
				int encryptedCharint = ((int) thisChar + key);
				while (encryptedCharint > UPPER_BOUND) {
					encryptedCharint -= RANGE;
				}
				encryptedText += (char) encryptedCharint;
			}
		}
// return the encrypted file
		return encryptedText;
	}

	/**
	 * Encrypts a string according the Bellaso Cipher. Each character in plainText
	 * is offset according to the ASCII value of the corresponding character in
	 * bellasoStr, which is repeated to correspond to the length of plainText
	 * 
	 * @param plainText  an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character
	 *                   by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encryptedText = "";
		int bellasoStrLength = bellasoStr.length();
		for (int index = 0; index < plainText.length(); index++) {
			char thisChar = plainText.charAt(index);
			int encryptedCharint = ((int) thisChar + (int) bellasoStr.charAt(index % bellasoStrLength));
			while (encryptedCharint > (int) UPPER_BOUND) {
				encryptedCharint -= RANGE;
			}
			encryptedText += (char) encryptedCharint;
		}
		return encryptedText;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in encryptedText is replaced by the character
	 * \"offset\" characters before it. This is the inverse of the encryptCaesar
	 * method.
	 * 
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key           an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedText = "";
		for (int index = 0; index < encryptedText.length(); index++) {
			char thisChar = encryptedText.charAt(index);
			int decryptedCharint = ((int) thisChar - key);
			while (decryptedCharint < LOWER_BOUND) {
				decryptedCharint += RANGE;
			}
			decryptedText += (char) decryptedCharint;
		}
		return decryptedText;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher. Each character in
	 * encryptedText is replaced by the character corresponding to the character in
	 * bellasoStr, which is repeated to correspond to the length of plainText. This
	 * is the inverse of the encryptBellaso method.
	 * 
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr    an uppercase string that specifies the offsets,
	 *                      character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decryptedText = "";
		int bellasoStrLength = bellasoStr.length();
		for (int index = 0; index < encryptedText.length(); index++) {
			char thisChar = encryptedText.charAt(index);
			int decryptedCharint = ((int) thisChar - (int) bellasoStr.charAt(index % bellasoStrLength));
			while (decryptedCharint < (int) LOWER_BOUND) {
				decryptedCharint += RANGE;
			}
			decryptedText += (char) decryptedCharint;
		}
		return decryptedText;

	}
}// As per your question, You already provided the GUI
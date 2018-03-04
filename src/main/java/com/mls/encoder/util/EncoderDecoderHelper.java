package com.mls.encoder.util;

public final class EncoderDecoderHelper {

	private static final String EMPTY = "";

	private EncoderDecoderHelper() {
	};

	/**
	 * The encrypt method encodes the given string as per the offset value.
	 * If the offset is not given, the method will return the same value.
	 * 
	 * @param plainText 
	 *            The string to be encoded
	 * @param offset
	 *            The offset value with which to encode the string
	 *            
	 * @return the encoded string
	 */
	public static String encrypt(String plainText, String offset) {
		if (offset.isEmpty()) {
			return plainText;
		}
		
		String cipherText = EMPTY;
		int offSetNumber = Integer.parseInt(offset);
		for (int i = 0; i < plainText.length(); i++) {
			char plainChar, encodedChar;
			plainChar = plainText.charAt(i);
			if (plainChar < 'a' || plainChar > 'z')
				cipherText += plainChar; // it's not a letter; don't encode it.
			else {
				encodedChar = encode(plainChar, offSetNumber);
				cipherText += encodedChar;
			}
		}
		return cipherText;
	}

	/**
	 * Encodes a single letter as another letter by applying an offset to move
	 * the letter forward in the alphabet. If the new position is past the end
	 * of the alphabet, it wraps around to the beginning.
	 * 
	 * @param ch
	 *            the letter that is to be encoded. This must be a lower case
	 *            letter!
	 * @param offset
	 *            an integer in the range 0 to 25 (inclusive). The ch is "moved"
	 *            forward this many spaces in the alphabet.
	 * @return the encoded letter
	 */
	private static char encode(char ch, int offset) {
		int chCode;
		char encodedChar;
		chCode = (int) ch - (int) 'a'; // convert ch to a number from 0 to 25
		chCode += offset; // add the offset to the character code
		if (chCode >= 26) { // wrap around to the beginning of the alphabet
			chCode = chCode - 26;
		} else if (chCode == -1) {// user has entered 'a' with offset -1, it should change to 'z'
			chCode = 25;
		}
		encodedChar = (char) (chCode + (int) 'a'); // convert back to a letter
		return encodedChar;
	}

}

package org.eclipse.january.geometry.dsl;

import org.antlr.runtime.*;
import org.eclipse.january.geometry.dsl.parser.antlr.internal.InternalIGESLexer;


/**
 * This class provides custom functions for properly lexing IGES files. The Hollerith,
 * Delimiter, and Separator terminal functions are implemented here, but there definitions
 * in the grammar are important to match for the parser. 
 * @author Kasper Gammeltoft
 *
 */
public class CustomIGESLexer extends InternalIGESLexer {

	/** The delimiter for the lexer */
	private String DELIMITER;
	/** The entry separator for the lexer */
	private String SEPARATOR;
	/**
	 * Flag indicating if the delimiter was specified in the file. This
	 * determines if the separator needs to be set to default ';' when the
	 * delimiter is called again.
	 */
	boolean DELIM_SET;
	
	public CustomIGESLexer() {
		DELIMITER = null;
		SEPARATOR = null;
		DELIM_SET = false;
	}

	public CustomIGESLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public CustomIGESLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
		DELIMITER = null;
		SEPARATOR = null;
		DELIM_SET = false;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.january.geometry.xtext.parser.antlr.internal.
	 * InternalIGESLexer#mTokens()
	 */
	public void mTokens() throws RecognitionException {
		// Handle hollerith string
		if (isHollerith()) {
			
			// Delimiter needs to be set first
			if (DELIMITER == null) {
				setDelimiter();
				
				// Set flag to true
				DELIM_SET = true;
				
			// Separator is second
			} else if (SEPARATOR == null) {
				setSEPARATOR();
			}
			// Call the new Hollerith rule
			RULE_HOLLERITH();
			
		// process the delimiter
		} else if (isDelimiter()) {
			RULE_DELIMITER();
			
		// process the separator
		} else if (isSEPARATOR()) {
			RULE_SEPARATOR();
		// Other token
		} else {
			// If comma, then check delimiter
			if (isComma() && DELIMITER == null) {
				// Set the delimiter as default
				DELIMITER = ",";
				super.mRULE_DELIMITER();
				// Let all other tokens be handled
				// by internal lexer
			} else {
				super.mTokens();
			}
		}
	}

	/**
	 * Determines if the current token on the stream is the delimiter for the
	 * current file
	 * 
	 * @return Returns true if the token is the delimiter, false if otherwise
	 */
	private boolean isDelimiter() {
		// Cannot be if delimiter is null
		if (DELIMITER == null) {
			return false;
		}
		
		int index = 0;
		// Check each character
		while (index < DELIMITER.length() && (input.LA(index + 1)) == DELIMITER.charAt(index)) {
			index++;
		}
		// Return if index got to end or not
		return index == DELIMITER.length();
	}

	/**
	 * Determines if the current token on the stream is the separator for the
	 * current file
	 * 
	 * @return Returns true if the token is the separator, false if otherwise
	 */
	private boolean isSEPARATOR() {
		// Cannot be if separator is null
		if (SEPARATOR == null) {
			return false;
		}
		int index = 0;
		// Check each character
		while (index < SEPARATOR.length() && (input.LA(index + 1)) == SEPARATOR.charAt(index)) {
			index++;
		}
		// Return if index got to the end or not
		return index == SEPARATOR.length();
	}

	/**
	 * Sets the delimiter for the current file.
	 */
	private void setDelimiter() {
		// Setup temp string
		String curInt = "";
		int index = 1;
		int cur = input.LA(index);
		// get hollerith string length
		while (cur >= '0' && cur <= '9') {
			curInt += (char) cur;
			index++;
			cur = input.LA(index);
		}
		// Get int value
		int n;
		try {
			n = Integer.parseInt(curInt);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		// Make sure it is a hollerith
		if (input.LA(index) == 'H') {
			index++;
		} else {
			return;
		}
		// Set the delimiter
		DELIMITER = "";
		for (int i = 0; i < n; i++) {
			DELIMITER += (char) input.LA(index + i);
		}
	}

	/**
	 * Sets the separator for the current file.
	 */
	private void setSEPARATOR() {
		// Setup temp string
		String curInt = "";
		int index = 1;
		int cur = input.LA(index);
		// Get hollerith string length
		while (cur >= '0' && cur <= '9') {
			curInt += (char) cur;
			index++;
			cur = input.LA(index);
		}
		// Get int value
		int n;
		try {
			n = Integer.parseInt(curInt);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		// Make sure it is a hollerith string
		if (input.LA(index) == 'H') {
			index++;
		} else {
			return;
		}
		// Set the separator
		SEPARATOR = "";
		for (int i = 0; i < n; i++) {
			SEPARATOR += (char) input.LA(index + i);
		}

	}

	/**
	 * Custom lexer rule for the delimiter token. Matches the file specified
	 * entry delimiter.
	 * 
	 * @throws RecognitionException
	 */
	public final void RULE_DELIMITER() throws RecognitionException {
		try {
			int _type = RULE_DELIMITER;
			int _channel = DEFAULT_TOKEN_CHANNEL;

			{	
				// Match the delimiter in the token stream
				for (int i = 0; i < DELIMITER.length(); i++) {
					match(String.valueOf(DELIMITER.charAt(i)));
				}
				// If the separator is not set, and needs to be, then set it
				if (SEPARATOR == null && !DELIM_SET) {
					SEPARATOR = ";";
				}
				// Delimiter has already been set
				DELIM_SET = false;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	/**
	 * Custom lexer rule for the separator token. Matches the file specified
	 * entry separator.
	 * 
	 * @throws RecognitionException
	 */
	public final void RULE_SEPARATOR() throws RecognitionException {
		try {
			int _type = RULE_SEPARATOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;

			{
				// Match the separator in the token stream
				for (int i = 0; i < SEPARATOR.length(); i++) {
					match(String.valueOf(SEPARATOR.charAt(i)));
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	/**
	 * Custom lexer rule for getting Hollerith strings. Is not dictated by the
	 * grammar! Will return the entire Hollerith string, including the int 'H'
	 * prefix.
	 * 
	 * @throws RecognitionException
	 */
	public final void RULE_HOLLERITH() throws RecognitionException {
		try {
			// Follow style and conventions of internal lexer
			int _type = RULE_HOLLERITH;
			int _channel = DEFAULT_TOKEN_CHANNEL;

			// Read in the int at the beginning of the string
			String curInt = "";
			// Get the next character
			int cur = input.LA(1);
			// While it is a digit add it to cur
			while (cur >= '0' && cur <= '9') {
				curInt += (char) cur;
				matchRange('0', '9');
				cur = input.LA(1);
			}
			// Try to read the integer. Should be successful. Otherwise there
			// was an error
			int n;
			try {
				n = Integer.parseInt(curInt);
			} catch (Exception e) {
				throw new EarlyExitException(1, input);
			}

			// Match the H
			match('H');

			// Match the n number of characters in the stream
			for (int i = 0; i < n; i++) {
				matchAny();
			}
			// Set the type and channel, as the internal lexer does
			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	/**
	 * Checks if the current token is a Hollerith String
	 * 
	 * @return Returns true if the current token is a Hollerith string, false if
	 *         otherwise
	 */
	private boolean isHollerith() {
		int index = 1;
		int cur = input.LA(index);
		// See if an int starts the string
		while (cur >= '0' && cur <= '9') {
			index++;
			cur = input.LA(index);
		}
		// Followed by an 'H'
		return index > 1 && cur == 'H';
	}

	/**
	 * Checks if the current character in the stream is a comma
	 * 
	 * @return Returns true if it is a comma, false if otherwise
	 */
	private boolean isComma() {

		return (input.LA(1) == ',');

	}

}
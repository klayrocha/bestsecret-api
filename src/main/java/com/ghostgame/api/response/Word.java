package com.ghostgame.api.response;

import java.io.Serializable;

/**
 * Class representing the model of an word
 * 
 * @author Francis Klay Rocha
 *
 */
public class Word implements Serializable {

	private static final long serialVersionUID = 1L;

	public String letter;
	private String lettersInserted;
	private boolean computerWin;
	private boolean playerWin;

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getLettersInserted() {
		return lettersInserted;
	}

	public void setLettersInserted(String lettersInserted) {
		this.lettersInserted = lettersInserted;
	}

	public boolean isComputerWin() {
		return computerWin;
	}

	public void setComputerWin(boolean computerWin) {
		this.computerWin = computerWin;
	}

	public boolean isPlayerWin() {
		return playerWin;
	}

	public void setPlayerWin(boolean playerWin) {
		this.playerWin = playerWin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (computerWin ? 1231 : 1237);
		result = prime * result + ((letter == null) ? 0 : letter.hashCode());
		result = prime * result + ((lettersInserted == null) ? 0 : lettersInserted.hashCode());
		result = prime * result + (playerWin ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (computerWin != other.computerWin)
			return false;
		if (letter == null) {
			if (other.letter != null)
				return false;
		} else if (!letter.equals(other.letter))
			return false;
		if (lettersInserted == null) {
			if (other.lettersInserted != null)
				return false;
		} else if (!lettersInserted.equals(other.lettersInserted))
			return false;
		if (playerWin != other.playerWin)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Word [letter=" + letter + ", lettersInserted=" + lettersInserted + ", computerWin=" + computerWin
				+ ", playerWin=" + playerWin + "]";
	}
	
}
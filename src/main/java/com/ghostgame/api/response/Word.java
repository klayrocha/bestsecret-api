package com.ghostgame.api.response;

import java.io.Serializable;

public class Word implements Serializable {

	private static final long serialVersionUID = 1L;

	private String lettersInserted;
	private boolean computerWin;
	private boolean playerWin;

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

}

package penaltykick.domain;

import java.util.ArrayList;
import java.util.List;

public class PenaltyKickReferee {

	private static final int REPEAT_NUMBER = 5;

	private final NumberGenerator numberGenerator;

	public PenaltyKickReferee(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public List<String> calculateResult(Computer computer, Player player) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < REPEAT_NUMBER; i++) {
			if (computer.checkNumberByPlayer(player.getPlayerNumberByIndex(i))) {
				result.add("O");
			}
			if (!computer.checkNumberByPlayer(player.getPlayerNumberByIndex(i))) {
				result.add("X");
			}
		}
		return result;
	}

	public int resultCount(List<String> result) {
		int count = 0;
		for (String element : result) {
			if (element.contains("O")) {
				count++;
			}
		}
		return count;
	}

	public Computer generateComputer() {
		List<Integer> computerNumber = generateRandomNumber();
		return new Computer(computerNumber);
	}

	public List<Integer> generateRandomNumber() {
		List<Integer> computerNumber = new ArrayList<>();
		for (int i = 0; i < REPEAT_NUMBER; i++) {
			computerNumber.add(numberGenerator.generate());
		}
		return computerNumber;
	}

	public Player generatePlayer(List<Integer> playerNumbers) {
		return new Player(playerNumbers);
	}
}
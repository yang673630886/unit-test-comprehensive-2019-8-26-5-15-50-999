package tw.commands;

public class CalculationNumber {
	private int[] answerNumber;

	public boolean isInt(String num) {
		return true;
	}

	public int[] getInputNumberArray(String inputNumber) {
		String[] numberString = inputNumber.split(" ");
		if (numberString.length != 4) {
			return null;
		}
		int[] numberInt = new int[numberString.length];
		for (int i = 0; i < numberString.length; i++) {
			numberInt[i] = Integer.parseInt(numberString[i]);
		}
		return numberInt;
	}

	public int[] setAnswerNumber() {
		answerNumber = new int[4];
		for (int i = 0; i < 4; i++) {
			int getNumber = (int) (Math.random() * 10);
			boolean repeatFag = true;
			for (int j = 0; j <= i; j++) {
				if (answerNumber[j] == getNumber) {
					repeatFag = false;
					i--;
				}
			}
			if (repeatFag) {
				this.answerNumber[i] = getNumber;
			}
		}
		return answerNumber;
	}

	public StringBuffer printAnswerNumber() {
		StringBuffer answer = new StringBuffer();
		for (int i = 0; i < answerNumber.length; i++) {
			String delimiter = "";
			if (i < answerNumber.length - 1) {
				delimiter = " ";
			}
			answer.append(answerNumber[i]);
			answer.append(delimiter);
		}
		System.out.println("正确的答案是：" + answer);
		return answer;
	}

	public String getResult(int[] inputNumber) {
		int numA = 0;
		int numB = 0;
		for (int i = 0; i < inputNumber.length; i++) {
			for (int j = 0; j < answerNumber.length; j++) {
				if (inputNumber[i] == answerNumber[j]) {
					numB++;
					if (i == j) {
						numA++;
					}
				}
			}
		}
		return "你的结果是：" + numA + "A" + numB + "B";
	}

	public String checkInput(String inputNumber) {
		String errorMessageString = "";
		if (inputNumber.length() < 7) {
			System.out.println("您输入的数字或格式有误");
			errorMessageString = "您输入的数字或格式有误";
		}
		return errorMessageString;
	}
}

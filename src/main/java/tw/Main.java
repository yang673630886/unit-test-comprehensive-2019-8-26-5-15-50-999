package tw;

import tw.commands.CalculationNumber;
import tw.commands.GuessInputCommand;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Main {

	private static final int RUN_TIMES = 6;

	public static void main(String[] args) throws Exception {
		CalculationNumber calculationNumber = new CalculationNumber();
		calculationNumber.setAnswerNumber();
		calculationNumber.printAnswerNumber();
		for (int i = 0; i < RUN_TIMES; i++) {
			String input = new GuessInputCommand().input();
			System.out.println("您的输入是：" + input);
			String errorMessageString = calculationNumber.checkInput(input);
			if (errorMessageString == "您输入的数字或格式有误") {
				continue;
			}
			int[] inputArray = calculationNumber.getInputNumberArray(input);
			String prompt = calculationNumber.getResult(inputArray);
			if (prompt.equals("你的结果是：4A4B")) {
				System.out.println("你猜对了！");
				break;
			}
			System.out.println(prompt);
		}
		System.out.println("游戏结束!");
	}
}

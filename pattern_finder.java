package previous_test;

import java.util.Scanner;

public class pattern_finder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isValidPattern = false;
		Scanner sc = new Scanner(System.in);
		String line="";
		PatternCheck checker = new PatternCheck();
		do
		{
			System.out.println("문자열 입력해주세요");
			line = sc.next();
			isValidPattern = checker.checkValidPattern(line);
			if(!isValidPattern)
				System.out.println("허용되지 않은 규칙입니다.");
			
		}while(!isValidPattern);
		System.out.println("허용된 규칙입니다.");
	}

}

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
			System.out.println("���ڿ� �Է����ּ���");
			line = sc.next();
			isValidPattern = checker.checkValidPattern(line);
			if(!isValidPattern)
				System.out.println("������ ���� ��Ģ�Դϴ�.");
			
		}while(!isValidPattern);
		System.out.println("���� ��Ģ�Դϴ�.");
	}

}

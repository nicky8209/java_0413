/*
 * Author: 권동원(nicky8209)
 * 
 * 본인이 원하는 프로그래밍언어(C, Java, Python 등)를 선택하여 아래의 기능을 포함하고 
 * 진법변환을 수행할 수 있는 프로그램을 작성하시오.
 * 
 */



import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloWorld {

	private static int isDebug = 0;// 값 표시용 스위치, true = 1, false = 0.

	public static void wku() {

		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("2진수를 입력하십시오 . . .");
				double d_num = sc.nextDouble();

				int i_num;
				i_num = (int) d_num;

				if (i_num == d_num) {// 정수일 때
					if (isIntegerBinary(i_num) == true) {// 2진수 체크
						String s_num = Integer.toString(i_num);
						System.out.println("HEX : " + Integer.toHexString(Integer.parseInt(s_num, 2)).toUpperCase());// 16진수 출력
						System.out.println("DEC : " + Integer.toString(Integer.parseInt(s_num, 2)));// 10진수 출력
						System.out.println("OCT : " + Integer.toOctalString(Integer.parseInt(s_num, 2)));// 8진수 출력
						System.out.println("BIN : " + s_num);// 2진수 출력
						break;

					} else {
						System.out.println("2진수가 아닙니다. . .");

					}

				} else {// 실수일 때
					if (isIntegerBinary(i_num) == true) {// 2진수 체크
						String s_num = Integer.toString(i_num);
						String r_num = Double.toString(d_num);
						String[] t_num = r_num.split("\\.");
						double c_num = 0;

						for (int i = 0; i < t_num[1].length(); i++) {
							double f_num = 1 / Math.pow(2, i + 1);

							if (t_num[1].charAt(i) == '1') {
								c_num = c_num + f_num;

							}
						}

						String q_num = Double.toString(c_num);
						String[] w_num = q_num.split("\\.");

						System.out.println("HEX : " + Integer.toHexString(Integer.parseInt(s_num, 2)).toUpperCase() + "." + toHexString(t_num));// 16진수 출력
						System.out.println("DEC : " + Integer.toString(Integer.parseInt(s_num, 2)) + "." + w_num[1]);// 10진수 출력
						System.out.println("OCT : " + Integer.toOctalString(Integer.parseInt(s_num, 2)) + "." + toOctalString(t_num));// 8진수 출력
						System.out.println("BIN : " + s_num + "." + t_num[1]);// 2진수 출력
						break;

					} else {
						System.out.println("2진수가 아닙니다. . .");

					}

				}

			} catch (InputMismatchException e) {
				System.out.println("숫자가 아닙니다. . .");
				break;

			}

		}
		sc.close();

	}

	public static void main(String[] args) {
		HelloWorld.wku();

	}

	// 2진수 체크 메소드
	public static boolean isIntegerBinary(int xc) {
		int B_inary = xc;

		while (B_inary != 0) {
			if (B_inary % 10 > 1) {
				return false;
			}
			B_inary = B_inary / 10;
		}
		return true;
	}

	public static String toOctalString(String[] t_num) {
		String[] j_num = t_num[1].split("");// 문자열 배열 만들기
		String[] k_num = t_num[1].split("");// 문자열 배열 만들기
		String[] l_num = t_num[1].split("");// 문자열 배열 만들기

		if (t_num[1].length() % 3 == 2) {
			j_num[0] = String.join("", t_num[1] + "0");

		} else if (t_num[1].length() % 3 == 1) {
			j_num[0] = String.join("", t_num[1] + "00");

		} else {
			j_num[0] = t_num[1];
		}

		for (int j = 0; j < j_num[0].length() / 3; j++) {
			k_num[j] = j_num[0].substring(3 * j, 3 * j + 3);// 3자리씩 자르기
			if (isDebug == 1) {// 값 확인용
				System.out.println(k_num[j]);
			}

		}

		for (int k = 0; k < j_num[0].length() / 3; k++) {
			switch (k_num[k]) {// 8진수는 0~7
			case "000":
				l_num[k] = "0";
				break;

			case "001":
				l_num[k] = "1";
				break;

			case "010":
				l_num[k] = "2";
				break;

			case "011":
				l_num[k] = "3";
				break;

			case "100":
				l_num[k] = "4";
				break;

			case "101":
				l_num[k] = "5";
				break;

			case "110":
				l_num[k] = "6";
				break;

			case "111":
				l_num[k] = "7";
				break;

			}
		}

		l_num[j_num[0].length() / 3] = "\0";// 널문자

		String OctalString = String.join("", l_num);
		String[] Octal_Array = OctalString.split("\0");

		return Octal_Array[0];// 반환
	}

	public static String toHexString(String[] t_num) {
		String[] j_num = t_num[1].split("");// 문자열 배열 만들기
		String[] k_num = t_num[1].split("");// 문자열 배열 만들기
		String[] l_num = t_num[1].split("");// 문자열 배열 만들기

		if (t_num[1].length() % 4 == 3) {
			j_num[0] = String.join("", t_num[1] + "0");

		} else if (t_num[1].length() % 4 == 2) {
			j_num[0] = String.join("", t_num[1] + "00");

		} else if (t_num[1].length() % 4 == 1) {
			j_num[0] = String.join("", t_num[1] + "000");

		} else {
			j_num[0] = t_num[1];
		}

		for (int j = 0; j < j_num[0].length() / 4; j++) {
			k_num[j] = j_num[0].substring(4 * j, 4 * j + 4);// 4자리씩 자르기
			if (isDebug == 1) {// 값 확인용
				System.out.println(k_num[j]);
			}

		}

		for (int k = 0; k < j_num[0].length() / 4; k++) {
			switch (k_num[k]) {// 16진수는 0~F(15)
			case "0000":
				l_num[k] = "0";
				break;

			case "0001":
				l_num[k] = "1";
				break;

			case "0010":
				l_num[k] = "2";
				break;

			case "0011":
				l_num[k] = "3";
				break;

			case "0100":
				l_num[k] = "4";
				break;

			case "0101":
				l_num[k] = "5";
				break;

			case "0110":
				l_num[k] = "6";
				break;

			case "0111":
				l_num[k] = "7";
				break;

			case "1000":
				l_num[k] = "8";
				break;

			case "1001":
				l_num[k] = "9";
				break;

			case "1010":
				l_num[k] = "A";// 10
				break;

			case "1011":
				l_num[k] = "B";// 11
				break;

			case "1100":
				l_num[k] = "C";// 12
				break;

			case "1101":
				l_num[k] = "D";// 13
				break;

			case "1110":
				l_num[k] = "E";// 14
				break;

			case "1111":
				l_num[k] = "F";// 15
				break;

			}
		}

		l_num[j_num[0].length() / 4] = "\0";

		String HexString = String.join("", l_num);
		String[] Hex_Array = HexString.split("\0");

		return Hex_Array[0];// 반환
	}

}

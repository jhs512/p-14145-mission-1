package com.back;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	Scanner sc = new Scanner(System.in);
	void run () {
		System.out.println("== 명언 앱 ==");

		int count = 1;

		ArrayList<WiseSaying> wiseSayings = new ArrayList<>();

		while (true) {
			System.out.print("명령) ");
			String input = sc.nextLine();
			if (input.equals("등록")) {
				register(wiseSayings, count);
				count++;
			} else if (input.equals("목록")) {
				showList(wiseSayings);
			} else if (input.startsWith("삭제")) {
				String[] parts = input.split("=");
				int id = Integer.parseInt(parts[1]);
				wiseSayings = deleteSaying(id, wiseSayings);
			} else if (input.startsWith("수정")) {
				String[] parts = input.split("=");
				int id = Integer.parseInt(parts[1]);
//				wiseSayings = editSaying(id, wiseSayings);
				editSaying(id, wiseSayings);
			} else if (input.equals("종료")) {
				break;
			}
		}
	}

	void register(ArrayList<WiseSaying> wiseSayings, int count) {
		System.out.print("명언) ");
		String input_line = sc.nextLine();
		System.out.print("작가) ");
		String input_auther = sc.nextLine();
		System.out.println(count + "번 명언이 등록되었습니다.");
		WiseSaying newOne = new WiseSaying(count, input_auther, input_line);
		wiseSayings.add(newOne);
	}

	void showList(ArrayList<WiseSaying> wiseSayings) {
		System.out.println("번호 / 작가 / 명언");
		System.out.println("----------------------");
		WiseSaying[] forListWideSayings = findForList(wiseSayings);
		for (WiseSaying wiseSaying :forListWideSayings) {
			System.out.println(wiseSaying.num + " / " + wiseSaying.user + " / " + wiseSaying.comment);
		}
	}

	WiseSaying[] findForList(ArrayList<WiseSaying> wiseSayings) {
		WiseSaying[] newArr = new WiseSaying[wiseSayings.size()];
		int index = 0;

		for (int i = wiseSayings.size() - 1; i >= 0; i--) {
			newArr[index] = wiseSayings.get(i);
			index++;
		}
		return newArr;
	}

	ArrayList<WiseSaying> deleteSaying(int id, ArrayList<WiseSaying> wiseSayings) {

		ArrayList<WiseSaying> setArr = new ArrayList<>();
		boolean existId = false;
		for (int i=0; i < wiseSayings.size(); i++) {
			WiseSaying saying = wiseSayings.get(i);
			if (saying.num != id) {
				setArr.add(saying);
			} else {
				existId = true;
			}
		}
		if (!existId) {
			System.out.println(id + "번 명언은 존재하지 않습니다.");
		}

		return setArr;
	}

	void editSaying(int id, ArrayList<WiseSaying> wiseSayings) {
		boolean existId = false;
		for (int i=0; i < wiseSayings.size(); i++) {
			WiseSaying saying = wiseSayings.get(i);
			if (saying.num == id) {
				System.out.println("명언(기존) : " +saying.comment);
				System.out.print("명언) ");
				String input_line = sc.nextLine();
				System.out.println("작가(기존) : " +saying.user);
				System.out.print("작가) ");
				String input_auther = sc.nextLine();
				saying.upDate(input_auther, input_line);
				existId = true;
			} else {

			}
		}
		if (!existId) {
			System.out.println(id + "번 명언은 존재하지 않습니다.");
		}
	}
}

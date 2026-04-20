package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {

    static Scanner sc;

    static public class Wise {
        public String wise;
        public String author;

        public Wise(String wise, String author) {
            this.wise = wise;
            this.author = author;
        }
    }

    static Wise GetWise(String wiseLabel, String authorLabel) {

        System.out.print(wiseLabel);
        String wise = sc.nextLine().trim();
        System.out.print(authorLabel);
        String author = sc.nextLine().trim();

        return new Wise(wise, author);
    }

    static void main() {

        List<Wise> list = new ArrayList<Wise>();
        System.out.println("== 명언 앱 ==");

        sc = new Scanner(System.in);

        while (true) {
            System.out.print("명령) ");

            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            }
            if (cmd.equals("등록")) {
                list.add(GetWise("명언 : ", "작가 : "));
                System.out.println(list.size() + "번 명언이 등록되었습니다.");
                continue;
            }
            if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------------");
                for (int i = 0; i < list.size(); i++) {
                    int idx = list.size() - i - 1;
                    Wise wise = list.get(idx);
                    if (wise == null) continue;
                    System.out.printf("%d / %s / %s\n",
                            idx + 1, wise.author, wise.wise);
                }
                continue;
            }

            String[] cmds = cmd.split("\\?id=");

            if (cmds.length < 2) continue;

            int targetIdx = Integer.parseInt(cmds[1]) - 1;

            if (targetIdx < 0
                    || targetIdx > list.size()
                    || list.get(targetIdx) == null) {
                System.out.printf("%d번 명언은 존재하지 않습니다.\n", targetIdx + 1);
                continue;
            }

            if (cmds[0].equals("삭제")) {
                list.set(targetIdx, null);
                System.out.printf("%d번 명언을 삭제하였습니다.\n", targetIdx + 1);
                continue;
            }
            if (cmds[0].equals("수정")) {
                Wise wise = list.get(targetIdx);
                Wise newWise = GetWise(
                        String.format("이전 명언: %s\n명언 : ", wise.wise),
                        String.format("이전 작가: %s\n작가 : ", wise.author));
                list.set(targetIdx, newWise);
            }
        }

    }
}

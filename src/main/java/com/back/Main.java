package com.back;

import java.util.Scanner;

public class Main {
    static void main() {
        System.out.println("== 명언 앱 ==");

        Scanner sc = new Scanner(System.in);

        int lastId = 0;

        WiseSaying[] wiseSayings = new WiseSaying[100];
        int wiseSayingsLastIndex = -1;

        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) break;
            else if (cmd.equals("등록")) {
                System.out.print("명언: ");
                String content = sc.nextLine().trim();

                System.out.print("작가: ");
                String author = sc.nextLine().trim();

                int id = ++lastId;

                WiseSaying wiseSaying = new WiseSaying();

                wiseSaying.id = id;
                wiseSaying.content = content;
                wiseSaying.author = author;

                wiseSayings[++wiseSayingsLastIndex] = wiseSaying;

                System.out.printf("%d번 명언이 등록되었습니다.\n", id);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 명언 / 작가");
                System.out.println("-------------------");

                for (int i = wiseSayingsLastIndex; i >= 0; i--) {
                    WiseSaying wiseSaying = wiseSayings[i];

                    if (wiseSaying == null) {
                        continue;
                    }

                    System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.content, wiseSaying.author);
                }
            }else if (cmd.equals("삭제")) {
                System.out.print("번호를 입력해주세요: ");
                int num = Integer.parseInt(sc.nextLine().trim());

                if (num <= 0 || num > lastId || wiseSayings[num - 1] == null) {
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", num);
                } else {
                    wiseSayings[num - 1] = null;
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", num);
                }
            }else if (cmd.equals("수정")) {
                System.out.print("번호를 입력해주세요: ");
                int num = Integer.parseInt(sc.nextLine().trim());

                if (num <= 0 || num > lastId || wiseSayings[num - 1] == null) {
                    System.out.printf("%d번 명언은 존재하지 않습니다.\n", num);
                } else {
                    WiseSaying wiseSaying = wiseSayings[num - 1];

                    System.out.printf("명언(기존) : %s\n", wiseSaying.content);
                    System.out.print("명언 : ");
                    wiseSaying.content = sc.nextLine().trim();

                    System.out.printf("작가(기존) : %s\n", wiseSaying.author);
                    System.out.print("작가 : ");
                    wiseSaying.author = sc.nextLine().trim();
                }
            }
        }
        sc.close();
    }
}

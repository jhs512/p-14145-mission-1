package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new App().run();
    }
}

class App {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        List<WiseSaying> wiseSayings = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("종료")) {
                break;
            }

            if (command.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();

                count++;
                wiseSayings.add(new WiseSaying(count, content, author));
                System.out.println(count + "번 명언이 등록되었습니다.");

            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                    WiseSaying ws = wiseSayings.get(i);
                    System.out.printf("%d / %s / %s\n", ws.id, ws.author, ws.content);
                }

            } else if (command.startsWith("삭제?id=")) {
                int id = Integer.parseInt(command.split("=")[1]);
                WiseSaying found = null;
                for (WiseSaying ws : wiseSayings) {
                    if (ws.id == id) {
                        found = ws;
                        break;
                    }
                }

                if (found != null) {
                    wiseSayings.remove(found);
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }

            } else if (command.startsWith("수정?id=")) {
                int id = Integer.parseInt(command.split("=")[1]);
                WiseSaying found = null;
                for (WiseSaying ws : wiseSayings) {
                    if (ws.id == id) {
                        found = ws;
                        break;
                    }
                }

                if (found != null) {
                    System.out.println("명언(기존) : " + found.content);
                    System.out.print("명언 : ");
                    found.content = sc.nextLine();
                    System.out.println("작가(기존) : " + found.author);
                    System.out.print("작가 : ");
                    found.author = sc.nextLine();
                } else {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
            }
        }
        sc.close();
    }
}

class WiseSaying {
    int id;
    String content;
    String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
}

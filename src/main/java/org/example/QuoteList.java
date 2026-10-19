package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class QuoteList {
    private final ArrayList<Quote> arr = new ArrayList<>();
    private final Scanner sc;
    private boolean running = true;

    public QuoteList(Scanner sc) {
        this.sc = sc;
    }

    public void printWelcomeMessage() {
        System.out.println("== 명언 앱 ==");
        System.out.println("사용 가능한 명령어:");
        System.out.println("등록 : 명언과 작가를 입력해 등록합니다.");
        System.out.println("목록 : 명언을 최신 등록순으로 보여줍니다.");
        System.out.println("삭제?id=번호 : 해당 명언을 삭제합니다. (예: 삭제?id=1)");
        System.out.println("수정?id=번호 : 해당 명언의 내용을 수정합니다. (예: 수정?id=1)");
        System.out.println("종료 : 앱을 종료합니다.");
    }

    public void printCommandPrompt() {
        System.out.print("명령) ");
    }

    public void printInvalidInputMessage() {
        System.out.println("잘못된 입력입니다. 종료하시려면 \"종료\"라고 입력하세요.");
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isAvailableCommand(String cmd) {
        if (cmd.equals("종료") || cmd.equals("등록") || cmd.equals("목록")) {
            return true;
        }

        if (!cmd.matches("(삭제|수정)\\?id=[0-9]+")) {
            return false;
        }

        try {
            return Integer.parseInt(cmd.split("\\?id=")[1]) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void execute(String cmd) {
        if (cmd.equals("종료")) {
            running = false;
            return;
        }

        if (cmd.equals("등록")) {
            System.out.print("명언 : ");
            String content = sc.nextLine().trim();
            System.out.print("작가 : ");
            String author = sc.nextLine().trim();

            arr.add(new Quote(arr.size() + 1, content, author));
            System.out.println(arr.size() + "번 명언이 등록되었습니다.");
        }

        if (cmd.equals("목록")) {
            System.out.print("번호 / 작가 / 명언\n----------------------\n");
            for (int i = arr.size() - 1; i >= 0; i--) {
                Quote q = arr.get(i);
                q.println();
            }
        }

        if (cmd.contains("삭제")) {
            String[] split = cmd.split("\\?id=");
            int num = Integer.parseInt(split[1]);

            if (num - 1 >= arr.size()) {
                System.out.print(num + "번 명언은 존재하지 않습니다.\n");
                return;
            }
            arr.get(num - 1).delete();
        }

        if (cmd.contains("수정")) {
            String[] split = cmd.split("\\?id=");
            int num = Integer.parseInt(split[1]);

            if (num - 1 >= arr.size()) {
                System.out.print(num + "번 명언은 존재하지 않습니다.\n");
                return;
            }
            arr.get(num - 1).edit(sc);
        }
    }
}

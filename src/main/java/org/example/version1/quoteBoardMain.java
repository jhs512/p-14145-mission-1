package org.example.version1;

import java.util.Scanner;

public class quoteBoardMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Quote[] quotes = new Quote[100];
        int count = 1;

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                count = doWrite(sc, quotes, count);
            } else if (command.equals("목록")) {
                doList(count, quotes);
            } else if (command.startsWith("삭제?")) {
                doDelete(command, quotes);
            } else if (command.startsWith("수정?")) {
                doUpdate(command, quotes, sc);
            }
        }
    }

    private static int doWrite(Scanner sc, Quote[] quotes, int count) {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        Quote quote = new Quote(content, author);
        quotes[count] = quote;
        System.out.println(count + "번 명언이 등록되었습니다.");
        count++;
        return count;
    }

    private static void doList(int count, Quote[] quotes) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------------");
        for (int i = count; i > 0; i--) {
            if (quotes[i] != null) {
                System.out.println((i) + " / " + quotes[i].author + " / " + quotes[i].content);
            }
        }
    }

    private static void doDelete(String command, Quote[] quotes) {
        int num = Integer.parseInt(command.split("\\?")[1].split("=")[1]);
        if (quotes[num] != null) {
            quotes[num] = null;
            System.out.println(num + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(num + "번 명언은 존재하지 않습니다.");
        }
    }


    private static void doUpdate(String command, Quote[] quotes, Scanner sc) {
        int num = Integer.parseInt(command.split("\\?")[1].split("=")[1]);
        if (quotes[num] != null) {
            System.out.println("명언(기존) : " + quotes[num].content);
            System.out.print("명언 : ");
            String content = sc.nextLine();
            quotes[num].content = content;
            System.out.println("작가(기존) : " + quotes[num].author);
            System.out.print("작가 : ");
            String author = sc.nextLine();
            quotes[num].author = author;
        } else {
            System.out.println(num + "번 명언은 존재하지 않습니다.");
        }
    }

}

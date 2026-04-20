package org.example.version2;

import java.util.ArrayList;
import java.util.Scanner;

public class quoteBoardListMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Quote> quotes = new ArrayList<>();
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

    private static int doWrite(Scanner sc, ArrayList<Quote> quotes, int count) {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        Quote quote = new Quote(count ,content, author);
        quotes.add(quote);
        System.out.println(count + "번 명언이 등록되었습니다.");
        count++;
        return count;
    }

    private static void doList(int count, ArrayList<Quote> quotes) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------------");
        for (int i = quotes.size()-1; i >= 0; i--) {
            System.out.println(quotes.get(i).id + " / " + quotes.get(i).author + " / " +quotes.get(i).content);
        }
    }

    private static void doDelete(String command, ArrayList<Quote> quotes) {
        int num = Integer.parseInt(command.split("\\?")[1].split("=")[1]);
        int index = findIndexById(quotes, num);
        if (index != -1) {
            quotes.remove(findIndexById(quotes, num));
            System.out.println(num + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(num + "번 명언은 존재하지 않습니다.");
        }
    }


    private static void doUpdate(String command, ArrayList<Quote> quotes, Scanner sc) {
        int num = Integer.parseInt(command.split("\\?")[1].split("=")[1]);
        int index = findIndexById(quotes, num);
        if (index != -1) {
            System.out.println("명언(기존) : " + quotes.get(index).content);
            System.out.print("명언 : ");
            String content = sc.nextLine();
            quotes.get(index).content = content;
            System.out.println("작가(기존) : " + quotes.get(index).author);
            System.out.print("작가 : ");
            String author = sc.nextLine();
            quotes.get(index).author = author;
        } else {
            System.out.println(num + "번 명언은 존재하지 않습니다.");
        }
    }

    private static int findIndexById(ArrayList<Quote> quotes, int id) {
        for (int i = 0; i < quotes.size(); i++) {
            if (quotes.get(i).id == id) {
                return i;
            }
        }
        return -1;
    }

}

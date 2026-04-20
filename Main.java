package com.back;

import java.util.Scanner;

class Indexsave {
    int number;
    String sentence;
    String writer;

    public Indexsave(int number, String sentence, String writer) {
        this.number = number;
        this.sentence = sentence;
        this.writer = writer;

    }

}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Indexsave[] indexes = new Indexsave[100];
    static int cnt = 0;

    public static void main(String[] args) {


        while (true) {
            System.out.println("== 명언 앱 ==");
            System.out.print("명령) ");
            String str = sc.nextLine();

            if (str.equals("종료")) {
                break;
            } else if (str.equals("등록")) {
                register();
            } else if (str.equals("목록")) {
                index();
            } else if (str.startsWith("삭제?id=")) {
                deleteok(str);
            } else if (str.startsWith("수정?id=")) {
                editok(str);
            }
        }
    }


    static void register() {

        System.out.print("명언 : ");
        String sent = sc.nextLine();

        System.out.print("작가 : ");
        String wrt = sc.nextLine();

        int num = cnt + 1;
        indexes[cnt] = new Indexsave(num, sent, wrt);

        System.out.println(num + "번 명언이 등록되었습니다.");
        cnt++;
    }

    static void index() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = 0; i < cnt; i++) {
            if(indexes[i]==null){continue;}
            Indexsave index = indexes[i];
            System.out.println(index.number + " / " + index.writer + " / " + index.sentence);
        }
    }

    static void deleteok(String cmd) {
        String ids = cmd.substring("삭제?id=".length());
        int id = Integer.parseInt(ids);
        delete(id);
    }

    static void delete(int id) {
        int target = id - 1;
        indexes[target] = null;
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    static void editok(String cmd) {
        String ids = cmd.substring("수정?id=".length());
        int id = Integer.parseInt(ids);
        edit(id);
    }

    static void edit(int id) {
        int target = id - 1;
        System.out.println("명언(기존): " + indexes[target].sentence);
        System.out.print("명언 : ");
        String editsentence = sc.nextLine();
        indexes[target].sentence = editsentence;
        System.out.println("작가(기존) : " + indexes[target].writer);
        System.out.print("작가 : ");
        String editwriter = sc.nextLine();
        indexes[target].writer = editwriter;

    }
}
package com.back; // package== 폴더

import java.util.ArrayList;
import java.util.Scanner;

class Saying {
    int no;
    String says;
    String author;

    boolean isDeleted(){
        return this.says==null;
    }
}
public class Main {
    public static void main(String[] args) {

        System.out.println("==명언 앱==");
        Scanner sc = new Scanner(System.in);
        String command = "";
        ArrayList<Saying> lst = new ArrayList<>();
        int cnt = 0;
        while (true) {
            System.out.print("명령) ");
            command = sc.nextLine();
            if (command.equals("종료")) break;
            else if (command.equals("등록")) {
                Saying s = new Saying();
                lst.add(s);
                System.out.print("명언 : ");
                s.says = sc.nextLine();
                System.out.print("작가 : ");
                s.author = sc.nextLine();
                s.no = ++cnt;
                System.out.println(cnt + "번 명언이 등록되었습니다.");
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언\n" + "----------------------");
                for (int i = cnt - 1; i >= 0; i--) {
                    if (lst.get(i).isDeleted()) continue;
                    else System.out.println(lst.get(i).no + " / " + lst.get(i).author + " / " + lst.get(i).says);
                }
            } else if (command.startsWith("삭제?id=")) {
                int id = Integer.parseInt(command.substring(6)) - 1;
                if (id < 0 || id >= cnt || lst.get(id).isDeleted()) System.out.println(id + 1 + "번 명언은 존재하지 않습니다.");
                else {
                    lst.get(id).says = null;
                    lst.get(id).author = null;
                    System.out.println(id+1+"번 명언이 삭제되었습니다.");
                }
            } else if (command.startsWith("수정?id=")) {
                int id = Integer.parseInt((command.substring(6))) - 1;
                if (id < 0 || id >= cnt || lst.get(id).isDeleted()) System.out.println(id + 1 + "번 명언은 존재하지 않습니다.");
                else {
                    System.out.print("명언(기존): " + lst.get(id).says + "\n명언 : ");
                    lst.get(id).says = sc.nextLine();
                    System.out.print("작가(기존): " + lst.get(id).author + "\n작가 : ");
                    lst.get(id).author = sc.nextLine();
                }
            }
        }
    }
}

package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Content findByNumber(List<Content> list, int Number) {
        for (Content c : list) {
            if (c.number == Number) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("== 명언 앱 ==");
        Scanner sc = new Scanner(System.in);

        String content; // 명언
        String author;  // 작가
        int number = 1; // 명언 번호
        Content target; // 삭제나 수정에 쓰일 content

        List<Content> myContent = new ArrayList<>();

        label:
        while (true) {
            System.out.print("명령) ");
            String line = sc.nextLine(); // 등록/종료 입력
            String[] str = line.split("\\?id=");
            int contentNumber;

            switch (str[0]) {
                case "종료":
                    break label;
                case "등록":
                    System.out.print("명언 : ");  // 명언 입력
                    content = sc.nextLine();

                    System.out.print("작가 : ");  // 작가 입력
                    author = sc.nextLine();

                    myContent.add(new Content(number, author, content)); // 명언 추가

                    System.out.println(number++ + "번 명언이 등록되었습니다.");
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for (int i = myContent.size() - 1; i >= 0; i--) { // 목록 출력
                        myContent.get(i).print();
                    }
                    break;
                case "삭제":
                    contentNumber = Integer.parseInt(str[1]);
                    target = findByNumber(myContent, contentNumber);

                    if (target == null) {
                        System.out.println(contentNumber + "번 명언은 존재하지 않습니다.");
                        break;
                    } else {
                        myContent.remove(target);
                        System.out.println(contentNumber + "번 명언이 삭제되었습니다.");
                    }
                    break;
                case "수정":
                    contentNumber = Integer.parseInt(str[1]);
                    target = findByNumber(myContent, contentNumber);

                    if (target == null) {
                        System.out.println(contentNumber + "번 명언은 존재하지 않습니다.");
                        break;
                    } else {
                        System.out.println("명언(기존) : " + target.content);
                        System.out.print("명언 : ");
                        String newContent = sc.nextLine();
                        System.out.println("작가(기존) : " + target.author);
                        System.out.print("작가 : ");
                        String newAuthor = sc.nextLine();
                        target.modify(newAuthor, newContent);
                    }
                    break;
            }
        }
        sc.close();
    }
}

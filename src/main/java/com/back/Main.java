package com.back;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

class WiseSaying {
    String content;
    String author;
    int id;
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = new String();
        int idx = 0;

        ArrayList<WiseSaying> quoteList = new ArrayList<>();

        System.out.println("== 명언 앱 ==");
        do{
            System.out.println("무엇을 수행할까요?");
            System.out.println("1. 등록 2. 목록 3. 삭제 4. 수정 5. 종료");
            input = sc.nextLine();

            if (input.equals("등록")){
                WiseSaying q = new WiseSaying();
                System.out.print("명언: ");
                q.content = sc.nextLine();

                System.out.print("작가: ");
                q.author = sc.nextLine();

                idx++;
                q.id = idx;

                quoteList.add(q);
                System.out.printf("%d번 명언이 등록되었습니다.",idx);
            }
            else if (input.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-----------------------");
                for (int i = quoteList.size() - 1; i > -1 ; i--) {
                    System.out.printf("%d / %s / %s", quoteList.get(i).id, quoteList.get(i).author, quoteList.get(i).content);
                    System.out.println();
                }
            }
            else if (input.equals("삭제")){
                System.out.print("삭제할 명언 id: ");
                int targetId = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기

                for (WiseSaying ws: quoteList){
                    if(ws.id == targetId){
                       quoteList.remove(ws);
                       break;
                    }
                }
            }
            else if (input.equals("수정")){
                System.out.print("수정할 명언 id: ");
                int targetId = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
                for(WiseSaying ws: quoteList){
                    if (ws.id == targetId){
                        System.out.printf("명언(기존): %s\n", ws.content);
                        System.out.print("명언: ");
                        ws.content = sc.nextLine();

                        System.out.printf("작가(기존): %s\n", ws.author);
                        System.out.print("작가: ");
                        ws.author = sc.nextLine();
                    }
                }


            }
            else if (input.equals("종료")){
                System.out.println("프로그램이 종료되었습니다.");
                return;
            }
            else {
                System.out.println("올바른 명령을 입력해주세요.");
            }

        }
        while(true);


    }
}

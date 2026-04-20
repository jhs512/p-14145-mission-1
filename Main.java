package com.back;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0; //생성된 명언을 색인 가능한 인덱스용 카운트
        String[] quote_list = new String[100]; //명언용 리스트
        String[] author_list = new String[100]; //작가용 리스트
        //명언과 작가는 1:1 매칭이 되야함(한 작가라 여러 명언을 할 수는 있으나, 명언이 존재하라면 대응하는 변수(작가값)가 있어야 출력 가능함)
        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.println("입력 가능한 명령: 등록, 목록, 삭제, 수정, 종료");
            System.out.print("명령을 입력해 주십시오 :");

            String command = sc.nextLine().trim();

            if(command.equals("종료")){
                System.out.print("프로그렘을 종료합니다.");
                break;
            } else if (command.equals("등록")) {
                count++; //등록했다면, 인덱스 카운트 증가

                System.out.print("명언 : ");
                String quote = sc.nextLine().trim();
                System.out.print("작가 : ");
                String author = sc.nextLine().trim();

                quote_list[count-1] = quote; //명언 리스트에 추가
                author_list[count-1] = author; //작가 리스트에 추가

                System.out.println(count+"번 명언이 등록되었습니다.");
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = 0; i < count; i++) {
                    if(author_list[count-i-1] != null){
                        System.out.println( count-i + "/" + author_list[count-i-1] + "/" + quote_list[count-i-1]);
                    }
                }
            } else if (command.equals("삭제")) {
                System.out.print("?id=");
                int id = Integer.parseInt(sc.nextLine().trim()); //특정 명언 관리용 변수 id

                if(quote_list[id-1] == null){ //만약, 특정 변수를 조회했을때 '애초에' 값이 없다면
                    System.out.println(id+"번 명언은 존재하지 않습니다.");
                }
                else{ // 만약, 특정 면수를 조회했을때 작가명조차 없다면
                    quote_list[id-1] = null;
                    author_list[id-1] = null;
                    System.out.println(id+"번 명언이 삭제되었습니다.");
                }

            } else if (command.equals("수정")) {
                System.out.print("?id=");
                int id = Integer.parseInt(sc.nextLine().trim());

                if(quote_list[id-1] == null){
                    System.out.println(id+"번 명언은 존재하지 않습니다.");
                }  else{
                    System.out.println("명언(기존) : "+quote_list[id-1]);

                    System.out.print("명언 : "); //새로 명언 입력
                    String new_quote = sc.nextLine().trim();

                    quote_list[id-1] = new_quote;

                    System.out.println("작가(기존) : "+author_list[id-1]); //작가명 새로 입력

                    System.out.print("작가 : ");
                    String new_author = sc.nextLine().trim();
                    author_list[id-1] = new_author;
                }

            }else{
                System.out.println("잘못된 접근입니다.");
            }
        }
    }
}
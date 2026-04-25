package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<Saying> sayingList = new ArrayList<>();
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (true){
            System.out.print("명령) ");
            command = scanner.nextLine();
            if (command.equals("종료")){
                break;
            } else if (command.equals("등록")){
                System.out.print("명언 : ");
                String saying = scanner.nextLine();
                System.out.print("작자 : ");
                String author = scanner.nextLine();
                sayingList.add(new Saying(saying,author));
            } else if (command.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = sayingList.size()-1; i >= 0; i--){
                    sayingList.get(i).getItem();
                }
            } else if (command.contains("삭제?id=")){
                int targetNumber = Integer.parseInt(command.substring(command.indexOf("=")+1));
                Saying target = null;
                for (Saying s : sayingList){
                    if (s.getNumber() == targetNumber){
                        target = s;
                        break;
                    }
                }
                if (target == null) {
                    System.out.println(targetNumber + "번 명언은 존재하지 않습니다.");
                } else {
                    sayingList.remove(target);
                    System.out.println(targetNumber + "번 명언이 삭제되었습니다.");
                }
            } else if (command.contains("수정?id=")){
                int targetNumber = Integer.parseInt(command.substring(command.indexOf("=")+1));
                Saying target = null;
                for (Saying s : sayingList){
                    if (s.getNumber() == targetNumber){
                        target = s;
                        String newSaying;
                        String newAuthor;
                        System.out.println("명언(기존) : " + target.getSaying());
                        System.out.print("명언 : ");
                        newSaying = scanner.nextLine();
                        System.out.println("작자(기존) : " + target.getAuthor());
                        System.out.print("작자 : ");
                        newAuthor = scanner.nextLine();
                        target.modifySaying(newSaying,newAuthor);
                        break;
                    }
                }
                if (target == null){
                    System.out.println(targetNumber + "번 명언은 존재하지 않습니다.");
                }
            }
        }
    }
}

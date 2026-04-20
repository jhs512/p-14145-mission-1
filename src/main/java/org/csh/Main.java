package org.csh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String saying = "";
        String author = "";
        ArrayList<Map<String,Object>> list = new ArrayList<>();
        int no = 1;
        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) " );
            String word = sc.next();
            if(word.equals("종료")) break;
            if(word.equals("등록")) {
                System.out.print("명언 : ");
                saying = sc.next().trim();
                System.out.print("작가 : ");
                author = sc.next().trim();
                if(!saying.isEmpty() && !author.isEmpty()) {
                    Map<String,Object> map = new HashMap<>();
                    map.put("no", no);
                    map.put("saying", saying);
                    map.put("author", author);
                    list.add(map);
                    System.out.println(no++ + "번 명언이 등록되었습니다.");
                }
            } else if (word.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i = list.size()-1; i>=0; i--) {
                    Map<String,Object> m = list.get(i);
                    if(m.get("no") != null) {
                        System.out.println(m.get("no") + " / " + m.get("author") + " / " + m.get("saying"));
                    }
                }
            } else if (word.contains("삭제")) {
                int removeNumber = Integer.parseInt(word.substring(6));
                if(list.size() >= removeNumber) {
                    if(list.get(removeNumber-1) != null) {
                        if (list.get(removeNumber - 1).get("no") != null) {
                            list.remove(removeNumber - 1);
                            list.add(removeNumber - 1, new HashMap<>());
                            System.out.println(removeNumber + "번 명언이 삭제되었습니다.");
                        } else {
                            System.out.println(removeNumber + "번 명언은 존재하지 않습니다.");
                        }
                    } else {
                        System.out.println(removeNumber + "번 명언은 존재하지 않습니다.");
                    }
                } else {
                    System.out.println(removeNumber + "번 명언은 존재하지 않습니다.");
                }
            } else if(word.contains("수정")) {
                int editNumber = Integer.parseInt(word.substring(6));
                if(list.size() >= editNumber) {
                    if(list.get(editNumber-1) != null) {
                        if (list.get(editNumber - 1).get("no") != null) {
                            Map<String, Object> m = list.get(editNumber - 1);

                            System.out.println("명언(기존) : " + m.get("saying"));
                            System.out.print("명언 : ");
                            saying = sc.next().trim();
                            m.put("saying", saying);
                            System.out.println("작가(기존) : " + m.get("author"));
                            System.out.print("작가 : ");
                            author = sc.next().trim();
                            m.put("author", author);
                            list.remove(editNumber - 1);
                            list.add(editNumber - 1, m);
                            System.out.println(editNumber + "번 명언이 수정되었습니다..");
                        } else {
                            System.out.println(editNumber + "번 명언은 존재하지 않습니다.");
                        }
                    } else {
                        System.out.println(editNumber + "번 명언은 존재하지 않습니다.");
                    }
                } else {
                    System.out.println(editNumber + "번 명언은 존재하지 않습니다.");
                }
            }
        }
    }
}

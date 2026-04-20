package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FamusSayingBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String order = "";
        String content = "";
        String author = "";

        List<Saying> sayings = new ArrayList<>();
        int sayingCount = 0;

        System.out.println("==명언 앱==");

        while (!Objects.equals(order, "종료")) {

            System.out.print("명령) ");

            order = sc.nextLine();
            // System.out.println(order);  // 입력한 명령 확인용

            if (Objects.equals(order, "종료")) {
                System.out.println("시스템을 종료합니다.");
                break;
            }

            if (Objects.equals(order, "등록")) {
                System.out.print("명언 : ");
                content = sc.nextLine();
                System.out.print("작가 : ");
                author = sc.nextLine();

                sayingCount++;
                Saying saying = new Saying(sayingCount, content, author);
                sayings.add(saying);

                System.out.println(sayingCount + "번 명언이 등록되었습니다.");

                // 명령 목록 갯수 확인 용
                // System.out.println("Count : " + sayingCount);

                // 입력값 확인 용
                // System.out.println("명언: " + content);
                // System.out.println("작가: " + author);

            } else if (Objects.equals(order, "목록")) {
                System.out.println("==============");
                if (sayings.size() > 0) {
                    for (int i = sayings.size() - 1; i >= 0; i--) {
                        Saying s = sayings.get(i);
                        System.out.println(s.id + " / " + s.content + " / " + s.author);
                    }
                } else {
                    System.out.println("명언 목록이 없습니다.");
                }

            } else if (Objects.equals(order, "삭제")) {
                if(sayings.size() > 0) {
                    System.out.print("?id=");
                    int deleteNumber = sc.nextInt();
                    sc.nextLine();

                    Saying found = null;

                    for (Saying saying : sayings) {
                        if (saying.id == deleteNumber) {
                            found = saying;
                            sayings.remove(saying);
                            System.out.println(saying.id + "번 명언이 삭제되었습니다.");
                            // 명령 목록 갯수 확인 용
                            // System.out.println("Count : " + sayingCount);
                            break;
                        }
                    }
                    if (found == null) {
                        System.out.println(deleteNumber + "번 명언이 존재하지 않습니다.");
                    }
                } else {
                    System.out.println("등록된 명언이 없습니다.");
                }

            } else if (Objects.equals(order, "수정")) {
                if (sayings.size() > 0) {
                    System.out.print("?id=");
                    int modifiedNumber = sc.nextInt();
                    sc.nextLine();

                    Saying found = null;

                    for (Saying saying : sayings) {
                        if (saying.id == modifiedNumber) {
                            System.out.println("명언(기존) : " + saying.content);
                            System.out.print("명언 : ");
                            String modifiedContent = sc.nextLine();

                            System.out.println("작가(기존) : " + saying.content);
                            System.out.print("작가 : ");
                            String modifiedAuthor = sc.nextLine();

                            Saying modifiedSaying = new Saying(modifiedNumber, modifiedContent, modifiedAuthor);

                            found = saying;
                            int index = sayings.indexOf(saying);
                            sayings.set(index, modifiedSaying);
                            System.out.println(saying.id + "번 명언이 수정되었습니다.");
                            break;
                        }
                    }
                    if (found == null) {
                        System.out.println(modifiedNumber + "번 명언이 존재하지 않습니다.");
                    }
                } else {
                    System.out.println("등록된 명언이 없습니다.");
                }
            }

            else {
                System.out.print("올바르지 않은 명령입니다.\n");
            }

        }
    }
}

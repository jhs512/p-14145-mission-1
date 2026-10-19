package org.example;

import java.util.Scanner;

public class Quote {
    int number;
    String content;
    String author;
    boolean isDeleted;

    Quote(int number, String content, String author) {
        this.number = number;
        this.content = content;
        this.author = author;
        isDeleted = false;
    }

    void println() {
        if (isDeleted) return;
        System.out.print(this.number + " / " + this.author + " / " + this.content + "\n");
    }

    void delete() {
        if (isDeleted) {
            System.out.print(this.number + "번 명언은 존재하지 않습니다.\n");
            return;
        }
        isDeleted = true;
        System.out.print(this.number + "번 명언이 삭제되었습니다.\n");
    }

    void edit(Scanner sc) {
        if (isDeleted) {
            System.out.print(this.number + "번 명언은 존재하지 않습니다.\n");
            return;
        }
        System.out.print("명언(기존) : " + this.content + "\n");
        System.out.print("명언 : ");
        this.content = sc.nextLine().trim();
    }
}

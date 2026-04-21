package com.back;

class Content {
    int number;
    String author;
    String content;

    Content(int number, String author, String content) {
        this.number = number;
        this.author = author;
        this.content = content;
    }

    void modify(String author, String content) {
        this.author = author;
        this.content = content;
    }

    void print() {
        System.out.println(number + " / " + author + " / " + content);
    }
}

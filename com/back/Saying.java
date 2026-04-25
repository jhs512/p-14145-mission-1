package com.back;

public class Saying {
    String saying;
    String author;
    private int Number; // 객체 고유 번호
    static int registeredCount = 0; // 지금까지 등록했던 개수
    public Saying(String saying, String author){
        this.saying = saying;
        this.author = author;
        this.Number = registerNumber();
        System.out.println(this.Number + "번 명언이 등록되었습니다.");
        registeredCount++;
    }
    private int registerNumber(){
        return registeredCount+1;
    }
    public void getItem(){
        System.out.println(this.Number + " / " + this.author + " / " + this.saying);
    }
    public int getNumber(){
        return this.Number;
    }
    public String getSaying(){
        return this.saying;
    }
    public String getAuthor(){
        return this.author;
    }
    public void modifySaying(String newSaying, String newAuthor){
        this.saying = newSaying;
        this.author = newAuthor;
    }
}

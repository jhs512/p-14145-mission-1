package com.back;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class QuoteClass {
    int index;
    String quote;
    String writer;
    public QuoteClass(int index,String quote, String writer) {
        this.index = index;
        this.quote = quote;
        this.writer = writer;
    }
}
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int i = 0;
    private static ArrayList<QuoteClass> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("== 명언 앱 ==");
        start();
    }
    private static void start() throws IOException {
        while(true) {
            System.out.print("명령) ");
            String text = br.readLine();
            switch (text) {
                case "등록" :
                    create();
                    break;
                case "종료" :
                    return;
                case "목록" :
                    readQuote();
                    break;
                case "삭제" :
                    remove();
                    break;
                case "수정" :
                    update();
                    break;
            }
        }
    }
    private static void create() throws IOException {
        System.out.print("명언 : ");
        String quote = br.readLine();
        System.out.print("작가 : ");
        String writer = br.readLine();
        int index = ++i;
        QuoteClass q = new QuoteClass(index, quote, writer);
        list.add(q);
        System.out.println(i + "번 명언이 등록되었습니다.");
    }
    private static void readQuote() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for (int i = list.size() - 1; i >= 0; i--) {
            QuoteClass q = list.get(i);
            System.out.println(q.index + " / " + q.writer + " / " + q.quote);
        }
    }
    private static void remove() throws IOException {
        System.out.print("?id=");
        int id = Integer.parseInt(br.readLine());
        boolean removed = list.removeIf(q -> q.index == id);
        if(removed) {
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }
    private static void update() throws IOException {
        System.out.print("?id=");
        int id = Integer.parseInt(br.readLine());
        for(QuoteClass q : list) {
            if(q.index == id) {
                System.out.println("명언(기존) : " + q.quote);
                System.out.print("명언 : ");
                String updateQuote = br.readLine();
                q.quote = updateQuote;
                System.out.println("작가(기존) : " + q.writer);
                System.out.print("작가 : ");
                String updateWriter = br.readLine();
                q.writer = updateWriter;
                System.out.println(id + "번 명언이 수정되었습니다.");
                return;
            }
        }
        System.out.println(id + "번 명언은 존재하지 않습니다.");
    }
}

import java.util.Objects;

public class Quote {
    private int idx;
    private String author;
    private String content;
    Quote(int idx, String author, String content)
    {
        this.idx = idx;
        this.author = author;
        this.content = content;
    }
    Quote(int idx, String content)
    {
        this.idx = idx;
        this.author = "작자미상";
        this.content = content;
    }
    String getAuthor(){return this.author;}
    String getContent(){return this.content;}
    int getIdx(){return this.idx;}
    void setContext(String  content){this.content = content;}
    void setAuthor(String author){this.author = author;}
    void printInfo()
    {
        System.out.println(this.idx + " / " + this.author + " / " + this.content);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this==o)return true;
        if(o == null || getClass() != o.getClass()) return false;
        Quote dummy = (Quote) o;
        return idx == ((Quote) o).getIdx();
    }
    @Override
    public int hashCode() {
        return Objects.hash(idx); // equals에서 쓴 필드를 그대로 사용
    }
}

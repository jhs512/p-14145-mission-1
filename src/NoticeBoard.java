import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoticeBoard {
    private int max_idx;
    private Quote[] list;
    private List<Quote> otherList;
    private Scanner sc;
    private boolean mode;
    NoticeBoard()
    {
        this.mode = true;
        this.max_idx = 0;
        if(mode)
            this.otherList = new ArrayList<Quote>();
        else
            this.list = new Quote[101];
        this.sc = new Scanner(System.in);
    }

    private boolean isInHere(int idx)
    {
        boolean check = true;
        if(mode)
        {
            Quote dummy = new Quote(idx, "");
            if(otherList.contains(dummy)) check =  true;
            else check = false;
        }
        else {
            if (!(0 <= idx && idx <= list.length)) {
                System.out.println(idx + "번 명언은 존재하지 않습니다.");
                check = false;
            }
            if (list[idx] == null) {
                System.out.println(idx + "번 명언은 존재하지 않습니다.");
                check = false;
            }
        }
        if(!check)System.out.println(idx + "번 명언은 존재하지 않습니다.");
        return check;
    }
    private void regist()
    {
        //일단 이렇게 확장
        if(!mode && max_idx+1 >= this.list.length)
        {
            Quote[] dummy = new Quote[max_idx*100];
            System.arraycopy(this.list,0, dummy, 0, this.list.length);
            this.list = dummy;
        }

        System.out.print("명언 : ");
        String context = sc.nextLine().trim();

        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        max_idx++;
        System.out.println(max_idx + "번 명언이 등록되었습니다.");
        Quote quo = new Quote(max_idx, author, context);
        if(!mode)
            this.list[max_idx] = quo;
        else
            this.otherList.add(quo);
    }

    private void delete(int idx)
    {
        if(!isInHere(idx))return;
        if(!mode)list[idx] = null;
        else otherList.remove(new Quote(idx, ""));
        System.out.println(idx + "번 명언이 삭제되었습니다.");
    }

    private void print()
    {
        if(!mode) {
            // Quote[]
            for (int i = 1; i <= max_idx; i++) {
                if (list[i] != null)
                    list[i].printInfo();
            }
        }
        else {
            // List<Quote>
            for(Quote quo : otherList)
            {
                quo.printInfo();
            }
        }
    }

    private void modify(int idx)
    {
        if(!isInHere(idx))return;
        Quote dummy = new Quote(idx, "");
        if(mode)
            dummy = otherList.get(otherList.indexOf((dummy)));
        else
            dummy = list[idx];

        String beforeContent = dummy.getContent();
        System.out.println("명언(기존) : " + beforeContent);
        System.out.print("명언 : ");
        String afterContext =sc.nextLine().trim();

        String beforeAuthor = dummy.getAuthor();
        System.out.println("작가(기존) : " + beforeAuthor);
        System.out.print("작가 : ");
        String afterAuthor = sc.nextLine().trim();

        dummy.setContext(afterContext);
        dummy.setAuthor(afterAuthor);
    }

    void loop()
    {
        String command;
        boolean online = true;
        System.out.println("== 명언 앱 ==");
        while(online) {
            System.out.print("명령) ");
            command = sc.nextLine().trim();

            if(command.equals("종료"))online = false;
            else if(command.equals("등록"))
            {
                regist();
            }
            else if(command.equals("목록"))
            {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("------------------------");
                print();
            }
            else if(command.contains("삭제"))
            {
                // 1 로 접근 수정 필요할 수 있음
                String[] splited = command.split("\\?");
                String[] idSplited = splited[1].split("id=");
                int idx = Integer.parseInt(idSplited[idSplited.length-1]);
                delete(idx);
            }
            else if(command.contains("수정"))
            {
                // 1 로 접근 수정 필요할 수 있음
                String[] splited = command.split("\\?");
                String[] idSplited = splited[1].split("id=");
                int idx = Integer.parseInt(idSplited[idSplited.length-1]);
                modify(idx);
            }
        }
    }
}

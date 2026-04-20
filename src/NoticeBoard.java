import java.util.Scanner;

public class NoticeBoard {
    private int max_idx;
    private Quote[] list;
    private Scanner sc;

    NoticeBoard()
    {
        this.max_idx = 0;
        this.list = new Quote[101];
        this.sc = new Scanner(System.in);
    }
    private boolean isInHere(int idx)
    {
        if( !(0 <= idx && idx <=list.length) )
        {
            System.out.println(idx + "번 명언은 존재하지 않습니다.");
            return false;
        }
        if(list[idx] == null)
        {
            System.out.println(idx + "번 명언은 존재하지 않습니다.");
            return false;
        }
        return true;
    }
    private void regist()
    {
        //일단 이렇게 확장
        if(max_idx+1 >= this.list.length)
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
        this.list[max_idx] = quo;
    }

    private void delete(int idx)
    {
        if(!isInHere(idx))return;
        list[idx] = null;
        System.out.println(idx + "번 명언이 삭제되었습니다.");
    }

    private void print()
    {
        for(int i=1; i<=max_idx; i++)
        {
            if(list[i] != null)
                list[i].printInfo();
        }
    }

    private void modify(int idx)
    {
        if(!isInHere(idx))return;
        String beforeContext = list[idx].getContent();
        System.out.println("명언(기존) : " + beforeContext);
        System.out.print("명언 : ");
        String afterContext =sc.nextLine().trim();

        String beforeAuthor = list[idx].getAuthor();
        System.out.println("작가(기존) : " + beforeAuthor);
        System.out.print("작가 : ");
        String afterAuthor = sc.nextLine().trim();

        list[idx].setContext(afterContext);
        list[idx].setAuthor(afterAuthor);
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

package untitled.src.member;

import java.io.IOException;

public class MemberMain {
    public static void main(String[] args) throws IOException {
        MemberPro pro = new MemberProImpl();
        while(true) {
            System.out.println("1. 입력 2. 출력 3. 삭제 4. 수정 5. 종료 : ");
            // 아스키코드 정수화, /r/n 삭제
            int select = System.in.read() - 48;
            System.in.skip(5);

            switch(select) {
                case 1: pro.insert(); break;
                case 2: pro.view(); break;
                case 3: pro.delete(); break;
                case 4: pro.edit(); break;
                case 5: pro.exit(); break;
                default:
                    System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
            }
        }
    }
}

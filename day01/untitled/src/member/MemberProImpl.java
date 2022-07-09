package untitled.src.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberProImpl implements MemberPro{

    private List<Member> list;
    private Scanner in;
    public MemberProImpl() {
        list = new ArrayList<>();
        in = new Scanner(System.in);
    }

    @Override
    public void insert() {
        System.out.println("이름을 입력하세요. : ");
        String name = in.next();
        System.out.println("전화번호를 입력하세요. : ");
        String tel = in.next();
        Member input = new Member(name, tel);
        list.add(input);
    }

    @Override
    public void view() {
        for(Member view : list){
            System.out.println(view.getName());
            System.out.println(view.getTel());
        }
    }

    @Override
    public void delete() {
        System.out.println("삭제할 회원의 이름은 : ");
        String name = in.next();
        for(Member delete : list){
            if(delete.equals(name)){
                list.remove(delete);
                System.out.println(name +"회원님을 삭제하였습니다.");
                return;
            }
        }
        System.out.println(name +"님은 존재하지 않습니다.");
    }

    @Override
    public void edit() {
        System.out.println("수정할 회원의 이름은 : ");
        String name = in.next();
        for(Member edit : list) {
            if(edit.getName().equals(name)){
                System.out.println(name + "님의 현재 전화번호는 " +edit.getTel());
                System.out.println("새로운 전화번호를 입력해주세요. ");
                String tel = in.next();
                edit.setTel(tel);
                System.out.println(name + "님의 전화번호가 " + tel +"로 수정되었습니다.");
            }
        }
        System.out.println("입력하신 회원이름은 존재하지 않습니다.");
    }

    @Override
    public void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}

package untitled.src.member;

import java.util.*;

public class MemberProImpl2 implements MemberPro{


    private Map<String, Member> map;
    private Scanner in;
    public MemberProImpl2() {
        map = new Hashtable<>();
        in = new Scanner(System.in);
    }

    @Override
    public void insert() {
        System.out.println("이름을 입력하세요. : ");
        String name = in.next();
        System.out.println("전화번호를 입력하세요. : ");
        String tel = in.next();
        Member input = new Member(name, tel);
        if(map.containsKey(name)){
            insert();
        } else {
            map.put(name, input);
        }
    }

    @Override
    public void view() {
        //entry를 사용한 map 출력

        //forEach를 사용한 map 출력
        map.forEach((String, Member) -> {
            System.out.println("name: " + String + ", Phone : " + Member.getTel());
        });

        //Iterator를 사용한 map 출력
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String name = it.next();
            Member view = map.get(name);
            System.out.println(view.getName() + " " + view.getTel());
        }
    }

    @Override
    public void delete() {
        System.out.println("삭제할 회원의 이름은 : ");
        String name = in.next();
        if(map.containsKey(name)){
            map.remove(name);
            System.out.println(name +"회원님을 삭제하였습니다.");
        }
        System.out.println(name +"님은 존재하지 않습니다.");
    }

    @Override
    public void edit() {
        System.out.println("수정할 회원의 이름은 : ");
        String name = in.next();
        if(map.containsKey(name)) {
            Member edit = map.get(name);
            System.out.println(name + "님의 현재 이름과 전화번호는 " + map.get(name));
            System.out.println("새로운 전화번호를 입력해주세요. ");
            String tel = in.next();
            edit.setTel(tel);
            map.replace(name, edit);
        }
        System.out.println("입력하신 회원이름은 존재하지 않습니다.");
    }

    @Override
    public void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}

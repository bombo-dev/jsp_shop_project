package untitled.src.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        System.out.println("1. 입력 / 2. 출력 / 3. 삭제 / 4. 수정 / 5. 종료");
        Scanner sc = new Scanner(System.in);
        List<Person> list = new ArrayList<Person>();
        int input = sc.nextInt();

        while(true) {
            switch (input) {
                case 1:
                    Person p1 = new Person();
                    System.out.print("이름을 입력해주세요. : ");
                    String insertName = sc.next();
                    p1.setName(insertName);
                    System.out.print("번호를 입력해주세요. ex)010xxxxxxxx : ");
                    int insertPhone = sc.nextInt();
                    p1.setPhone(insertPhone);
                    list.add(p1);

                    break;
                case 2:
                    for (Person p : list) {
                        System.out.println("이름은 : " + p.getName());
                        System.out.println("전화번호는 : " + p.getPhone());
                    }
                    break;
                case 3:
                    System.out.print("삭제할 회원의 이름을 입력해주세요. : ");
                    String deleteName = sc.next();
                    for (Person p : list) {
                        if (p.getName().equals(deleteName))
                            list.remove(p);
                    }
                    break;
                case 4:
                    System.out.print("전화번호를 수정할 회원의 이름을 입력해주세요. : ");
                    String modifyName = sc.next();
                    for (Person p : list) {
                        if (p.getName().equals(modifyName)) {
                            System.out.println("수정할 회원님의 기존 번호는 " + p.getPhone() + "입니다.");
                            System.out.println("변경하실 새로운 전화번호를 입력해주세요. ex)010xxxxxxxx");
                            int modifyPhone = sc.nextInt();
                            p.setPhone(modifyPhone);
                        }
                    }
                    break;
                case 5:
                    System.out.println("프로그램이 종료되었습니다.");
                    break;
                default:
                    System.out.println("1 ~ 5번 사이의 값을 입력해주세요.");
                    break;
            }
        }
    }
}

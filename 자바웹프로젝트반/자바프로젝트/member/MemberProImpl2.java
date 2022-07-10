package member;
import java.util.*;

public class MemberProImpl2 implements MemberPro {
	private Map<String, Member> map;
	private Scanner in;
	public MemberProImpl2() {
		map = new Hashtable<>();
		in = new Scanner(System.in);
	}
	
	@Override
	public void insert() {
		String name;
		do {
			System.out.print("이름을 입력 : ");
			name = in.next();
		}while(map.containsKey(name));
		System.out.print("전화번호를 입력 : ");
		String tel = in.next();
		Member input = new Member(name, tel);
		map.put(name, input);
	}

	@Override
	public void view() {
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String name = it.next();
			Member view = map.get(name);
			System.out.println(view.getName()+
						"님의 전화번호 : " + view.getTel());
		}
	}

	@Override
	public void delete() {
		System.out.print("삭제할 회원의 이름 : ");
		String name = in.next();
		if (map.containsKey(name)) {
			map.remove(name);
			System.out.println(name+"회원님을 삭제하였습니다.");
			return;
		}
		System.out.println(name+"님은 저희 회원이 아닙니다.");
	}

	@Override
	public void edit() {
		System.out.print("수정할 회원의 이름 : ");
		String name = in.next();
		if (map.containsKey(name)) {
			Member edit = map.get(name);
			System.out.println(name+"님의 현재 전화번호는 " + edit.getTel()+"번 입니다.");
			System.out.print("새로운 전화번호를 입력 : ");
			String tel = in.next();
			edit.setTel(tel);
			System.out.println(name+"님의 전화번호를 수정하였습니다.");
			return;				
		}
		System.out.println(name+"님은 저희 회원이 아닙니다.");
	}

	@Override
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);	
	}

}

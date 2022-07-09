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
			System.out.print("�̸��� �Է� : ");
			name = in.next();
		}while(map.containsKey(name));
		System.out.print("��ȭ��ȣ�� �Է� : ");
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
						"���� ��ȭ��ȣ : " + view.getTel());
		}
	}

	@Override
	public void delete() {
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		if (map.containsKey(name)) {
			map.remove(name);
			System.out.println(name+"ȸ������ �����Ͽ����ϴ�.");
			return;
		}
		System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
	}

	@Override
	public void edit() {
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		if (map.containsKey(name)) {
			Member edit = map.get(name);
			System.out.println(name+"���� ���� ��ȭ��ȣ�� " + edit.getTel()+"�� �Դϴ�.");
			System.out.print("���ο� ��ȭ��ȣ�� �Է� : ");
			String tel = in.next();
			edit.setTel(tel);
			System.out.println(name+"���� ��ȭ��ȣ�� �����Ͽ����ϴ�.");
			return;				
		}
		System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
	}

	@Override
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);	
	}

}

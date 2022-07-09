package member;
import java.util.*;
public class MemberProImpl implements MemberPro{
	private List<Member> list;
	private Scanner in;
	
	public MemberProImpl() {
		list = new ArrayList<>();
		in = new Scanner(System.in);
	}
	@Override
	public void insert() {
		System.out.print("�̸��� �Է� : ");
		String name = in.next();
		System.out.print("��ȭ��ȣ�� �Է� : ");
		String tel = in.next();
		Member input = new Member(name, tel);
		list.add(input);
	}

	@Override
	public void view() {
		for(Member view : list) {
			System.out.println(view.getName()+"���� ��ȭ��ȣ : " + view.getTel());
		}
	}

	@Override
	public void delete() {
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		for(Member delete : list) {
			if (delete.getName().equals(name)) {
				list.remove(delete);
				System.out.println(name+"ȸ������ �����Ͽ����ϴ�.");
				return;
			}
		}
		System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
	}

	@Override
	public void edit() {
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		for(Member edit : list) {
			if (edit.getName().equals(name)) {
				System.out.println(name+"���� ���� ��ȭ��ȣ�� " + edit.getTel()+"�� �Դϴ�.");
				System.out.print("���ο� ��ȭ��ȣ�� �Է� : ");
				String tel = in.next();
				edit.setTel(tel);
				System.out.println(name+"���� ��ȭ��ȣ�� �����Ͽ����ϴ�.");
				return;
			}
		}
		System.out.println(name+"���� ���� ȸ���� �ƴմϴ�.");
	}

	@Override
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);		
	}

}
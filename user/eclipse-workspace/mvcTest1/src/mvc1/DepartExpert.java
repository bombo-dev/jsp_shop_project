package mvc1;

import java.util.*;

public class DepartExpert {
	public List<String> getAdvice(String depart){
		List<String> list = new ArrayList<>();
		switch(depart) {
		case "c" :
			list.add("�������ҿ��� ������ ���α׷��� ���");
			list.add("���α׷��� �����ϰ� �� �� �ִ�");
			list.add("���α׷��� �ϱ� ���� ���� ����̴�.");
			break;
		case "java" :
			list.add("��ü���� ���α׷��� ���");
			list.add("��Ʈ��ũ ����� ������ �����Ͽ� ���ͳ� ȯ�濡�� ���� ����ϴ� ���");
			list.add("���ȼ��� �پ�� �������� �ڵ�� �ٸ� ���� ��� ����");
			break;
		case "python" :
			list.add("�����ϰ� ���꼺�� ���� ���α׷��� ���");
			list.add("������ �����ϰ� �ſ� ����");
			list.add("����� ��ȭ�ϵ� ���α׷��� �� �� �־� �ʺ��ڵ� ���� ���� �� �ִ�");
			break;
		case "go" :
			list.add("���ۿ��� ������ ���α׷��� ���");
			list.add("��Ƽ�ھ �����Ͽ� ȿ������ �ſ� ���� ����� �� �ִ� ���");
			list.add("����Ÿ�Ծ��� �����Ͽ� ����ð� ȿ������ ���̰�.......");
			break;
		}
		return list;
	}
}

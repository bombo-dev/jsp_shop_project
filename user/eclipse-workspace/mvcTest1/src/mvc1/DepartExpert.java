package mvc1;

import java.util.*;

public class DepartExpert {
	public List<String> getAdvice(String depart){
		List<String> list = new ArrayList<>();
		switch(depart) {
		case "c" :
			list.add("벨연구소에서 개발한 프로그래밍 언어");
			list.add("프로그램을 간결하게 쓸 수 있다");
			list.add("프로그래밍 하기 쉬운 편리한 언어이다.");
			break;
		case "java" :
			list.add("객체지향 프로그래밍 언어");
			list.add("네트워크 기능의 구현이 용이하여 인터넷 환경에서 많이 사용하는 언어");
			list.add("보안성이 뛰어나며 컴파일한 코드는 다른 언어에서 사용 가능");
			break;
		case "python" :
			list.add("간결하고 생산성이 높은 프로그래밍 언어");
			list.add("문법이 간결하고 매우 쉽다");
			list.add("사람이 대화하듯 프로그램을 할 수 있어 초보자도 쉽게 접할 수 있다");
			break;
		case "go" :
			list.add("구글에서 개발한 프로그래밍 언어");
			list.add("멀티코어를 지원하여 효율성을 매우 높게 사용할 수 있는 언어");
			list.add("정적타입언어로 설계하여 실행시간 효율성을 높이고.......");
			break;
		}
		return list;
	}
}

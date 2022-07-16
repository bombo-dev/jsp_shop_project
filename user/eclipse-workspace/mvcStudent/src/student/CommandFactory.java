package student;

public class CommandFactory {
	//1. private �����ڷ� �����
	private CommandFactory() {}
	//2. ���ο��� ��ü�� �����Ѵ�
	private static CommandFactory instance = new CommandFactory();
	//3. static���� ����� instance�� �������� �޼ҵ带 �����
	public static CommandFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if (cmd.equals("insert")){
			cmdIf = new InsertCommand();
		}else if (cmd.equals("delete")) {
			cmdIf = new DeleteCommand();
		}else if (cmd.equals("find")) {
			cmdIf = new FindCommand();
		}else if (cmd.equals("list")) {
			cmdIf = new ListCommand();
		}else if (cmd.equals("index")) {
			cmdIf = new IndexCommand();
		}
		return cmdIf;
	}
}





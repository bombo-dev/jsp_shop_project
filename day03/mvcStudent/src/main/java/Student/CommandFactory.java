package Student;

// Factory Pattern
// CommandFactory 만들기
public class CommandFactory {
    //1. private 생성자로 만든다.
    private CommandFactory() {

    }
    //2. 내부에서 객체를 생성한다.
    private static CommandFactory instance = new CommandFactory();

    //3. static으로 선언된 instance를 내보내는 메소드를 만든다.

    public static CommandFactory getInstance() {
        return instance;
    }

    public CommandIf createCommand(String cmd) {
        CommandIf cmdIf = null;
        if(cmd.equals("insert")){
            cmdIf = new InsertCommand();
        }else if(cmd.equals("delete")){
            cmdIf = new DeleteCommand();
        }else if(cmd.equals("find")){
            cmdIf = new FindCommand();
        }else if(cmd.equals("list")){
            cmdIf = new ListCommand();
        }else if(cmd.equals("index")) {
            cmdIf = new IndexCommand();
        }
        return cmdIf;
    }
}

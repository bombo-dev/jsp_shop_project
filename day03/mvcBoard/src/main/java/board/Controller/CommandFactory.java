package board.Controller;

public class CommandFactory {
    private CommandFactory() {}

    private static CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {
        return instance;
    }

    public CommandIf createCommand(String cmd) {
        CommandIf cmdIf = null;

        if(cmd.equals("/board_list.do")){
            cmdIf = new BoardListCommand();
        }

        return cmdIf;
    }
}

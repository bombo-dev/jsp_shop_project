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
        } else if(cmd.equals("/board_content.do")) {
            cmdIf = new BoardContentCommand();
        } else if(cmd.equals("/board_writeForm.do")) {
            cmdIf = new BoardWriteFormCommand();
        } else if(cmd.equals("/board_writePro.do")) {
            cmdIf = new BoardWriteProCommand();
        } else if(cmd.equals("/board_updateForm.do")) {
            cmdIf = new BoardUpdateFormCommand();
        } else if(cmd.equals("/board_updatePro.do")) {
            cmdIf = new BoardUpdateProCommand();
        } else if(cmd.equals("/board_deleteForm.do")){
            cmdIf = new BoardDeleteFormCommand();
        } else if(cmd.equals("/board_deletePro.do")){
            cmdIf = new BoardDeleteProCommand();
        }

        return cmdIf;
    }
}

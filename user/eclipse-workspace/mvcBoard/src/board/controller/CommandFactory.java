package board.controller;

public class CommandFactory {
	private CommandFactory() {}
	private static CommandFactory instance = new CommandFactory();
	public static CommandFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		
		if (cmd.equals("/board_list.board")) {
			cmdIf = new BoardListCommand();
		}
		
		return cmdIf;
	}
}

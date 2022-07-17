package shop.controller;

public class CommandFactory {
	private CommandFactory() {}
	private static CommandFactory instance = new CommandFactory();
	public static CommandFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if (cmd.equals("/adminShop.mall")) {
			cmdIf = new AdminShopCommand();
		}else if (cmd.equals("/cate_input.mall")) {
			cmdIf = new CateInputCommand();
		}else if (cmd.equals("/cate_input_ok.mall")) {
			cmdIf = new CateInputOkCommand();
		}else if (cmd.equals("/cate_list.mall")) {
			cmdIf = new CateListCommand();
		}else if (cmd.equals("/cate_delete.mall")) {
			cmdIf = new CateDeleteCommand();
		}
		return cmdIf;
	}
}

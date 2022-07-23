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
		}else if (cmd.equals("/prod_input.mall")) {
			cmdIf = new ProdInputCommand();
		}else if (cmd.equals("/prod_input_ok.mall")) {
			cmdIf = new ProdInputOkCommand();
		}else if (cmd.equals("/prod_list.mall")) {
			cmdIf = new ProdListCommand();
		}else if (cmd.equals("/prod_view.mall")) {
			cmdIf = new ProdViewCommand();
		}else if (cmd.equals("/prod_delete.mall")) {
			cmdIf = new ProdDeleteCommand();
		}else if (cmd.equals("/prod_update.mall")) {
			cmdIf = new ProdUpdateCommand();
		}else if (cmd.equals("/prod_update_ok.mall")) {
			cmdIf = new ProdUpdateOkCommand();
		}else if (cmd.equals("/displayShop.mall")) {
			cmdIf = new ShopMainCommand();
		}else if (cmd.equals("/cgProdList.mall")){
			cmdIf = new CgProdListCommand();
		}else if (cmd.equals("/prodView.mall")){
			cmdIf = new ProdViewMallCommand();
		}
		return cmdIf;
	}
}







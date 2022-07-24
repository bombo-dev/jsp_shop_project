package Controller;

public class CommandFactory {
    private CommandFactory() {
    }

    private static CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {
        return instance;
    }

    public CommandIf createCommand(String cmd) {
        CommandIf cmdIf = null;

        if (cmd.equals("/shop_admin.do")) {
            cmdIf = new AdminShopCommand();
        } else if (cmd.equals("/cate_input.do")) {
            cmdIf = new CateInputCommand();
        } else if (cmd.equals("/cate_input_ok.do")) {
            cmdIf = new CateInputOkCommand();
        } else if (cmd.equals("/cate_list.do")) {
            cmdIf = new CateListCommand();
        } else if (cmd.equals("/cate_delete.do")) {
            cmdIf = new CateDeleteCommand();
        } else if (cmd.equals("/prod_input.do")) {
            cmdIf = new ProdInputCommand();
        } else if (cmd.equals("/prod_input_ok.do")) {
            cmdIf = new ProdInputOkCommand();
        } else if (cmd.equals("/prod_list.do")) {
            cmdIf = new ProdListCommand();
        } else if (cmd.equals("/prod_view.do")) {
            cmdIf = new ProdViewCommand();
        } else if (cmd.equals("/prod_delete.do")){
            cmdIf = new ProdDeleteCommand();
        } else if (cmd.equals("/prod_update.do")){
            cmdIf = new ProdUpdateCommand();
        } else if (cmd.equals("/prod_update_ok.do")){
            cmdIf = new ProdUpdateOkCommand();
        } else if(cmd.equals("/mall.do")){
            cmdIf = new MallCommand();
        } else if(cmd.equals("/cgProdList.do")){
            cmdIf = new MallCategoryProductListCommand();
        } else if(cmd.equals("/prodView.do")){
            cmdIf = new MallProdViewCommand();
        } else if(cmd.equals("/ProdShoppingBasket.do")){
            cmdIf = new ProdShoppingBasketCommand();
        }
        return cmdIf;
    }

}

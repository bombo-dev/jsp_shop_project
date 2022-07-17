package Controller;

public class CommandFactory {
    private CommandFactory() {}

    private static CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() { return instance; }

    public CommandIf createCommand(String cmd) {
        CommandIf cmdIf = null;

        if(cmd.equals("/shop_admin.do")){
            cmdIf = new ShopAdminCommand();
        } else if (cmd.equals("/shop_admin_cate_input.do")){
            cmdIf = new ShopAdminCateInputCommand();
        } else if (cmd.equals("/shop_admin_cate_list.do")) {
            cmdIf = new ShopAdminCateListCommand();
        }

        return cmdIf;
    }
}

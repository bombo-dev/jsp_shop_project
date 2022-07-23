package shop.Controller;

public class CommandFactory {
    private CommandFactory() {}

    private static CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() { return instance;}

    public CommandIf createCommand(String cmd) {
        CommandIf cmdIf = null;

        if(cmd.equals("/adminShop.do")){
            cmdIf = new AdminShopCommand();
        } else if(cmd.equals("/cate_input.do")){
            cmdIf = new CateInputCommand();
        } else if(cmd.equals("/cate_input_ok.do")){
            cmdIf = new CateInputOkCommand();
        } else if(cmd.equals("/cate_list.do")){
            cmdIf = new CateListCommand();
        } else if(cmd.equals("/cate_delete.do")){
            cmdIf = new CateDeleteCommand();
        }
        return cmdIf;
    }

}

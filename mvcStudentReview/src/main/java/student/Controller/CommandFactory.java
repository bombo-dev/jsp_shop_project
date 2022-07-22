package student.Controller;

public class CommandFactory {

    private CommandFactory() {}

    private static CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {return instance;}

    public CommandIf createCommand(String cmd){
        CommandIf cmdIf = null;
        if(cmd.equals("/student_insert.do")){
            cmdIf = new InsertCommand();
        } else if(cmd.equals("/student_delete.do")){
            cmdIf = new DeleteCommand();
        } else if(cmd.equals("/student_list.do")){
            cmdIf = new ListCommand();
        } else if(cmd.equals("/student_find.do")){
            cmdIf = new FindCommand();
        } else if(cmd.equals("/student_manage.do")){
            cmdIf = new ManageCommand();
        }
        return cmdIf;
    }

}

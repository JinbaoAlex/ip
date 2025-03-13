public class MissingCommand extends Commands{
    private final String reply;

    MissingCommand(String reply){
        this.reply = reply;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        new Ui().formatResponse("     " + reply);
    }
}

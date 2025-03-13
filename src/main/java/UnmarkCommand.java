public class UnmarkCommand extends Commands {
    private final int taskNo;

    UnmarkCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.getTask(taskNo).unmarkAsDone();
            String reply = "     OK, I've marked this task as not done yet:\n"
                    + "       " + tasks.getTask(taskNo).toString();
            ui.formatResponse(reply);
        } catch (NullPointerException e) {
            String reply = "     Task number not found, reenter with correct task number:";
            new MissingCommand(reply).execute(tasks, ui, storage);
        } catch (NumberFormatException e) {
            String reply = "     No task number detected, reenter with correct task number:";
            new MissingCommand(reply).execute(tasks, ui, storage);
        }
    }
}

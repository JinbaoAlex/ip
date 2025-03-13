public class MarkCommand extends Commands {
    private final int taskNo;

    MarkCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.getTask(taskNo).markAsDone();
            String reply = "     Nice! I've marked this task as done:\n"
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

public class DeleteCommand extends Commands {
    private final int taskNo;

    DeleteCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            String reply = "     Noted. I've removed this task::\n"
                + "       " + tasks.getTask(taskNo).toString()
                + "     Now you have " + (tasks.size()-1) + " tasks in the list.";
            ui.formatResponse(reply);
            tasks.removeTask(taskNo);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            String reply = "     Task number not found, reenter with correct task number:";
            new MissingCommand(reply).execute(tasks, ui, storage);
        } catch (NumberFormatException e) {
            String reply = "     No task number detected, reenter with correct task number:";
            new MissingCommand(reply).execute(tasks, ui, storage);
        }

    }
}

public class FindCommand extends Commands {
    private final String searchTerm;

    FindCommand(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        StringBuilder sb = new StringBuilder();
        sb.append("     Here are the matching tasks in your list:");
        int count = 1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.getTask(i).find(searchTerm)) {
                sb.append("\n     ").append(count).append(".").append(tasks.getTask(i));
                count++;
            }
        }
        ui.formatResponse(sb.toString());
    }
}

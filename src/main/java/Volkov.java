/**
 * The main code for the Volkov application that handles the overall workflow.
 */
public class Volkov {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    public Volkov(String filePath) {
        ui = new Ui();
        storage = new Storage("./data/volkov.txt", ui);
        this.tasks = storage.loadFile();
    }

    /**
     * Main application loop for processing user commands. This keeps
     * running until the user exits the program.
     */
    public void run() {
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            Commands c = Parser.parse(fullCommand);
            c.execute(tasks, ui, storage);
            isExit = c.isExit();
        }
        storage.saveFile(tasks);
    }

    public static void main(String[] args) {
        new Volkov("data/tasks.txt").run();
    }
}

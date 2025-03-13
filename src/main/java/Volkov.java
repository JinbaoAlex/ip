public class Volkov {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    public Volkov(String filePath) {
        ui = new Ui();
        storage = new Storage("./data/volkov.txt", ui);
        this.tasks = storage.loadFile();
    }

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

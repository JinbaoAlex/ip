import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The {@code Storage} class deals with the loading
 * and saving of tasks in a local txt file.
 */
public class Storage {
    private final String filePath;
    Ui ui;

    Storage(String filePath, Ui ui) {
        this.filePath = filePath;
        this.ui = ui;
    }

    /**
     * Saves the current list of tasks to a txt file.
     * <p>
     * If the file or directory does not exist, it will be created first.
     * Tasks are saved in a format to ease the load process
     *
     * @param taskList The list of tasks to be saved.
     */
    public void saveFile(TaskList taskList) {
        try {
            File f = new File(filePath);

            File parentDir = f.getParentFile();
            if (!parentDir.exists()) {
                if (parentDir.mkdirs()) {
                    ui.formatResponse("     Folder missing, new folder created");
                }
            }

            if (f.createNewFile()) {
                ui.formatResponse("     No file present, new file created");
            }

            FileWriter fw = new FileWriter(filePath);
            for (Task task : taskList.getList()) {
                fw.write(task.txtSave() + "\n");
            }
            fw.close();

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    /**
     * Attempts to load tasks from the txt file into a new {@code TaskList}.
     * <p>
     * If the file exists, it greets the user  as a returning user,
     * reads, parses and loads the tasks from the txt file to a new {@code TaskList}
     * which then gets returned. Otherwise, it greets the user as a new user
     * and returns an empty {@code TaskList}.
     *
     * @return A {@code TaskList} containing the loaded tasks.
     */
    public TaskList loadFile() {
        TaskList taskList = new TaskList();

        File f = new File(filePath);
        if (f.exists()) {
            ui.returnUserGreet();
        } else {
            ui.newUserGreet();
        }

        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String taskString = s.nextLine();

                if (taskString.startsWith("[T]")) {
                    Task t = new Todo(taskString.substring(7).trim());
                    if (taskString.contains("[X]")) {
                        t.markAsDone();
                    }
                    taskList.addTask(t);
                } else if (taskString.startsWith("[D]")) {
                    String[] descAndDate = taskString.substring(7).split("\\|");
                    String desc = descAndDate[0].trim();
                    String date = descAndDate[1].trim();
                    Task t = new Deadline(desc, date);
                    if (taskString.contains("[X]")) {
                        t.markAsDone();
                    }
                    taskList.addTask(t);
                } else if (taskString.startsWith("[E]")) {
                    String[] descAndDate = taskString.substring(7).split("\\|");
                    String desc = descAndDate[0].trim();
                    String start = descAndDate[1].trim();
                    String end = descAndDate[2].trim();
                    Task t = new Event(desc, start, end);
                    if (taskString.contains("[X]")) {
                        t.markAsDone();
                    }
                    taskList.addTask(t);
                }
            }
        } catch (FileNotFoundException e) {

        }
        return taskList;
    }
}



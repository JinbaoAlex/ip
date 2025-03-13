import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private final String filePath;
    Ui ui;

    Storage(String filePath, Ui ui) {
        this.filePath = filePath;
        this.ui = ui;
    }

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



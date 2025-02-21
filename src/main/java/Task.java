public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void unmarkAsDone() {
        isDone = false;
    }

    public String getMark() {
        if (isDone) {
            return "[X] ";
        } else {
            return "[ ] ";
        }
    }

    public String txtSave() {
        return getMark() + description;
    }

    @Override
    public String toString() {
        String mark = getMark();
        return mark + description;
    }
}

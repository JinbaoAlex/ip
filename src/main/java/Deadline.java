import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    protected String deadline;
    protected LocalDate deadlineLocalDate;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
        try {
            this.deadlineLocalDate = LocalDate.parse(deadline);
        } catch (DateTimeParseException e) {
            this.deadlineLocalDate = null;
        }

    }

    /**
     * {@inheritDoc}
     * This method is inherited from {@link Task}.
     * @return A string representation of the task, its description, and deadline date
     */
    public String txtSave() {
        return "[D]" + super.txtSave() + "|" + deadline;
    }

    /**
     * {@inheritDoc}
     * This method is inherited from {@link Task}.
     * @return A formatted string representing the task.
     */
    @Override
    public String toString() {
        if (deadlineLocalDate != null) {
            String deadlineFormatted = deadlineLocalDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            return "[D]" + super.toString() + " (by: " + deadlineFormatted + ")";
        } else {
            return "[D]" + super.toString() + " (by: " + deadline + ")";
        }
    }
}

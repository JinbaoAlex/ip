import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an event task with a description, completion status, and start and end dates.
 * <p>
 * The {@code Event} class provides methods to mark the task as done,
 * unmark it, retrieve its status, and formatting for displaying or saving.
 */
public class Event extends Task {
    protected String startDate;
    protected String endDate;
    protected LocalDate startLocalDate;
    protected LocalDate endLocalDate;

    public Event(String description, String startDate, String endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
        try {
            this.startLocalDate = LocalDate.parse(startDate);
            this.endLocalDate = LocalDate.parse(endDate);
        } catch (DateTimeParseException e) {
            this.startLocalDate = null;
            this.endLocalDate = null;
        }
    }

    /**
     * {@inheritDoc}
     * This method is inherited from {@link Task}.
     * @return A string representation of the task, its description, and start and end dates.
     */
    public String txtSave() {
        return "[E]" + super.txtSave() + "|" + startDate + "|" + endDate;
    }

    /**
     * {@inheritDoc}
     * This method is inherited from {@link Task}.
     * @return A formatted string representing the task.
     */
    @Override
    public String toString() {
        if (startLocalDate != null && endLocalDate != null) {
            String startDateFormatted = startLocalDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            String endDateFormatted = endLocalDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            return "[E]" + super.toString() + " (from: " + startDateFormatted + " to: " + endDateFormatted + ")";
        } else {
            return "[E]" + super.toString() + " (from: " + startDate + " to: " + endDate + ")";
        }
    }
}

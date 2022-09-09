package duke.commands;

import duke.exceptions.DukeException;
import duke.exceptions.DukeInvalidDateException;
import duke.storage.Storage;
import duke.tasks.Deadline;
import duke.tasks.TaskList;
import duke.ui.Ui;

/**
 * Command to add a deadline to the list of tasks
 */
public class DeadlineCommand extends Command {

    public static final String COMMAND_WORD = "deadline";
    private static final String MESSAGE_SUCCESS = "Yo, I managed to add this task: \n";

    private Deadline deadline;

    /**
     * Constructs a DeadlineCommand instance
     *
     * @param description The description of the task
     * @param by The deadline of the task
     * @throws DukeInvalidDateException if the date does not follow the correct format
     */
    public DeadlineCommand(String description, String by) throws DukeInvalidDateException {
        super();
        deadline = new Deadline(description, by);
    }

    /**
     * Returns a boolean value true if the command is a bye command,
     * false otherwise.
     *
     * @return a boolean value on whether the command is a bye command
     */
    @Override
    public boolean isByeCommand() {
        return false;
    }

    /**
     * Executes the command to add the specified deadline task to the
     * list of tasks
     *
     * @param tasks The current list of tasks
     * @param ui The Ui instance to return the result to the user
     * @param storage The Storage instance to store the result to local storage
     * @throws DukeException if errors are encountered during execution
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.add(deadline);
        ui.showMessage(MESSAGE_SUCCESS + deadline + " " + tasks.showNumberOfTasks());
    }
}

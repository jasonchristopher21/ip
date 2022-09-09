package duke.commands;

import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.tasks.TaskList;
import duke.ui.Ui;

/**
 * Command to find the commands that matches a given string
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";
    private static final String MESSAGE_SUCCESS = "Woof! Here's some results I found associated with \"%s\": ";

    private String keyword;

    /**
     * Constructs a FindCommand instance
     *
     * @param keyword the String to find in the list of tasks
     */
    public FindCommand(String keyword) {
        super();
        this.keyword = keyword;
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
     * Executes the command to find the command and show the list to the user
     *
     * @param tasks The current list of tasks
     * @param ui The Ui instance to return the result to the user
     * @param storage The Storage instance to store the result to local storage
     * @throws DukeException if task is not found, or cannot be marked
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ui.showMessage(String.format(MESSAGE_SUCCESS, keyword) + System.lineSeparator() + tasks.showFilteredList(keyword));
    }
}
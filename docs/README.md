# Volkov User Guide

Volkov is a command-line task manager that allows you to add 3 different types of tasks,
set their relevant dates, and track your progress on the tasks with simple commands.
Your tasks are saved automatically, allowing you to revisit whenever you need to.

## Adding a Todo Task: `todo`
Adds a todo task for Volkov to remember.

**Format:**  
`todo DESCRIPTION`  
**Examples:**
```
todo buy groceries
```
**Expected Outcome:**
```
    ____________________________________________________________
     Roger. Task has been added to the list:
       [T][ ] buy groceries
     You now have 1 tasks in the list.
    ____________________________________________________________

```

## Adding a Deadline Task: `deadline`
Adds a deadline task for Volkov to remember.

**Format:**  
`deadline DESCRIPTION /by DATE`  
**Examples:**
```
deadline do homework /by 2025-03-14
```
**Expected Outcome:**
```
    ____________________________________________________________
     Roger. Task has been added to the list:
       [D][ ] do homework (by: Mar 14 2025)
     You now have 2 tasks in the list.
    ____________________________________________________________
```

## Adding an Event Task: `event`
Adds an event task for Volkov to remember.

**Format:**  
`event DESCRIPTION /from STARTDATE /to ENDDATE`  
**Examples:**
```
event open house /from 2025-02-16 /to 2025-02-18
```
**Expected Outcome:**
```
    ____________________________________________________________
     Roger. Task has been added to the list:
       [E][ ] open house (from: Feb 16 2025 to: Feb 18 2025)
     You now have 3 tasks in the list.
    ____________________________________________________________
```

## Mark a task as done: `mark`
Marks a task as completed in Volkov's task list.

**Format:**  
`mark TASKNO`  
**Examples:**
```
mark 1
```
**Expected Outcome:**
```
    ____________________________________________________________
     Roger. This task has been marked as done:
       [T][X] buy groceries
    ____________________________________________________________
```

## Mark a task as notdone: `unmark`
Marks a task as uncompleted in Volkov's task list.

**Format:**  
`unmark TASKNO`  
**Examples:**
```
unmark 1
```
**Expected Outcome:**
```
    ____________________________________________________________
     Roger. This task has been marked as not done yet:
       [T][ ] buy groceries
    ____________________________________________________________
```

## Delete a task: `delete`
Removes a task from Volkov's task list.

**Format:**  
`delete TASKNO`  
**Examples:**
```
delete 2
```
**Expected Outcome:**
```
    ____________________________________________________________
     Roger. Task has been removed:
       [D][ ] do homework (by: Mar 14 2025)
     You now have 2 tasks in the list.
    ____________________________________________________________
```

## List all tasks: `list`
Lists all tasks in Volkov's task list.

**Format:**  
`list`  
**Expected Outcome:**
```
    ____________________________________________________________
     These are all the tasks in your list:
     1.[T][ ] buy groceries
     2.[E][ ] open house (from: Feb 16 2025 to: Feb 18 2025)
    ____________________________________________________________
```

## Find a task: `find`
Finds the tasks in Volkov's task list that match the query

**Format:**  
`find SEARCHTERM`  
**Examples:**
```
find groceries
```
**Expected Outcome:**
```
    ____________________________________________________________
     These are the tasks that match you search query:
     1.[T][ ] buy groceries
    ____________________________________________________________
```

## Exit Program: `bye`
Saves the task list on the hard disk and closes the program

**Format:**  
`bye`  
**Expected Outcome:**
```
    ____________________________________________________________
     See you again soon! Service terminated.
    ____________________________________________________________
```

### Command Summary

| Action       | Format and Examples                                                                                          |
|--------------|--------------------------------------------------------------------------------------------------------------|
| **Todo**     | `todo DESCRIPTION`<br/>e.g., `todo buy groceries`                                                            |
| **Deadline** | `deadline DESCRIPTION /by DATE`<br/>e.g., `deadline do homework /by 2025-03-14`                              |
| **Event**    | `event DESCRIPTION /from STARTDATE /to ENDDATE`<br/>e.g., `event open house /from 2025-02-16 /to 2025-02-18` |
| **Mark**     | `mark TASKNO`<br/>e.g.,  `mark 1`                                                                            |
| **Unmark**   | `unmark TASKNO`<br/>e.g., `unmark 1`                                                                         |
| **Delete**   | `delete TASKNO`<br/>e.g., `delete 1`                                                                         |
| **List**     | `list`                                                                                                       |
| **Find**     | `find SEARCHTERM`<br/>e.g., `find groceries`                                                                 |
| **Bye**      | `bye`                                                                                                        |

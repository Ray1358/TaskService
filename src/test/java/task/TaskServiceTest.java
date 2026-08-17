package task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

    private TaskService taskService;
    private Task task;

    /*
     * Runs before every test and creates a fresh service and task.
     * This prevents one test from affecting another test.
     */
    @BeforeEach
    void setUp() {
        taskService = new TaskService();

        task = new Task(
                "12345",
                "Original name",
                "Original description"
        );
    }

    /*
     * Verifies that a task can be added successfully.
     *
     * Adding another task using the same ID should then fail,
     * proving that the first task was stored.
     */
    @Test
    void testAddTask() {
        taskService.addTask(task);

        Task duplicateTask = new Task(
                "12345",
                "Different name",
                "Different description"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.addTask(duplicateTask)
        );
    }

    /*
     * Verifies that two tasks with different IDs can be added.
     */
    @Test
    void testAddTasksWithDifferentIds() {
        Task secondTask = new Task(
                "67890",
                "Second task",
                "Second description"
        );

        taskService.addTask(task);
        taskService.addTask(secondTask);
    }

    /*
     * Verifies that duplicate task IDs are rejected.
     */
    @Test
    void testCannotAddDuplicateTaskId() {
        Task duplicateTask = new Task(
                "12345",
                "Duplicate task",
                "Duplicate description"
        );

        taskService.addTask(task);

        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.addTask(duplicateTask)
        );
    }

    /*
     * Verifies that a task can be deleted.
     *
     * After deleting it, a new task using the same ID can be added.
     */
    @Test
    void testDeleteTask() {
        taskService.addTask(task);
        taskService.deleteTask("12345");

        Task replacementTask = new Task(
                "12345",
                "Replacement task",
                "Replacement description"
        );

        taskService.addTask(replacementTask);
    }

    /*
     * Verifies that deleting a task ID that does not exist
     * throws an exception.
     */
    @Test
    void testDeleteTaskNotFound() {
        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.deleteTask("99999")
        );
    }

    /*
     * Verifies that the service can update a task's name by ID.
     */
    @Test
    void testUpdateTaskName() {
        taskService.addTask(task);

        taskService.updateTaskName("12345", "Updated name");

        assertEquals("Updated name", task.getName());
    }

    /*
     * Verifies that updating the name of a missing task
     * throws an exception.
     */
    @Test
    void testUpdateTaskNameNotFound() {
        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.updateTaskName(
                        "99999",
                        "Updated name"
                )
        );
    }

    /*
     * Verifies that invalid names are rejected during an update.
     * Task.setName performs the validation.
     */
    @Test
    void testUpdateTaskNameCannotBeNull() {
        taskService.addTask(task);

        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.updateTaskName("12345", null)
        );
    }

    /*
     * Verifies that the service can update a task's description by ID.
     */
    @Test
    void testUpdateTaskDescription() {
        taskService.addTask(task);

        taskService.updateTaskDescription(
                "12345",
                "Updated description"
        );

        assertEquals(
                "Updated description",
                task.getDescription()
        );
    }

    /*
     * Verifies that updating the description of a missing task
     * throws an exception.
     */
    @Test
    void testUpdateTaskDescriptionNotFound() {
        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.updateTaskDescription(
                        "99999",
                        "Updated description"
                )
        );
    }

    /*
     * Verifies that invalid descriptions are rejected during an update.
     * Task.setDescription performs the validation.
     */
    @Test
    void testUpdateTaskDescriptionCannotBeNull() {
        taskService.addTask(task);

        assertThrows(
                IllegalArgumentException.class,
                () -> taskService.updateTaskDescription("12345", null)
        );
    }
}
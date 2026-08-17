package task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TaskTest {

    /*
     * Verifies that a Task can be created using valid values
     * and that the getters return the correct information.
     */
    @Test
    void testCreateTask() {
        Task task = new Task(
                "12345",
                "Complete homework",
                "Finish the Java testing assignment"
        );

        assertEquals("12345", task.getTaskId());
        assertEquals("Complete homework", task.getName());
        assertEquals(
                "Finish the Java testing assignment",
                task.getDescription()
        );
    }

    /*
     * Verifies that values exactly at the maximum allowed
     * lengths are accepted.
     */
    @Test
    void testMaximumAllowedLengths() {
        Task task = new Task(
                "1234567890",
                "12345678901234567890",
                "12345678901234567890123456789012345678901234567890"
        );

        assertEquals("1234567890", task.getTaskId());
        assertEquals("12345678901234567890", task.getName());
        assertEquals(
                "12345678901234567890123456789012345678901234567890",
                task.getDescription()
        );
    }

    /*
     * The task ID is required and cannot be null.
     */
    @Test
    void testTaskIdCannotBeNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task(null, "Task name", "Task description")
        );
    }

    /*
     * The task ID cannot be longer than 10 characters.
     */
    @Test
    void testTaskIdCannotBeTooLong() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task(
                        "12345678901",
                        "Task name",
                        "Task description"
                )
        );
    }

    /*
     * The task name is required and cannot be null.
     */
    @Test
    void testNameCannotBeNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task("12345", null, "Task description")
        );
    }

    /*
     * The task name cannot be longer than 20 characters.
     */
    @Test
    void testNameCannotBeTooLong() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task(
                        "12345",
                        "123456789012345678901",
                        "Task description"
                )
        );
    }

    /*
     * The task description is required and cannot be null.
     */
    @Test
    void testDescriptionCannotBeNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task("12345", "Task name", null)
        );
    }

    /*
     * The task description cannot be longer than 50 characters.
     */
    @Test
    void testDescriptionCannotBeTooLong() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Task(
                        "12345",
                        "Task name",
                        "123456789012345678901234567890123456789012345678901"
                )
        );
    }

    /*
     * Verifies that the task name can be updated to a valid value.
     */
    @Test
    void testSetName() {
        Task task = new Task(
                "12345",
                "Original name",
                "Task description"
        );

        task.setName("Updated name");

        assertEquals("Updated name", task.getName());
    }

    /*
     * Verifies that setName rejects a null value.
     */
    @Test
    void testSetNameCannotBeNull() {
        Task task = new Task(
                "12345",
                "Original name",
                "Task description"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> task.setName(null)
        );
    }

    /*
     * Verifies that setName rejects a value longer than 20 characters.
     */
    @Test
    void testSetNameCannotBeTooLong() {
        Task task = new Task(
                "12345",
                "Original name",
                "Task description"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> task.setName("123456789012345678901")
        );
    }

    /*
     * Verifies that the task description can be updated.
     */
    @Test
    void testSetDescription() {
        Task task = new Task(
                "12345",
                "Task name",
                "Original description"
        );

        task.setDescription("Updated description");

        assertEquals("Updated description", task.getDescription());
    }

    /*
     * Verifies that setDescription rejects a null value.
     */
    @Test
    void testSetDescriptionCannotBeNull() {
        Task task = new Task(
                "12345",
                "Task name",
                "Original description"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> task.setDescription(null)
        );
    }

    /*
     * Verifies that setDescription rejects a value longer
     * than 50 characters.
     */
    @Test
    void testSetDescriptionCannotBeTooLong() {
        Task task = new Task(
                "12345",
                "Task name",
                "Original description"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> task.setDescription(
                        "123456789012345678901234567890123456789012345678901"
                )
        );
    }
}
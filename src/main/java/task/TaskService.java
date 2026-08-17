package task;

import java.util.HashMap;

public class TaskService {

    // Stores all tasks using the task ID as the key.
    private HashMap<String, Task> tasks;

    // Constructor
    public TaskService() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a task to the service.
     * Task IDs must be unique.
     *
     * @param task Task object to add
     * @throws IllegalArgumentException if the task ID already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }

        tasks.put(task.getTaskId(), task);
    }

    /**
     * Deletes a task using its ID.
     *
     * @param taskId ID of the task to remove
     * @throws IllegalArgumentException if the task does not exist
     */
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }

        tasks.remove(taskId);
    }

    /**
     * Updates the name of an existing task.
     *
     * @param taskId ID of the task
     * @param name New task name
     * @throws IllegalArgumentException if the task does not exist
     */
    public void updateTaskName(String taskId, String name) {
        Task task = tasks.get(taskId);

        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }

        task.setName(name);
    }

    /**
     * Updates the description of an existing task.
     *
     * @param taskId ID of the task
     * @param description New task description
     * @throws IllegalArgumentException if the task does not exist
     */
    public void updateTaskDescription(String taskId, String description) {
        Task task = tasks.get(taskId);

        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }

        task.setDescription(description);
    }
}
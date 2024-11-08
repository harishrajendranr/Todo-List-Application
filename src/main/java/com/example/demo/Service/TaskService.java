package com.example.demo.Service;


import com.example.demo.Models.Task;
import com.example.demo.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> GetAlltask() {

        return taskRepository.findAll();
    }

    public void CreateAlltask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void Deletetask(long id) {
        taskRepository.deleteById(id);
    }

    public void ToggleTask(long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);

    }
}

package com.example.demo.Controller;


import com.example.demo.Models.Task;
import com.example.demo.Service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public String gettask(Model model)
    {
        List<Task> tasks = taskService.GetAlltask();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping
    public String createtask(@RequestParam String title)
    {
        taskService.CreateAlltask(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deletetask(@PathVariable long id)
    {
        taskService.Deletetask(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String toggletask(@PathVariable long id)
    {
        taskService.ToggleTask(id);
        return "redirect:/";
    }
}

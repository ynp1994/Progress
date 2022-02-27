package com.huawei.progress.core;

import java.util.LinkedList;
import java.util.List;

public class Project {

    private String projectName;
    private List<Task> tasks;
    private double progress;

    public Project(String projectName) {
        this.projectName = projectName;
        this.tasks = new LinkedList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public double getProgress() {
        int finished = tasks.stream().mapToInt(Task::getFinished).sum();
        int total = tasks.stream().mapToInt(Task::getTotal).sum();
        return finished * 1.0 / total;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}

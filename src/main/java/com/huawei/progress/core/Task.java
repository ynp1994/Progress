package com.huawei.progress.core;

import org.apache.commons.collections4.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

public class Task {
    public static final int DEFAULT_TASK_WEIGHT = 10;
    private String taskName;
    private int weight;
    private boolean isFinished;
    private int finished;
    private int total;
    private List<Task> subTasks;

    public Task(String taskName, int weight) {
        this.taskName = taskName;
        this.weight = weight;
        this.subTasks = new LinkedList<>();
    }

    public Task(String taskName) {
        this(taskName, DEFAULT_TASK_WEIGHT);
    }

    public int getTotal() {
        if (CollectionUtils.isEmpty(subTasks)) {
            return weight;
        }
        return subTasks.stream().mapToInt(Task::getTotal).sum();
    }

    public int getFinished() {
        if (CollectionUtils.isEmpty(subTasks)) {
            return isFinished ? weight : 0;
        }
        return subTasks.stream().mapToInt(Task::getFinished).sum();
    }

    public void addSubTask(Task task) {
        this.subTasks.add(task);
        this.weight += task.weight;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void addSubTasks(List<Task> subTasks) {
        subTasks.forEach(this::addSubTask);
    }

    public void done() {
        if (!CollectionUtils.isEmpty(subTasks)) {
            throw new UnsupportedOperationException();
        }
        this.isFinished = true;
    }
}

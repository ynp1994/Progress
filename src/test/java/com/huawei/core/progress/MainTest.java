package com.huawei.core.progress;

import com.huawei.progress.core.Project;
import com.huawei.progress.core.Task;
import org.junit.Test;

public class MainTest {

    @Test
    public void testAddTask() {
        Project test = new Project("test");
        Task task1 = new Task("task1",100);
        test.addTask(task1);
        Task task11 = new Task("test1.1",20);
        task1.addSubTask(task11);
        Task task12 = new Task("test1.2");
        task1.addSubTask(task12);
        task12.done();
        System.out.println("test.getProgress() = " + test.getProgress());
        Task task2 = new Task("task2");
        test.addTask(task2);
        System.out.println("test.getProgress() = " + test.getProgress());
        Task task21 = new Task("task21");
        task2.addSubTask(task21);
        Task task22 = new Task("task22");
        task2.addSubTask(task22);
        System.out.println("test.getProgress() = " + test.getProgress());
        task11.done();
        System.out.println("test.getProgress() = " + test.getProgress());
        task21.done();
        System.out.println("test.getProgress() = " + test.getProgress());
    }
}

package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {

    //@InjectMocks
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "task", "task");
        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals("task", mappedTask.getTitle());
    }

    @Test
    public void mapToTaskDto() {
        //Given
        Task task = new Task(1L, "task", "task");
        //When
        TaskDto mappedTaskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals("task", mappedTaskDto.getTitle());
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "task", "task"));
        //When
        List<TaskDto> mappedList = taskMapper.mapToTaskDtoList(tasks);
        //Then
        assertEquals(1,mappedList.size());
    }
}
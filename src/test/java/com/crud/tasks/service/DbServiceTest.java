package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void getAllTasks() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L,"task","task"));

        when(taskRepository.findAll()).thenReturn(tasks);
        //When
        List<Task> taskList = dbService.getAllTasks();
        //Then
        assertEquals(1,taskList.size());
    }

    @Test
    public void shouldReturnEmptyList(){
        //Given
        List<Task> tasks = new ArrayList<>();
        when(taskRepository.findAll()).thenReturn(tasks);
        //When
        List<Task> tasksList = dbService.getAllTasks();
        //Then
        assertEquals(0,tasksList.size());
    }

    @Test
    public void getTask() {
        //Given
        //When
        //Then
    }

    @Test
    public void saveTask() {
    }
}
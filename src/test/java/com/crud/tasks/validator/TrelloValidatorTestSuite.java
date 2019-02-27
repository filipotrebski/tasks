package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTestSuite {

    @InjectMocks
    private TrelloValidator trelloValidator;

    @Test
    public void validateReturnEmptyList() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1","list",false));

        List<TrelloBoard> boards = new ArrayList<>();
        boards.add(new TrelloBoard("1","test",trelloLists));

        //When
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(boards);
        //Then
        assertEquals(0,filteredBoards.size());
    }

}
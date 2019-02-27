package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Test
    public void fetchTrelloBoards() {
        //Given
        List<TrelloListDto> listDtos = new ArrayList<>();
        listDtos.add(new TrelloListDto("1","list",false));
        List<TrelloBoardDto> boardDtos =new ArrayList<>();
        boardDtos.add(new TrelloBoardDto("1","board",listDtos));

        when(trelloClient.getTrelloBoards()).thenReturn(boardDtos);
        //When
        List<TrelloBoardDto> fetchedBoards = trelloService.fetchTrelloBoards();
        //Then
        assertEquals(1,fetchedBoards.size());
    }

    @Test
    public void createTrelloCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("1","desc","top","1");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1","desc","url");


        when(trelloClient.createNewCard(cardDto)).thenReturn(createdTrelloCardDto);
        //When
        CreatedTrelloCardDto createdCard = trelloClient.createNewCard(cardDto);
        //Then
        assertSame(createdTrelloCardDto,createdCard);
    }

    @Test
    public void shouldCreateEmptyCard(){
        //Given
        TrelloCardDto cardDto = new TrelloCardDto();

        when(trelloClient.createNewCard(cardDto)).thenReturn(null);
        //When
        CreatedTrelloCardDto createdCard = trelloService.createTrelloCard(cardDto);
        //Then
        assertNull(createdCard);
    }
}
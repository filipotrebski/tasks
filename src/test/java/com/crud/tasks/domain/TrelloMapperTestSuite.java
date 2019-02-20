package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoard() {
        //Given
        TrelloListDto listDto = new TrelloListDto("1", "List", false);
        List<TrelloListDto> list = new ArrayList<>();
        list.add(listDto);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "1st board", list);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("2", "2nd board", list);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("3", "3rd board", list);

        List<TrelloBoardDto> boards = new ArrayList<>();
        boards.add(trelloBoardDto);
        boards.add(trelloBoardDto1);
        boards.add(trelloBoardDto2);
        //When
        List<TrelloBoard> resultList = trelloMapper.mapToBoard(boards);
        //Then
        assertNotNull(resultList);
        assertEquals(3, resultList.size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList list = new TrelloList("1", "List", false);
        List<TrelloList> lists = new ArrayList<>();
        lists.add(list);

        TrelloBoard trelloBoard = new TrelloBoard("1", "1st board", lists);
        TrelloBoard trelloBoard1 = new TrelloBoard("2", "2nd board", lists);
        TrelloBoard trelloBoard2 = new TrelloBoard("3", "3rd board", lists);

        List<TrelloBoard> boards = new ArrayList<>();
        boards.add(trelloBoard);
        boards.add(trelloBoard1);
        boards.add(trelloBoard2);

        //When
        List<TrelloBoardDto> resultList = trelloMapper.mapToBoardsDto(boards);

        //Then
        assertNotNull(resultList);
        assertEquals(3, resultList.size());
    }

    @Test
    public void testMapToLists() {
        //Given
        TrelloListDto listDto = new TrelloListDto("1","1st list",false);
        TrelloListDto listDto1 = new TrelloListDto("2","2nd list", false);
        TrelloListDto listDto2 = new TrelloListDto("3","3rd list",false);

        List<TrelloListDto> listDtos = new ArrayList<>();
        listDtos.add(listDto);
        listDtos.add(listDto1);
        listDtos.add(listDto2);

        //When
        List<TrelloList> resultList = trelloMapper.mapToLists(listDtos);

        //Then
        assertNotNull(resultList);
        assertEquals(3,resultList.size());
    }

    @Test
    public void testMapToListsDto() {
        //Given
        TrelloList list = new TrelloList("1","1st list",false);
        TrelloList list1 = new TrelloList("2","2nd list", false);
        TrelloList list2 = new TrelloList("3","3rd list",false);

        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(list);
        trelloLists.add(list1);
        trelloLists.add(list2);

        //When
        List<TrelloListDto> resultList = trelloMapper.mapToListsDto(trelloLists);

        //Then
        assertNotNull(resultList);
        assertEquals(3,resultList.size());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("ToDo","Things to do","1","1");
        //When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(card);
        //Then
        assertEquals("ToDo",cardDto.getName());
    }

    @Test
    public void mapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("Walk","Go for walk","1","1");
        //When
        TrelloCard card = trelloMapper.mapToCard(cardDto);
        //Then
        assertEquals("Go for walk",card.getDescription());
    }
}
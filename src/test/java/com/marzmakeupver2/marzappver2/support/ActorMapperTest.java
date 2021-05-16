package com.marzmakeupver2.marzappver2.support;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ActorMapperTest {


    @Mock
    ScenarioRequestMapper scenarioRequestMapper;

    @InjectMocks
    ActorMapper actorMapper;

//    @Test
//    void shouldReturnActorFromActorRequest() {
//        //given
//        //when
//        //then
//
//    }
}
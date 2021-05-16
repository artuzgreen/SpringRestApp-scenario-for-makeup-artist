package com.marzmakeupver2.marzappver2.service;

import com.marzmakeupver2.marzappver2.api.request.ActorRequest;
import com.marzmakeupver2.marzappver2.api.response.ActorResponsePlain;
import com.marzmakeupver2.marzappver2.domain.Actor;
import com.marzmakeupver2.marzappver2.repository.ActorRepository;
import com.marzmakeupver2.marzappver2.support.ActorMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActorServiceTest {

    private static final Long ActorId = 1L;
    private static final String nameActReq = "Tomasz";
    private static final String surnameActReq = "Nowak";
    private static final String characterActReq = "Belmondo";


    @Mock
    ActorRepository actorRepository;

    @Mock
    ActorMapper actorMapper;

    @InjectMocks
    ActorService actorService;

/*
Here we truly testing mocks what is not very sensible but left this in the case,
but i decided test only Mapper Class methods
 */
    @Test
    void ShouldCreateActorFromActorRequest() {

        //given
        ActorRequest actorRequest = new ActorRequest(nameActReq, surnameActReq, characterActReq);
        Actor actorFromActorMapper = new Actor(nameActReq, surnameActReq, characterActReq);
        Actor actorWithId = getActorWithId(actorFromActorMapper);
        ActorResponsePlain actResPlain = new ActorResponsePlain(ActorId, nameActReq, surnameActReq, characterActReq);


        when(actorMapper.toActor(actorRequest)).thenReturn(actorFromActorMapper);
        when(actorRepository.save(actorFromActorMapper)).thenReturn(actorWithId);
        when(actorMapper.toActorResponsePlain(actorWithId)).thenReturn(actResPlain);

        // when
        ActorResponsePlain actorResponsePlainFromCreate = actorService.create(actorRequest);
        //then
        assertThat(actorResponsePlainFromCreate).isNotNull();
        assertThat(actorResponsePlainFromCreate.getId()).isEqualTo(1);
        assertThat(actorResponsePlainFromCreate.getName()).isEqualTo(nameActReq);
        assertThat(actorResponsePlainFromCreate.getSurname()).isEqualTo(surnameActReq);
        assertThat(actorResponsePlainFromCreate.getCharacter()).isEqualTo(characterActReq);
    }

    private Actor getActorWithId(Actor actorFromActorMapper) {
        actorFromActorMapper.setId(ActorId);
        return actorFromActorMapper;
    }


}
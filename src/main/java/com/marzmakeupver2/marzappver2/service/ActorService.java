package com.marzmakeupver2.marzappver2.service;

import com.marzmakeupver2.marzappver2.api.request.ActorRequest;
import com.marzmakeupver2.marzappver2.api.request.UpdateActorRequest;
import com.marzmakeupver2.marzappver2.api.response.ActorResponsePlain;
import com.marzmakeupver2.marzappver2.domain.Actor;
import com.marzmakeupver2.marzappver2.repository.ActorRepository;
import com.marzmakeupver2.marzappver2.support.ActorExceptionSupplier;
import com.marzmakeupver2.marzappver2.support.ActorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {
    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    public ActorService(ActorRepository actorRepository, ActorMapper actorMapper) {
        this.actorRepository = actorRepository;
        this.actorMapper = actorMapper;
    }

    public ActorResponsePlain create(ActorRequest actorrequest) {
        Actor actorFromActorMapper = actorMapper.toActor(actorrequest);
        Actor actor = actorRepository.save(actorFromActorMapper);
        return actorMapper.toActorResponsePlain(actor);
    }

    public ActorResponsePlain find(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(ActorExceptionSupplier.actorNotFound(id));
        return actorMapper.toActorResponsePlain(actor);
    }

    public ActorResponsePlain update(UpdateActorRequest updateActorRequest) {
        Actor actor = actorRepository.findById(updateActorRequest.getId()).orElseThrow(
                ActorExceptionSupplier.actorNotFound(updateActorRequest.getId()));
        actorRepository.save(actorMapper.toActor(actor, updateActorRequest));
        return actorMapper.toActorResponsePlain(actor);
    }

    public List<ActorResponsePlain> findAll() {
        return actorRepository.findAll().stream().map(actorMapper::toActorResponsePlain).collect(Collectors.toList());
    }

    public void delete(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(ActorExceptionSupplier.actorNotFound(id));
        actorRepository.deleteById(actor.getId());
    }
}

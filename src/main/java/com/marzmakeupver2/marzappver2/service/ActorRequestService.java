package com.marzmakeupver2.marzappver2.service;

import com.marzmakeupver2.marzappver2.domain.Actor;
import com.marzmakeupver2.marzappver2.repository.ActorRepository;
import com.marzmakeupver2.marzappver2.support.ActorExceptionSupplier;
import org.springframework.stereotype.Service;

@Service
public class ActorRequestService {
    private final ActorRepository actorRepository;

    public ActorRequestService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor findForRequest(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(ActorExceptionSupplier.actorNotFound(id));
        return actor;
    }

    public Long findForResponse(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(ActorExceptionSupplier.actorNotFound(id));
        Long actorId = actor.getId();
        return actorId;
    }
}

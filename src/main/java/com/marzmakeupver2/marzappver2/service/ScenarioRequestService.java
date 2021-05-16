package com.marzmakeupver2.marzappver2.service;

import com.marzmakeupver2.marzappver2.domain.Scenario;
import com.marzmakeupver2.marzappver2.repository.ScenarioRepository;
import com.marzmakeupver2.marzappver2.support.ScenarioExceptionSupplier;
import org.springframework.stereotype.Service;

@Service
public class ScenarioRequestService {
    private final ScenarioRepository scenarioRepository;

    public ScenarioRequestService(ScenarioRepository scenarioRepository) {
        this.scenarioRepository = scenarioRepository;
    }

    public Scenario findForRequest(Long id) {
        Scenario scenario = scenarioRepository.findById(id).orElseThrow(ScenarioExceptionSupplier.scenarioNotFound(id));
        return scenario;
    }
}

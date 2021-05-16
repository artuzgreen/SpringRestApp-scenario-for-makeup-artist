package com.marzmakeupver2.marzappver2.service;

import com.marzmakeupver2.marzappver2.api.request.ScenarioRequest;
import com.marzmakeupver2.marzappver2.api.request.UpdateScenarioRequest;
import com.marzmakeupver2.marzappver2.api.response.ScenarioResponsePlain;
import com.marzmakeupver2.marzappver2.domain.Scenario;
import com.marzmakeupver2.marzappver2.repository.ScenarioRepository;
import com.marzmakeupver2.marzappver2.support.ScenarioExceptionSupplier;
import com.marzmakeupver2.marzappver2.support.ScenarioMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ScenarioService {


    private final ScenarioRepository scenarioRepository;
    private final ScenarioMapper scenarioMapper;

    public ScenarioService(ScenarioRepository scenarioRepository, ScenarioMapper scenarioMapper) {
        this.scenarioRepository = scenarioRepository;
        this.scenarioMapper = scenarioMapper;
    }

    public ScenarioResponsePlain create(ScenarioRequest scenariorequest) {
        Scenario scenario = scenarioRepository.save(scenarioMapper.toScenario(scenariorequest));
        return scenarioMapper.toScenarioResponsePlain(scenario);
    }

    public ScenarioResponsePlain find(Long id) {
        Scenario scenario = scenarioRepository.findById(id).orElseThrow(ScenarioExceptionSupplier.scenarioNotFound(id));
        return scenarioMapper.toScenarioResponsePlain(scenario);
    }

    public ScenarioResponsePlain update(UpdateScenarioRequest updateScenarioRequest) {
        Scenario scenario = scenarioRepository.findById(updateScenarioRequest.getId()).orElseThrow(
                ScenarioExceptionSupplier.scenarioNotFound(updateScenarioRequest.getId()));
        scenarioRepository.save(scenarioMapper.toScenario(scenario, updateScenarioRequest));
        return scenarioMapper.toScenarioResponsePlain(scenario);
    }

    public List<ScenarioResponsePlain> findAll() {
        return scenarioRepository.findAll().stream().map(scenarioMapper::toScenarioResponsePlain).collect(Collectors.toList());
    }

    public void delete(Long id) {
        Scenario scenario = scenarioRepository.findById(id).orElseThrow(ScenarioExceptionSupplier.scenarioNotFound(id));
        scenarioRepository.deleteById(scenario.getId());
    }

    public Set<ScenarioResponsePlain> findAllCoplexInfo() {
        return scenarioRepository.findComplexInfo().stream().map(scenarioMapper::toScenarioResponsePlain).collect(Collectors.toSet());
    }

}
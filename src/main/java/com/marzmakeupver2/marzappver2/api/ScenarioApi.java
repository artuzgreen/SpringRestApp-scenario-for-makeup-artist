package com.marzmakeupver2.marzappver2.api;

import com.marzmakeupver2.marzappver2.api.request.ScenarioRequest;
import com.marzmakeupver2.marzappver2.api.request.UpdateScenarioRequest;
import com.marzmakeupver2.marzappver2.api.response.ScenarioResponsePlain;
import com.marzmakeupver2.marzappver2.service.ScenarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Api(tags = "Scenes")
@RequestMapping("/api/scenarios")
public class ScenarioApi {
    private final ScenarioService scenarioService;

    ScenarioApi(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    @PostMapping
    @ApiOperation("Create scene")
    public ResponseEntity<ScenarioResponsePlain> create(@RequestBody ScenarioRequest scenarioRequest) {
        ScenarioResponsePlain scenarioResponse = scenarioService.create(scenarioRequest);
        return ResponseEntity.status(HttpStatus.OK).body(scenarioResponse);

    }

    @GetMapping("/{id}")
    @ApiOperation("Find scene")
    public ResponseEntity<ScenarioResponsePlain> find(@PathVariable Long id) {
        ScenarioResponsePlain scenarioResponse = scenarioService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(scenarioResponse);

    }

    @PutMapping
    @ApiOperation("Update scene")
    public ResponseEntity<ScenarioResponsePlain> update(@RequestBody UpdateScenarioRequest updateScenarioRequest) {
        ScenarioResponsePlain scenarioResponse = scenarioService.update(updateScenarioRequest);
        return ResponseEntity.status(HttpStatus.OK).body(scenarioResponse);
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Delete scene")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        scenarioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/allcomplexinfo")
    @ApiOperation("Find all scenes with complex info")
    public ResponseEntity<Set<ScenarioResponsePlain>> findAllInfo() {
        Set<ScenarioResponsePlain> scenarioResponses = scenarioService.findAllCoplexInfo();
        return ResponseEntity.status(HttpStatus.OK).body(scenarioResponses);
    }
    /*
    findAll() method have problem with n+1, left in case if i want to compare this method with findAllInfo() method
    */
//    @GetMapping
//    @ApiOperation("Find all scenes")
//    public ResponseEntity<List<ScenarioResponsePlain>> findAll() {
//        List<ScenarioResponsePlain> scenarioResponses = scenarioService.findAll();
//        return ResponseEntity.status(HttpStatus.OK).body(scenarioResponses);
//    }

}
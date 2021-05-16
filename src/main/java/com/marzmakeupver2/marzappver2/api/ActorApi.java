package com.marzmakeupver2.marzappver2.api;

import com.marzmakeupver2.marzappver2.api.request.ActorRequest;
import com.marzmakeupver2.marzappver2.api.request.UpdateActorRequest;
import com.marzmakeupver2.marzappver2.api.response.ActorResponsePlain;
import com.marzmakeupver2.marzappver2.service.ActorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Actors")
@RequestMapping("/api/actors")
public class ActorApi {
    private final ActorService actorService;

    ActorApi(ActorService actorService) {
        this.actorService = actorService;
    }


    @PostMapping
    @ApiOperation("Create actor")
    public ResponseEntity<ActorResponsePlain> create(@RequestBody ActorRequest actorRequest) {
        ActorResponsePlain actorResponsePlain = actorService.create(actorRequest);
        return ResponseEntity.status(HttpStatus.OK).body(actorResponsePlain);

    }

    @GetMapping("/{id}")
    @ApiOperation("Find actor")
    public ResponseEntity<ActorResponsePlain> find(@PathVariable Long id) {
        ActorResponsePlain actorResponsePlain = actorService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(actorResponsePlain);

    }

    @PutMapping
    @ApiOperation("Update actor")
    public ResponseEntity<ActorResponsePlain> update(@RequestBody UpdateActorRequest updateActorRequest) {
        ActorResponsePlain actorResponsePlain = actorService.update(updateActorRequest);
        return ResponseEntity.status(HttpStatus.OK).body(actorResponsePlain);
    }

    @GetMapping
    @ApiOperation("Find all actors")
    public ResponseEntity<List<ActorResponsePlain>> findAll() {
        List<ActorResponsePlain> actorResponsesPlain = actorService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(actorResponsesPlain);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete actor")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        actorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}

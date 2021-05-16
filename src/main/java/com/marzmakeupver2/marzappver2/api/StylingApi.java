package com.marzmakeupver2.marzappver2.api;

import com.marzmakeupver2.marzappver2.api.request.StylingRequest;
import com.marzmakeupver2.marzappver2.api.request.UpdateStylingRequest;
import com.marzmakeupver2.marzappver2.api.response.StylingResponsePlain;
import com.marzmakeupver2.marzappver2.service.StylingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Api(tags = "Styling")
@RequestMapping("/api/stylings")
public class StylingApi {
    private final StylingService stylingService;

    public StylingApi(StylingService stylingService) {
        this.stylingService = stylingService;
    }

    @PostMapping
    @ApiOperation("Create styling")
    public ResponseEntity<StylingResponsePlain> create(@RequestBody StylingRequest stylingRequest) {
        StylingResponsePlain stylingResponsePlain = stylingService.create(stylingRequest);
        return ResponseEntity.status(HttpStatus.OK).body(stylingResponsePlain);

    }

    @GetMapping("/{id}")
    @ApiOperation("Find styling")
    public ResponseEntity<StylingResponsePlain> find(@PathVariable Long id) {
        StylingResponsePlain stylingResponsePlain = stylingService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(stylingResponsePlain);

    }

    @PutMapping
    @ApiOperation("Update styling")
    public ResponseEntity<StylingResponsePlain> update(@RequestBody UpdateStylingRequest updateStylingRequest) {
        StylingResponsePlain stylingResponsePlain = stylingService.update(updateStylingRequest);
        return ResponseEntity.status(HttpStatus.OK).body(stylingResponsePlain);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete styling")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stylingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/allcomplexinfo")
    @ApiOperation("Find all stylings with complex info")
    public ResponseEntity<Set<StylingResponsePlain>> findAllInfo() {
        Set<StylingResponsePlain> stylingResponses = stylingService.findAllCoplexInfo();
        return ResponseEntity.status(HttpStatus.OK).body(stylingResponses);
    }

    /*
    findAll() method have problem with n+1, left in case if i want to compare this method with findAllInfo() method
    */
//    @GetMapping
//    @ApiOperation("Find all stylings")
//    public ResponseEntity<List<StylingResponsePlain>> findAll() {
//        List<StylingResponsePlain> stylingResponsesPlain = stylingService.findAll();
//        return ResponseEntity.status(HttpStatus.OK).body(stylingResponsesPlain);
//    }


}

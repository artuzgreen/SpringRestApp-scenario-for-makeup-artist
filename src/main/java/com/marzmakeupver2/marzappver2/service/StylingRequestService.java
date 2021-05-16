/*
Left this class for future refactoring
 */

//package com.marzmakeupver2.marzappver2.service;
//
//import com.marzmakeupver2.marzappver2.domain.Styling;
//import com.marzmakeupver2.marzappver2.repository.StylingRepository;
//import com.marzmakeupver2.marzappver2.support.ScenarioExceptionSupplier;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StylingRequestService {
//    private final StylingRepository stylingRepository;
//
//    public StylingRequestService(StylingRepository stylingRepository) {
//        this.stylingRepository = stylingRepository;
//    }
//
//    public Styling findForRequest(Long id) {
//        Styling styling = stylingRepository.findByStylingId(id).orElseThrow(ScenarioExceptionSupplier.scenarioNotFound(id));
//        return styling;
//    }
//}

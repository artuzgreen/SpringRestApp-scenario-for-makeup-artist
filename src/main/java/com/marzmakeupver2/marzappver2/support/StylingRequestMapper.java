/*
Left this class for future refactoring
 */

//package com.marzmakeupver2.marzappver2.support;
//
//
//import com.marzmakeupver2.marzappver2.api.request.ScenarioStylingRequest;
//import com.marzmakeupver2.marzappver2.domain.Styling;
//import com.marzmakeupver2.marzappver2.service.StylingRequestService;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Component
//public class StylingRequestMapper {
//    private final StylingRequestService stylingRequestService;
//
//    public StylingRequestMapper(StylingRequestService stylingRequestService) {
//        this.stylingRequestService = stylingRequestService;
//    }
//
//
//    public Set<Styling> toStylingFromRequestWithId(Set<ScenarioStylingRequest> scenarioStylingRequestList) {
//        Set<Styling> stylings = scenarioStylingRequestList.stream()
//                .map(sceStyRequest -> stylingRequestService.findForRequest(sceStyRequest.getId()))
//                .collect(Collectors.toSet());
//        return stylings;
//    }
//
//}

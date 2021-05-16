package com.marzmakeupver2.marzappver2.service;

import com.marzmakeupver2.marzappver2.api.request.StylingRequest;
import com.marzmakeupver2.marzappver2.api.request.UpdateStylingRequest;
import com.marzmakeupver2.marzappver2.api.response.StylingResponsePlain;
import com.marzmakeupver2.marzappver2.domain.Styling;
import com.marzmakeupver2.marzappver2.repository.StylingRepository;
import com.marzmakeupver2.marzappver2.support.StylingExceptionSupplier;
import com.marzmakeupver2.marzappver2.support.StylingMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StylingService {
    private final StylingRepository stylingRepository;
    private final StylingMapper stylingMapper;

    public StylingService(StylingRepository stylingRepository, StylingMapper stylingMapper) {
        this.stylingRepository = stylingRepository;
        this.stylingMapper = stylingMapper;
    }


    public StylingResponsePlain create(StylingRequest stylingrequest) {
        Styling styling = stylingRepository.save(stylingMapper.toStyling(stylingrequest));
        return stylingMapper.toStylingResponsePlain(styling);
    }

    public StylingResponsePlain find(Long id) {
        Styling styling = stylingRepository.findByStylingId(id).orElseThrow(StylingExceptionSupplier.stylingNotFound(id));
        return stylingMapper.toStylingResponsePlain(styling);
    }

    public StylingResponsePlain update(UpdateStylingRequest updateStylingRequest) {
        Styling styling = stylingRepository.findByStylingId(updateStylingRequest.getId()).orElseThrow(
                StylingExceptionSupplier.stylingNotFound(updateStylingRequest.getId()));
        stylingRepository.save(stylingMapper.toStyling(styling, updateStylingRequest));
        return stylingMapper.toStylingResponsePlain(styling);
    }

    public List<StylingResponsePlain> findAll() {
        return stylingRepository.findAll().stream().map(stylingMapper::toStylingResponsePlain).collect(Collectors.toList());
    }

    public void delete(Long id) {
        Styling styling = stylingRepository.findByStylingId(id).orElseThrow(StylingExceptionSupplier.stylingNotFound(id));
        stylingRepository.deleteByStylingId(styling.getStylingId());
    }

    public Set<StylingResponsePlain> findAllCoplexInfo() {
        return stylingRepository.findComplexInfo().stream().map(stylingMapper::toStylingResponsePlain).collect(Collectors.toSet());
    }


}

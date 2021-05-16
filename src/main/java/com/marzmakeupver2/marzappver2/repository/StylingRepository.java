package com.marzmakeupver2.marzappver2.repository;


import com.marzmakeupver2.marzappver2.domain.Styling;
import com.marzmakeupver2.marzappver2.domain.StylingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;
import java.util.Set;


public interface StylingRepository extends JpaRepository <Styling, StylingId> {

    Optional<Styling> findByStylingId(Long stylingId);

    void deleteByStylingId(Long stylingId);


    @Query("select s from Styling s left join fetch s.scenariosList sc left join fetch s.actorId ac")
    Set<Styling> findComplexInfo();


}









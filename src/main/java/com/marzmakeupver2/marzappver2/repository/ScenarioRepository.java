package com.marzmakeupver2.marzappver2.repository;

import com.marzmakeupver2.marzappver2.domain.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Set;

public interface ScenarioRepository extends JpaRepository<Scenario,Long> {

    @Query("select sc from Scenario sc left join fetch sc.stylingsList s left join fetch s.actorId a")
    Set<Scenario> findComplexInfo();
}

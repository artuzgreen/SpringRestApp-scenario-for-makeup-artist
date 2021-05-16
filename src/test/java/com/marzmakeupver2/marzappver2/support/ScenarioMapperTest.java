package com.marzmakeupver2.marzappver2.support;

import com.marzmakeupver2.marzappver2.api.response.ScenarioResponsePlain;
import com.marzmakeupver2.marzappver2.api.response.ScenarioStylingResponse;
import com.marzmakeupver2.marzappver2.domain.Actor;
import com.marzmakeupver2.marzappver2.domain.Scenario;
import com.marzmakeupver2.marzappver2.domain.Styling;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ScenarioMapperTest {
    private static final long SCENARIO_ID = 1L;
    private Styling styling1 = new Styling();
    private Styling styling2 = new Styling();
    private Scenario scenario = new Scenario();
    private Set<Styling> stylingSet = createStylingList();
    private Set<ScenarioStylingResponse> scenarioStylingResponseSet = createScenarioStylingResponseList();
    private Set<Actor> actorSet = createSetFromActors();


    @InjectMocks
    ScenarioMapper scenarioMapper;


    @Test
    void shouldReturnScenarioResponsePlainClassFromScenarioClass() {
        //when
        ScenarioResponsePlain scenarioResponsePlain = scenarioMapper.toScenarioResponsePlain(setScenario());
        //then
        assertThat(scenarioResponsePlain).isNotNull();
        assertThat(scenarioResponsePlain.getId()).isEqualTo(SCENARIO_ID);
        assertThat(scenarioResponsePlain.getDay()).isEqualTo(1);
        assertThat(scenarioResponsePlain.getPartOfADay()).isEqualTo("Night");
        assertThat(scenarioResponsePlain.getLocation()).isEqualTo("Lake");
        assertThat(scenarioResponsePlain.getComment()).isEqualTo("very dirty place");
        assertThat(scenarioResponsePlain.getStylingList()).hasSize(scenarioStylingResponseSet.size());
        assertThat(scenarioResponsePlain.getActorsList()).hasSize(actorSet.size());
    }


    private Scenario setScenario() {
        scenario.setId(SCENARIO_ID);
        scenario.setDay(1);
        scenario.setPartOfADay("Night");
        scenario.setLocation("Lake");
        scenario.setComment("very dirty place");
        scenario.setStylingsList(stylingSet);
        return scenario;
    }

    private Set<ScenarioStylingResponse> createScenarioStylingResponseList() {
        Set<ScenarioStylingResponse> scenarioStylingResponses = new HashSet<>();
        ScenarioStylingResponse scenarioStylingResponse1 = new ScenarioStylingResponse(styling1);
        ScenarioStylingResponse scenarioStylingResponse2 = new ScenarioStylingResponse(styling2);
        scenarioStylingResponses.add(scenarioStylingResponse1);
        scenarioStylingResponses.add(scenarioStylingResponse2);
        return scenarioStylingResponses;
    }

    private Set<Styling> createStylingList() {
        Set<Styling> stylings = new HashSet<>();
        Styling styling1 = createStyling1();
        Styling styling2 = createStyling2();
        stylings.add(styling1);
        stylings.add(styling2);
        return stylings;

    }


    private Styling createStyling1() {
        HashSet<Scenario> scenariosList = new HashSet<>();
        scenariosList.add(scenario);
        styling1.setStylingId(1L);
        styling1.setActorId(createActor1());
        styling1.setMakeup("dark");
        styling1.setSfx("scar on face");
        styling1.setHair("curly");
        styling1.setImg_dir("/StyleImg");
        styling1.setScenariosList(scenariosList);
        return styling1;
    }

    private Styling createStyling2() {
        HashSet<Scenario> scenariosList = new HashSet<>();
        scenariosList.add(scenario);
        styling2.setStylingId(2L);
        styling2.setActorId(createActor2());
        styling2.setMakeup("beauty");
        styling2.setSfx("none");
        styling2.setHair("straight");
        styling2.setImg_dir("/StyleImg");
        styling2.setScenariosList(scenariosList);
        return styling2;
    }


    private Actor createActor1() {
        Actor actor = new Actor();
        actor.setId(1L);
        actor.setName("Stefan");
        actor.setSurname("Burczymucha");
        actor.setCharacter("T100");
        return actor;
    }

    private Actor createActor2() {
        Actor actor = new Actor();
        actor.setId(2L);
        actor.setName("John");
        actor.setSurname("Wick");
        actor.setCharacter("Mnemonic");
        return actor;
    }

    private Set<Actor> createSetFromActors() {
        HashSet<Actor> actorsSet = new HashSet<>();
        actorsSet.add(createActor1());
        actorsSet.add(createActor2());
        return actorsSet;
    }


}
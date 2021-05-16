package com.marzmakeupver2.marzappver2.support;

import com.marzmakeupver2.marzappver2.api.request.StylingRequest;
import com.marzmakeupver2.marzappver2.api.request.StylingScenarioRequest;
import com.marzmakeupver2.marzappver2.domain.Actor;
import com.marzmakeupver2.marzappver2.domain.Scenario;
import com.marzmakeupver2.marzappver2.domain.Styling;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class StylingMapperTest {

    public static final String MAKEUP = "dark";
    public static final String SFX = "scars";
    public static final String HAIR = "curly";
    public static final String IMG_DIR = "/directory";
    public static final long STY_SCE_REQ_ID1 = 1L;
    public static final long STY_SCE_REQ_ID2 = 2L;
    public static final long STY_SCE_REQ_ID3 = 3L;
    public static final long STYLING_ID = 5L;
    @Mock
    ActorRequestMapper actorRequestMapper;

    @Mock
    ScenarioRequestMapper scenarioRequestMapper;

    @InjectMocks
    StylingMapper stylingMapper;

    @Test
    void shouldReturnStylingFromStylingRequest() {
        //given
        Set<StylingScenarioRequest> stylingScenarioRequestSet = createStylingScenarioRequestSet();
        Actor actor1 = createActor1();
        StylingRequest stylingRequest = new StylingRequest(1L, MAKEUP, SFX, HAIR, IMG_DIR, stylingScenarioRequestSet);
        when(actorRequestMapper.toActorFromRequestOnlyWithId(stylingRequest)).thenReturn(actor1);
        when(scenarioRequestMapper.toScenariosFromStylingRequestOnlyWithId(stylingRequest.getScenariosList())).
                thenReturn(createScenariosFromStylingScenarioRequestSet());
        //when
        Styling styling = stylingMapper.toStyling(stylingRequest);
        styling.setStylingId(STYLING_ID);
        //then
        assertThat(styling).isNotNull();
        assertThat(styling.getStylingId()).isGreaterThan(0L);
        assertThat(styling.getActorId()).isEqualTo(actor1);
        assertThat(styling.getMakeup()).isEqualTo(MAKEUP);
        assertThat(styling.getHair()).isEqualTo(HAIR);
        assertThat(styling.getSfx()).isEqualTo(SFX);
        assertThat(styling.getImg_dir()).isEqualTo(IMG_DIR);
        assertThat(styling.getScenariosList()).hasSize(stylingScenarioRequestSet.size());

    }

    private Set<StylingScenarioRequest> createStylingScenarioRequestSet() {
        Set<StylingScenarioRequest> stylingScenarioRequestSet = new HashSet<>();
        StylingScenarioRequest stylingScenarioRequest1 = new StylingScenarioRequest(STY_SCE_REQ_ID1);
        StylingScenarioRequest stylingScenarioRequest2 = new StylingScenarioRequest(STY_SCE_REQ_ID2);
        StylingScenarioRequest stylingScenarioRequest3 = new StylingScenarioRequest(STY_SCE_REQ_ID3);
        stylingScenarioRequestSet.add(stylingScenarioRequest1);
        stylingScenarioRequestSet.add(stylingScenarioRequest2);
        stylingScenarioRequestSet.add(stylingScenarioRequest3);
        return stylingScenarioRequestSet;

    }
    private Set<Scenario> createScenariosFromStylingScenarioRequestSet() {
        Set<Scenario> scenarios = new HashSet<>();
        Scenario scenario1 = new Scenario();
        scenario1.setId(STY_SCE_REQ_ID1);
        Scenario scenario2 = new Scenario();
        scenario2.setId(STY_SCE_REQ_ID2);
        Scenario scenario3 = new Scenario();
        scenario3.setId(STY_SCE_REQ_ID3);
        scenarios.add(scenario1);
        scenarios.add(scenario2);
        scenarios.add(scenario3);
        return scenarios;

    }

    private Actor createActor1() {
        Actor actor = new Actor();
        actor.setId(1L);
        actor.setName("Stefan");
        actor.setSurname("Burczymucha");
        actor.setCharacter("T100");
        return actor;
    }


}
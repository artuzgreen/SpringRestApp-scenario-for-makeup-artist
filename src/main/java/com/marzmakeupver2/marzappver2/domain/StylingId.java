package com.marzmakeupver2.marzappver2.domain;

import java.io.Serializable;
import java.util.Objects;

public class StylingId implements Serializable {

    private Long stylingId;

    private Long actorId;

    public StylingId() {
    }

    public StylingId(Long stylingId, Long actorId) {
        this.stylingId = stylingId;
        this.actorId = actorId;
    }

    public Long getStylingId() {
        return stylingId;
    }

    public void setStylingId(Long stylingId) {
        this.stylingId = stylingId;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StylingId stylingId1 = (StylingId) o;
        return Objects.equals(stylingId, stylingId1.stylingId) && Objects.equals(actorId, stylingId1.actorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stylingId, actorId);
    }


}

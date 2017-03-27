package it.lisik.domainutils.event;

import org.joda.time.DateTime;

import java.util.UUID;

public abstract class DomainEvent {
    private final UUID eventId = UUID.randomUUID();
    private final DateTime createdAt;

    protected DomainEvent(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    protected DomainEvent() {
        this.createdAt = DateTime.now();
    }

    public UUID getEventId() {
        return eventId;
    }
}

package it.lisik.domainutils.event;

public abstract class EntityAwareEvent<T> extends DomainEvent {
    private final T entity;

    public EntityAwareEvent(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }
}

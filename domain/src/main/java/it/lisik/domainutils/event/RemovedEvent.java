package it.lisik.domainutils.event;

public class RemovedEvent<T> extends EntityAwareEvent<T> {
    public RemovedEvent(T entity) {
        super(entity);
    }
}

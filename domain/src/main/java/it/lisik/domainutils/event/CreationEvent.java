package it.lisik.domainutils.event;

public class CreationEvent<T> extends EntityAwareEvent<T> {

    public CreationEvent(T entity) {
        super(entity);
    }
}

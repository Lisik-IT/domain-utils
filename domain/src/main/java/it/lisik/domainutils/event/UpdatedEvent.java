package it.lisik.domainutils.event;

public class UpdatedEvent<T> extends EntityAwareEvent<T> {
    public UpdatedEvent(T entity) {
        super(entity);
    }
}

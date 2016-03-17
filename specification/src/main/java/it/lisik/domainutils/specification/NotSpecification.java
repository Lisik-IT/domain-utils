package it.lisik.domainutils.specification;

public class NotSpecification<T> implements Specification<T> {
    private final Specification<T> specification;

    public NotSpecification(Specification<T> specification) {
        this.specification = specification;
    }

    @Override
    public boolean isSatisfiedBy(T object) {
        return !specification.isSatisfiedBy(object);
    }
}

package it.lisik.domainutils.specification;

public class AndSpecification<T> implements Specification<T> {
    private final Specification<T> firstSpecification;
    private final Specification<T> secondsSpecification;

    public AndSpecification(Specification<T> firstSpecification, Specification<T> secondsSpecification) {
        this.firstSpecification = firstSpecification;
        this.secondsSpecification = secondsSpecification;
    }

    @Override
    public boolean isSatisfiedBy(T object) {
        return firstSpecification.isSatisfiedBy(object) && secondsSpecification.isSatisfiedBy(object);
    }
}

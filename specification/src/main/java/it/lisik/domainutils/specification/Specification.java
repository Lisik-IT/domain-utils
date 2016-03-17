package it.lisik.domainutils.specification;

public interface Specification<T> {
    boolean isSatisfiedBy(T object);

    default Specification<T> and(Specification<T> specification) {
        return new AndSpecification<>(this, specification);
    }

    default Specification<T> or(Specification<T> specification) {
        return new OrSpecification<>(this, specification);
    }

    default Specification<T> not() {
        return new NotSpecification<>(this);
    }
}

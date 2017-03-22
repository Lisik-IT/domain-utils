package it.lisik.domainutils.person;

import it.lisik.domainutils.ValueObject;

public class Weight implements ValueObject<Integer> {
    private final Integer value;

    public Weight(Integer value) {
        if (value <= 0) {
            throw new InvalidWeightException();
        }
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "kg";
    }
}

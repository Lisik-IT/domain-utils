package it.lisik.domainutils.person;

import it.lisik.domainutils.ValueObject;

public class Height implements ValueObject<Integer> {
    private final Integer height;

    public Height(Integer height) {
        if (height == 0) {
            throw new InvalidHeightException();
        }

        this.height = height;
    }

    @Override
    public String toString() {
        return getValue() + " cm";
    }

    @Override
    public Integer getValue() {
        return height;
    }
}

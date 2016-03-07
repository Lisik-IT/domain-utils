package it.lisik.domainutils.person;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import it.lisik.domainutils.ValueObject;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public class LastName implements ValueObject<String> {
    public final static Range<Integer> NAME_RANGE = Range.closed(1, 100);
    private final String lastName;

    /**
     * Build LastName (Surname) value object out of string
     *
     * @param lastName Last Name
     * @throws LastNameLengthException when name doesn't match constrain [1,100]
     */
    public LastName(@NotNull String lastName) {
        lastName = StringUtils.stripToNull(lastName);
        lastName = Preconditions.checkNotNull(lastName);

        if (!NAME_RANGE.contains(lastName.length())) {
            throw new LastNameLengthException(lastName, NAME_RANGE);
        }

        this.lastName = lastName;
    }

    @Override
    public String getValue() {
        return lastName;
    }
}

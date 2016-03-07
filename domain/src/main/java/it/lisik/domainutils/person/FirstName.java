package it.lisik.domainutils.person;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import it.lisik.domainutils.ValueObject;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public class FirstName implements ValueObject<String> {
    public final static Range<Integer> NAME_RANGE = Range.closed(1, 100);
    private final String firstName;

    /**
     * Build first name value object out of string
     *
     * @param firstName first name
     * @throws FirstNameLengthException when name doesn't match constrain [1,100]
     */
    public FirstName(@NotNull String firstName) {
        firstName = StringUtils.stripToNull(firstName);
        firstName = Preconditions.checkNotNull(firstName);

        if (!NAME_RANGE.contains(firstName.length())) {
            throw new FirstNameLengthException(firstName, NAME_RANGE);
        }

        this.firstName = firstName;
    }

    @Override
    public String getValue() {
        return firstName;
    }
}

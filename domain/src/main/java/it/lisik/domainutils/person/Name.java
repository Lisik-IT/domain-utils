package it.lisik.domainutils.person;

import com.google.common.base.Objects;
import it.lisik.domainutils.ValueObject;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Name implements ValueObject<String> {
    private final FirstName firstName;
    private final LastName lastName;

    public Name(String firstName, String lastName) {
        this(new FirstName(firstName), new LastName(lastName));
    }

    public Name(FirstName firstName, LastName lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name = (Name) o;
        return Objects.equal(firstName, name.firstName) &&
                Objects.equal(lastName, name.lastName);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .toString();
    }

    public FirstName getFirstName() {
        return firstName;
    }

    public LastName getLastName() {
        return lastName;
    }

    @Override
    public String getValue() {
        return firstName.getValue() + " " + lastName.getValue();
    }
}

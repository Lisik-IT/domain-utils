@TypeDefs({
        @TypeDef(typeClass = FirstNameType.class, defaultForType = FirstName.class, name = "firstname"),
        @TypeDef(typeClass = LastNameType.class, defaultForType = LastName.class, name = "lastname")
})
package it.lisik.domainutils.person;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
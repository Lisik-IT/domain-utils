@TypeDefs({
        @TypeDef(typeClass = FirstNameType.class, defaultForType = FirstName.class, name = "firstname"),
        @TypeDef(typeClass = LastNameType.class, defaultForType = LastName.class, name = "lastname"),
        @TypeDef(typeClass = NameType.class, defaultForType = Name.class, name = "name")
})
package it.lisik.domainutils.person;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
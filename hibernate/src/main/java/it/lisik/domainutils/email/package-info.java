@TypeDefs(
        @TypeDef(typeClass = EmailAddressType.class, defaultForType = EmailAddress.class, name = "emailAddress")
)
package it.lisik.domainutils.email;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
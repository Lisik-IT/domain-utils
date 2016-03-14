package it.lisik.domainutils;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import it.lisik.domainutils.ein.EIN;
import it.lisik.domainutils.ein.EINMixin;
import it.lisik.domainutils.email.EmailAddress;
import it.lisik.domainutils.email.EmailAddressMixin;
import it.lisik.domainutils.person.*;
import it.lisik.domainutils.phonenumber.PhoneNumber;
import it.lisik.domainutils.phonenumber.PhoneNumberMixin;
import it.lisik.domainutils.ssn.SSN;
import it.lisik.domainutils.ssn.SSNMixin;

public class DomainUtilsModule extends Module {
    @Override
    public String getModuleName() {
        return "DomainUtils";
    }

    @Override
    public Version version() {
        return Version.unknownVersion();
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(EIN.class, EINMixin.class);
        context.setMixInAnnotations(EmailAddress.class, EmailAddressMixin.class);
        context.setMixInAnnotations(FirstName.class, FirstNameMixin.class);
        context.setMixInAnnotations(LastName.class, LastNameMixin.class);
        context.setMixInAnnotations(Name.class, NameMixin.class);
        context.setMixInAnnotations(PhoneNumber.class, PhoneNumberMixin.class);
        context.setMixInAnnotations(SSN.class, SSNMixin.class);
    }
}

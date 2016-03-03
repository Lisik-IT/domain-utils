package it.lisik.domainutils.hibernate;

import it.lisik.domainutils.ValueObject;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Set;

public class DomainUtilsIntegrator implements Integrator {
    private final static Logger LOGGER = LoggerFactory.getLogger(DomainUtilsIntegrator.class);

    public void integrate(Configuration configuration, SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {
        final Collection<Class<? extends AbstractSingleColumnStandardBasicType>> types = getTypes();
        LOGGER.info("Found {} types to register", types.size());

        for (Class<? extends AbstractSingleColumnStandardBasicType> type : types) {
            try {
                LOGGER.info("Registering {} type", type.getCanonicalName());
                configuration.registerTypeOverride(type.newInstance());
            } catch (Exception e) {
                LOGGER.error("Couldn't initialize {} with default constructor", type.getCanonicalName());
//                throw new RuntimeException(e);
                continue;
            }
        }

        final Set<Class<? extends ValueObject>> valueObjects = new Reflections(ClasspathHelper.forJavaClassPath()).getSubTypesOf(ValueObject.class);
        LOGGER.info("Found {} generic value objects to register", valueObjects.size());


        for (Class<? extends ValueObject> valueObject : valueObjects) {
            if (valueObject.getCanonicalName().contains("it.lisik.domainutils")) continue;
            try {
                valueObject.getConstructor(String.class);
                LOGGER.info("Registering {} value object", valueObject.getCanonicalName());
                configuration.registerTypeOverride(new GenericSingleStringType(valueObject), new String[]{valueObject.getClass().getName()});
            } catch (NoSuchMethodException e) {
                continue;
            }
        }


    }

    private Collection<Class<? extends AbstractSingleColumnStandardBasicType>> getTypes() {
        return new Reflections("it.lisik.domainutils").getSubTypesOf(AbstractSingleColumnStandardBasicType.class);
    }

    public void integrate(MetadataImplementor metadata, SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {

    }

    public void disintegrate(SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {

    }
}

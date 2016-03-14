package it.lisik.domainutils.ein;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Mixin class for Jackson
 * <p>
 * Examples:
 * <pre>
 *     {
 *         "ein": "558360596"
 *     }
 * </pre>
 * <p>
 * <pre>
 *     {
 *         "ein": "55-8360596"
 *     }
 * </pre>
 */
public abstract class EINMixin {
    EINMixin(@JsonProperty String value) {}

    @JsonValue
    abstract String getValue();
}

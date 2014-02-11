package org.ei.drishti.domain.register;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class ECRegister {

    private final List<ECRegisterEntry> ecRegisterEntries;

    public ECRegister(List<ECRegisterEntry> ecRegisterEntries) {
        this.ecRegisterEntries = ecRegisterEntries;
    }

    public List<ECRegisterEntry> ecRegisterEntries() {
        return ecRegisterEntries;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, "id", "revision");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "revision");
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
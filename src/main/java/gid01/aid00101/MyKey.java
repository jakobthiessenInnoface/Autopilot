package gid01.aid00101;

import java.util.Objects;

import io.adminshell.aas.v3.model.Key;
import io.adminshell.aas.v3.model.KeyElements;
import io.adminshell.aas.v3.model.KeyType;
import io.adminshell.aas.v3.model.annotations.IRI;
import io.adminshell.aas.v3.model.builder.KeyBuilder;
import io.adminshell.aas.v3.model.impl.DefaultKey;

/**
 * Default implementation of package io.adminshell.aas.v3.model.Key
 * 
 * A key is a reference to an element by its id.
 */

@IRI("aas:Key")
public class MyKey implements Key {

    @IRI("https://admin-shell.io/aas/3/0/RC01/Key/idType")
    protected KeyType idType;

    protected Boolean local;
    
    @IRI("https://admin-shell.io/aas/3/0/RC01/Key/type")
    protected KeyElements type;

    @IRI("https://admin-shell.io/aas/3/0/RC01/Key/value")
    protected String value;

    public MyKey() {}

    @Override
    public int hashCode() {
        return Objects.hash(this.idType,
            this.type,
            this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            MyKey other = (MyKey) obj;
            return Objects.equals(this.idType, other.idType) &&
                Objects.equals(this.type, other.type) &&
                Objects.equals(this.value, other.value);
        }
    }

    @Override
    public KeyType getIdType() {
        return idType;
    }

    @Override
    public void setIdType(KeyType idType) {
        this.idType = idType;
    }

    @Override
    public KeyElements getType() {
        return type;
    }

    @Override
    public void setType(KeyElements type) {
        this.type = type;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * This builder class can be used to construct a DefaultKey bean.
     */
    public static class Builder extends KeyBuilder<DefaultKey, Builder> {

        @Override
        protected Builder getSelf() {
            return this;
        }

        @Override
        protected DefaultKey newBuildingInstance() {
            return new DefaultKey();
        }
    }
    
    public void setLocal(Boolean local) {
        this.local = Boolean.TRUE;
    }
    public Boolean getLocal() {
        return this.local;
    }
}

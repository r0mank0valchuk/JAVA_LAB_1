package ua.model;

import java.util.Objects;

public abstract class BaseEntity {
    protected long id;

    public BaseEntity(long id) { this.id = id; }

    public long getId() { return id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}

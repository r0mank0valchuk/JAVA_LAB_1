package ua.model;

import ua.util.Utils;

public class Branch extends BaseEntity {

    private String name;
    private String location;

    public Branch(long id, String name, String location) {
        super(id);
        this.name = Utils.requireName(name, "Branch name");
        this.location = Utils.requireName(location, "Location");
    }

    public static Branch create(long id, String name, String location) {
        return new Branch(id, name, location);
    }

    public String getName() { return name; }
    public String getLocation() { return location; }

    @Override
    public String toString() {
        return name + " Branch (" + location + ")";
    }
}

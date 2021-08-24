package com.solvd.orderProject.order;

import java.util.Objects;

public abstract class MenuItem {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;
        MenuItem menuItem = (MenuItem) o;
        return id.equals(menuItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

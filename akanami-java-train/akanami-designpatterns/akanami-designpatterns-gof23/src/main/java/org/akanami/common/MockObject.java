package org.akanami.common;

public class MockObject implements Cloneable {
    String name;

    public MockObject() {

    }

    public MockObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MockObject{" +
                "name='" + name + '\'' +
                '}';
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

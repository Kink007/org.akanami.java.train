package org.akanami.prototype;

import org.akanami.common.MockObject;

public class Demo01 {
    public static void main(String[] args) throws CloneNotSupportedException {
        MockObject mock = new MockObject();
        mock.setName("mock");

        ShallowCopyObject shallow = new ShallowCopyObject();
        shallow.setName("shallow");
        shallow.setMockObject(mock);

        ShallowCopyObject shallowCopy = (ShallowCopyObject)shallow.clone();
        System.out.println(shallowCopy);
        System.out.println(shallow.getMockObject() == shallowCopy.getMockObject());

        DeepCopyObject deep = new DeepCopyObject();
        deep.setName("deep");
        deep.setMockObject(mock);

        DeepCopyObject deepCopy = (DeepCopyObject)deep.clone();
        System.out.println(deepCopy);
        System.out.println(deep.getMockObject() == deepCopy.getMockObject());
    }
}

/*
    浅拷贝
 */
class ShallowCopyObject extends MockObject implements Cloneable {
    MockObject mockObject;

    public MockObject getMockObject() {
        return this.mockObject;
    }

    public void setMockObject(MockObject mockObject) {
        this.mockObject = mockObject;
    }

    public Object clone() throws CloneNotSupportedException  {
            return super.clone();
    }

    @Override
    public String toString() {
        return "ShallowCopyObject{" +
                "mockObject=" + mockObject +
                '}';
    }
}

/*
    深拷贝
 */
class DeepCopyObject extends ShallowCopyObject {

    @Override
    public Object clone() throws CloneNotSupportedException {
        DeepCopyObject obj = (DeepCopyObject)super.clone();
        MockObject mock  = (MockObject) obj.getMockObject().clone();
        obj.setMockObject(mock);

        return obj;
    }

    @Override
    public String toString() {
        return "DeepCopyObject{" +
                "mockObject=" + mockObject +
                '}';
    }
}

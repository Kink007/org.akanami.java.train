package org.akanami.factory;

import org.akanami.common.MockObject;

public class Demo01 {
    static class MockObjectFactory {
        public static MockObject createMockObject(String key) {
            MockObject mo = new MockObject();
            mo.setName(key);

            return mo;
        }
    }

    public static void main(String[] args) {
        MockObject mockObject = MockObjectFactory.createMockObject("测试");
        System.out.println("mockObject:" + mockObject);
    }
}

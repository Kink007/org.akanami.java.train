package org.akanami.innerclass;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OuterClassTest {

    @Test
    public void callInner() {
        OuterClass outer = new OuterClass();

        Integer initCode = outer.getCode();
        outer.CallInner();
        Integer afterCallCode = outer.getCode();

        Assert.assertNotEquals(initCode, afterCallCode);
        Assert.assertEquals( Integer.valueOf(initCode.intValue() + 1), afterCallCode);
    }
}
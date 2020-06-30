package org.akanami.enums.simple;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColorTest {
    @Test
    public void getName() {
        Assert.assertEquals(Color.BLACK.getName(), "黑色");
        Assert.assertEquals(Color.WHITE.getName(), "白色");
        Assert.assertEquals(Color.RED.getName(), "红色");
        Assert.assertEquals(Color.BLUE.getName(), "蓝色");
    }

    @Test
    public void getCode() {
        Assert.assertEquals(Color.BLACK.getCode(), Integer.valueOf(0));
        Assert.assertEquals(Color.WHITE.getCode(), Integer.valueOf(1));
        Assert.assertEquals(Color.RED.getCode(), Integer.valueOf(2));
        Assert.assertEquals(Color.BLUE.getCode(), Integer.valueOf(3));
    }

    @Test
    public void valueOf() {
        Color black = Color.valueOf("BLACK");

        Assert.assertEquals(black.getName(), "黑色");
        Assert.assertEquals(black.getCode(), Integer.valueOf(0));
    }

    @Test
    public void getColor() {
        Color black = Color.getColor("黑色");

        Assert.assertEquals(black.getName(), "黑色");
        Assert.assertEquals(black.getCode(), Integer.valueOf(0));
    }
}
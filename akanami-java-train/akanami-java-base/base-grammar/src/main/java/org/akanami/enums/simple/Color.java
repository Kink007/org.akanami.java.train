package org.akanami.enums.simple;

public enum  Color {
    BLACK(0, "黑色"),
    WHITE(1, "白色"),
    RED(2, "红色"),
    BLUE(3, "蓝色");

    private Integer code;
    private String name;

    Color(Integer aCode, String aName) {
        this.code = aCode;
        this.name = aName;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static Color getColor(String name) {
        for (Color c: Color.values()) {
            if(c.getName() == name) {
                return c;
            }
        }

        return null;
    }
}

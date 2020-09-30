package org.akanami.spring.spel4.evaluation_4_1;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class EvaluationDemo01 {
    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp1 = parser.parseExpression("'hello world'.concat('!')");
        String str1  = (String)exp1.getValue();
        System.out.println(str1);

        Expression exp2 = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes2 = (byte[]) exp2.getValue();
        System.out.println(bytes2.toString());

        Expression exp3 = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp3.getValue();
        System.out.println(length);

        Expression exp4 = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp4.getValue(String.class);
        System.out.println(message);
    }
}

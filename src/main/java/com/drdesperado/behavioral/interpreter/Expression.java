package com.drdesperado.behavioral.interpreter;

public interface Expression {
    int interpret();
}

//Terminal Expression
class NumberExpression implements Expression{
    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

//Non-terminal Expression
class MinusExpression implements Expression{
    private final Expression left;
    private final Expression right;

    public MinusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

//Non-terminal Expression
class PlusExpression implements Expression{
    private final Expression left;
    private final Expression right;

    public PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

//Context
class Context {
    Expression evaluate(String s) {
        int pos = s.length() - 1;

        while (pos > 0) {
            if (Character.isDigit(s.charAt(pos))) {
                pos--;
            } else {
                Expression left = evaluate(s.substring(0, pos));
                Expression right = new NumberExpression(Integer.parseInt(s.substring(pos + 1)));
                char operator = s.charAt(pos);

                switch (operator) {
                    case '+' -> {
                        return new PlusExpression(left, right);
                    }
                    case '-' -> {
                        return new MinusExpression(left, right);
                    }
                }
            }
        }
        int result = Integer.parseInt(s);
        return new NumberExpression(result);
    }
}

class Test{
    public static void main(String[] args) {
        Context context = new Context();
        System.out.println(context.evaluate("5+24+3+353-234").interpret());

    }
}



package com.netty.gateway.router;

public enum Operation {
    PLUS("+") {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
    }, MINUS("-") {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    }, TIMES("*") {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    }, DIVIDE("/") {
        @Override
        public int apply(int x, int y) {
            return x / y;
        }
    };

    private String op;

    Operation(String op) {
        this.op = op;
    }

    public abstract int apply(int x, int y);

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public static void main(String[] args) {
        System.out.println(Operation.PLUS.apply(1, 2));
    }

}
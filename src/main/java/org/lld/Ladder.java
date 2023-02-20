package org.lld;

public class Ladder {

    private Integer base;
    private Integer top;

    public Ladder(int base, int top){
        this.base = Integer.valueOf(base);
        this.top = Integer.valueOf(top);
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }
}

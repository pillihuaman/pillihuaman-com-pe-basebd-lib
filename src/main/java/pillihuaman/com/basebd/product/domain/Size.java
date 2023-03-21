package pillihuaman.com.basebd.product.domain;


import pillihuaman.com.base.commons.Parameters;

import java.util.List;

public class Size  {
    private int id;
    private Parameters parameter;
    List<Color> color;

    public List<Color> getColor() {
        return color;
    }

    public void setColor(List<Color> color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parameters getParameter() {
        return parameter;
    }

    public void setParameter(Parameters parameter) {
        this.parameter = parameter;
    }
}

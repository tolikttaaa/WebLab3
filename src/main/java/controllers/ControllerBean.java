package controllers;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Map;

@ManagedBean(name = "controller", eager = true)
@ApplicationScoped
public class ControllerBean {

    private float x = 0.0f;
    private String y = "0";
    private String r = "1";
    private String result = "";
    private DBManager manager;

    public ControllerBean() {
        manager = new DBManager();
    }

    public void checkArea() {
        try {
            y = AreaValidator.validateY(y);
            x = Float.parseFloat(AreaValidator.validateX(x + ""));
            r = AreaValidator.validateR(r);
            result = AreaValidator.checkArea(x + "", y, r);
        } catch (NumberFormatException e) { result = "Incorrect value(s)!"; }
        manager.addDot(x,  Double.parseDouble(y),  Integer.parseInt(r), result);
        resetBean();
    }

    public void plotCheckArea() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String plotX = params.get("x");
        String plotY = params.get("y");
        String plotR = params.get("r");
        try {
            plotY = AreaValidator.validateY(plotY);
            plotX = AreaValidator.validateX(plotX);
            plotR = AreaValidator.validateR(plotR);
            result = AreaValidator.checkArea(plotX, plotY, plotR);
        } catch (NumberFormatException e) { result = "Incorrect value(s)!"; }
        if (manager != null) manager.addDot(Double.parseDouble(plotX), Double.parseDouble(plotY), Integer.parseInt(plotR), result);
        resetBean();
    }

    public void resetBean() {
        setX(0.0f);
        setY("0");
        setR("1");
        setResult("");
    }


    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getY() {
        return y;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

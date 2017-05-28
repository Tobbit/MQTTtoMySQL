package de.tobisee.mqtt2sql.Entity;

import sun.util.calendar.LocalGregorianCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Tobi on 27.05.2017.
 */
public class BMP180 {
    private long timestamp;
    private double temp;
    private double pressure;

    public BMP180(){}

    public BMP180(long timestamp, double temp, double pressure) {
        this.timestamp = timestamp;
        this.temp = temp;
        this.pressure = pressure;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        Calendar kalendar = GregorianCalendar.getInstance();
        kalendar.setTime(new Date(timestamp));
       return   kalendar.getTime()+"\tTemp: "+getTemp()+"°C\tPressure: "+getPressure()+"hP";

    }
}

package logging;

import java.util.Scanner;

public class ConsoleLogger implements ILog {

    /**
     *
     * @param text represents a <b>long value</b>, which the method will print
     */
    public void write(long text) {
        System.out.println(text);
    }

    /**
     *
     * @param text represents a <b>String</b>, which the method will print
     */
    public void write(String text) {
        System.out.println(text);

    }

    /**
     * @param values represent a <b>variable number of objects</b>, which the method will print
     * in the given order, with a space between each parameter
     */
    public void write(Object... values) {
        String result="";
        for(Object o: values)
            result+=o + " ";
        System.out.println(result);
    }

    @Override
    public void writeTime(String string, long value, TimeUnit.units unit) {
        double number = (double) value;
        int precision=0;
        switch(unit)
        {
            case milliseconds: case millisec: case ms: precision=-3; break;
            case nanoseconds: case nanosec: case ns: precision=-9; break;
            case seconds: case sec: case s: precision=0; break;
            default: System.out.println("invalid precision");
        }
        System.out.println(string + number*Math.pow(10, -precision-9) + unit);
    }

    public void close() {
        // TODO Auto-generated method stub

    }

}

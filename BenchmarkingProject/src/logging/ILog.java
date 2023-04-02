package logging;

public interface ILog {
    void write(long text);

    /**
     *
     * @param text
     */
    void write(String text);
    void write(Object ...values);
    void writeTime(String string, long value, TimeUnit.units unit);
    void close();
}

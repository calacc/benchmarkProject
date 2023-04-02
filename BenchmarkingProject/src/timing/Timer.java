package timing;

public class Timer implements ITimer{

    private long elapsedTime, totalTime,
            startInterval, endInterval;

    /**
     * <b>Starts</b> the current timer, and resets the variables <b>elapsedTime</b> and <b>totalTime</b>
     */
    public void start() {
        startInterval=System.nanoTime();
        elapsedTime=0;
        totalTime=0;
    }

    /**
     * <b>Stops</b> the current timer and computes the elapsed time in the current interval, adding it to the total time
     * @return <b>totalTime</b>, which is the sum of all the intervals in which the timer was active
     */
    public long stop() {
        endInterval=System.nanoTime();
        elapsedTime=endInterval-startInterval;
        totalTime+=elapsedTime;
        return totalTime;
    }

    /**
     * <b>Resumes</b> the timer by setting the start of the current interval to the current time
     */
    public void resume() {
        startInterval=System.nanoTime();
    }

    /**
     * <b>Pauses</b> the timer, marking the end of the current interval
     * the method will compute and @return the elapsed time in the current interval
     */
    public long pause() {
        endInterval=System.nanoTime();
        elapsedTime=endInterval-startInterval;
        totalTime+=elapsedTime;
        return elapsedTime;
    }

}

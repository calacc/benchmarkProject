package testbench;

import bench.IBenchmark;
import bench.cpu.CPUThreadedHashing;
import logging.ConsoleLogger;
import logging.ILog;
import timing.ITimer;
import logging.TimeUnit;
import timing.Timer;

public class TestCPUThreadedHashing {
    public static void main(String[] args) {
        IBenchmark bench = new CPUThreadedHashing();
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        int maxLength = 10;
        int nThreads = 8;
        int hashCode = 524381996;
        timer.start();
        bench.run(maxLength, nThreads, hashCode);
        long time = timer.stop();
        log.writeTime("Finished in", time, TimeUnit.units.ms);
        log.write("Result is", ((CPUThreadedHashing) bench).getResult());
    }

}

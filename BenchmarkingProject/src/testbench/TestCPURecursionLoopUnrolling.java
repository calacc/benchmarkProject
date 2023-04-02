package testbench;

import bench.IBenchmark;
import bench.cpu.CPURecursionLoopUnrolling;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPURecursionLoopUnrolling {
    public static void main(String[] args) {
        IBenchmark bench = new CPURecursionLoopUnrolling();
        ILog log = new ConsoleLogger();
        ITimer timer = new Timer();
        long workload=100000L;

        bench.initialize(workload);
        bench.warmUp();

        timer.start();
        bench.run(false);

        long time=timer.stop();
        log.write("Finished in ", time, TimeUnit.units.ms);


    }
}

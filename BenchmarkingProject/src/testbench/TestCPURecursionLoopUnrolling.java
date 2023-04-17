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
        long workload=1000000L;

        bench.initialize(workload);
        bench.warmUp();

        timer.start();
//        bench.run(false);
//        bench.run(true, 1);
        bench.run(true, 3);

        long time=timer.stop();
        log.write("Finished in ", time, TimeUnit.units.ms);
        log.write(((CPURecursionLoopUnrolling) bench).getParameters());
        log.write("Score:", workload*10000.0/time);


    }
}

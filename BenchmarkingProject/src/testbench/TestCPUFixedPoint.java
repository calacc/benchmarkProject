package testbench;

import bench.IBenchmark;
import bench.cpu.CPUFixedPoint;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPUFixedPoint {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new CPUFixedPoint();
        double timeInSeconds;

        int workload=100000000;
        bench.initialize(workload);
//        bench.warmUp();

        timer.start();
        bench.run(1);
        log.writeTime("Finished in: ", timer.stop(), TimeUnit.units.ms);
        timeInSeconds=timer.stop()/Math.pow(10, 9);
        log.write("MOPS = ", 26L*workload/timeInSeconds/Math.pow(10, 6));

        timer.start();
        bench.run(2);
        log.writeTime("Finished in: ", timer.stop(), TimeUnit.units.ms);
        timeInSeconds=timer.stop()/Math.pow(10, 9);
        log.write("MOPS = ", 20L*workload/timeInSeconds/Math.pow(10, 6));

        timer.start();
        bench.run(3);
        log.writeTime("Finished in: ", timer.stop(), TimeUnit.units.ms);
        timeInSeconds=timer.stop()/Math.pow(10, 9);
        log.write("MOPS = ",10L*workload/timeInSeconds/Math.pow(10, 6));

    }
}

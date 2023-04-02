package testbench;

import bench.IBenchmark;
import bench.cpu.CPUDigitsOfPi;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit.units;
import timing.ITimer;
import timing.Timer;

public class TestCPUDigitsOfPi {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new CPUDigitsOfPi();

        // 50 digits
        bench.initialize(50);
        ((CPUDigitsOfPi) bench).warmup();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), units.milliseconds);

        // 100 digits
        bench.initialize(100);
//        ((CPUDigitsOfPi) bench).warmup();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), units.milliseconds);

        // 1000 digits
        bench.initialize(1000);
//        ((CPUDigitsOfPi) bench).warmup();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), units.milliseconds);

        // 10 000 digits
        bench.initialize(10000);
//        ((CPUDigitsOfPi) bench).warmup();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), units.milliseconds);

        // 50 000 digits
        bench.initialize(50000);
//        ((CPUDigitsOfPi) bench).warmup();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), units.milliseconds);

        // 100 000 digits
        bench.initialize(100000);
//        ((CPUDigitsOfPi) bench).warmup();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), units.milliseconds);
    }
}

package testbench;

import bench.DemoBenchmark;
import bench.IBenchmark;
import bench.cpu.CPUDigitsOfPi;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestDemoBench {

    public static void main(String[] args)
    {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new DemoBenchmark();

        final int workload=100;
        bench.initialize(workload);

        for (int i = 0; i < 12; i++) {
            timer.resume();
            bench.run();
            long time=timer.pause();
            log.writeTime("Run " + i + ":", time, TimeUnit.units.ms);
        }

        log.writeTime("Finished in ", timer.stop(), TimeUnit.units.ms);
        log.close();
        bench.clean();
    }
}

package testbench;

import bench.IBenchmark;
import bench.cpu.CPUThreadedRoots;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestThreadedRoots{
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        IBenchmark bench = new CPUThreadedRoots();
        int workload=200000000;
        bench.initialize(workload);
        bench.warmUp();

        for(int i=1; i<=64; i*=2)
        {
            timer.start();
            bench.run(i);
            log.write(i, "threads");
            log.writeTime("Finished in: ", timer.stop(), TimeUnit.units.seconds);
            log.write("Score: ", (int)((double)workload/(timer.stop()*i)*100000));
        }
    }
}

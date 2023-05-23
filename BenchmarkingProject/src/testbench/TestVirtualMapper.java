package testbench;

import bench.IBenchmark;
import bench.ram.VirtualMemoryBenchmark;
import logging.ConsoleLogger;
import logging.ILog;

public class TestVirtualMapper {
    public static void main(String[] args) {
        ILog log = new ConsoleLogger();
        IBenchmark bench = new VirtualMemoryBenchmark();

        long fileSize=13*1024*1024*1024L;
        int bufferSize=4*1024; //4kb

        bench.run(fileSize, bufferSize);
        log.write(bench.getResult());

        bench.clean();
    }
}

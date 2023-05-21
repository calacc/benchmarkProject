package testbench;

import bench.IBenchmark;
import bench.hdd.HDDRandomAccess;
import logging.ConsoleLogger;
import logging.ILog;

public class TestHDDRandomAccess {
    public static void main(String[] args) {
        ILog log = new ConsoleLogger();
        IBenchmark bench = new HDDRandomAccess();
        long fileSize = 1*1024*1024*1024L; //2gb
        long bufferSize = 512; //4kb

        bench.initialize(fileSize);
        bench.run("r", "fs", bufferSize);
        log.write(bench.getResult());
    }
}

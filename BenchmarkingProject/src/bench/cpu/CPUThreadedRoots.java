package bench.cpu;

import bench.IBenchmark;

public class CPUThreadedRoots implements IBenchmark {

    private double result;
    private int size;
    private boolean running;
    private int workload;

    @Override
    public void initialize(Object... params) {
        workload = (int) params[0];
    }

    @Override
    public void warmUp() {
        run(2);
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("nr of cores: " + cores + "\n");
        // call run method: call run() once
        // detect number of cores: Runtime.....availableProcessors();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException(
                "Method not implemented. Use run(Objects...) instead");
    }

    @Override
    public void run(Object... options) {
        int nThreads = (int) options[0];
        Thread[] threads = new Thread[nThreads];
        final int jobPerThread = workload/nThreads;

        running = true; // flag used to stop all started threads
        // create a thread for each runnable (SquareRootTask) and start it
        for (int i = 0; i < nThreads; ++i) {
            if(threads[i]==null) {
                threads[i] = new Thread(new SquareRootTask(jobPerThread*i+1, jobPerThread*(i+1)+1));
                threads[i].start();
            }
        }

        // join threads
        for (int i = 0; i < nThreads; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void clean() {
        // only implement if needed
    }

    @Override
    public void cancel() {

    }

    public String getResult() {
        return String.valueOf(result);
    }

    class SquareRootTask implements Runnable {

        private int from, to;
        private final double precision = 1e-4; // fixed
        private double result = 0.0;

        public SquareRootTask(int from, int to) {
            this.from=from;
            this.to=to;
        }

        @Override
        public void run() {
            for (int i = from; i < to && running; i++) {
                result+=getNewtonian((double)i);
            }
            getResult();
            // compute Newtonian square root on each number from i = 'from' to 'to', and also check 'running'
            // save (+=) each computed square root in the local 'result' variable
            // extra: send 'result' back to main thread and sum up with all results
        }

        private double getNewtonian(double x) {
            double s=x;
            while(Math.abs(s*s-x)>precision)
                s=(x/s+s)/2;
            return s;
        }

        // extra: compute sum, pass it back to wrapper class. Use synchronized
    }

}
//hehe

package bench.cpu;

import bench.IBenchmark;

public class CPURecursionLoopUnrolling implements IBenchmark {

    long size;
    @Override
    public void run() {

    }
    boolean isPrime(long n)
    {
        if(n==2) return true;
        if(n<2 || n%2==0)
            return false;
        for(int i=3; i*i<n; i+=2)
            if(n%i==0)
                return false;
        return true;
    }
    private long recursive(long start, long size, int counter)
    {
        try{
            long i;
            for(i=start; i<=size; ++i)
                if(isPrime(i))
                    break;
            if(i>=size) return 0;
            else
                return i+recursive(i+1, size, counter+1);
        }catch(StackOverflowError e)
        {
            System.out.println("Reached nr " + start + "/" + size + "after" + counter + "calls");
        }
        return 0;
    }

    private long recursiveUnrolled(long start, int unrollLevel, long size, int counter)
    {
        try{
            long sum=0, counterLevel=0, i;
            for(i=start; i<=size && counterLevel<unrollLevel; ++i)
                if(isPrime(i)) {
                    sum+=i;
                    counterLevel++;
                    if(counterLevel==unrollLevel)
                        break;
                }
            if(counterLevel==unrollLevel)
                return sum + recursiveUnrolled(i + 1, unrollLevel, size, counter + 1);
            else return 0;
        }catch(StackOverflowError e)
        {
            System.out.println("Reached nr " + start + "/" + size + "after" + counter + "calls");
        }
        return 0;
    }
    @Override
    public void run(Object... params) {
        boolean unrollingUse = (boolean) params[0];
        if(unrollingUse==false)
        {
            System.out.println(recursive(1, this.size, 0));
        }
        else
        {
            System.out.println(recursiveUnrolled(1, 3, this.size, 0));
        }
    }

    @Override
    public void initialize(Object... params) {
        this.size=(long)params[0];
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {

    }
}

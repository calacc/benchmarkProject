package bench;

import java.util.Random;

public class DemoBenchmark implements IBenchmark{
    private int[] array;
    private int n;
    private boolean running;
    public void run() {

        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        for(int i=0; i<n && running; ++i)
//            for(int j=i+1; j<n; ++j)
//                if(array[i]>array[j])
//                {
//                    int aux=array[i];
//                    array[i]=array[j];
//                    array[j]=aux;
//                }
    }

    public void run(Object... params) {

    }

    public void initialize(Object... params) {
        this.n=(int)params[0];
        this.array=new int[n];
        running=true;

        Random random = new Random();
        for(int i=0; i<n; ++i)
            array[i]=random.nextInt(1000);
    }


    public void clean() {

    }

    public void cancel() {
        running=false;
    }

    @Override
    public void warmUp() {

    }

    @Override
    public String getResult() {
        return null;
    }
}

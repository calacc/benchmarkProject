package bench.cpu;

import bench.IBenchmark;

import java.util.Random;

public class CPUFixedPoint implements IBenchmark {

    private int size;
    @Override
    public void run() {

    }

    public void arithmeticTest()
    {
        int []num=new int[5];
        int []res=new int[size];
        int j=0, k=0, l=0;
        for(int i=0; i<size; ++i)
        {
            j=num[1]*(k-j);
            k=num[3]*k+l+j;
            l=(l-k)*(num[2]+j);
            res[l]=j+l;
            res[k]=l-j;
        }
    }

    public void branchingTest()
    {
        int []num={0,1,2,3};
        int j=0;
        for(int i=0; i<size; ++i)
        {
            if(j==1)
            {
                j=num[2];
            }
            else
            {
                j=num[3];
            }
            if(j>2)
            {
                j=num[0];
            }
            else {
                j=num[1];
            }
            if(j<1)
            {
                j=num[1];
            }
            else
            {
                j=num[0];
            }
        }
    }

    public void accessTest()
    {
        int []a = new int[size];
        int []b = new int[size];
        int []c = new int[size];
        Random rd=new Random();
        for(int i=0; i<size; ++i) {
            a[i] = rd.nextInt();
            b[i] = rd.nextInt();
        }
        try {
            for (int i = 0; i < size; ++i)
                c[i] = a[i]+b[i];
        } catch(ArrayIndexOutOfBoundsException e)
        { }
    }
    @Override
    public void run(Object... params) {
        int option=(int)params[0];
        switch (option) {
            case 1: arithmeticTest(); break;
            case 2: branchingTest(); break;
            case 3: accessTest(); break;
            default: System.out.println("please provide a valid option");
        }
    }

    @Override
    public void initialize(Object... params) {
        this.size=(int)params[0];
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {
        for (int i = 0; i < 100; i++) {
            arithmeticTest();
            branchingTest();
            accessTest();
        }

    }

    @Override
    public String getResult() {
        return null;
    }
}

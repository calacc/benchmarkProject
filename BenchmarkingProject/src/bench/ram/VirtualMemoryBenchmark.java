package bench.ram;

import java.io.IOException;
import java.util.Random;

import timing.Timer;
import bench.IBenchmark;

/**
 * Maps a large file into RAM triggering the virtual memory mechanism. Performs
 * reads and writes to the respective file.<br>
 * The access speeds depend on the file size: if the file can fit the available
 * RAM, then we are measuring RAM speeds.<br>
 * Conversely, we are measuring the access speed of virtual memory, implying a
 * mixture of RAM and HDD access speeds (i.e., lower speeds).
 */
public class VirtualMemoryBenchmark implements IBenchmark {

	private String result = "";
	MemoryMapper core;

	@Override
	public void initialize(Object... params) {
		/* not today */
	}

	@Override
	public void warmUp() {
		/* summer is coming anyway */
	}

	@Override
	public void run() {
		throw new UnsupportedOperationException("Use run(Object[]) instead");
	}

	@Override
	public void run(Object... options) {
		// expected: {fileSize, bufferSize}	
		Object[] params = (Object[]) options;
		long fileSize = Long.parseLong(params[0].toString()); // e.g. 2-16GB
		int bufferSize = Integer.parseInt(params[1].toString()); // e.g. 4+KB

		core = null;
		try {
			core = new MemoryMapper("D:\\year 2\\sem2\\co\\PROJECT here\\Files\\file.txt", fileSize);
			byte[] buffer = new byte[bufferSize];
			Random rand = new Random();

			Timer timer = new Timer();

			// write to VM
			timer.start();
			for (long i = 0; i < fileSize; i += bufferSize) {
				rand.nextBytes(buffer);
				core.put(i, buffer);
			}
			double speed = ((double)(fileSize/1024/1024) / timer.stop())* 1000000000; /* 3. fileSize/time [MB/s] */

			result = "\nWrote " + (fileSize / 1024 / 1024L)
					+ " MB to virtual memory at " + String.format("%.2f",speed)/* 4. speed, with exactly 2 decimals*/ + " MB/s";

			// read from VM
			timer.start();
			for (long i = 0; i < fileSize; i += bufferSize) {
				core.get(i, bufferSize);
			}
			speed = ((double)(fileSize/1024/1024) / timer.stop())* 1000000000; /* 6. MB/s */

			// append to previous 'result' string
			result += "\nRead " + (fileSize / 1024 / 1024L)
					+ " MB from virtual memory at " + String.format("%.2f",speed)/*7. speed, with exactly 2 decimals*/ + " MB/s";

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (core != null)
				core.purge();
		}
	}

	@Override
	public void clean() {
		if (core != null)
			core.purge();
	}

	@Override
	public void cancel() {

	}

	@Override
	public String getResult() {
		return result;
	}

}

package bench.hdd;

import java.io.IOException;

import bench.IBenchmark;

public class HDDWriteSpeed implements IBenchmark {

	@Override
	public void initialize(Object... params) {
	}

	@Override
	public void warmUp() {
	}

	@Override
	public void run() {
		throw new UnsupportedOperationException(
				"Method not implemented. Use run(Object) instead");
	}

	@Override
	public void run(Object... options) {
		FileWriter writer = new FileWriter();
		// either "fs" - fixed size, or "fb" - fixed buffer
		String option = (String) options[0];
		// true/false whether the written files should be deleted at the end
		Boolean clean = (Boolean) options[1];

		String prefix = "D:\\year 2\\sem2\\co\\PROJECT here\\Files\\write-";
		String suffix = ".dat";
		int minIndex = 0;
		int maxIndex = 8;
		long fileSize = 512*1024*1024;  // 512MB
		int bufferSize = 2*1024; // 2KB
		
		try {
			if (option.equals("fs"))
				writer.streamWriteFixedFileSize(prefix, suffix, minIndex,
						maxIndex, fileSize, clean);
			else if (option.equals("fb"))
				writer.streamWriteFixedBufferSize(prefix, suffix, minIndex,
						maxIndex, bufferSize, clean);
			else
				throw new IllegalArgumentException("Argument "
						+ options[0].toString() + " is undefined");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void clean() {
		// clean temp files here?
	}

	@Override
	public void cancel() {

	}

	public String getResult() {
		return null; // or MBps
	}
}

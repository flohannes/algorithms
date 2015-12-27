import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
 
public class StealingSmall {
 
	private final static int NTHREADS = Runtime.getRuntime().availableProcessors();
 
	private void work(double[] array, int from, int to) {
		for (int j = from; j < to; j++) {
			array[j] = Math.log(j);
		}
	}
 
	class ForEach extends RecursiveAction {
 
		private double[] array;
		private int from;
		private int to;
 
		// you can fine-tune this,
		// should be sth between 100 and 10000
		public final static int TASK_LEN = 5000;
 
		public ForEach(double[] array, int from, int to) {
			this.array = array;
			this.from = from;
			this.to = to;
		}
 
		@Override
		protected void compute() {
			int len = to - from;
			if (len < TASK_LEN) {
				work(array, from, to);
			} else {
				// split work in half, execute sub-tasks asynchronously
				int mid = (from + to) >>> 1;
				new ForEach(array, from, mid).fork();
				new ForEach(array, mid, to).fork();
			}
		}
	}
 
	public void attempt3(final double[] array) {
		ForkJoinPool pool = new ForkJoinPool(NTHREADS);
		// blocks until completion
		pool.invoke(new ForEach(array, 0, array.length));
	}
 
	public void test() {
		final int ROUNDS = 10;
		long seq = 0, a1 = 0, a2 = 0, a3 = 0, t;
	
		double[] array = new double[8388608];
		
		for (int i = 0; i < ROUNDS; i++) {
			t = System.currentTimeMillis();
			work(array, 0, array.length);
			seq += System.currentTimeMillis() - t;
		}
		seq /= ROUNDS;
		print(array);
			
		clear(array);
		for (int i = 0; i < ROUNDS; i++) {
			t = System.currentTimeMillis();
			attempt3(array);
			a3 += System.currentTimeMillis() - t;
		}
		a3 /= ROUNDS;
		print(array);
	
		System.out.println("sequential avg: " + seq + " ms");
		System.out.println("attempt 3 avg: " + a3 + " ms");
	}
	
	private void clear(double[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}
	
	private void print(double[] array) {
		System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, 10)));
	}
 
	public static void main(String[] args) {
		new StealingSmall().test();
	}
}
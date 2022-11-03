import java.util.concurrent.atomic.AtomicLong;

public class testMain {

	public static void main(String args[]) {
		
		AtomicLong knTrxId = new AtomicLong();
		long trxId = knTrxId.incrementAndGet();
		System.out.println(trxId);
		
	}
}

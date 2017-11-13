package com.java8.exam.lambda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class streamExam4Parallel {
	
	public static void main(String args[]) {
	
		/**
		 * stream parellel �� ����Ͽ� ���� ��ġ ó��.
		 * 
		 * http://www.popit.kr/java8-stream%EC%9D%98-parallel-%EC%B2%98%EB%A6%AC/
		 *   >> Stream<String> stream = Files.lines(file)  ������ ���� ���� ó�� ��� X
		 *   >> BATCH ó�� ���.
		 * **/
		int batchSize = 10;
		int taskLineNum = 20;
		// ��Ű�� ��ο� ��ġ�� ���� �б�
		File file = new File("src/main/java/com/java8/exam/lambda/test.txt");
		
		//System.out.println("PATH:"+streamExam4Parallel.class.getClassLoader().getResource("").getPath());
		//System.out.println(file.exists());
		
		/* try(){}  >> 1.7 ���� try syntax , () �ȿ� ����� �ڿ��� finally ���� ��ȯġ �ʾƵ� �ڵ� ��ȯ�ȴ�. */
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
			MultiLineSpliterator spliterator = new MultiLineSpliterator(reader, batchSize, taskLineNum);
		    Stream<List<String>> stream = StreamSupport.stream(spliterator, false);
		    stream.parallel().forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

class MultiLineSpliterator implements Spliterator<List<String>>{

	List<String> lines;
	int lineBuffSize;
	int batchSize;
	BufferedReader reader;
	Iterator<String> it;
	
	public MultiLineSpliterator(BufferedReader reader, int lineBuffSize, int batchSize) {
		// TODO Auto-generated constructor stub
		this.reader = reader;
		this.lineBuffSize = lineBuffSize;
		this.batchSize = batchSize;
		this.lines = new ArrayList<>(lineBuffSize);
	}
	
	/*
	 * ���������� �ݺ��ڸ� üũ�Ͽ� ������ ������ �������Ӱ� �ִ� ��� true ������ false �� ��ȯ�Ѵ�.
	 * */
	@Override
	public boolean tryAdvance(Consumer<? super List<String>> action) {
		// TODO Auto-generated method stub
		if(it == null) {
			it = lines.iterator();
		}
		List<String> batchList = new ArrayList<>(batchSize);
		int count = 0;
		while(it.hasNext()) {
			batchList.add(it.next());
			count++;
			if(count >= batchSize) break;
		}
		action.accept(batchList);
		return it.hasNext();
	}

	
	@Override
	public Spliterator<List<String>> trySplit() {
		// TODO Auto-generated method stub
		try {
			String line;
			while( (line = reader.readLine()) != null) {
				lines.add(line);
				if ( lines.size() >= lineBuffSize ) {
					return new MultiLineSpliterator(reader, lineBuffSize, batchSize);
				}
			}
			if (lines.isEmpty()) {
	        	return null;
	        }
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return null;
	}

	/*
	 * ���ҵ������� ����ġ�� �����մϴ�.
	 * */
	@Override
	public long estimateSize() {
		// TODO Auto-generated method stub
		return lines.isEmpty() ? Long.MAX_VALUE : lines.size();
	}

	/*
	 * ���� spliterator �� Ư�������� ��ȯ�մϴ�.
	 * 
	 * 	   ORDER : ��Һ��� ��, ������ �����ϱ� ������ �����ؼ� �����ϵ��� �մϴ�.
     *     DISTINCT : ��� �� ���� ��(equals)�� ���ٰ� �����մϴ�.
     *     SORTED : Ž���� ��Ҵ� �̸� ���ǵ� ���ļ����� �����ϴ�. 
     *     SIZED : estimateSize �� ��Ȯ�� ������ �� ���� �����մϴ�.
     *     NONNULL : Ž���ϴ� ��� ��Ҵ� null �� �ƴ��� �����մϴ�.
     *     IMMUTABLE : ��Ұ� Ž���Ǵ� ���� �����͸� �߰��ϰų�, ������ �� �����ϴ�.
     *     CONCURRENT : ����ȭ ����, ���� �����尡 �ҽ��� ���ÿ� ������ �� �ֽ��ϴ�.
     *     SUBSIZED : �� Spliterator �� ���� �� ��� Spliterator �� ��� SIZE ���� �����մϴ�.
     *
     *      ��ó: http://doohyun.tistory.com/42 [N`s Lab]
	 * */
	@Override
	public int characteristics() {
		// TODO Auto-generated method stub
		return IMMUTABLE;
	}
	
}

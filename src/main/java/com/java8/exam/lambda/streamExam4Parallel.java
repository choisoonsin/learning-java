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
		 * stream parellel 을 사용하여 파일 배치 처리.
		 * 
		 * http://www.popit.kr/java8-stream%EC%9D%98-parallel-%EC%B2%98%EB%A6%AC/
		 *   >> Stream<String> stream = Files.lines(file)  다음과 같은 한줄 처리 방식 X
		 *   >> BATCH 처리 방식.
		 * **/
		int batchSize = 10;
		int taskLineNum = 20;
		// 패키지 경로에 위치한 파일 읽기
		File file = new File("src/main/java/com/java8/exam/lambda/test.txt");
		
		//System.out.println("PATH:"+streamExam4Parallel.class.getClassLoader().getResource("").getPath());
		//System.out.println(file.exists());
		
		/* try(){}  >> 1.7 도입 try syntax , () 안에 선언된 자원을 finally 에서 반환치 않아도 자동 반환된다. */
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
	 * 순차적으로 반복자를 체크하여 스프릿 사이즈 다음연속가 있는 경우 true 없으면 false 를 반환한다.
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
	 * 분할데이터의 예측치를 리턴합니다.
	 * */
	@Override
	public long estimateSize() {
		// TODO Auto-generated method stub
		return lines.isEmpty() ? Long.MAX_VALUE : lines.size();
	}

	/*
	 * 현재 spliterator 의 특성정보를 반환합니다.
	 * 
	 * 	   ORDER : 요소분할 시, 순서가 존재하기 때문에 유의해서 분할하도록 합니다.
     *     DISTINCT : 요쇼 간 같은 값(equals)은 없다고 보장합니다.
     *     SORTED : 탐색된 요소는 미리 정의된 정렬순서를 따릅니다. 
     *     SIZED : estimateSize 은 정확한 정보를 줄 것을 보장합니다.
     *     NONNULL : 탐색하는 모든 요소는 null 이 아님을 보장합니다.
     *     IMMUTABLE : 요소가 탐색되는 동안 데이터를 추가하거나, 삭제할 수 없습니다.
     *     CONCURRENT : 동기화 없이, 여러 스레드가 소스를 동시에 수정할 수 있습니다.
     *     SUBSIZED : 이 Spliterator 와 분할 된 모든 Spliterator 는 모두 SIZE 임을 보장합니다.
     *
     *      출처: http://doohyun.tistory.com/42 [N`s Lab]
	 * */
	@Override
	public int characteristics() {
		// TODO Auto-generated method stub
		return IMMUTABLE;
	}
	
}

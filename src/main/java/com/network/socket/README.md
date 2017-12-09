## JAVA NETWORK API Programming

 * 블로킹 서버
 
	1. 블로킹 서버 예제를 통해 논블로킹 서버와의 차이점을 알아본다.
	
	* 실행 후 telnet 접속 테스트
	~~~~
	java BlockingServer
	~~~~

	2. 블로킹 스레드 서버 실행 ( 응답까지 10초 대기 )
	
	* 실행 후 ClientForBlockingServer 를 1~2초 간격으로 실행하여 스레드 서버 생성을 확인.
	
	* 핵심코드
	~~~~
	public class BlockingThreadServer {
	
		public static final int PORT = 8888;
		
		public static void main(String[] args)  {
			// TODO Auto-generated method stub
			try(ServerSocket server = new ServerSocket(PORT)){
				while(true){
					try {
						Socket socket = server.accept();
						BlokingServer blockingServer = new BlokingServer(socket);
						blockingServer.start();
					} catch (Exception e) {
					}
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	
	} 
	~~~~
package com.websocket.configuration;

import java.net.URI;
import javax.websocket.*;

@ClientEndpoint
public class WSClient {
	
	
	private static Object waitLock = new Object();

	@OnMessage
	public void onMessage(String message) {
		System.out.println("Received msg: " + message);
	}

	private static void wait4TerminateSignal() {
		synchronized (waitLock) {
			try {
				waitLock.wait();
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) {
		WebSocketContainer container = null;
		Session session = null;
		try {
			container = ContainerProvider.getWebSocketContainer();
			session = container.connectToServer(WSClient.class, URI.create("ws://localhost:8080/DemoService/serveristek"));
			wait4TerminateSignal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
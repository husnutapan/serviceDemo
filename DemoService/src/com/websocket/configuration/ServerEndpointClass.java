package com.websocket.configuration;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.*;
import javax.websocket.*;
import javax.websocket.server.*;

@ServerEndpoint("/serveristek")
public class ServerEndpointClass {
	private static Queue<Session> queue = new ConcurrentLinkedQueue<Session>();
	private static Thread rateThread;

	static {
		rateThread = new Thread() {
			public void run() {
				DecimalFormat df = new DecimalFormat("#.####");
				while (true) {
					double d = 2 + Math.random();
					if (queue != null)
						sendAll("USD Rate: " + df.format(d));
					try {
						sleep(2000);
					} catch (InterruptedException e) {
					}
				}
			};
		};
		rateThread.start();
	}

	@OnMessage
	public void onMessage(Session session, String msg) {
		try {
			System.out.println("received msg " + msg + " from " + session.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnOpen
	public void open(Session session) {
		queue.add(session);
		System.out.println("New session opened: " + session.getId());
	}

	@OnError
	public void error(Session session, Throwable t) {
		queue.remove(session);
		System.err.println("Error on session " + session.getId());
	}

	@OnClose
	public void closedConnection(Session session) {
		queue.remove(session);
		System.out.println("session closed: " + session.getId());
	}

	private static void sendAll(String msg) {
		try {
			ArrayList<Session> closedSessions = new ArrayList<>();
			for (Session session : queue) {
				if (!session.isOpen()) {
					System.err.println("Closed session: " + session.getId());
					closedSessions.add(session);
				} else {
					session.getBasicRemote().sendText(msg);
				}
			}
			queue.removeAll(closedSessions);
			System.out.println("Sending " + msg + " to " + queue.size() + " clients");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}

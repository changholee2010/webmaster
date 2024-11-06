package com.yedam.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/boardsocket")
public class BroadSocket {

	private static List<Session> sessions = Collections.synchronizedList(new ArrayList<>());
	private static Pattern pattern = Pattern.compile("^\\{\\{.*?\\}\\}");

	@OnOpen
	public void handleOpen(Session session) {
		sessions.add(session);
		System.out.println("client is now connected.");
	}

	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {
		System.out.println(message);
		String name = "anonymous";
		Matcher matcher = pattern.matcher(message);

		if (matcher.find()) {
			name = matcher.group();
		}

		final String msg = message.replaceAll(pattern.pattern(), "");
		final String username = name.replaceFirst("^\\{\\{", "").replaceFirst("\\}\\}$", "");

		sessions.forEach(session -> {
			if (session == userSession) {
				return;
			}

			try {
				session.getBasicRemote().sendText(username + " => " + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

	}

	@OnClose
	public void handleClose(Session userSession) {
		sessions.remove(userSession);
		System.out.println("client is now disconnected...");
	}

}

package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class EventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");

		String job = req.getParameter("job");
		System.out.println(job);

		BoardService svc = new BoardServiceImpl();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = "";

		if (job.equals("list")) { // 목록.

			List<Map<String, Object>> list = svc.eventList();
			json = gson.toJson(list);

		} else if (job.equals("add")) { // 등록.
			String title = req.getParameter("title");
			String start = req.getParameter("start");
			String end = req.getParameter("end");

			Map<String, String> map = new HashMap<>();
			map.put("title", title);
			map.put("startDate", start);
			map.put("endDate", end);

			try {
				if (svc.registerEvent(map)) { // {"retCode":"OK"}
					json = "{\"retCode\":\"OK\"}";
				}
			} catch (Exception e) {
				e.printStackTrace();
				json = "{\"retCode\":\"FAIL\"}";
			}

		}
		// 출력.
		resp.getWriter().println(json);

	} // end of exec.

}

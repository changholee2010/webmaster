package com.yedam.control.product;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductServiceImpl;

public class ProductMainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// pmain.do?p=main
		String p = req.getParameter("p");
		String tiles = "";

		p = p == null ? "main" : p;

		// 상품카테고리는 항상 나올 수 있도록 처리를 해줘야한다.
		List<Map<String, String>> list = ProductServiceImpl.getInstance().allCategory();

		if (p.equals("main")) {
			tiles = "hero/pmain.tiles";

		} else if (p.equals("plist")) {
			tiles = "normal/plist.tiles";

		} else if (p.equals("pcart")) {
			tiles = "normal/pcart.tiles";

		}

		// 전달할 속성을 지정.
		req.setAttribute("categoryList", list);

		req.getRequestDispatcher(tiles).forward(req, resp);

	}

}

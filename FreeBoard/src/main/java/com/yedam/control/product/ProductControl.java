package com.yedam.control.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class ProductControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// pmain.do?p=main
		String p = req.getParameter("p");
		String tiles = "";

		if (p.equals("main")) {
			tiles = "hero/pmain.tiles";

		} else if (p.equals("plist")) {
			tiles = "normal/plist.tiles";

		} else if (p.equals("pcart")) {
			tiles = "normal/pcart.tiles";

		}

		req.getRequestDispatcher(tiles).forward(req, resp);

	}

}

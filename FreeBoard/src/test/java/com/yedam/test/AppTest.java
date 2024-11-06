package com.yedam.test;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.service.ProductServiceImpl;

public class AppTest {
	public static void main(String[] args) {

		List<Map<String, String>> result = ProductServiceImpl.getInstance().allCategory();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);

		System.out.println(json);

	}
}

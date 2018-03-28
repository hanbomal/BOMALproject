package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chatcontroller")
public class ChatController {

	@RequestMapping("/intro")
	public String intro(HttpServletRequest req, HttpServletResponse res) throws Throwable {

		return "chat/websocketGroup";

	}

}

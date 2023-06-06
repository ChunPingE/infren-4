package hello.springmvc.basic.response;

import java.io.*;

import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import hello.springmvc.basic.*;
import jakarta.servlet.http.*;
import lombok.extern.slf4j.*;

@Slf4j
@Controller
//@RestController
public class ResponseBodyController {
	@GetMapping("/response-body-string-v1")
	public void responseBodyV1(HttpServletResponse response) throws IOException {
		response.getWriter().write("ok");
	}

	/**
	* HttpEntity, ResponseEntity(Http Status 추가)
	* @return
	*/
	@GetMapping("/response-body-string-v2")
	public ResponseEntity<String> responseBodyV2() {
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping("/response-body-string-v3")
	public String responseBodyV3() {
		return "ok";
	}

	@GetMapping("/response-body-json-v1")
	public ResponseEntity<HelloData> responseBodyJsonV1() {
		HelloData helloData = new HelloData();
		helloData.setUsername("userA");
		helloData.setAge(20);
		return new ResponseEntity<>(helloData, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@GetMapping("/response-body-json-v2")
	public HelloData responseBodyJsonV2() {
		HelloData helloData = new HelloData();
		helloData.setUsername("userA");
		helloData.setAge(20);
		return helloData;
	}
}
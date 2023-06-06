package hello.springmvc.basic.request;

import java.util.*;

import org.springframework.http.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.*;
import lombok.extern.slf4j.*;

@Slf4j
@RestController
public class RequestHeaderController {
	@RequestMapping("/headers")
	public String headers(HttpServletRequest request,
			HttpServletResponse response,
			HttpMethod httpMethod,
			Locale locale,
			@RequestHeader MultiValueMap<String, String> headerMap,
			@RequestHeader("host") String host,
			@CookieValue(value = "myCookie", required = false) String cookie) {
		log.info("request={}", request);
		log.info("response={}", response);
		log.info("httpMethod={}", httpMethod);
		log.info("locale={}", locale);
		log.info("headerMap={}", headerMap);
		log.info("header host={}", host);
		log.info("myCookie={}", cookie);
		return "ok";
	}
}
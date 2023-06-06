package hello.springmvc.basic;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.*;

@Slf4j
@RestController
public class LogTestController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping("/log-test")
	public String logTest() {
		String name = "Spring";

		// 여러개 취합해서 보여줌
		log.trace("trace log={}", name);
		// 디버그
		log.debug("debug log={}", name);
		// INFO라고 나오고 실행한 스레드이름 컨트롤러이름 메시지
		log.info(" info log={}", name);
		// 경고?
		log.warn(" warn log={}", name);
		// 에러
		log.error("error log={}", name);
		// 로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행된다. 이런 방식으로 사용하면 X
		log.debug("String concat log=" + name);
		return "ok";
	}
}
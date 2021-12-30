package hello.springmvc.basic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest(){
        String name = "spring";
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        // 운영시스템에서 볼 정보
        log.info("info log={}", name);
        // 알람을 봐야할정도의 정보
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        return "ok";
    }
}

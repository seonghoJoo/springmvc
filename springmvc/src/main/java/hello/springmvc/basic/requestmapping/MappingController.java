package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("userId = {}", data);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        return "ok";
    }

    /**
     *  파라미터로 추가 맵핑
     *  params="mode"
     *  params="!mode"
     *  params="mode=debug"
     *  params="mode!=debug"
     *  params={"mode=debug", "data=good"}
     */

    // 특정 파라미터 조건 매핑
    // localhost:8091/mapping-param?mode=debug
    @GetMapping(value="/mapping-param", params = "mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    /**
     *  특정헤더로 추가 맵핑
     *  headers="mode"
     *  headers="!mode"
     *  headers="mode=debug"
     *  headers="mode!=debug"
     *  headers={"mode=debug", "data=good"}
     */

    // 특정 파라미터 조건 매핑
    // localhost:8091/mapping-param?mode=debug
    @GetMapping(value="/mapping-header", headers = "mode=debug")
    public String mappingHeader(){
        log.info("mappingheader");
        return "ok";
    }
}

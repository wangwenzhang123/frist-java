package com.ai.ge.controller.demo;

import com.ai.ge.controller.BaseController;
import com.ai.ge.service.common.CommonService;
import com.ai.ge.service.demo.DemoTableService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;

/**
 * @author jiangzd3
 * @version 1.0
 * @note
 * @since 2020/5/27 4:48 下午
 */
@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @Resource
    private CommonService commonService;

    @Resource
    private DemoTableService demoTableService;

    @ResponseBody
    @GetMapping("hello")
    public String hello() {
        return "hello word!";
    }

    @RequestMapping("/main")
    public String index() {
        System.out.println("111");
        return "index";
    }

    @ResponseBody
    @RequestMapping("/qrySysTime")
    public String qrySysTime() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(commonService.getSysTime());
    }

    @ResponseBody
    @RequestMapping("/insertIntoDemoTable/{id}/{name}/{type}")
    public String insertIntoDemoTable(@PathVariable Integer id,@PathVariable String name,@PathVariable int type) {
        return String.valueOf(demoTableService.insert(id,name,type));
    }

    @ResponseBody
    @RequestMapping("/deleteFromDemoTable/{id}")
    public String delete(@PathVariable Integer id) {
        return String.valueOf(demoTableService.deleteById(id));
    }

    @ResponseBody
    @RequestMapping("/qryDemoTableById/{id}")
    public String qryDemoTableById(@PathVariable Integer id) {
        return demoTableService.qryOneById(id).toString();
    }

    @ResponseBody
    @RequestMapping("/qryDemoTableByName/{name}")
    public String qryDemoTableById(@PathVariable String name) {
        return demoTableService.qryListByName(name).toString();
    }
}

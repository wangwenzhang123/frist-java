package com.ai.ge.exception.handler;

import com.ai.ge.constant.Constant;
import com.ai.ge.exception.BusinessException;
import com.ai.ge.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理，跳转到BaseController类中的printException方法
 */
public class ExceptionHandlerResolver extends SimpleMappingExceptionResolver {

    protected Logger logger = LoggerFactory.getLogger(ExceptionHandlerResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception e) {
        //e.printStackTrace();
        logger.error("服务器发生异常......");
        logger.error("异常handler " + handler);
        logger.error("异常信息 " + e.getMessage() + " 异常源 " + e.toString());

        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        String str = sw.toString();
        logger.error("堆栈信息:" + str);

        logger.info("记录异常日志......");

        Map<String,String> result = null;
        if (e instanceof DataException) {
            result = new HashMap<String,String>();
            result.put("code",((DataException) e).getErrorCode());
            result.put("msg",e.getMessage());
        } else if (e instanceof BusinessException)
        {
            result = new HashMap<String,String>();
            result.put("code",((BusinessException) e).getErrorCode());
            result.put("msg",e.getMessage());
        }
        else if (e instanceof SQLException) {
            result = new HashMap<String,String>();
            result.put("code", Constant.OTHER_ERROR_CODE);
            result.put("msg",Constant.OTHER_ERROR_TEXT);
        } else {
            result = new HashMap<String,String>();
            result.put("code", Constant.OTHER_ERROR_CODE);
            result.put("msg",str);//CoreUtils.isEmpty(e.getMessage()) ? String.valueOf(e) : str
        }

        request.setAttribute("result", result);
        return new ModelAndView("forward:/errorPage");
    }
}

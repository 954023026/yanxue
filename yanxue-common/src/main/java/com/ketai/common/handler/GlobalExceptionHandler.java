package com.ketai.common.handler;

import com.fasterxml.jackson.core.JsonParseException;
import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.KetaiException;
import com.ketai.common.util.ExceptionUtil;
import com.ketai.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 统一异常处理类
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        //e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return Result.error();
    }

    //异常处理方法
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public Result error(BadSqlGrammarException e) {
        //e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return Result.setResponseResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Result error(JsonParseException e) {
        //e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return Result.setResponseResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }

    @ExceptionHandler(KetaiException.class)
    @ResponseBody
    public Result error(KetaiException e) {
        //e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().message(e.getMessage()).code(e.getCode());
    }

}
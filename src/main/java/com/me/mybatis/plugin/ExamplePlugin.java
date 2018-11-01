package com.me.mybatis.plugin;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @author OuyangJie
 * @Date 2018/11/1 9:12
 * @Description:
 */
@Intercepts({@Signature(
        type= Executor.class, method = "update", args={MappedStatement.class, Object.class}
)})
public class ExamplePlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("===== update 执行期间，搞点事情 ====");
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }
}

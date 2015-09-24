package com.amos.spring.aop;

import com.amos.spring.annotation.ChooseDataSource;
import com.amos.spring.util.DataSourceKeyHolder;
import com.amos.spring.util.ReflectUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Method;


/**
 * <li>类描述：完成数据源的切换，抽类切面，具体项目继承一下，不需要重写即可使用</li>
 *
 * @author： amos.zhou
 * 2013-8-1 上午11:51:40
 * @since v1.0
 */
@Aspect
public    class ChooseDataSourceAspect {

    protected static final ThreadLocal<String> preDatasourceHolder = new ThreadLocal<String>();


    @Pointcut("@annotation(com.amos.spring.annotation.ChooseDataSource)")
    public void methodWithChooseAnnotation() {

    }


//    /**
//     * 对所有注解有ChooseDataSource的类进行拦截
//     */
//    @Pointcut("cflow(methodWithChooseAnnotation()) && methodWithChooseAnnotation()")
//    public void changeDatasourcePoint() {
//    }


    /**
     * 根据@ChooseDataSource的属性值设置不同的dataSourceKey,以供DynamicDataSource
     */
    @Before("methodWithChooseAnnotation()")
    public void changeDataSourceBeforeMethodExecution(JoinPoint jp) {
        //拿到anotation中配置的数据源
        String resultDS = determineDatasource(jp);
        //没有配置实用默认数据源
        if (resultDS == null) {
            DataSourceKeyHolder.setDataSourceKey(null);
            return;
        }
        preDatasourceHolder.set(DataSourceKeyHolder.getDataSourceKey());
        //将数据源设置到数据源持有者
        DataSourceKeyHolder.setDataSourceKey(resultDS);

    }

    /**
     * <p>创建时间： 2013-8-20 上午9:48:44</p>
     * 如果需要修改获取数据源的逻辑，请重写此方法
     *
     * @param jp
     * @return
     */
    @SuppressWarnings("rawtypes")
    protected String determineDatasource(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Class targetClass = jp.getSignature().getDeclaringType();
        String dataSourceForTargetClass = resolveDataSourceFromClass(targetClass);
        String dataSourceForTargetMethod = resolveDataSourceFromMethod(
                targetClass, methodName);
        String resultDS = determinateDataSource(dataSourceForTargetClass,
                dataSourceForTargetMethod);
        return resultDS;
    }


    /**
     * 方法执行完毕以后，数据源切换回之前的数据源。
     * 比如foo()方法里面调用bar()，但是bar()另外一个数据源，
     * bar()执行时，切换到自己数据源，执行完以后，要切换到foo()所需要的数据源，以供
     * foo()继续执行。
     * <p>创建时间： 2013-8-16 下午4:27:06</p>
     */
    @After("methodWithChooseAnnotation()")
    public void restoreDataSourceAfterMethodExecution() {
        DataSourceKeyHolder.setDataSourceKey(preDatasourceHolder.get());
        preDatasourceHolder.remove();
    }


    /**
     * <li>创建时间： 2013-6-17 下午5:34:13</li> <li>创建人：amos.zhou</li> <li>方法描述 :</li>
     *
     * @param targetClass
     * @param methodName
     * @return
     */
    @SuppressWarnings("rawtypes")
    private String resolveDataSourceFromMethod(Class targetClass,
                                               String methodName) {

        Method m = ReflectUtil.findUniqueMethod(targetClass, methodName);
        if (m != null) {
            ChooseDataSource choDs = m.getAnnotation(ChooseDataSource.class);
            return resolveDataSourcename(choDs);
        }
        return null;
    }

    /**
     * <li>创建时间： 2013-6-17 下午5:06:02</li>
     * <li>创建人：amos.zhou</li>
     * <li>方法描述 : 确定
     * 最终数据源，如果方法上设置有数据源，则以方法上的为准，如果方法上没有设置，则以类上的为准，如果类上没有设置，则使用默认数据源</li>
     *
     * @param classDS
     * @param methodDS
     * @return
     */
    private String determinateDataSource(String classDS, String methodDS) {
//        if (null == classDS && null == methodDS) {
//            return null;
//        }
        // 两者必有一个不为null,如果两者都为Null，也会返回Null
        return methodDS == null ? classDS : methodDS;
    }

    /**
     * <li>创建时间： 2013-6-17 下午4:33:03</li> <li>创建人：amos.zhou</li> <li>方法描述 : 类级别的 @ChooseDataSource
     * 的解析</li>
     *
     * @param targetClass
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private String resolveDataSourceFromClass(Class targetClass) {
        ChooseDataSource classAnnotation = (ChooseDataSource) targetClass
                .getAnnotation(ChooseDataSource.class);
        // 直接为整个类进行设置
        return null != classAnnotation ? resolveDataSourcename(classAnnotation)
                : null;
    }

    /**
     * <li>创建时间： 2013-6-17 下午4:31:42</li> <li>创建人：amos.zhou</li> <li>方法描述 :
     * 组装DataSource的名字</li>
     *
     * @param ds
     * @return
     */
    private String resolveDataSourcename(ChooseDataSource ds) {
        return ds == null ? null : ds.value();
    }

}

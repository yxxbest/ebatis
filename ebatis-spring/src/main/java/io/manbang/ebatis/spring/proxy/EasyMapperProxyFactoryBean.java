package io.manbang.ebatis.spring.proxy;

import io.manbang.ebatis.core.proxy.MapperProxyFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author 章多亮
 * @since 2020/5/29 14:46
 */
public class EasyMapperProxyFactoryBean implements FactoryBean<Object>, BeanClassLoaderAware {
    private final Class<?> mapperInterface;
    private final String clusterRouterName;
    private ClassLoader classLoader;

    public EasyMapperProxyFactoryBean(Class<?> mapperInterface, String clusterRouterName) {
        this.mapperInterface = mapperInterface;
        this.clusterRouterName = clusterRouterName;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public Object getObject() {
        return MapperProxyFactory.getMapperProxy(mapperInterface, classLoader, clusterRouterName);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

package com.ymm.ebatis.spring.proxy;

import com.ymm.ebatis.cluster.ClusterRouter;
import com.ymm.ebatis.proxy.MapperProxyFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author 章多亮
 * @since 2020/5/29 14:46
 */
public class EsMapperProxyFactoryBean implements FactoryBean<Object>, BeanClassLoaderAware {
    private final Class<?> mapperInterface;
    private final ClusterRouter clusterRouter;
    private ClassLoader classLoader;

    public EsMapperProxyFactoryBean(Class<?> mapperInterface, ClusterRouter router) {
        this.mapperInterface = mapperInterface;
        this.clusterRouter = router;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public Object getObject() {
        return MapperProxyFactory.getMapperProxy(mapperInterface, classLoader, clusterRouter);
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
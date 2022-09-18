package com.liufei.mall.seed.config;

import com.github.pagehelper.PageInterceptor;
import com.liufei.mall.seed.core.ProjectConstant;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author liufei
 * @version 1.0.0
 * @description MyBatis配置类
 * @date 2022/9/4
 */
@Configuration
public class MyBatisConfig {


    @Bean("sqlSessionFactoryBean")
    public SqlSessionFactoryBean createSqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.liufei.mall.*.model");

        // 配置分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("pageSizeZero", "true"); // 分页尺寸为0，查询所有记录，不再分页
        properties.setProperty("reeasonable", "true");
        // 分页合理化参数，默认值为false。当该参数设置为 true 时，pageNum<=0 时会查询第一页, pageNum>pages（超过总数时），会查询最后一页。默认false 时，直接根据参数进行查询。
        properties.setProperty("supportMethodsArguments", "true");
        pageInterceptor.setProperties(properties);

        factoryBean.setPlugins(new PageInterceptor[]{pageInterceptor});

        //获取数据源
        // 设置MyBatis 配置文件的路径
        factoryBean.setMapperLocations(resolveMapperLocations());
        return factoryBean;
    }

    public Resource[] resolveMapperLocations() throws IOException {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<String> mapperLocations = new ArrayList<>();
        mapperLocations.add("classpath*:mapper/*.xml");
        mapperLocations.add("classpath*:mapper/v1/*.xml");
        List<Resource> resources = new ArrayList();
        for (String mapperLocation : mapperLocations) {
            Resource[] mappers = resourceResolver.getResources(mapperLocation);
            resources.addAll(Arrays.asList(mappers));
        }
        return resources.toArray(new Resource[resources.size()]);
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("com.liufei.mall.*.dao");

        // 配置统一mapper
        Properties properties = new Properties();
        properties.setProperty("mappers", ProjectConstant.MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "false");
        properties.setProperty("INENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }

}

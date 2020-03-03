package com.haizhi.template.config.database;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;
import java.util.List;

/**
 * Create by liuyu
 * Date is 2020-03-03
 * Description is : 手动配置mysql数据源，自动配置的话多数据源不能适配mysql-plus
 */

@Slf4j
//@Configuration
@EnableConfigurationProperties(MybatisPlusProperties.class)
@MapperScan(basePackages = "com.haizhi.template.mapper.mysql", sqlSessionTemplateRef = "mysqlSqlSessionTemplate")
public class MysqlDataBaseAccess {

    @Bean("mysqlMPConfig")
    public MybatisPlusAutoConfiguration config(MybatisPlusProperties properties,
                                               ObjectProvider<Interceptor[]> interceptorsProvider,
                                               ObjectProvider<TypeHandler[]> typeHandlersProvider,
                                               ObjectProvider<LanguageDriver[]> languageDriversProvider,
                                               ResourceLoader resourceLoader,
                                               ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                                               ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
                                               ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider,
                                               ApplicationContext applicationContext) {
        properties.setMapperLocations(new String[]{"classpath:mybatis/mysql/**/*.xml"});
        return new MybatisPlusAutoConfiguration(properties, interceptorsProvider, typeHandlersProvider, languageDriversProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider, mybatisPlusPropertiesCustomizerProvider, applicationContext);
    }

    @Bean("mysqlDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource setDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("mysqlSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("mysqlDatasource") DataSource dataSource,
                                                  @Qualifier("mysqlMPConfig") MybatisPlusAutoConfiguration mpConfig) throws Exception {
        return mpConfig.sqlSessionFactory(dataSource);
    }

    @Bean("mysqlSqlSessionTemplate")
    public SqlSessionTemplate setTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory,
                                          @Qualifier("mysqlMPConfig") MybatisPlusAutoConfiguration mpConfig) {
        return mpConfig.sqlSessionTemplate(sqlSessionFactory);
    }

}

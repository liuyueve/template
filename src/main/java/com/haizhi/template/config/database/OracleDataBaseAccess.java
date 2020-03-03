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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;
import java.util.List;

/**
 * Create by liuyu
 * Date is 2020-03-03
 * Description is : 手动配置oracle数据源，自动配置的话多数据源不能适配mysql-plus
 */

@Slf4j
//@Configuration
@MapperScan(basePackages = "com.haizhi.template.mapper.oracle", sqlSessionTemplateRef = "oracleSqlSessionTemplate")
public class OracleDataBaseAccess {

    @Bean("oracleMPConfig")
    public MybatisPlusAutoConfiguration config(MybatisPlusProperties properties,
                                               ObjectProvider<Interceptor[]> interceptorsProvider,
                                               ObjectProvider<TypeHandler[]> typeHandlersProvider,
                                               ObjectProvider<LanguageDriver[]> languageDriversProvider,
                                               ResourceLoader resourceLoader,
                                               ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                                               ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
                                               ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider,
                                               ApplicationContext applicationContext) {
        properties.setMapperLocations(new String[]{"classpath:mybatis/oracle/**/*.xml"});
        return new MybatisPlusAutoConfiguration(properties, interceptorsProvider, typeHandlersProvider, languageDriversProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider, mybatisPlusPropertiesCustomizerProvider, applicationContext);
    }

    @Bean("oracleDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource setDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("oracleSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("oracleDatasource") DataSource dataSource,
                                                  @Qualifier("oracleMPConfig") MybatisPlusAutoConfiguration mpConfig) throws Exception {
        return mpConfig.sqlSessionFactory(dataSource);
    }

    @Bean("oracleSqlSessionTemplate")
    public SqlSessionTemplate setTemplate(@Qualifier("oracleSqlSessionFactory") SqlSessionFactory sqlSessionFactory,
                                          @Qualifier("oracleMPConfig") MybatisPlusAutoConfiguration mpConfig) {
        return mpConfig.sqlSessionTemplate(sqlSessionFactory);
    }

}

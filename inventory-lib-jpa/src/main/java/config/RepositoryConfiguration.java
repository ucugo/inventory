package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import web.CurrentRequestInterceptor;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by Ugo on 18/04/2015.
 */

@EnableTransactionManagement
@Configuration
public class RepositoryConfiguration {

    @Autowired private DataSource dataSource;
    @Bean
    public EntityManagerFactory entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        final LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(vendorAdapter);
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("repositories","domain");
        bean.afterPropertiesSet();
        return bean.getObject();
    }


    @Bean
    public AbstractPlatformTransactionManager transactionManager() throws NamingException{
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        transactionManager.setPersistenceUnitName("inventory");
        return transactionManager;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.getJpaPropertyMap().put("database","MYSQL");
        adapter.getJpaPropertyMap().put("generateDdl","true");
        adapter.getJpaPropertyMap().put("showSql","true");
        return adapter;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator(){
        HibernateExceptionTranslator hibernateExceptionTranslator = new HibernateExceptionTranslator();
        return hibernateExceptionTranslator;
    }

    @Bean
    public CurrentRequestInterceptor currentRequestInterceptor(){
        return new CurrentRequestInterceptor();
    }
}

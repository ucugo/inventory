package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by Ugo on 22/04/2015.
 */
@Configuration
public class ApplicationDataSourceConfig {

    @Bean
    public DataSource dataSource(){
        LazyConnectionDataSourceProxy lazyConnectionDataSourceProxy = new LazyConnectionDataSourceProxy();
        Context ctx = null;
        try {
            ctx = new InitialContext();
            lazyConnectionDataSourceProxy.setTargetDataSource((DataSource) ctx.lookup("java:comp/env/jdbc/inventory"));
        } catch (NamingException e) {
            e.printStackTrace();
        }


        return lazyConnectionDataSourceProxy;
//        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//        dsLookup.setResourceRef(true);
//        DataSource dataSource = dsLookup.getDataSource("java:comp/env/jdbc/inventory");
//        return dataSource;
    }

}

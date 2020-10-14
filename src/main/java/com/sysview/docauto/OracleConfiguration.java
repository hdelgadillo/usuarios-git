package com.sysview.docauto;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
public class OracleConfiguration{
	
    @Bean(name="dataSource")
    public OracleDataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setURL("jdbc:oracle:thin:@//192.168.1.112:1521/orcl");
        dataSource.setUser("C##_DAPRESENTACIONES12");
        dataSource.setPassword("sysview12");
        return dataSource;
    }
    
    @Bean
	public InternalResourceViewResolver viewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setViewClass(JstlView.class);
	    viewResolver.setPrefix("/WEB-INF/pages/");
	    viewResolver.setSuffix(".html");
	    return viewResolver;
	}
}


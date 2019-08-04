package com.healthq.core.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.healthq.core") 
public class HealthQCoreAutoConfiguration {
	final static Logger logger = LoggerFactory.getLogger(HealthQCoreAutoConfiguration.class);

	@Autowired Environment environment;

	private static final String PROP_NAME_DS_DRIVER     = "healthq.datasource.driver";
	private static final String PROP_NAME_DS_PASS       = "healthq.datasource.password"; 
	private static final String PROP_NAME_DS_URL        = "healthq.datasource.url";
	private static final String PROP_NAME_DS_USER       = "healthq.datasource.username";
	private static final String PROP_NAME_DS_TEST_QUERY = "healthq.datasource.testquery";
	private static final String PROP_NAME_DS_POOL_MAX   = "healthq.datasource.pool.max";
	private static final String PROP_NAME_DS_POOL_MIN   = "healthq.datasource.pool.min";

	private static final String DEFAULT_TEST_QUERY = "SELECT 1 FROM DUAL";
	private static final String DEFAULT_POOL_MAX = "1";
	private static final String DEFAULT_POOL_MIN_IDLE = "1";

	private String getEnvOrDefault(Environment env, String name, String defaultVal) {
		return env.getProperty(name) != null ? env.getProperty(name) : defaultVal;
	}

    @Bean(destroyMethod = "close")
    DataSource dataSource(Environment env) {
        logger.info("Running in environment profile " + getActiveProfiles());
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setPoolName("HealthQCoreDBPool");
        dataSourceConfig.setMinimumIdle(Integer.parseInt(getEnvOrDefault(env, PROP_NAME_DS_POOL_MIN, DEFAULT_POOL_MIN_IDLE)));
        dataSourceConfig.setMaximumPoolSize(Integer.parseInt(getEnvOrDefault(env, PROP_NAME_DS_POOL_MAX, DEFAULT_POOL_MAX)));
        dataSourceConfig.setDriverClassName(env.getRequiredProperty(PROP_NAME_DS_DRIVER));
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty(PROP_NAME_DS_URL));
        dataSourceConfig.setUsername(env.getRequiredProperty(PROP_NAME_DS_USER));
        dataSourceConfig.setPassword(env.getRequiredProperty(PROP_NAME_DS_PASS));
        dataSourceConfig.setConnectionTestQuery(getEnvOrDefault(env, PROP_NAME_DS_TEST_QUERY, DEFAULT_TEST_QUERY));
        return new HikariDataSource(dataSourceConfig);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate template = new JdbcTemplate(dataSource);
        return template;
    }

    @Bean
    @Autowired
    DataSourceTransactionManager transactionManager(DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

	public String getActiveProfiles() {
		String profiles = "";
		for (final String profileName : this.environment.getActiveProfiles()) {
			profiles = profiles.concat(profileName + ", ");
		}
		return (profiles.length() > 0) ? profiles.replaceAll(", $",  "") : "default";
	}
}

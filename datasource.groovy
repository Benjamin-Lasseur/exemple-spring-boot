import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@Configuration
@Grab(group='org.mariadb.jdbc', module='mariadb-java-client', version='1.1.7')
class DataSourceConfig {
@Bean
public DataSource dataSource() {
DriverManagerDataSource dataSource = new DriverManagerDataSource();
dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
dataSource.setUrl("jdbc:mysql://localhost:3306/sirhpaie");
dataSource.setUsername("root");
dataSource.setPassword("");
return dataSource;
}
}
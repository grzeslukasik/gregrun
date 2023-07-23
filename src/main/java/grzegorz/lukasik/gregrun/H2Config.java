package grzegorz.lukasik.gregrun;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class H2Config {
    @Bean
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp");
    }
}

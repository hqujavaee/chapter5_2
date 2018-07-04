package cn.edu.hqu.javaee.chapter5_2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration

public class JdbcSecurityConfig {
	@Autowired
	private DataSource ds;
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManger=new JdbcUserDetailsManager();
		jdbcUserDetailsManger.setDataSource(ds);
		//jdbcUserDetailsManger.setGroupAuthoritiesByUsernameQuery("select g.id, g.group_name, ga.authority from  groups g, group_members gm, group_authorities ga  where gm.username = ? and g.id = ga.group_id and g.id = gm.group_id");
		jdbcUserDetailsManger.setUsersByUsernameQuery("select username, password, enabled from users where username=?"); 
		return jdbcUserDetailsManger;
	}

}

//package tn.esprit.pi.configurations;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.DelegatingFilterProxy;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	 @Override
//	    protected void configure(final HttpSecurity http) throws Exception {
//	        http
//	                .csrf().disable()
//	                .authorizeRequests()
//	                .antMatchers("/login*").permitAll()
//	                .anyRequest().authenticated()
//	                .and()
//	                .formLogin()
//	                .loginPage("/login.html")
//	                .defaultSuccessUrl("/landingPage.html", true);
//	    }
//
//	    @Configuration
//	    public class SecSecurityConfig {
//	        public SecSecurityConfig() {
//	            super();
//	        }
//	    }
//
//	    public class AppInitializer implements WebApplicationInitializer {
//
//	        @Override
//	        public void onStartup(ServletContext sc) {
//
//	            AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
//	            root.register(SecSecurityConfig.class);
//
//	            sc.addListener(new ContextLoaderListener(root));
//
//	            sc.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
//	                    .addMappingForUrlPatterns(null, false, "/*");
//	        }
//	    }
//
//	    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//	        auth.inMemoryAuthentication()
//	                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//	                .and()
//	                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//	                .and()
//	                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//	    }
//
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//}

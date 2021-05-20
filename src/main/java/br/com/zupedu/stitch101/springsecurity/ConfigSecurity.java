package br.com.zupedu.stitch101.springsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // dsl -> domain specific language
        // builder
        http
                .authorizeRequests() //iniciando o processo de autorização
                .antMatchers("/images/**", "/time").permitAll() //essas urls são públicas
                .anyRequest() // para qualquer outa requisição
                .authenticated() // devemos estar autenticado
                .and() // caso não esteja logado
                .formLogin(); // redirecione para o login;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("stitch")
                .password("{noop}lilo")
                .roles("USER");
        auth.inMemoryAuthentication().withUser("lilo").password("{noop}stitch").roles("ADMIN");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {


        web
                .ignoring()
                .antMatchers("/images/**");
    }
}

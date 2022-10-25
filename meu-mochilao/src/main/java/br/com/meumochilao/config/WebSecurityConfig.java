package br.com.meumochilao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.meumochilao.servicos.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	//Pede login e senha pra entrar
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/adminlte/**").permitAll().antMatchers("/img/**").permitAll() //se for colocar a api nesse projeto precisa colocar .antMatchers("caminho").permitAll() 
				.antMatchers("/js/**").permitAll().antMatchers("/plugins/**").permitAll().anyRequest().authenticated();
		// .antMatchers("/**/cadastrar").hasAuthority(Perfil.ADMIN.toString())
		// .antMatchers("/**/editar").hasAuthority(Perfil.ADMIN.toString())
		// .antMatchers("/**/excluir").hasAuthority(Perfil.ADMIN.toString())

        http.formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/clientes")
        .permitAll();

    http.logout()
        .logoutRequestMatcher(
            new AntPathRequestMatcher("/logout", "GET") //diz a rota e o padrao que vai usar. O correto seira usar POST, mas aqui ele é só um botão de link
        )
        .logoutSuccessUrl("/login");

    http.rememberMe()
        .key("chaverememberMe");

		// http.rememberMe().key("chaverememberMe");

	}


	// desabilita o spring security (libera tudo)

	 //@Override
	 //   protected void configure(HttpSecurity httpSecurity) throws Exception {
	 //       httpSecurity.authorizeRequests().antMatchers("/").permitAll();
	  //  }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
	}

}

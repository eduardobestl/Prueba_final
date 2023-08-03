package cl.lemagnifique.restaurant.web.security;

import awakelab.g6.grupal.model.persistence.repository.AdministrativoRepository;
import awakelab.g6.grupal.model.persistence.repository.ClienteRepository;
import awakelab.g6.grupal.model.persistence.repository.ProfesionalRepository;
import awakelab.g6.grupal.model.persistence.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final UsuarioRepository repository;
  private final ClienteRepository repositoryCliente;
  private final AdministrativoRepository repositoryAdministrativo;
  private final ProfesionalRepository repositoryProfesional;

  public SecurityConfig(UsuarioRepository repository, ClienteRepository repositoryCliente,
                        AdministrativoRepository repositoryAdministrativo,
                        ProfesionalRepository repositoryProfesional) {
    this.repository = repository;
    this.repositoryCliente = repositoryCliente;
    this.repositoryAdministrativo = repositoryAdministrativo;
    this.repositoryProfesional = repositoryProfesional;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
    http.authorizeRequests()
            .requestMatchers("/capacitacion/**").hasAuthority("CLIENTE")
            .requestMatchers("/contacto/**").hasAuthority("CLIENTE")
            .requestMatchers("/usuario/**").hasAuthority("ADMINISTRATIVO")
            .requestMatchers("/cliente/**").hasAuthority("ADMINISTRATIVO")
            .requestMatchers("/profesional/**").hasAuthority("ADMINISTRATIVO")
            .requestMatchers("/administrativo/**").hasAuthority("ADMINISTRATIVO")
            .requestMatchers("/pago/**").hasAuthority("ADMINISTRATIVO")
            .requestMatchers("/visita").hasAuthority("PROFESIONAL")
            .requestMatchers("/chequeo").hasAuthority("PROFESIONAL")
            .requestMatchers("/api/cliente").hasAuthority("ADMINISTRATIVO")
            .and().httpBasic(Customizer.withDefaults())
            .formLogin().and().logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true)
            .deleteCookies("JSESSIONID");
    return http.build();
  }
  @Bean
  public PasswordEncoder encoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService(){
    return new UsuarioDetailsServiceImpl(repository, repositoryCliente,
            repositoryAdministrativo,repositoryProfesional);
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(encoder());
    return authProvider;
  }

  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.authenticationProvider(authenticationProvider());
  }

}

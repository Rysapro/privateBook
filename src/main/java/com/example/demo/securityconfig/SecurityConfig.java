//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        // Доступ к редактированию и добавлению данных только для администратора
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .formLogin()  // Стандартная форма логина
//                .and()
//                .logout()  // Стандартная форма выхода из системы
//                .permitAll();
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        // Создание администратора с ролью ADMIN
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("password")  // Задай свой пароль
//                .roles("ADMIN")
//                .build();
//
//        // В данном примере используется InMemoryUserDetailsManager (данные в памяти)
//        return new InMemoryUserDetailsManager(admin);
//    }
//}

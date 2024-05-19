package com.jk.saraApi.config;

import com.jk.saraApi.jwt.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtUtil jwtUtil;

    public SecurityConfig(AuthenticationConfiguration authenticationConfiguration, JwtUtil jwtUtil) {
        this.authenticationConfiguration = authenticationConfiguration;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        //csrf disable
//        http
//                .csrf((auth) -> auth.disable());
//        //From 로그인 방식 disable
//        http
//                .formLogin((auth) -> auth.disable());
//        //http basic 인증 방식 disable
//        http
//                .httpBasic((auth) -> auth.disable());
//
//        http.
//                authorizeRequests()
//                        .antMatchers("/main/", "/user/join").permitAll()
//                        .antMatchers("/admin").hasRole("ADMIN")
//                        .anyRequest().authenticated();
//
////        http
////                .formLogin()
////                    .loginPage("/login")
////                    .loginProcessingUrl("/loginProc")
////                    .permitAll();
//
//        http
//                .addFilterBefore(new JwtFilter(jwtUtil), LoginFilter.class);
//
//        http
//                .addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil), UsernamePasswordAuthenticationFilter.class);
//
//        http
//                .sessionManagement((session) -> session
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        // 테스트용 - 토큰이 없어도 테스트 가능
//        http.csrf().disable();
//
//        return http.build();
//    }
}
package com.example.demo.filter;

import com.example.demo.entity.JwtUser;
import com.example.demo.entity.LoginUser;
import com.example.demo.utils.JwtTokenUtils;
import com.example.demo.utils.ResultMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

// 用户验证
public class JWTAuthenticatonFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTAuthenticatonFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/user/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("开始登陆了！");

        // 从输入流中获取登陆的信息
        try{
            LoginUser loginUser = new ObjectMapper().readValue(request.getInputStream(), LoginUser.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(),
                    loginUser.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();
        // 获取用户Id
        String userId = jwtUser.getId();
        String role = "";
        // 每个用户在某一个时间内只有一个角色
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            role = authority.getAuthority();
        }
        String token = JwtTokenUtils.createToken(jwtUser.getUsername(), role);
        // 返回创建成功的token
        // 按照jwt的规定，最后请求的格式应该是"Bearer token"
        response.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + token);
        response.getWriter().write(mapper.writeValueAsString(ResultMap.setResult("200", new JwtUser(jwtUser.getId(), jwtUser.getUsername(), jwtUser.getAuthorities()),
                "登陆成功！")));
    }

    // 验证失败的回调
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(ResultMap.setResult("1001", null, "用户名或者密码错误！")));
    }
}

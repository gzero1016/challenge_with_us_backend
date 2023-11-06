package com.dogtiger.challus.security.oauth2;

import com.dogtiger.challus.entity.User;
import com.dogtiger.challus.jwt.JwtProvider;
import com.dogtiger.challus.repository.UserMapper;
import com.dogtiger.challus.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final UserMapper userMapper;
    private final JwtProvider jwtProvider;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String oauth2Id = authentication.getName();

        User user = userMapper.findUserByOauth2Id(oauth2Id);

        if(user == null) {
            DefaultOAuth2User defaultOAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
            //String provider = defaultOAuth2User.getAttributes().get("provider").toString();

            //회원가입이 안되었을 때 OAuth2 계정 회원가입 페이지로 이동
            response.sendRedirect("http://localhost:3000/auth/signup" +
                    "?oauth2Id=" + oauth2Id);
            return;
        }

        PrincipalUser principalUser = new PrincipalUser(user);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(principalUser, null, principalUser.getAuthorities());

        String accessToken = jwtProvider.generateToken(authenticationToken);
        response.sendRedirect("http://localhost:3000/" +
                "?token=" + URLEncoder.encode(accessToken, "UTF-8"));
    }
}
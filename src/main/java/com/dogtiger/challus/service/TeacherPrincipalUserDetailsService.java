//package com.dogtiger.challus.service;
//
//import com.dogtiger.challus.entity.User;
//import com.dogtiger.challus.repository.UserMapper;
//import com.dogtiger.challus.security.PrincipalUser;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//@RequiredArgsConstructor
//public class TeacherPrincipalUserDetailsService implements UserDetailsService, OAuth2UserService {
//
//    private final UserMapper userMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userMapper.findUserByEmail(email);
//
//        if(user == null) {
//            throw new UsernameNotFoundException("UsernameNotFound");
//        }
//
//        return new PrincipalUser(user);
//    }
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        System.out.println("클라이언트 정보: " + userRequest.getClientRegistration());
//
//        OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();
//        OAuth2User oAuth2User = oAuth2UserService.loadUser(userRequest);
//
//        Map<String, Object> attributes = new HashMap<>();
//
//        switch (userRequest.getClientRegistration().getClientName()) {
//            case "Naver":
//                Map<String, Object> response = (Map<String, Object>) oAuth2User.getAttributes().get("response");
//                attributes.putAll(response);
//                break;
//            case "Kakao":
//                attributes.putAll(oAuth2User.getAttributes());
//                break;
//        }
//
//        attributes.put("provider", userRequest.getClientRegistration().getClientName());
//
//        return new PrincipalUser(null, attributes, "id");
//    }
//}
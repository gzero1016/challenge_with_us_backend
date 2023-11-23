//package com.dogtiger.challus.security;
//
//import com.dogtiger.challus.entity.User;
//import lombok.Getter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//public class TeacherPrincipalUser implements UserDetails, OAuth2User {
//    @Getter
//    private User user;
//    private Map<String, Object> attributes;
//    private String nameAttributeKey;
//
//    public TeacherPrincipalUser(User user) {
//        this.user = user;
//        this.attributes = new HashMap<>();
//        this.nameAttributeKey = "";
//    }
//
//    public TeacherPrincipalUser(User user, Map<String, Object> attributes, String nameAttributeKey) {
//        this.user = user;
//        this.attributes = attributes;
//        this.nameAttributeKey = nameAttributeKey;
//    }
//
//    @Override
//    public Map<String, Object> getAttributes() {
//        return attributes;
//    }
//
//    @Override
//    public String getName() {
//        return attributes.get(nameAttributeKey).toString();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        if(user == null) {
//            return null;
//        }
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        if(user == null) {
//            return null;
//        }
//        return user.getEmail();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}

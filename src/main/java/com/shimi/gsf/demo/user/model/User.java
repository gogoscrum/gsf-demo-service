package com.shimi.gsf.demo.user.model;

import com.shimi.gsf.demo.common.entity.BaseDemoEntity;
import com.shimi.gsf.demo.user.dto.UserDto;
import jakarta.persistence.Entity;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serial;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends BaseDemoEntity implements com.shimi.gsf.core.model.User {
    @Serial
    private static final long serialVersionUID = -2322205969864150058L;

    private String username;
    private String nickname;
    private String password;
    private String avatarUrl;
    private boolean enabled = true;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    @Override
    public UserDto toDto() {
        return this.toDto(false);
    }

    @Override
    public UserDto toDto(boolean detailed) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(this, dto, "password");
        return dto;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return authorities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return username.equals(user.username) && nickname.equals(user.nickname);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + nickname.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

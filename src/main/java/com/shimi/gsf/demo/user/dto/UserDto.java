package com.shimi.gsf.demo.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.shimi.gsf.demo.common.dto.BaseDemoDto;
import com.shimi.gsf.demo.user.model.User;
import org.springframework.beans.BeanUtils;

import java.io.Serial;

public class UserDto extends BaseDemoDto implements com.shimi.gsf.core.dto.UserDto {
    @Serial
    private static final long serialVersionUID = -5842231722816716788L;

    private String nickname;
    private String username;
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    private String avatarUrl;
    @JsonProperty(access = Access.WRITE_ONLY)
    private boolean enabled = true;

    public UserDto() {
    }

    public UserDto(Long id) {
        this.id = id;
    }

    @Override
    public User toEntity() {
        User entity = new User();
        BeanUtils.copyProperties(this, entity);
        return entity;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}

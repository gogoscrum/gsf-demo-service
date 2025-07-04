package com.shimi.gsf.demo.common.service;

import com.shimi.gsf.core.model.BaseFilter;
import com.shimi.gsf.core.model.TraceableEntity;
import com.shimi.gsf.core.service.GeneralServiceImpl;
import com.shimi.gsf.demo.user.model.User;

public abstract class BaseDemoServiceImpl<T extends TraceableEntity, K extends BaseFilter> extends GeneralServiceImpl<T, K> {
    @Override
    protected User getCurrentUser() {
        com.shimi.gsf.core.model.User user = super.getCurrentUser();
        return user != null ? (User) user : null;
    }
}

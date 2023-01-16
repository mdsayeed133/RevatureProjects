package com.revature.utils;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestSession {

    private HttpSession session;

    @Autowired
    public RequestSession(HttpSession session) {
        this.session = session;
    }

    public void setAttribute(String key, Object value) {
        session.setAttribute(key, value);
    }

    public Object getAttribute(String key) {
        return session.getAttribute(key);
    }
}

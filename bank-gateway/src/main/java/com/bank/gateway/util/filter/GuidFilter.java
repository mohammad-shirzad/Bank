package com.bank.gateway.util.filter;

import com.bank.gateway.util.DiagnosticKeyUtils;
import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

public class GuidFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uuid = UUID.randomUUID().toString();
        DiagnosticKeyUtils.setDiagKey(uuid);
        MDC.put("diagKey", uuid);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

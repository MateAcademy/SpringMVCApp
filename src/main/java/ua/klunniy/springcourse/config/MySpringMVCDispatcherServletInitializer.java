package ua.klunniy.springcourse.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Serhii Klunniy
 */
public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

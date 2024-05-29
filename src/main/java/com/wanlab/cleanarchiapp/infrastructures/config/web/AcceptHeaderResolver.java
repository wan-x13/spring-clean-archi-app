package com.wanlab.cleanarchiapp.infrastructures.config.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNullApi;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


@Configuration
public class AcceptHeaderResolver extends AcceptHeaderLocaleResolver {

    List<Locale> LOCALES = Arrays.asList(new Locale("en"), new Locale("fr"),new Locale("pt-BR"));

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        System.out.println(headerLang);
        return headerLang == null || headerLang.isEmpty()
                ? Locale.getDefault()
                : Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
    }
}

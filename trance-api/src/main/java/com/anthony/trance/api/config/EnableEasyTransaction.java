package com.anthony.trance.api.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author BG343891
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EasyTransactionTrrigerConfiguration.class)
public @interface EnableEasyTransaction {

}

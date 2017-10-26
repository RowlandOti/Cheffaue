package com.rowland.cheffaue.detailfeature.di;

/**
 * Created by Rowland on 10/26/2017.
 */

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface RecipeDetailScope {}


package ir.arashjahani.marketplace.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created By ArashJahani on 05
 */

//is used to distinguish between objects of the same type but with different instances

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {

}

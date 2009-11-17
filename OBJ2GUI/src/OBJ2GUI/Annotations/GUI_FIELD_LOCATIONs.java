package OBJ2GUI.Annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface GUI_FIELD_LOCATIONs {
	GUI_FIELD_LOCATION[] value();
}


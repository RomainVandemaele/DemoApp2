package be.bf.android.demoapp.models;

import java.lang.reflect.Field;
import java.util.function.BiFunction;

public enum ValidatorResolver {

    MIN_LENGTH(MinLength.class, ValidatorResolver::minLength),
    REQUIRED(Required.class,ValidatorResolver::required);

    public  Class<?> annotation;
    public BiFunction<Object,Field,Boolean> validator;


    ValidatorResolver(Class<?> annotation, BiFunction<Object, Field, Boolean> validator) {
        this.annotation = annotation;
        this.validator = validator;
    }

    public static BiFunction<Object,Field,Boolean> findByAnnotation(Class<?> annotation) {
        for(ValidatorResolver value : ValidatorResolver.values()) {
            if (value.annotation.equals(annotation) ) {
                return value.validator;
            }
        }
        return null;
    }

    public static boolean minLength(Object src, Field field) {
        try {
            String value = (String) field.get(src);
            MinLength ml = field.getAnnotation(MinLength.class);
            int minLength = ml.size();
            return value!=null && value.length() >= ml.size() ;
        }catch (Exception e) {
            return false;
        }
    }

    public static boolean required(Object src, Field field) {
      try {
            Object value = field.get(src);
            return value!=null && field.getType() == String.class  && !value.equals("");
        }catch (Exception e) {
            return false;
        }
    }

}

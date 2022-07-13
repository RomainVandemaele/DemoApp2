package be.bf.android.demoapp.models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.function.BiFunction;

public interface FormModel {

    @RequiresApi(api = Build.VERSION_CODES.N)
    default public boolean isValid() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                BiFunction<Object,Field,Boolean> resolver = ValidatorResolver.findByAnnotation(annotation.getClass());
                if(!resolver.apply(this,field)) {
                    return false;
                }
            }
        }
        return true;
    }
}

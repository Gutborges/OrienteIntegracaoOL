package integradorol.commons;

import java.lang.reflect.Field;

public class BaseTest {
    protected void mockarAtributoPrivado(Object target, String fieldName, Object value){
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

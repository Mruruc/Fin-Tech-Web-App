
package com.mruruc.authentication;

public class AuthUtils {
    private AuthUtils(){}

    protected static boolean checkForBlankAndEmptyAndNull(String field, Class<? extends RuntimeException> exceptionClass, String message) {
        if (field == null || field.trim().isEmpty()) {
            try {
                // Using reflection to create a new instance of the exception with a custom message
                RuntimeException exceptionInstance = exceptionClass.getDeclaredConstructor(String.class).newInstance(message);
                throw exceptionInstance;
            } catch (ReflectiveOperationException e) {
                // Handle potential reflection exceptions (like NoSuchMethodException, InstantiationException, etc.)
                throw new RuntimeException("Error instantiating exception: " + e.getMessage());
            }
        }
        return true;
    }

}

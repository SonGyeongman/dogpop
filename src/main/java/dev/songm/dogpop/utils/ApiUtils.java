package dev.songm.dogpop.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

public class ApiUtils {

    public static <T> ApiResult<T> success(T response){
        return new ApiResult<>(true, response, null);
    }

    public static ApiResult<?> error(Throwable throwable, HttpStatus status){
        return new ApiResult<>(false, null, new ApiError(throwable, status));
    }

    public static ApiResult<?> error(String message, HttpStatus status){
        return new ApiResult<>(false, null, new ApiError(message, status));
    }

    @ToString
    @Getter
    public static class ApiError {
        private final String message;
        private final int status;

        ApiError(Throwable throwable, HttpStatus status){
            this(throwable.getMessage(), status);
        }

        ApiError(String message, HttpStatus status){
            this.message = message;
            this.status = status.value();
        }
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    @ToString
    public static class ApiResult<T> {
        private final boolean success;
        private final T response;
        private final ApiError error;
    }
}

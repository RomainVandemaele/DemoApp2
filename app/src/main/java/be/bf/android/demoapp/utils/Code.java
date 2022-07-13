package be.bf.android.demoapp.utils;

import lombok.Getter;

public enum Code {

    RESULT_VALIDATED(100),
    RESULT_CANCELLED(101);


    private final int code;

    public final int getCode() {
        return this.code;
    }

    Code(int  code) {
        this.code = code;
    }

}

package com.medilink.backend.ModelDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckConnectionRespons {




    private int value;
    public CheckConnectionRespons(int value) {
        this.value = value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}

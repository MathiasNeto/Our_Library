package com.ourlibrary.project_library.enuns;

import jakarta.persistence.Embeddable;

@Embeddable
public enum EnumGender {
    MASCULINE,
    FEMININE;

    EnumGender() {
    }
}

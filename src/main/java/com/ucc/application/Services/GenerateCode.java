package com.ucc.application.Services;



import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class GenerateCode {

    private String code;

    public String generateRandomCode() {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();

    }


    public GenerateCode() {
    }

    public GenerateCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public GenerateCode code(String code) {
        setCode(code);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GenerateCode)) {
            return false;
        }
        GenerateCode generateCode = (GenerateCode) o;
        return Objects.equals(code, generateCode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public String toString() {
        return "{" +
            " code='" + getCode() + "'" +
            "}";
    }



}

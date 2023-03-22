package com.manokel.dev.tinysensor.validation;

import com.manokel.dev.tinysensor.dto.UserDTO;

public class Validator {
    private Validator() {}

    public static String validate(UserDTO dto) {
        if (dto.getFirstname().equals("")) {
            return "Firstname: Empty";
        }

        // 3 & 32 are indicative. A RegEx can be placed here.
        if ((dto.getFirstname().length()) < 3 || (dto.getFirstname().length() > 32)) {
            return "Firstname: Length";
        }

        if (dto.getLastname().equals("")) {
            return "Lastname: Empty";
        }

        if ((dto.getLastname().length()) < 3 || (dto.getLastname().length() > 32)) {
            return "Lastname: Length";
        }

        // if (userService.isEmailTaken(userDTO.getEmail() {
        // count email instances (0-1)
        // }

        return "";
    }
}

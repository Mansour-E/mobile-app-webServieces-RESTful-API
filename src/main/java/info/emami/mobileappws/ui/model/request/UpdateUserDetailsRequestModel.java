package info.emami.mobileappws.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

    @NotNull(message = "First name cannot be null")
    @Size(min=2 , message = "it should not be less than 2 charakter")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min=2 , message = "it should not be less than 2 charakter")
    private String lastName;

    public @NotNull(message = "First name cannot be null") @Size(min = 2, message = "it should not be less than 2 charakter") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull(message = "First name cannot be null") @Size(min = 2, message = "it should not be less than 2 charakter") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "Last name cannot be null") @Size(min = 2, message = "it should not be less than 2 charakter") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "Last name cannot be null") @Size(min = 2, message = "it should not be less than 2 charakter") String lastName) {
        this.lastName = lastName;
    }
}

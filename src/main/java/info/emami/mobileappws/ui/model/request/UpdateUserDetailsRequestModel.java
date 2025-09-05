package info.emami.mobileappws.ui.model.request;

import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {


    @Size(min=2 , message = "it should not be less than 2 charakter")
    private String firstName;


    @Size(min=2 , message = "it should not be less than 2 charakter")
    private String lastName;

    public  @Size(min = 2, message = "it should not be less than 2 charakter") String getFirstName() {
        return firstName;
    }

    public void setFirstName( @Size(min = 2, message = "it should not be less than 2 charakter") String firstName) {
        this.firstName = firstName;
    }

    public  @Size(min = 2, message = "it should not be less than 2 charakter") String getLastName() {
        return lastName;
    }

    public void setLastName( @Size(min = 2, message = "it should not be less than 2 charakter") String lastName) {
        this.lastName = lastName;
    }
}

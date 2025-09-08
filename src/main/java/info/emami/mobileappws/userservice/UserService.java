package info.emami.mobileappws.userservice;

import info.emami.mobileappws.ui.model.request.UserDetailsRequestModel;
import info.emami.mobileappws.ui.model.response.UserRest;

public interface UserService {

   UserRest createUser(UserDetailsRequestModel userDetails);
}

package edu.uncc.service.currentuser;

import edu.uncc.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}

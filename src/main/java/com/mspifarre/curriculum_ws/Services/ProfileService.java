package com.mspifarre.curriculum_ws.Services;

import com.mspifarre.curriculum_ws.Entities.Profile;
import com.mspifarre.curriculum_ws.Entities.User;
import com.mspifarre.curriculum_ws.Repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;


}

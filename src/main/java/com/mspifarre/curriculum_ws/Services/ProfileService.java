package com.mspifarre.curriculum_ws.Services;

import com.mspifarre.curriculum_ws.Repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

}

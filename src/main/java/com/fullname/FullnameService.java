package com.fullname;

import org.springframework.stereotype.Service;

@Service
public interface FullnameService {
    
    Fullname saveFullName(Fullname fullname);
}

package com.example.backend_cleaningsupplie.observer_pattern;

import com.example.backend_cleaningsupplie.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ObserverService {

    private final AppUserService appUserService;

    public List<ObserverRequest> addObservers() {

        return appUserService.getAppUsers().stream().map(
                observer -> new ObserverRequest(
                        observer.getUsername()

                )
        ).collect(Collectors.toList());
    }
}

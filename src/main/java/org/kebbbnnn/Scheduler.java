package org.kebbbnnn;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class Scheduler {
    @Inject
    CookieService cookieService;

    @Scheduled(every = "1m") // Executes every 1 minute
    void scheduleTask() {
        cookieService.fetchAndStoreCookies();
    }
}


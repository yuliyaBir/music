package be.vdab.muziek;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Component
class ReleaseClient {
    private final Requests requests;

    public ReleaseClient(Requests requests) {
        this.requests = requests;
    }

    Optional<Release> findById(long id) {
        try {
            var response = requests.findById(id);
            var release = new Release(response);
            return Optional.of(release);
        } catch (HttpClientErrorException.NotFound ex) {
            return Optional.empty();
        }
    }
}

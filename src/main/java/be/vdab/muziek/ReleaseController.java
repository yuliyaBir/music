package be.vdab.muziek;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("releases")
public class ReleaseController {
    private final ReleaseClient releaseClient;

    public ReleaseController(ReleaseClient releaseClient) {
        this.releaseClient = releaseClient;
    }
    @GetMapping("{id}")
    Release findById(@PathVariable long id){
        return releaseClient.findById(id).orElseThrow(ReleaseNotFoundException::new);
    }
}

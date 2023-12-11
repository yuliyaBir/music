package be.vdab.muziek;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

interface Requests {
    @GetExchange("{id}")
    ReleaseResponse findById(@PathVariable long id);
}

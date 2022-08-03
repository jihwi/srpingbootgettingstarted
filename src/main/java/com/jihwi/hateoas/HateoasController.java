package com.jihwi.hateoas;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HateoasController {

    @GetMapping("/hateoas")
    public Resource<Hello> hateoas(){
        Hello hello = new Hello();
        hello.setPrefix("Hey,");
        hello.setName("keesun");

        Resource<Hello> helloResource = new Resource<>(hello);
        helloResource.add(linkTo(methodOn(HateoasController.class).hateoas()).withSelfRel());

        return helloResource;
    }
}

package com.mindhub.firstSprint.controllers;

import io.swagger.v3.oas.annotations.Operation; //documenting API endpoints
import io.swagger.v3.oas.annotations.Parameter; //To document the parameters of a method
import io.swagger.v3.oas.annotations.responses.ApiResponse; //To document a specific response that the endpoint can return (line 28 and 29)
import io.swagger.v3.oas.annotations.responses.ApiResponses; //to include multiple @ApiResponse in a single method (line 27)
import org.springframework.web.bind.annotation.GetMapping; //Get requests
import org.springframework.web.bind.annotation.PathVariable; //Binds a URL value to a method parameter
import org.springframework.web.bind.annotation.PostMapping; //handles HTTP requests of type POST
import org.springframework.web.bind.annotation.RequestBody; //Binds the HTTP request body to the method parameter
import org.springframework.web.bind.annotation.RequestParam; //Binds Query parameters to a method parameter
import org.springframework.web.bind.annotation.RequestMapping; //URL prefix for controller
import org.springframework.web.bind.annotation.RestController; //declares that the class methods handle HTTP requests

@RestController
@RequestMapping("/api") //path through "/api"

public class Controllers {
    @GetMapping("/greeting")
    @Operation(summary = "Get Greeting", description = "Returns a greeting message.")
    public String getGreeting() {
        return "Hello, World!";
    }

    @PostMapping("/submit")
    @Operation(summary = "Submit Data", description = "Receives data and returns a confirmation message.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data successfully received."),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid data.")
    })
    public String submitData(@RequestBody String data) {
        return "Data received: " + data;
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Long id) {
        return "User ID: " + id;
    }

    @GetMapping("/search")
    @Operation(summary = "Search", description = "Searches for items based on a query parameter.")
    public String search(
            @RequestParam(name = "query", defaultValue = "")
            @Parameter(description = "Search Query") String query) {
        return "Search results for: " + query;
    }

}

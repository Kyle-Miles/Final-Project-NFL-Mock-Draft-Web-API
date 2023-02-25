package com.promineo.mockdrafts.needs;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/nfldraft/needs")
public class NeedsController {
  
  private NeedsService needsService;
  
  @Autowired
  private NeedsController(NeedsService needsService) {
    super();
    this.needsService = needsService;
  }
  
  @Operation(
      summary = "Return a list of all Needs",
          description = "Returns Needs",
          responses = {
              @ApiResponse(
                  responseCode = "200", 
                  description = "Needs are returned", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Needs.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameter is invalid", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                      responseCode = "403", 
                      description = "The current user is forbidden from this operation", 
                      content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No needs were found with the input criteria", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occured.", 
                  content = @Content(mediaType = "application/json"))
          }
          
       )
  @GetMapping
  public List<Needs> getAllTeams(){
    return needsService.getAllNeeds();
  }
 
 
}

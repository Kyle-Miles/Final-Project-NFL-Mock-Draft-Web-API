package com.promineo.mockdrafts.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.mockdrafts.entity.MockDraft;
import com.promineo.mockdrafts.service.MockDraftService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/nfldraft/mock_draft")
public class MockDraftController {
  
  private MockDraftService mockDraftService;
  
  @Autowired
  private MockDraftController(MockDraftService mockDraftService) {
    super();
    this.mockDraftService = mockDraftService;
  }
  
  @Operation(
      summary = "Create a Mock Draft",
          description = "Creates Mock Drafts",
          responses = {
              @ApiResponse(
                  responseCode = "200", 
                  description = "A Mock Draft is created", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = MockDraft.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameter is invalid", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No Mock Drafts were found with the input criteria", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occured.", 
                  content = @Content(mediaType = "application/json"))
          }
          
       )
  @PostMapping()
  public ResponseEntity<MockDraft> saveMockDraft(@RequestBody MockDraft mockDraft) {
    return new ResponseEntity<MockDraft>(mockDraftService.saveMockDraft(mockDraft),HttpStatus.CREATED);
}
  
  @Operation(
      summary = "Returns a list of Mock Drafts",
          description = "Returns all Mock Drafts",
          responses = {
              @ApiResponse(
                  responseCode = "200", 
                  description = "Mock Drafts are returned", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = MockDraft.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameter is invalid", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No Mock Drafts were found with the input criteria", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occured.", 
                  content = @Content(mediaType = "application/json"))
          }
          
       )
  @GetMapping
  public List<MockDraft> getAllMockDrafts(){
    return mockDraftService.getAllMockDrafts();
  }

}

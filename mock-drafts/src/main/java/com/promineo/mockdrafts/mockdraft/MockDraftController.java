package com.promineo.mockdrafts.mockdraft;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.mockdrafts.player.Player;
import com.promineo.mockdrafts.player.Position;
import com.promineo.mockdrafts.team.Team;
import com.promineo.mockdrafts.team.TeamName;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
                  responseCode = "201", 
                  description = "A Mock Draft is created", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = MockDraft.class))),
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
                      responseCode = "403", 
                      description = "The current user is forbidden from this operation", 
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
  
  @Operation(
		  summary = "Return a Mock Draft",
		      description = "Returns a Mock Draft by id",
		      responses = {
		          @ApiResponse(
		              responseCode = "200", 
		              description = "A Mock Draft is returned", 
		              content = @Content(
		                  mediaType = "application/json", 
		                  schema = @Schema(implementation = Player.class))),
		          @ApiResponse(
		              responseCode = "400", 
		              description = "The request parameter is invalid", 
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404", 
		              description = "No Mock Drafts were found with the input criteria", 
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		                  responseCode = "403", 
		                  description = "The current user is forbidden from this operation", 
		                  content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500", 
		              description = "An unplanned error occured.", 
		              content = @Content(mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "mock_draft_pk", 
		              allowEmptyValue = false, 
		              required = true, 
		              description = "The Mock Draft primary key (i.e., '1')"),
		      }
		      
		   )
		  
	@GetMapping("{mock_draft_pk}")
	public ResponseEntity<MockDraft> getMockDraftById(@PathVariable("mock_draft_pk") int mock_draft_pk) {
	  return new ResponseEntity<MockDraft>(mockDraftService.getMockDraftsById(mock_draft_pk), HttpStatus.OK);
  	}
  
  @Operation(
		  summary = "Update a Mock Draft",
		      description = "Updates a Mock Draft by id",
		      responses = {
		          @ApiResponse(
		              responseCode = "200", 
		              description = "A Mock Draft is updated", 
		              content = @Content(
		                  mediaType = "application/json", 
		                  schema = @Schema(implementation = Player.class))),
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
		              description = "No Mock Drafts were found with the input criteria", 
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500", 
		              description = "An unplanned error occured.", 
		              content = @Content(mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "mock_draft_pk", 
		              allowEmptyValue = false, 
		              required = true, 
		              description = "The Mock Draft primary key (i.e., '1')"),
		      }
		      
		   )
  @PutMapping("{mock_draft_pk}")
  public ResponseEntity<MockDraft> updateMockDraft(@PathVariable("mock_draft_pk") int mock_draft_pk,
    @RequestBody MockDraft mockDraft) {
      return new ResponseEntity<MockDraft>(mockDraftService.updateMockDraft(mockDraft, mock_draft_pk), HttpStatus.OK);
  }

  @Operation(
		  summary = "Delete a Mock Draft",
		      description = "Deletes a Mock Draft by id",
		      responses = {
		          @ApiResponse(
		              responseCode = "200", 
		              description = "A Mock Draft is deleted",  
		              content = @Content(
		                  mediaType = "application/json", 
		                  schema = @Schema(implementation = Player.class))),
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
		              description = "No Mock Drafts were found with the input criteria", 
		              content = @Content(mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500", 
		              description = "An unplanned error occured.", 
		              content = @Content(mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "mock_draft_pk", 
		              allowEmptyValue = false, 
		              required = true, 
		              description = "The Mock Draft primary key (i.e., '1')"),
		      }
		      
		   )
  @DeleteMapping("{mock_draft_pk}")
  public ResponseEntity<String> delete(@PathVariable("mock_draft_pk") int mock_draft_pk) {
    mockDraftService.deleteMockDraft(mock_draft_pk);
    return new ResponseEntity<String>("A Mock Draft is Deleted...", HttpStatus.OK);
  }
  
  @Operation(
	      summary = "Return Mock Drafts by Team",
	      description = "Returns Mock Drafts by Team name",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "A team's mock drafts are returned", 
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = Team.class))),
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
	              description = "No mock drafts were found with the input criteria", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occured.", 
	              content = @Content(mediaType = "application/json"))
	      },
	      parameters = {
	          @Parameter(
	              name = "team_name", 
	              allowEmptyValue = false,
	              required = true,
	              description = "The team name is (i.e., 'CARDINALS')")
	      }
	      
	   ) 
	  @GetMapping("team_name")
	  public ResponseEntity<List<MockDraft>> getMockDraftByTeamName(
	      @RequestParam(required = true) 
	      TeamName team_name) {
	    return new ResponseEntity<List<MockDraft>>(mockDraftService.getMockDraftByTeamName(team_name), HttpStatus.OK);
	     }
  
  @Operation(
	      summary = "Return Mock Drafts by Position",
	      description = "Returns Mock Drafts by position",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "A position's mock drafts are returned", 
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = Team.class))),
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
	              description = "No mock drafts were found with the input criteria", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occured.", 
	              content = @Content(mediaType = "application/json"))
	      },
	      parameters = {
	          @Parameter(
	              name = "position", 
	              allowEmptyValue = false,
	              required = true,
	              description = "The position is (i.e., 'QB')")
	      }
	      
	   ) 
	  @GetMapping("position")
	  public ResponseEntity<List<MockDraft>> getMockDraftByPosition(
	      @RequestParam(required = true) 
	      Position position) {
	    return new ResponseEntity<List<MockDraft>>(mockDraftService.getMockDraftByPosition(position), HttpStatus.OK);
	     }
  
  @Operation(
	      summary = "Return Mock Drafts by Time Published",
	      description = "Returns Mock Drafts by published",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "A published mock drafts are returned", 
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = Team.class))),
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
	              description = "No mock drafts were found with the input criteria", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occured.", 
	              content = @Content(mediaType = "application/json"))
	      },
	      parameters = {
	          @Parameter(
	              name = "published", 
	              allowEmptyValue = false,
	              required = true,
	              description = "The time published is (i.e., '2023-02-19 15:07:04'")
	      }
	      
	   ) 
	  @GetMapping("published")
	  public ResponseEntity<List<MockDraft>> getMockDraftByPublished(
	      @RequestParam(required = true) 
	      String published) {
	  			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	  			LocalDateTime dateTime = LocalDateTime.parse(published,format);
	  		return new ResponseEntity<List<MockDraft>>(mockDraftService.getMockDraftByPublished(dateTime),HttpStatus.OK);
	     }                                                                                                                                                                            

}

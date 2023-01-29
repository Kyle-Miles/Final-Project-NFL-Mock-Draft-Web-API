package com.promineo.mockdrafts.controller;

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
import com.promineo.mockdrafts.entity.Draft;
import com.promineo.mockdrafts.service.DraftService;
import com.promineo.mockdrafts.utils.DraftPick;
import com.promineo.mockdrafts.utils.DraftRound;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/nfldraft/draft")
public class DraftController {
  
  private DraftService draftService;
  @Autowired
  private DraftController(DraftService draftService) {
    super();
    this.draftService = draftService;
  }
  
  @Operation(
      summary = "Create a Draft Pick",
      description = "Create a Draft Pick slot",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A draft pick slot is created", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Draft.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No picks were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      }
      
   )
  @PostMapping()
  public ResponseEntity<Draft> saveDraft(@RequestBody (required = false) Draft draft) {
      return new ResponseEntity<Draft>(draftService.saveDraft(draft),HttpStatus.CREATED);
  }
  @Operation(
      summary = "Return a list of Draft Picks",
      description = "Returns all Draft Picks",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of draft pick slots are returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Draft.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No picks were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      }
      
   )
  @GetMapping
  public List<Draft> getAllPlayers(){
    return draftService.getAllDrafts();
  }
  
  @Operation(
      summary = "Return a list of Draft Picks",
      description = "Returns a list of Draft Picks by round and pick slot",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of draft pick slots are returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Draft.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No picks were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "round", 
              allowEmptyValue = false,
              required = true,
              description = "The round value is (i.e., 'FIRST')"),
          @Parameter(
              name = "pick", 
              allowEmptyValue = false,  
              required = true,
              description = "The pick value is (i.e., 'ONE')")
      }
      
   )

  
  @GetMapping("round_and_pick")
  public ResponseEntity<List <Draft>> getDraftsByRoundAndPick(
      @RequestParam(required = true) 
      DraftRound round,
      @RequestParam(required = true) 
      DraftPick pick) {
    
    return new ResponseEntity<List<Draft>>(draftService.getDraftByRoundAndPick(round, pick), HttpStatus.OK);
  }
  
  @Operation(
      summary = "Return a list of Draft Picks",
      description = "Returns a list of Draft Picks by round",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of draft pick slots are returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Draft.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No picks were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "round", 
              allowEmptyValue = false,
              required = true,
              description = "The round value is (i.e., 'FIRST')")
      }
      
   )
  @GetMapping("round")
  public List<Draft> getDraftsByRound(DraftRound round){
    return draftService.getDraftByRound(round);
  }
  
  @Operation(
      summary = "Return a Draft Pick",
      description = "Returns a Draft Pick by primary key",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A draft pick slot is returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Draft.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No picks were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "draft_pk", 
              allowEmptyValue = false,
              required = true,
              description = "The primary key is (i.e., '1')")
          }
      
   )
  @GetMapping("{draft_pk}")
  public ResponseEntity<Draft> getDraftById(@PathVariable("draft_pk") int draft_pk) {
    return new ResponseEntity<Draft>(draftService.getDraftById(draft_pk), HttpStatus.OK);
  }
  
  @Operation(
      summary = "Update a Draft Pick",
      description = "Updates a Draft Pick by primary key",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A draft pick slot is updated", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Draft.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No picks were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "draft_pk", 
              allowEmptyValue = false,
              required = true,
              description = "The primary key is (i.e., '1')")
          }
      
   )
  @PutMapping("{draft_pk}")
  public ResponseEntity<Draft> updateDraft(@PathVariable("draft_pk") int draft_pk ,
    @RequestBody Draft draft) {
      return new ResponseEntity<Draft>(draftService.updateDraft(draft, draft_pk), HttpStatus.OK);
  }
  
  @Operation(
      summary = "Delete a Draft Pick",
      description = "Deletes a Draft Pick by primary key",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A draft pick slot is deleted", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Draft.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No picks were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "draft_pk", 
              allowEmptyValue = false,
              required = true,
              description = "The primary key is (i.e., '1')")
          }
      
   )
  @DeleteMapping("{draft_pk}")
  public ResponseEntity<String> deleteDraft(@PathVariable("draft_pk") int draft_pk) {
    draftService.deleteDraft(draft_pk);
    return new ResponseEntity<String>("Draft Pick PrimaryKey " + draft_pk + " Deleted...", HttpStatus.OK);
  }

}

package com.promineo.mockdrafts.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.mockdrafts.entity.Team;
import com.promineo.mockdrafts.service.NeedsService;
import com.promineo.mockdrafts.service.TeamService;
import com.promineo.mockdrafts.utils.Position;
import com.promineo.mockdrafts.utils.TeamName;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/nfldraft/team")
public class TeamController {
  
  private TeamService teamService;
  @Autowired
  private TeamController(TeamService teamService, NeedsService needsService) {
    super();
    this.teamService = teamService;
  }
  @Operation(
      summary = "Return a list of Teams",
          description = "Returns a list of all Teams with Needs",
          responses = {
              @ApiResponse(
                  responseCode = "200", 
                  description = "Teams are returned", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Team.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameter is invalid", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No teams were found with the input criteria", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occured.", 
                  content = @Content(mediaType = "application/json"))
          }
          
       )
  @GetMapping
  public List<Team> getAllTeams(){
    return teamService.getAllTeams();
  }
 
  
  @Operation(
      summary = "Update a Team",
          description = "Update Team Needs",
          responses = {
              @ApiResponse(
                  responseCode = "200", 
                  description = "A team is updated", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Team.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameter is invalid", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No teams were found with the input criteria", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occured.", 
                  content = @Content(mediaType = "application/json"))
          }
          
       )
  @PutMapping("{team_pk}")
  public ResponseEntity<Team> updateTeam(@PathVariable("team_pk") int team_pk,
    @RequestBody Team team) {
      return new ResponseEntity<Team>(teamService.updateTeam(team, team_pk), HttpStatus.OK);
  }
  
  @Operation(
      summary = "Return a Team",
      description = "Returns a Team by name",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A team with needs are returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Team.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No teams were found with the input criteria", 
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
  @GetMapping("name")
  public ResponseEntity<List<Team>> getTeamByName(
      @RequestParam(required = true) 
      TeamName team_name) {
    return new ResponseEntity<List<Team>>(teamService.getTeamName(team_name), HttpStatus.OK);
     }
  
  @Operation(
	      summary = "Return Teams",
	      description = "Returns Teams by needs",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "Team needs are returned", 
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = Team.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "The request parameter is invalid", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No teams were found with the input criteria", 
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
	              description = "The team needs are (i.e., 'QB')")
	      }
	      
	   )
	  @GetMapping("needs")
	  public ResponseEntity<List<Team>> getTeamByNeeds(
	      @RequestParam(required = true) 
	      Position position) {
	    return new ResponseEntity<List<Team>>(teamService.getTeamNeeds(position), HttpStatus.OK);
	     }
  
 
}

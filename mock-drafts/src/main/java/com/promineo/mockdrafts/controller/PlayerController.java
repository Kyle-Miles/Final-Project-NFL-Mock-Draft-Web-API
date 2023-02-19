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
import org.springframework.web.bind.annotation.RestController;
import com.promineo.mockdrafts.entity.Player;
import com.promineo.mockdrafts.service.PlayerService;
import com.promineo.mockdrafts.utils.Position;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/nfldraft/player")
public class PlayerController {
  
  private PlayerService playerService;
  @Autowired
  private PlayerController(PlayerService playerService) {
    super();
    this.playerService = playerService;
  }
  @Operation(
      summary = "Create a Player",
          description = "Create Players",
          responses = {
              @ApiResponse(
                  responseCode = "201", 
                  description = "A player is created", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Player.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameter is invalid", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No players were found with the input criteria", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occured.", 
                  content = @Content(mediaType = "application/json"))
          }
          
       )
  @PostMapping()
  public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
      return new ResponseEntity<Player>(playerService.savePlayer(player),HttpStatus.CREATED);
  }
  @Operation(
      summary = "Return a list of Players",
      description = "Returns a list of Players by position",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of players are returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Player.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No players were found with the input criteria", 
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
              description = "The position name (i.e., 'QB')"),
      }
      
   )

  
  @GetMapping("position")
  public List <Player> getAllPlayersByPosition(Position position) {
    return playerService.getPlayersByPosition(position);
  }
  
  @Operation(
      summary = "Return all Players",
          description = "Returns a list of all Players",
          responses = {
              @ApiResponse(
                  responseCode = "200", 
                  description = "A list of players is returned", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Player.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameter is invalid", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No players were found with the input criteria", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occured.", 
                  content = @Content(mediaType = "application/json"))
          })
  @GetMapping
  public List <Player> getAllPlayers() {
    return playerService.getAllPlayers();
  }
  
  @Operation(
  summary = "Return a Player",
      description = "Returns a Players by id",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A player is returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Player.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No players were found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "player_pk", 
              allowEmptyValue = false, 
              required = true, 
              description = "The player primary key (i.e., '1')"),
      }
      
   )
  
  @GetMapping("{player_pk}")
  public ResponseEntity<Player> getPlayerById(@PathVariable("player_pk") int player_pk) {
    return new ResponseEntity<Player>(playerService.getPlayerById(player_pk), HttpStatus.OK);
  }
  @Operation(
      summary = "Update a Player",
          description = "Updates a Players by id",
          responses = {
              @ApiResponse(
                  responseCode = "200", 
                  description = "A player is updated", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Player.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameter is invalid", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No players were found with the input criteria", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occured.", 
                  content = @Content(mediaType = "application/json"))
          },
          parameters = {
              @Parameter(
                  name = "player_pk", 
                  allowEmptyValue = false, 
                  required = true, 
                  description = "The player primary key (i.e., '1')"),
          }
          
       )
  @PutMapping("{player_pk}")
  public ResponseEntity<Player> updatePlayer(@PathVariable("player_pk") int player_pk,
    @RequestBody Player player) {
      return new ResponseEntity<Player>(playerService.updatePlayer(player, player_pk), HttpStatus.OK);
  }
  @Operation(
      summary = "Delete a Player",
          description = "Deletes a Players by id",
          responses = {
              @ApiResponse(
                  responseCode = "200", 
                  description = "A player is deleted", 
                  content = @Content(
                      mediaType = "application/json", 
                      schema = @Schema(implementation = Player.class))),
              @ApiResponse(
                  responseCode = "400", 
                  description = "The request parameter is invalid", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "404", 
                  description = "No players were found with the input criteria", 
                  content = @Content(mediaType = "application/json")),
              @ApiResponse(
                  responseCode = "500", 
                  description = "An unplanned error occured.", 
                  content = @Content(mediaType = "application/json"))
          },
          parameters = {
              @Parameter(
                  name = "player_pk", 
                  allowEmptyValue = false, 
                  required = true, 
                  description = "The player primary key (i.e., '1')"),
          }
          
       )
  @DeleteMapping("{player_pk}")
  public ResponseEntity<String> deletePlayer(@PathVariable("player_pk") int player_pk) {
    playerService.deletePlayer(player_pk);
    return new ResponseEntity<String>("Player Deleted...", HttpStatus.OK);
  }

}

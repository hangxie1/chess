1. to run the program:
1.1 Go to the project lib directory 
1.2 java -jar  chess-1.0.0.jar

2. To create a chess game:  POST http://<server ip>:8080/chess/games
The response payload will have the gameid.

3. To reset a chess game: PUT http://<server ip>:8080/chess/reset/games/{game_id}

4. To retrieve a chess game: GET http://<server ip>:8080/chess/games/{game_id}

5. To make a move: PUT http://<server ip>:8080/chess/move/games/<game_id> with the following payload:
{
  "from_x": 5,
  "from_y": 4, 
  "to_x": 3,
  "to_y": 6
}
   The response will show if the move is successful.
   If not, it will tell the reason:  source position no pices, out-of-boarder, 
   target position is occupied by a piece of the same color,  invalid move, blocked by other piece.

   If yes, it will tell if a check is made
   
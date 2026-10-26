# 1. Design Patterns
### Strategy Pattern

We are using the strategy pattern to define what 
moves each kind of piece can take. As an example, the
queen moves are basically a combination of rook and bishop 
moves. 

This is also very relevant for pawn promotion logic, where 
piece strategy needs to change partway through the game.

### Observer Pattern

We use this to log things like moves, captures, checks, and checkmates. 
In general this will be useful to observe any events, and 
can be later used with a Swing viewer for a GUI of the game.

### Factory Pattern

We will use this to actually create the concrete objects 
inserted into the game and can define the strategies of 
each piece as well. This allows us to make the classic chess 
board, but we can also use it to insert pieces into the game 
for something like Fischer Random.

### Builder Pattern

We are using a builder pattern for the context for any events 
being observed in the game, since there are many possible options 
for moves that we might want to have reported, such as if a move 
captures a piece, is a check, or any combination of these.

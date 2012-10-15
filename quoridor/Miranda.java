package quoridor;

import java.util.List;

public class Miranda extends AIPlayer {

	int depth;
	
	public Miranda() {
		depth = 3;
	}
	
	public Miranda(int depth) {
		this.depth = depth;
	}
	
	@Override
	public String getMove(GameState gs) {
		if (gs.currentPlayer()==0) {
			if (gs.numWalls1 == 10) {
				List <Square> path = gs.shortestPathToWin();
				if (gs.isValidTraversal(path.get(0))) {
					return path.get(0).toString();
				} else {
					List <String> validMoves = gs.validMoves();
					return validMoves.get((int)(Math.random() * validMoves.size()));
				}
			} else {
				minimaxAlphaBetaWithMove(gs, depth, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
			}
		} else {
			if (gs.numWalls2 == 10) {
				List <Square> path = gs.shortestPathToWin();
				if (gs.isValidTraversal(path.get(0))) {
					return path.get(0).toString();
				} else {
					List <String> validMoves = gs.validMoves();
					return validMoves.get((int)(Math.random() * validMoves.size()));
				}
			} else {
				minimaxAlphaBetaWithMove(gs, depth, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
			}
		}
		return bestMove;
	}
	
}

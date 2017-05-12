package hunter;

import model.GameStarter;

public class Hunter {

    /**
     * Starts new game with the default value.
     * If an integer argument is provided, it starts the game with the
     * value of the argument.
     * @param args - optional: (int) number of games, (int) game size
     */
    public static void main(String[] args) {
        int num_of_games = 10;
        int game_size_difference = 3;
        try {
            if (args.length > 0) {
                num_of_games = Integer.parseInt(args[0]);
                game_size_difference = num_of_games;
            } else if (args.length > 1) {
                game_size_difference = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            System.err.println("Kérem számot adjon meg a program paramétereként"
                    + ", vagy semmit.");
        }
        GameStarter game = new GameStarter(num_of_games, game_size_difference);
    }
    
}

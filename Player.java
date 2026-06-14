// Abstract base for any type of player. Holds the shared token and requires subclasses to supply a pickColumn method
public abstract class Player {
    private Cell token;

    public Player(Cell token){ // Token state is shared across subclasses
        this.token = token;
    }

    public abstract int pickColumn(Board board); // pickColumn is required in any subclass, but is abstract as Player does not need the method itself

    public Cell getToken(){ // Provided to each of the subclasses as-is
        return token;
    }
}

package util;

public class Position {
	public Integer absc;
	public Integer ord;
	
	public Position(Integer absc, Integer ord) {
		super();
		this.absc = absc;
		this.ord = ord;
	}

	public Position(int absc, Integer ord) { this(Integer.valueOf(absc), ord); }
	public Position(Integer absc, int ord) { this(absc, Integer.valueOf(ord)); }
	public Position(int absc, int ord) { this(Integer.valueOf(absc), Integer.valueOf(ord)); }


}

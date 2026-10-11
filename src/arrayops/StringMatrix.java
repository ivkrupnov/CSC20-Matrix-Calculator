package arrayops;

public class StringMatrix {
	
	private String[][] words;
	
	public StringMatrix(String[][] words) {
		this.words = words;
	}
	
	public StringMatrix add(StringMatrix other) {
		
		if(other == null) {
			return null;
		}
		
		if(words == null || other.words == null) {
			return null;
		}
		
		if(words.length != other.words.length || words[0].length != other.words[0].length) {
			return null;
		}
		
		String[][] wordsArray = new String[words.length][words[0].length];

		for (int i = 0; i < words.length; i++) {
		    for (int k = 0; k < words[i].length; k++) {

		    	wordsArray[i][k] = WordLibrary.combine(
		    		    words[i][k],
		    		    other.words[i][k]
		    		);

		    }
		}

		return new StringMatrix(wordsArray);
		
	}
	
	
	@Override
	public String toString() {

	    String result = "";

	    for (int i = 0; i < words.length; i++) {
	        for (int k = 0; k < words[i].length; k++) {

	            result += words[i][k] + "    ";
	        }

	        result += "\n";
	    }

	    return result;
	}
	
}

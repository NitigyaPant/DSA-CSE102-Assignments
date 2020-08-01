public class ss {
	public String repeatSeparator(String word, String sep, int count) {
		  if(count==1)
		  {
		    return word;
		  }
		  else
		  {
		    String w = " ";
		    while(count>0)
		    {
		      w = word+sep;
		      count--;
		    }
		    return w;
		  }
		  
		}	
}

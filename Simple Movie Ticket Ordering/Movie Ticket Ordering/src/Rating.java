
public enum Rating {
	/*
	 * This is an enumerations class for the movie rating, with its
	 * associated age restrictions
	 */
	
	GENERAL (0),
	PARENTALGUIDANCE (12),
	MATURE (16);
	
	private int ageRestriction;
	private Rating(int ageRestriction)
	{
		//setting the minimum age
		this.ageRestriction= ageRestriction;
	}
	
	//method for getting the minimum age
	public int getMinAge()
	{
		return this.ageRestriction;
	}
	
	//method for setting the age restriction, if needed to be changed
	public void setMinAge(int ageRestriction)
	{
		this.ageRestriction = ageRestriction;
	}
	
	public String toString(int input)
	{
		String rating = "";
		if(input == 0)
		{
			rating = " rating: (G) \n";
		}
		else if(input == 12)
		{
			rating = " rating: (P) \n";
		}
		else
		{
			rating = " rating: (M) \n";
		}
		
		return rating;
	}

}

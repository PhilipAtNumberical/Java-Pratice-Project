public class Film
{
	private String movieTitle;
	private Rating movieRating;
	
	public Film()
	{
		/*
		 * creating an instances
		 */
		movieTitle = "";
		movieRating = null;
	}
	
	public Film(String movieTitle, Rating movieRating)
	{
		/*
		 * Setting the variables
		 */
		this.movieTitle = movieTitle;
		this.movieRating = movieRating;
	}
	
	public String toString()
	{
		//creating a string variable call rating to store rating
		String ratingOfMovie = "";
		
		//assign movie name to variable
		ratingOfMovie = ratingOfMovie + this.movieTitle;
		
		//assign rating to variable
		if(this.movieRating == Rating.GENERAL)
		{
			ratingOfMovie = ratingOfMovie + movieRating.toString(0);
		}
		else if(this.movieRating == Rating.MATURE)
		{
			ratingOfMovie = ratingOfMovie + movieRating.toString(12);
		}
		else
		{
			ratingOfMovie = ratingOfMovie + movieRating.toString(16);
		}
		return ratingOfMovie;
	}
	
	public String getTitle()
	{
		return this.movieTitle;
	}
	
	public void setTitle(String title)
	{
		this.movieTitle = title;
	}
	
	public Rating getRating()
	{
		return movieRating;
	}
	
	public void setRating(Rating rating)
	{
		this.movieRating = rating;
	}
}
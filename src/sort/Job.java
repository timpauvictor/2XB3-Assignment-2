package sort;

public class Job implements Comparable<Job>{
	private String jobID;
	private int time;
	
	public Job(String w, int s)
	{
		this.jobID = w;
		this.time = s;
	}
	
	public int getTime()
	{
		return this.time;
	}
	
	public void setTime(int t)
	{
		this.time = t;
	}
	
	public String getJobID()
	{
		//TODO
		return this.jobID;
	}
	
	public void setJobID(String id)
	{
		this.jobID = id;
	}
	
	@Override
	public int compareTo(Job other)
	{
		if (getTime() < other.getTime()) {
			return -1;
		} else if (getTime() > other.getTime()) {
			return +1;
		} else {
			return 0;
		}
	}
	
	
	public String toString()
	{
		return "{" + this.jobID + "," + this.time + "}";
	}

}

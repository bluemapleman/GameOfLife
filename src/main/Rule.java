package main;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2017年3月24日
 * 
 * The Living rule of lives
 */
public class Rule
{
	public Rule(){};
	public Rule(int liveNum,int stayNum){
		this.liveNum=liveNum;
		this.stayNum=stayNum;
	};
	private int liveNum=3;
	/**
	 * @return the liveNum
	 */
	public int getliveNum()
	{
		return liveNum;
	}
	/**
	 * @param liveNum the liveNum to set
	 */
	public void setliveNum(int liveNum)
	{
		this.liveNum = liveNum;
	}
	/**
	 * @return the stayNum
	 */
	public int getStayNum()
	{
		return stayNum;
	}
	/**
	 * @param stayNum the stayNum to set
	 */
	public void setStayNum(int stayNum)
	{
		this.stayNum = stayNum;
	}
	private int stayNum=2;
}


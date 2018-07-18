package cn.edu.lingnan.dto;

public class goodsDTO
{
	private String gid;
	private String gname;
	private String price;
	private String gnum; 
	private Integer state;
	
	public String getGname()
	{
		return gname;
	}
	public void setGname(String _gname)
	{
		this.gname = _gname;
	}
	public String getPrice()
	{
		return price;
	}
	public void setPrice(String _price)
	{
		this.price = _price;
	}
	public String getGnum()
	{
		return gnum;
	}
	public void setGnum(String _gnum)
	{
		this.gnum = _gnum;
	}
	public Integer getState()
	{
		return state;
	}
	public void setState(Integer _state)
	{
		this.state = _state;
	}
	
	public goodsDTO(){
		
	}
	/**
	 * @return the gid
	 */
	public String getGid()
	{
		return gid;
	}
	/**
	 * @param gid the gid to set
	 */
	public void setGid(String gid)
	{
		this.gid = gid;
	}
}

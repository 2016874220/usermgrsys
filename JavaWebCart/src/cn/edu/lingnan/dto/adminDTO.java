package cn.edu.lingnan.dto;

public class adminDTO {
	private String aid;
	private String aname;
	private String password;
	private Integer superuser;
	private Integer state;
	/**
	 * @return the aid
	 */
	public String getAid()
	{
		return aid;
	}
	/**
	 * @param id the aid to set
	 */
	public void setAid(String id)
	{
		this.aid = id;
	}
	/**
	 * @return the aname
	 */
	public String getAname()
	{
		return aname;
	}
	/**
	 * @param aname the aname to set
	 */
	public void setAname(String aname)
	{
		this.aname = aname;
	}
	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	/**
	 * @return the superuser
	 */
	public Integer getSuperuser()
	{
		return superuser;
	}
	/**
	 * @param superuser the superuser to set
	 */
	public void setSuperuser(Integer superuser)
	{
		this.superuser = superuser;
	}
	/**
	 * @return the state
	 */
	public Integer getState()
	{
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state)
	{
		this.state = state;
	}
	
}
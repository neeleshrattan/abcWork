package com.trantor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.trantor.model.ItemData;
import com.trantor.model.MomfileData;
import com.trantor.model.PointDiscuss;

public class MomDaoDataImp implements MomDaoDataIntf {
    Connection con=null;
    PreparedStatement preparedStatement = null;
	Statement stmt = null;

	
	ArrayList<PointDiscuss> pointDiscussedArr=new ArrayList<>();
	PointDiscuss pointDiscussed=null;
	ArrayList<ItemData> itemDataArr=new ArrayList<>();
	ItemData itemData=null;
	
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	Date date=null;
	
	@Override
	public MomfileData momDataFetch(int momId) {
		
		ResultSet rs=null;
		MomfileData momFileDataFetch=new MomfileData();
		
		try {

			con = Dbconnection.createconnection();
			preparedStatement = con.prepareStatement(Select_PointDiscussed);
			System.out.println(Select_PointDiscussed);
			preparedStatement.setInt(1,momId);
      
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				pointDiscussed= new PointDiscuss();
				pointDiscussed.setsNo(rs.getInt("s_no"));
				pointDiscussed.setPointDiscuss(rs.getString("point_discussed"));
				pointDiscussedArr.add(pointDiscussed);
				
				System.out.println(rs.getInt("s_no")+" "+rs.getString("point_discussed"));
			}
			momFileDataFetch.setPontDiscuss(pointDiscussedArr); 
		}catch(Exception e)
		{
			System.out.println("error in getting point Discuss data"+ e);
		}
		
		
	   try {

			preparedStatement = con.prepareStatement(Select_ActionItem);
			System.out.println(Select_ActionItem);
			preparedStatement.setInt(1,momId);
      
			 rs = preparedStatement.executeQuery();

			while (rs.next()) {
				itemData= new ItemData();
				itemData.setsNo(rs.getInt("s_no"));
				itemData.setItem(rs.getString("Item"));
				
				date=rs.getDate("by_when_date");
				itemData.setByWhenDate(df.format(date));
				itemData.setByWhome(rs.getString("by_whome"));
				
				itemDataArr.add(itemData);
				
				System.out.println(rs.getInt("s_no")+" "+rs.getString("Item")+" "+rs.getDate("by_when_date")+" "+rs.getString("by_whome"));
			
			}
			momFileDataFetch.setItemData(itemDataArr); 
		}catch(Exception e)
		{
			System.out.println("error in getting point Discuss data"+ e);
		}
		
		
		return momFileDataFetch;
	}

}

package com.trantor.dao;

import com.trantor.model.MomfileData;

public interface MomDaoDataIntf {
	
	static final String Select_PointDiscussed="select s_no,point_discussed from TBL_MOM_POINTDISCUSSED where mom_id=? AND is_del='N'";
	static final String Select_ActionItem="select s_no,Item,by_when_date,by_whome from TBL_MOM_ITEM where mom_id=? AND is_del='N'";
	
	MomfileData momDataFetch(int momId);
	
}

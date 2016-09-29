package com.trantor.dao;

import com.trantor.Service.WriteDataInFile;
import com.trantor.model.MomfileData;

public class Checker {
 public static void main(String arg[]) throws Exception
 {
	    MomDaoDataIntf a=new MomDaoDataImp();
        MomfileData momfiledata=a.momDataFetch(100001);
	    WriteDataInFile.writedatatofile(momfiledata);
	 
	  
 }
 
 
}

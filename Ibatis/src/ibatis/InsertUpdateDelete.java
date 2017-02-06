package ibatis;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class InsertUpdateDelete {
	public static void main(String[] args) {
		SqlMapClient ibatis = IbatisHelper.getSqlMapInstance();
		
		//di sql map config <transactionManager type="JDBC" commitRequired="false"> -> autocommit
		//kalo mau dibikin harus commit dlu, ganti jadi true
		
		try {
			//kalo commit required true harus ada ini, supaya bisa di commit nanti
			ibatis.startTransaction();

			RegionBean rBean = new RegionBean();
			rBean.setRegionId(7);
			rBean.setRegionName("Asian");
			
			//insert
			ibatis.insert("region.insRegion", rBean);
			ibatis.commitTransaction();
						
			List<RegionBean> list = ibatis.queryForList("region.getAll", null);
			for (RegionBean regionBean : list) {
				System.out.println(regionBean.getRegionId() + "-"
						+ regionBean.getRegionName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//terus d end disini
				ibatis.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}

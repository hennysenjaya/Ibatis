package ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

public class MainClass {
	public static void main(String[] args) {
		// ibatis membantu query pakai xml
		SqlMapClient ibatis = IbatisHelper.getSqlMapInstance();

		// jgn lupa query.xml nya di daftarin di sqlmapconfig -> sqlmap resource + ganti doctypenya
		// query biasa yang 2 parameter aja
		// karena mau ambil banyak, jadi nya ditampung ke list
		// param 1 -> id query yang mana (namespace.idquery)
		// param 2 -> kalo kita kirim parameter, kalo ga ada null aja
		try {
			List<RegionBean> list = ibatis.queryForList("region.getAll", null);
			for (RegionBean regionBean : list) {
				System.out.println(regionBean.getRegionId() + "-"
						+ regionBean.getRegionName());
			}
			System.out.println();
			//query for object dipake kalo hasilnya yakin cuma 1
			String regionName = (String) ibatis.queryForObject("region.getRegionById", 1);
			System.out.println(regionName);
			
			CountryBean cBean = new CountryBean();
			cBean.setCountryId("US");
			cBean.setRegionId("2");
			String countryName = (String) ibatis.queryForObject("region.getCountry", cBean);
			System.out.println(countryName);
			
			Map paramMap = new HashMap();
			paramMap.put("countryId", "US");
			paramMap.put("regionId",2);
			String countryName2 = (String) ibatis.queryForObject("region.getCountryWithMap", paramMap);
			System.out.println(countryName2);
			
			System.out.println();
			
			Map paramMap2 = new HashMap();
			paramMap2.put("countryId", "US");
			paramMap2.put("regionId","3");
			List<CountryBean> list2 = ibatis.queryForList("region.getCountries", paramMap2);
			for (CountryBean countryBean : list2) {
				System.out.println(countryBean.getCountryId() + "-"
						+ countryBean.getCountryName());
			}
			
			System.out.println();
			String countryName3 = "";
			Map paramMap3 = new HashMap();
			paramMap3.put("countryId", "US");
			//paramMap3.put("countryName", countryName3);
			ibatis.queryForObject("region.getCountryByProc", paramMap3);
			
			System.out.println(paramMap3.get("countryName"));
			
			System.out.println();
			System.out.println();
			
			Integer maxId = (Integer) ibatis.queryForObject("region.getMaxTestTrig", null);
			System.out.println(maxId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

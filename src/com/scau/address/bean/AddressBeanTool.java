package com.scau.address.bean;



/**
 * ������:
 * 1.��װ���ݵ�AddressBean����
 * @author Administrator
 *
 */
public class AddressBeanTool {
    /**���������ݷ�װ��AddressBean����*/
	public static AddressBean toBean(String[] item) {
		if(item.length != 0) {
			AddressBean bean = new AddressBean();
			bean.setName(item[0]);
			bean.setTelephone(item[1]);
			bean.setMobilephone(item[2]);
			bean.setEmail(item[3]);
			bean.setBirthday(item[4]);
			bean.setWorkplace(item[5]);
			bean.setAddress(item[6]);
			bean.setPostcode(item[7]);
			bean.setGroup(item[8]);
			bean.setRemarks(item[9]);
			return bean;
		}
		return null;
	}
    
}
